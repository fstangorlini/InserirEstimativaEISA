package com.eisa.arq.sol;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
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
                	if(a.mouseCoords!=null) mouseClick(a);
                	else	if(a.key != 0) pressKey(a);
                	else  try {Thread.sleep(a.delayAfter);} catch (InterruptedException ex) {System.err.println(ex);}
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
    
    public synchronized void mouseClick(Action a)
    {
    	robot.mouseMove(a.mouseCoords[0], a.mouseCoords[1]);
    	robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
        try {Thread.sleep(a.delayAfter);} catch (InterruptedException ex) {System.err.println(ex);}
        
    }
    
    public synchronized void pressKey(Action a)
    {
        //if(a.key == java.awt.event.KeyEvent.VK_SPACE) System.out.println("Executing: key["+a.key+"] delayBetween("+a.delayBetween+") delayAfter("+a.delayAfter+")");
        robot.keyPress(a.key);
        robot.keyRelease(a.key);
        try {Thread.sleep(a.delayAfter);} catch (InterruptedException ex) {System.err.println(ex);}
        
    }
}
