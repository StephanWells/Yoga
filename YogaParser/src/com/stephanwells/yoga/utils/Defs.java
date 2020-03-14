package com.stephanwells.yoga.utils;

public class Defs
{
    /**
     * Representing whether an agent is allied, enemy, or uncertain (is friend or foe).
     */
    public enum IFF
    {
        FRIEND, // Allied agent.
        FOE, // Enemy agent.
        UNKNOWN // Or uncertain.
    }

    /**
     * Types of hits you can land on foes.
     */
    public enum CombatResult
    {
        NORMAL, // Normal hit.
        CRIT, // Critical hit.
        GLANCE, // Glancing blow.
        BLOCK, // Hit was blocked by target.
        EVADE, // Hit was evaded by target.
        INTERRUPT, // Hit interrupted a skill being cast by the target.
        ABSORB, // Hit absorbed by target (invulnerability)
        BLIND, // Hit missed due to blind.
        KILLING_BLOW, // Hit killed the target.
        DOWNED // Hit downed the target.
    }

    /**
     * Info about the first skill that was cast to get into combat.
     */
    public enum CombatActivation
    {
        NONE, // Not this kind of event.
        START, // Started skill/animation activation.
        QUICKNESS_UNUSED, // Unused as of Nov 5 2019.
        CANCEL_FIRE, // Stopped skill activation with reaching tooltip time.
        CANCEL_CANCEL, // Stopped skill activation without reaching tooltip time.
        RESET // Animation completed fully.
    }

    /**
     * Changes in combat state. It uses src_agent and dst_agent, where srcAgent is usually the state or agent
     * associated with a change, and dstAgent is the state after the change or value associated with a change.
     * */
    public enum CombatStateChange
    {
        NONE, // Not this kind of event.
        ENTER_COMBAT, // srcAgent entered combat.
        EXIT_COMBAT, // srcAgent left combat.
        CHANGE_UP, // srcAgent is now alive.
        CHANGE_DEAD, // srcAgent is now dead.
        CHANGE_DOWN, // srcAgent is now downed.
        SPAWN, // srcAgent is now in game tracking range.
        DESPAWN, // srcAgent is no longer being tracked.
        HEALTH_UPDATE, // srcAgent has reached a health marker. dstAgent = percent * 10000 (e.g. 99.5% will be 9950)
        LOG_START, // Started logging. value = server Unix timestamp (uInt32). buffDmg = local Unix timestamp. srcAgent = 0x637261 (ArcDPS ID) if EVTC, NPC ID if realtime.
        LOG_END, // Finished logging. value = server unix timestamp (uInt32). buffDmg = local Unix timestamp. srcAgent = 0x637261.
        WEAPON_SWAP, // srcAgent swapped weapon set. dstAgent = current set ID (0/1 water, 4/5 land).
        MAX_HEALTH_UPDATE, // srcAgent has had its maximum health changed. dstAgent = new maximum health.
        POINT_OF_VIEW, // srcAgent is the agent of the player recording the log.
        LANGUAGE, // srcAgent is the text language.
        GW_BUILD, // srcAgent is the game build.
        SHARD_ID, // srcAgent is the server shard ID.
        REWARD, // srcAgent is self, dstAgent is reward ID, value is reward type. This is the bouncy chests.
        BUFF_INITIAL, // combat event that will appear once per buff per agent on logging start (stateChange == 18, buff == 18, normal CombatEvent otherwise.
        POSITION, // srcAgent changed, cast float* p = (float*)&dstAgent, access as x/y/z (float[3]).
        VELOCITY, // srcAgent changed, cast float* v = (float*)&dstAgent, access as x/y/z (float[3]).
        FACING, // srcAgent changed, cast float* f = (float*)&dstAgent, access as x/y (float[2]).
        TEAM_CHANGE, // srcAgent changed, dstAgent is new team ID.
        ATTACK_TARGET, // srcAgent is an attack target, dstAgent is the parent agent (gadget type), value is the current targetable state.
        TARGETABLE, // dstAgent is new targetable state (0 = no, 1 = yes, default yes).
        MAP_ID, // srcAgent is map ID.
        REPL_INFO, // Internal use, won't see anywhere.
        STACK_ACTIVE, // srcAgent is agent with buff, dstAgent is the stack ID marked active.
        STACK_RESET, // srcAgent is agent with buff, value is the duration to reset to (also marks inactive), pad61- is the stack ID.
        GUILD, // srcAgent is agent, dstAgent through buffDamage is 16-byte guild (client form).
        BUFF_INFO, // isFlanking = probably invulnerable, isShields = probably invert, isOffCycle = category, pad61 = stacking type, srcMasterInstId = max stacks.
        BUFF_FORMULA, // (float*)&time[9]: type attr1 attr2 param1 param2 param3 traitSrc traitSelf, isFlanking = !npc, isShields = !player, isOffCycle = break.
        SKILL_INFO, // (float*)&time[9]: recharge range0 range1 tooltip time.
        SKILL_TIMING, // srcAgent = action, dstAgent = at millisecond.
    }

    /**
     * Combat buff remove type.
     */
    public enum CombatBuffRemove
    {
        NONE, // Not this kind of event.
        ALL, // Last/all stacks removed (sent by server).
        SINGLE, // Single stack removed (sent by server). Will happen for each stack on cleanse.
        MANUAL, // Single stack removed (automatically done by Arc on getting out of combat or all stacks, ignore for strip/cleanse calculation, use for in/out volume).
    }

    /**
     * Attributes/stats.
     */
    public enum Attribute
    {
        NONE,
        POWER,
        PRECISION,
        TOUGHNESS,
        VITALITY,
        FEROCITY,
        HEALING,
        CONDITION,
        CONCENTRATION,
        EXPERTISE,
        CUST_ARMOUR,
        CUST_AGONY,
        CUST_STAT_INC,
        CUST_FLAT_INC,
        CUST_PHYSICAL_INC,
        CUST_CONDITION_INC,
        CUST_PHYSICAL_REC,
        CUST_CONDITION_REC,
        CUST_ATTACK_SPEED
    }

    // Custom skill IDs.
    public static final int CUST_RESURRECT = 1066;
    public static final int CUST_BANDAGE = 1175;
    public static final int CUST_DODGE = 65001;

    // Languages.
    public static final int LANG_ENG = 0;
    public static final int LAND_FRE = 2;
    public static final int LANG_GER = 3;
    public static final int LANG_ESP = 4;
}