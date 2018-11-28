package com.eisa.arq.sol;

/**
 *
 * @author Felipe S.
 */
public class Action
{
    public int key;
    public int delayBetween;
    public int delayBefore;
    public int delayAfter;
    
    public Action(int key, int delayBetween, int delayAfter)
    {
        this.key = key;
        this.delayBetween = delayBetween;
        this.delayAfter = delayAfter;
    }
}
