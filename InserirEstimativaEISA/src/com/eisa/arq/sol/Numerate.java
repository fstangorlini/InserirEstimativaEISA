package com.eisa.arq.sol;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import org.apache.commons.io.FileUtils;

import com.eisa.arq.sol.GUI;
import com.eisa.arq.sol.Numerate;

/**
*
* @author Felipe S.
*/
public final class Numerate
{
    private final File inputFolder;
    private final File outputFolder;
    private final Font font;
    private final Color color = Color.black;
    private Graphics2D g2d;
    private final String appendDirectoryName = "_numerado";
    private int countFiles          = 0;
    private int countDirectories    = 0;
    private GUI gui;    
    
    public Numerate(File currentDirectory, GUI gui)
    {
        font = new Font("Calibri", Font.PLAIN, 36);
        this.gui = gui;
        inputFolder = currentDirectory;
        outputFolder = new File(currentDirectory.getAbsoluteFile().toString().concat(appendDirectoryName));
        if(!outputFolder.exists()) outputFolder.mkdir();
        
            /*
            int count = 0;
            for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && listOfFile.getName().endsWith("jpg")) {
            count++;
            //System.out.println("File " + listOfFile.getName());
            } else {
            if (listOfFile.isDirectory()) {
            //System.out.println("Directory " + listOfFile.getName());
            }
            }
            }
            System.out.println("Found "+count+" jpg files in "+inputFolder.getAbsolutePath()+"");
            */
        
        long time1 = System.currentTimeMillis();
        try
        {
            FileUtils.copyDirectory(inputFolder, outputFolder);
            recursiveApplyMarks(outputFolder);
        } catch (IOException ex) {
            Logger.getLogger(Numerate.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Executado com sucesso\n");
        System.out.println("Nova pasta criada  : "+outputFolder.getAbsolutePath()+"\n");
        System.out.println("Arquivos criados   : "+countFiles+"\n");
        System.out.println("Pastas criadas     : "+countDirectories+"\n");
        System.out.println("Tempo de execução  : "+((System.currentTimeMillis()-time1)/1000)+"s\n");
        
        
        
    }
    
    public boolean recursiveApplyMarks(File currentDirectory) throws IOException
    {
        
        for (File file : currentDirectory.listFiles())
        {
            if(file.isFile() && file.getName().endsWith("jpg"))
            {
                countFiles++;
                applyMark(file);
            }
            else
            {
                if(file.isDirectory())
                {
                    countDirectories++;
                    recursiveApplyMarks(file);
                }
            }
        }
        return true;
    }
            
    public boolean applyMark(File file) throws IOException
    {
        BufferedImage image;
        int x;
        int y;
        String text;
        image = ImageIO.read(file);
        g2d = (Graphics2D) image.getGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        x = (image.getWidth() / 2)-50;
        y = (image.getHeight()/ 8);
        text = file.getName().substring(0,file.getName().length()-4);
        g2d.setFont(font);
        g2d.setColor(color);
        g2d.drawString(text, x, y);
        
        //Betterquality saving
        saveImage(image, file);
        
        //Lossy quality
        //ImageIO.write(image, "jpg", file);
        return true;
    }
    
    private void saveImage(BufferedImage image, File file) throws IOException
    {
        Iterator iter = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter writer = (ImageWriter) iter.next();
        ImageWriteParam iwp = writer.getDefaultWriteParam();
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality(0.8F);
        FileImageOutputStream output = new FileImageOutputStream(file);
        writer.setOutput(output);
        IIOImage outimage = new IIOImage(image, null, null);
        writer.write(null, outimage, iwp);
        writer.dispose();
    }
}
