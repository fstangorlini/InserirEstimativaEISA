package com.eisa.arq.sol;

import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 *
 * @author Felipe S.
 */
public class ActionSet1
{
    private LinkedList<Action> actions;
    private Thread thread;
    private Worker w;
    
    public ActionSet1()
    {
        actions = new LinkedList<>();
        
        
        //Opens File
        
        
        
        //Wait for excel to load
        actions.addLast(new Action(Constants._10000));
        
        //Click "Enable Content" x,y=[562,170] (excel maximizado @1360x760)
        actions.addLast(new Action(new int[] {562,170}, Constants._350));
        
        //Click "Distribuição do Plano" x,y=[633,696] (excel maximizado @1360x760) 
        actions.addLast(new Action(new int[] {633,696}, Constants._150));
        
        //Click "Distribuição do Plano" x,y=[633,281] (excel maximizado @1360x760)
        actions.addLast(new Action(new int[] {633,281}, Constants._150));
        
        
        
        //Start Action set
        try
        {
            w = new Worker(actions);
            thread = new Thread(w);
        }
        catch (AWTException ex)
        {
            System.err.println(ex);
        }
        
    }
    public void kill()
    {
        Thread.currentThread().interrupt();
        
        w.running = false;
        
    }
    public void start()
    {
        try
        {
            w = new Worker(actions);
            thread = new Thread(w);
            thread.start();
        }
        catch (AWTException ex)
        {
            System.err.println(ex);
        }
    }
    
    public void updateAttackSpeed(int attackSpeed)
    {
        for(Action a : actions)
        {
            if(a.key == KeyEvent.VK_SPACE) a.delayAfter = attackSpeed;
        }
    }
}
