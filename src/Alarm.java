/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.5139 modeling language!*/
/*
 * By: Leann Labelle
 */

import java.util.*;

// line 2 "model.ump"
// line 133 "model.ump"
public class Alarm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Alarm Attributes
  private String alrmSetting;
  private boolean snoozeActive;
  private boolean radioOn;
  private boolean ringerOn;
  private int alarmVolume;
  private boolean alarmActive;
  private Memory m;

  //Alarm State Machines
  enum State { alarmIdle, alarmRinging, alarmSnooze }
  enum StateAlarmRinging { Null, lessThan1Min, after1Min }
  private State state;
  private StateAlarmRinging stateAlarmRinging;

  //Helper Variables
  private TimedEventHandler timeoutalarmSnoozeToalarmRingingHandler;
  private TimedEventHandler timeoutlessThan1MinToafter1MinHandler;
  private TimedEventHandler timeoutafter1MinToalarmIdleHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Alarm(Memory aM)
  {
    alrmSetting = "1";
    snoozeActive = false;
    radioOn = false;
    ringerOn = false;
    alarmVolume = 1;
    alarmActive = false;
    m = aM;
    setStateAlarmRinging(StateAlarmRinging.Null);
    setState(State.alarmIdle);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAlrmSetting(String aAlrmSetting)
  {
    boolean wasSet = false;
    alrmSetting = aAlrmSetting;
    wasSet = true;
    return wasSet;
  }

  public boolean setSnoozeActive(boolean aSnoozeActive)
  {
    boolean wasSet = false;
    snoozeActive = aSnoozeActive;
    wasSet = true;
    return wasSet;
  }

  public boolean setRadioOn(boolean aRadioOn)
  {
    boolean wasSet = false;
    radioOn = aRadioOn;
    wasSet = true;
    return wasSet;
  }

  public boolean setRingerOn(boolean aRingerOn)
  {
    boolean wasSet = false;
    ringerOn = aRingerOn;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlarmVolume(int aAlarmVolume)
  {
    boolean wasSet = false;
    alarmVolume = aAlarmVolume;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlarmActive(boolean aAlarmActive)
  {
    boolean wasSet = false;
    alarmActive = aAlarmActive;
    wasSet = true;
    return wasSet;
  }

  public boolean setM(Memory aM)
  {
    boolean wasSet = false;
    m = aM;
    wasSet = true;
    return wasSet;
  }

  public String getAlrmSetting()
  {
    return alrmSetting;
  }

  public boolean getSnoozeActive()
  {
    return snoozeActive;
  }

  public boolean getRadioOn()
  {
    return radioOn;
  }

  public boolean getRingerOn()
  {
    return ringerOn;
  }

  public int getAlarmVolume()
  {
    return alarmVolume;
  }

  public boolean getAlarmActive()
  {
    return alarmActive;
  }

  public Memory getM()
  {
    return m;
  }

  public boolean isSnoozeActive()
  {
    return snoozeActive;
  }

  public boolean isRadioOn()
  {
    return radioOn;
  }

  public boolean isRingerOn()
  {
    return ringerOn;
  }

  public boolean isAlarmActive()
  {
    return alarmActive;
  }

  public String getStateFullName()
  {
    String answer = state.toString();
    if (stateAlarmRinging != StateAlarmRinging.Null) { answer += "." + stateAlarmRinging.toString(); }
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public StateAlarmRinging getStateAlarmRinging()
  {
    return stateAlarmRinging;
  }

  public boolean ringAlarm()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case alarmIdle:
        // line 15 "model.ump"
        setAlarm();
        setState(State.alarmRinging);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean stopRinging()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    StateAlarmRinging aStateAlarmRinging = stateAlarmRinging;
    switch (aState)
    {
      case alarmSnooze:
        if ("1".equals(getAlrmSetting()))
        {
          exitState();
        // line 37 "model.ump"
          resetAlarm();
          setState(State.alarmIdle);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStateAlarmRinging)
    {
      case lessThan1Min:
        if ("1".equals(getAlrmSetting()))
        {
          exitStateAlarmRinging();
        // line 23 "model.ump"
          resetAlarm();
          setState(State.alarmIdle);
          wasEventProcessed = true;
          break;
        }
        break;
      case after1Min:
        if ("1".equals(getAlrmSetting()))
        {
          exitStateAlarmRinging();
        // line 30 "model.ump"
          resetAlarm();
          setState(State.alarmIdle);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutalarmSnoozeToalarmRinging()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case alarmSnooze:
        exitState();
        // line 38 "model.ump"
        setAlarm();
        setState(State.alarmRinging);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterAlarmRinging()
  {
    boolean wasEventProcessed = false;
    
    StateAlarmRinging aStateAlarmRinging = stateAlarmRinging;
    switch (aStateAlarmRinging)
    {
      case Null:
        setStateAlarmRinging(StateAlarmRinging.lessThan1Min);
        System.out.println(this.getState());
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitAlarmRinging()
  {
    boolean wasEventProcessed = false;
    
    StateAlarmRinging aStateAlarmRinging = stateAlarmRinging;
    switch (aStateAlarmRinging)
    {
      case lessThan1Min:
        setStateAlarmRinging(StateAlarmRinging.Null);
        wasEventProcessed = true;
        break;
      case after1Min:
        setStateAlarmRinging(StateAlarmRinging.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutlessThan1MinToafter1Min()
  {
    boolean wasEventProcessed = false;
    
    StateAlarmRinging aStateAlarmRinging = stateAlarmRinging;
    switch (aStateAlarmRinging)
    {
      case lessThan1Min:
        exitStateAlarmRinging();
        // line 20 "model.ump"
        sIncreaseVolume();
        setStateAlarmRinging(StateAlarmRinging.after1Min);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean snooze()
  {
    boolean wasEventProcessed = false;
    
    StateAlarmRinging aStateAlarmRinging = stateAlarmRinging;
    switch (aStateAlarmRinging)
    {
      case lessThan1Min:
        exitStateAlarmRinging();
        // line 21 "model.ump"
        System.out.println("Snooze has been pressed"); 
                stopAlarm();
        setState(State.alarmSnooze);
        wasEventProcessed = true;
        break;
      case after1Min:
        exitStateAlarmRinging();
        // line 28 "model.ump"
        System.out.println("Snooze has been pressed"); 
                stopAlarm();
        setState(State.alarmSnooze);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeoutafter1MinToalarmIdle()
  {
    boolean wasEventProcessed = false;
    
    StateAlarmRinging aStateAlarmRinging = stateAlarmRinging;
    switch (aStateAlarmRinging)
    {
      case after1Min:
        exitStateAlarmRinging();
        // line 27 "model.ump"
        resetAlarm();
        setState(State.alarmIdle);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitState()
  {
    switch(state)
    {
      case alarmRinging:
        exitAlarmRinging();
        break;
      case alarmSnooze:
        // line 39 "model.ump"
        setSnoozeActive(false);
        stopTimeoutalarmSnoozeToalarmRingingHandler();
        break;
    }
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case alarmRinging:
        setStateAlarmRinging(StateAlarmRinging.lessThan1Min);
        break;
      case alarmSnooze:
        // line 36 "model.ump"
        setSnoozeActive(true);
        startTimeoutalarmSnoozeToalarmRingingHandler();
        break;
    }
  }

  private void exitStateAlarmRinging()
  {
    switch(stateAlarmRinging)
    {
      case lessThan1Min:
        stopTimeoutlessThan1MinToafter1MinHandler();
        break;
      case after1Min:
        stopTimeoutafter1MinToalarmIdleHandler();
        break;
    }
  }

  private void setStateAlarmRinging(StateAlarmRinging aStateAlarmRinging)
  {
    stateAlarmRinging = aStateAlarmRinging;
    if (state != State.alarmRinging && aStateAlarmRinging != StateAlarmRinging.Null) { setState(State.alarmRinging); }

    // entry actions and do activities
    switch(stateAlarmRinging)
    {
      case lessThan1Min:
        startTimeoutlessThan1MinToafter1MinHandler();
        break;
      case after1Min:
        startTimeoutafter1MinToalarmIdleHandler();
        break;
    }
  }

  private void startTimeoutalarmSnoozeToalarmRingingHandler()
  {
    timeoutalarmSnoozeToalarmRingingHandler = new TimedEventHandler(this,"timeoutalarmSnoozeToalarmRinging",300);
  }

  private void stopTimeoutalarmSnoozeToalarmRingingHandler()
  {
    timeoutalarmSnoozeToalarmRingingHandler.stop();
  }

  private void startTimeoutlessThan1MinToafter1MinHandler()
  {
    timeoutlessThan1MinToafter1MinHandler = new TimedEventHandler(this,"timeoutlessThan1MinToafter1Min",60);
  }

  private void stopTimeoutlessThan1MinToafter1MinHandler()
  {
    timeoutlessThan1MinToafter1MinHandler.stop();
  }

  private void startTimeoutafter1MinToalarmIdleHandler()
  {
    timeoutafter1MinToalarmIdleHandler = new TimedEventHandler(this,"timeoutafter1MinToalarmIdle",60);
  }

  private void stopTimeoutafter1MinToalarmIdleHandler()
  {
    timeoutafter1MinToalarmIdleHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private Alarm controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(Alarm aController, String aTimeoutMethodName, double aHowLongInSeconds)
    {
      controller = aController;
      timeoutMethodName = aTimeoutMethodName;
      howLongInSeconds = aHowLongInSeconds;
      timer = new Timer();
      timer.schedule(this, (long)howLongInSeconds*1000);
    }
    
    public void stop()
    {
      timer.cancel();
    }
    
    public void run ()
    {
      if ("timeoutalarmSnoozeToalarmRinging".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutalarmSnoozeToalarmRinging();
        if (shouldRestart)
        {
          controller.startTimeoutalarmSnoozeToalarmRingingHandler();
        }
        return;
      }
      if ("timeoutlessThan1MinToafter1Min".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutlessThan1MinToafter1Min();
        if (shouldRestart)
        {
          controller.startTimeoutlessThan1MinToafter1MinHandler();
        }
        return;
      }
      if ("timeoutafter1MinToalarmIdle".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutafter1MinToalarmIdle();
        if (shouldRestart)
        {
          controller.startTimeoutafter1MinToalarmIdleHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}

  // line 44 "model.ump"
  public void resetAlarm(){
    alrmSetting="1"; 
    snoozeActive=false;
    radioOn=false;
    ringerOn=false;
    alarmActive=false;
    System.out.println("Alarm is now off");
  }

  // line 52 "model.ump"
  public void stopAlarm(){
    if(alrmSetting=="2"){
      alarmActive=false;
      sRadioOff();
    }else if(alrmSetting == "3"){
      alarmActive=false;
      sRingerOff();
    }
  }

  // line 62 "model.ump"
  public void sRingerSel(){
    if(alarmActive==false){
      alrmSetting="3";
      m.storeAlrmSet(alrmSetting);
      m.displayAlarmSetting();
    }
  }

  // line 70 "model.ump"
  public void sRadioSel(){
    if(alarmActive==false){
      alrmSetting ="2";
      m.storeAlrmSet(alrmSetting);
      m.displayAlarmSetting();
    }
  }

  // line 77 "model.ump"
  public void sOffSel(){
    alrmSetting ="1";
    m.storeAlrmSet(alrmSetting);
    m.displayAlarmSetting();
  }

  // line 83 "model.ump"
  public void setAlarm(){
    if(alrmSetting=="2"){
      alarmActive=true;
      sRadioOn();
    }else if(alrmSetting == "3"){
      alarmActive=true;
      sRingerOn();
    }
  }

  // line 93 "model.ump"
  public void sRadioOn(){
    radioOn=true;
    System.out.println("The radio is now playing");
  }

  // line 98 "model.ump"
  public void sRingerOn(){
    ringerOn=true;
     System.out.println("The ringer is now playing");
  }

  // line 103 "model.ump"
  public void sRadioOff(){
    radioOn=false;
    System.out.println("The radio is off");
  }

  // line 108 "model.ump"
  public void sRingerOff(){
    ringerOn=false;
     System.out.println("The ringer is off");
  }

  // line 113 "model.ump"
  public void sIncreaseVolume(){
    if(alarmVolume >=3){
        System.out.println("Volume cannot be increased");
      }else{
        alarmVolume++;
      }
      m.storeVol(alarmVolume);
      m.displayAlarmVolume();
  }

  // line 123 "model.ump"
  public void sDecreaseVolume(){
    if(alarmVolume <=1){
        System.out.println("Volume cannot be decreased");
      }else{
        alarmVolume--;
      }
      m.storeVol(alarmVolume);
      m.displayAlarmVolume();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "alrmSetting" + ":" + getAlrmSetting()+ "," +
            "snoozeActive" + ":" + getSnoozeActive()+ "," +
            "radioOn" + ":" + getRadioOn()+ "," +
            "ringerOn" + ":" + getRingerOn()+ "," +
            "alarmVolume" + ":" + getAlarmVolume()+ "," +
            "alarmActive" + ":" + getAlarmActive()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "m" + "=" + (getM() != null ? !getM().equals(this)  ? getM().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}