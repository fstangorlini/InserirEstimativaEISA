package com.eisa.arq.sol;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.LinkedList;

/**
 *
 * @author Felipe S.
 */
public class Worker implements Runnable
{
    private final LinkedList<Action> actions;
    private int runs;
    public boolean running = true;
    private final Robot robot;
    
    public Worker(LinkedList<Action> actions) throws AWTException
    {
        robot = new Robot();
        this.actions = actions;
    }

    @Override
    public void run()
    {
        while(running)
        {
            for(Action a : actions)
            {
                if(a!=null && running)
                {
                    pressKey(a);
                }
                else
                {
                    running = false;
                    break;
                }
            }
            runs++;
        }
    }
    
    public synchronized void pressKey(Action a)
    {
        //if(a.key == java.awt.event.KeyEvent.VK_SPACE) System.out.println("Executing: key["+a.key+"] delayBetween("+a.delayBetween+") delayAfter("+a.delayAfter+")");
        try {Thread.sleep(a.delayBefore);} catch (InterruptedException ex) {System.err.println(ex);}
        robot.keyPress(a.key);
        try {Thread.sleep(a.delayBetween);} catch (InterruptedException ex) {System.err.println(ex);}
        robot.keyRelease(a.key);
        try {Thread.sleep(a.delayAfter);} catch (InterruptedException ex) {System.err.println(ex);}
        
    }
}
