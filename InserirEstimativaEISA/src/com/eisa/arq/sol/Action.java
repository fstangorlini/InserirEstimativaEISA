package com.eisa.arq.sol;

/**
 *
 * @author Felipe S.
 */
public class Action
{
	public int[] mouseCoords;
	public int key;
    public int delayAfter;
    
    public Action(int key, int delayAfter)
    {
        this.key = key;
        this.delayAfter = delayAfter;
    }
    
    public Action(int[] mouseCoords, int delayAfter)
    {
        this.mouseCoords = mouseCoords;
        this.delayAfter = delayAfter;
    }
    
    public Action(int delayAfter)
    {
    	this.delayAfter = delayAfter;
    }
    
}
