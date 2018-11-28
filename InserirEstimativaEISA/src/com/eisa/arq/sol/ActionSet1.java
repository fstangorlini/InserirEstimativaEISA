package com.eisa.arq.sol;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 *
 * @author Felipe S.
 */
public class ActionSet1
{
    //Farms on The Royal Tomb of Al Sheder
    private LinkedList<Action> actions;
    private Thread thread;
    private Worker w;
    
    public ActionSet1()
    {
        actions = new LinkedList<>();
        
        
        //Start in main menu, select multiplayer
        actions.addLast(new Action(KeyEvent.VK_LEFT, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_LEFT, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_LEFT, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_LEFT, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_LEFT, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_RIGHT, Constants._50, Constants._50));
        
        //Create a game
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._500));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        
        //Skip intro
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._1500));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        
        //Start script
        actions.addLast(new Action(KeyEvent.VK_LEFT, 3500, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_UP, 820, Constants._50));
        
        actions.addLast(new Action(KeyEvent.VK_RIGHT, Constants._150, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_SPACE, Constants._50, Constants._800));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_RIGHT, Constants._150, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_SPACE, Constants._50, Constants._800));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_RIGHT, Constants._150, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_SPACE, Constants._50, Constants._800));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        
        actions.addLast(new Action(KeyEvent.VK_RIGHT, Constants._450, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_SPACE, Constants._50, Constants._800));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._100, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_RIGHT, Constants._150, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_SPACE, Constants._50, Constants._800));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._100, Constants._50));
        
        //Exit game
        actions.addLast(new Action(KeyEvent.VK_ESCAPE, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_DOWN, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_RIGHT, Constants._50, Constants._50));
        actions.addLast(new Action(KeyEvent.VK_ENTER, Constants._50, 2000));
        
        
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
