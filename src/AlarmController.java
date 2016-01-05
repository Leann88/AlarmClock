/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.5095 modeling language!*/

/*
 * By: Leann Labelle
 */
import java.util.*;

// line 270 "model.ump"
// line 1411 "model.ump"
public class AlarmController
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AlarmController Attributes
  private int alrHour;
  private int alrMin;
  private Memory m;
  private Alarm a;

  //AlarmController State Machines
  enum State { AlarmControllerIdle }
  private State state;

  //Helper Variables
  private TimedEventHandler timeoutAlarmControllerIdleToAlarmControllerIdleHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AlarmController(Memory aM, Alarm aA)
  {
    alrHour = 0;
    alrMin = 0;
    m = aM;
    a = aA;
    setState(State.AlarmControllerIdle);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAlrHour(int aAlrHour)
  {
    boolean wasSet = false;
    alrHour = aAlrHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlrMin(int aAlrMin)
  {
    boolean wasSet = false;
    alrMin = aAlrMin;
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

  public boolean setA(Alarm aA)
  {
    boolean wasSet = false;
    a = aA;
    wasSet = true;
    return wasSet;
  }

  public int getAlrHour()
  {
    return alrHour;
  }

  public int getAlrMin()
  {
    return alrMin;
  }

  public Memory getM()
  {
    return m;
  }

  public Alarm getA()
  {
    return a;
  }

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public boolean timeoutAlarmControllerIdleToAlarmControllerIdle()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case AlarmControllerIdle:
        // line 280 "model.ump"
        checkTime();
        setState(State.AlarmControllerIdle);
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
      case AlarmControllerIdle:
        stopTimeoutAlarmControllerIdleToAlarmControllerIdleHandler();
        break;
    }
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case AlarmControllerIdle:
        startTimeoutAlarmControllerIdleToAlarmControllerIdleHandler();
        break;
    }
  }

  private void startTimeoutAlarmControllerIdleToAlarmControllerIdleHandler()
  {
    timeoutAlarmControllerIdleToAlarmControllerIdleHandler = new TimedEventHandler(this,"timeoutAlarmControllerIdleToAlarmControllerIdle",15);
  }

  private void stopTimeoutAlarmControllerIdleToAlarmControllerIdleHandler()
  {
    timeoutAlarmControllerIdleToAlarmControllerIdleHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private AlarmController controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(AlarmController aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutAlarmControllerIdleToAlarmControllerIdle".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutAlarmControllerIdleToAlarmControllerIdle();
        if (shouldRestart)
        {
          controller.startTimeoutAlarmControllerIdleToAlarmControllerIdleHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}

  // line 285 "model.ump"
  public void checkTime(){ 
    if(m.getAlrMin()==m.getClkMin() && 
       m.getAlrHour()==m.getClkHour()){
      soundAlarm();
    }
  }

  // line 291 "model.ump"
  public void addMinute(){
    alrMin ++;
    if(alrMin > 59){
      alrMin=0;
      add1Hour();
    }
    m.storeMinAlr(alrMin);
  }

  // line 299 "model.ump"
  public void add10Minute(){
    alrMin += 10;
    if(alrMin > 59){
      alrMin= alrMin%60;
      add1Hour(); 
    }
    m.storeMinAlr(alrMin);
  }

  // line 308 "model.ump"
  public void add1Hour(){
    alrHour ++;
    if(alrHour > 23){
      alrHour=0;
    }
    m.storeHourAlr(alrHour);
  }

  // line 316 "model.ump"
  public void soundAlarm(){
    a.ringAlarm();
  }

  // line 320 "model.ump"
  public void sRingerSel(){
    a.sRingerSel();
  }

  // line 324 "model.ump"
  public void sRadioSel(){
    a.sRadioSel();
  }

  // line 328 "model.ump"
  public void sOffSel(){
    a.sOffSel();
    a.stopRinging();
  }

  // line 334 "model.ump"
  public void bSnoozePressed(){
    a.snooze();
  }

  // line 338 "model.ump"
  public void sIncreaseVolume(){
    a.sIncreaseVolume();
  }

  // line 342 "model.ump"
  public void sDecreaseVolume(){
    a.sDecreaseVolume();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "alrHour" + ":" + getAlrHour()+ "," +
            "alrMin" + ":" + getAlrMin()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "m" + "=" + (getM() != null ? !getM().equals(this)  ? getM().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "a" + "=" + (getA() != null ? !getA().equals(this)  ? getA().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}