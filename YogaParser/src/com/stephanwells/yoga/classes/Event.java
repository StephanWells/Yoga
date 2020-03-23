package com.stephanwells.yoga.classes;

import com.stephanwells.yoga.utils.Defs.*;

public class Event
{
    private double time; // Time of registering the event.

    private double srcAgent; // Agent that caused the event.
    private double dstAgent; // Agent that the event happened to.
    private IFF iff; // Current affinity of srcAgent and dstAgent.
    private int skillId; // Skill ID of relevant skill (can be zero).

    private int srcInstId;
    private int dstInstId;
    private int srcMasterInstId; // = instId of master if srcAgent has a master (i.e. is a minion), 0 otherwise.
    private int dstMasterInstId; // = instId of master if dstAgent has a master (i.e. is a minion), 0 otherwise.

    private boolean isAboveNinety; // srcAgent is above 90% health.
    private boolean isBelowFifty; // dstAgent is below 50% health.
    private boolean isMoving; // srcAgent is moving at time of event.
    private boolean isFlanking; // srcAgent is flanking dstAgent at time of event.
}
