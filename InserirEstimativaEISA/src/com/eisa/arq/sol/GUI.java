package com.eisa.arq.sol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.IntellitypeListener;
import com.melloware.jintellitype.JIntellitype;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements HotkeyListener, IntellitypeListener{

	private JPanel contentPane;
	private JTextField textField;
	private boolean active = false;
    private JFileChooser chooser;
    private String choosertitle;
    private ActionSet1 as1;
    private final Action action = new SwingAction();
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void initComponentsCust()
    {
    	as1 = new ActionSet1();
    	initJIntellitype();
        //Register Intellitype hotkeys
        JIntellitype.getInstance();
        JIntellitype.getInstance().registerHotKey(88, "F5");
        textField.setText("Status: Inactive! Press F5 to Start...");
        textField.setBackground(Color.red);
        
        
    }
    
    public void initJIntellitype() {
        try {
           // initialize JIntellitype with the frame so all windows commands can
           // be attached to this window
           JIntellitype.getInstance().addHotKeyListener(this);
           JIntellitype.getInstance().addIntellitypeListener(this);
        } catch (RuntimeException ex) {
           System.err.println("Either you are not on Windows, or there is a problem with the JIntellitype library!");
        }
     }
    
    public void onHotKey(int i)
    {
        if(active)
        {
            stop();
        }
        else
        {
            start();
        }
    }

    public void onIntellitype(int i)
    {
        
    }
    
    public void start()
    {
        
        active = true;
        textField.setText("Status: Active! Press F5 to Stop...");
        textField.setBackground(Color.green);
    }
    
    public void stop()
    {
        
        active = false;
        textField.setText("Status: Inactive! Press F5 to Start...");
        textField.setBackground(Color.red);
    }
    
	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Inserir Estimativas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setEditable(false);
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		initComponentsCust();
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
