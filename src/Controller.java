/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.5095 modeling language!*/



/**
 * end display
 */
// line 101 "model.ump"
// line 476 "model.ump"
// line 491 "model.ump"
// line 506 "model.ump"
// line 521 "model.ump"
// line 536 "model.ump"
// line 551 "model.ump"
// line 566 "model.ump"
// line 581 "model.ump"
// line 596 "model.ump"
// line 611 "model.ump"
// line 816 "model.ump"
// line 831 "model.ump"
// line 846 "model.ump"
// line 861 "model.ump"
// line 876 "model.ump"
// line 891 "model.ump"
// line 906 "model.ump"
// line 921 "model.ump"
// line 936 "model.ump"
// line 951 "model.ump"
// line 966 "model.ump"
// line 981 "model.ump"
// line 996 "model.ump"
// line 1011 "model.ump"
// line 1026 "model.ump"
// line 1041 "model.ump"
// line 1056 "model.ump"
// line 1071 "model.ump"
// line 1086 "model.ump"
// line 1101 "model.ump"
// line 1116 "model.ump"
// line 1131 "model.ump"
// line 1146 "model.ump"
// line 1161 "model.ump"
// line 1176 "model.ump"
// line 1191 "model.ump"
// line 1206 "model.ump"
// line 1221 "model.ump"
// line 1236 "model.ump"
// line 1251 "model.ump"
// line 1266 "model.ump"
// line 1281 "model.ump"
// line 1296 "model.ump"
// line 1311 "model.ump"
// line 1326 "model.ump"
// line 1341 "model.ump"
// line 1356 "model.ump"
// line 1371 "model.ump"
// line 1386 "model.ump"
// line 1401 "model.ump"
// line 1431 "model.ump"
public class Controller
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Controller Attributes
  private boolean setTime;
  private boolean setAlarm;
  private TimeManager tm;
  private Memory m;
  private AlarmController ac;

  //Controller State Machines
  enum State { Idle, SettingTime, SettingAlarmTime }
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Controller(TimeManager aTm, Memory aM, AlarmController aAc)
  {
    setTime = false;
    setAlarm = false;
    tm = aTm;
    m = aM;
    ac = aAc;
    setState(State.Idle);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSetTime(boolean aSetTime)
  {
    boolean wasSet = false;
    setTime = aSetTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setSetAlarm(boolean aSetAlarm)
  {
    boolean wasSet = false;
    setAlarm = aSetAlarm;
    wasSet = true;
    return wasSet;
  }

  public boolean setTm(TimeManager aTm)
  {
    boolean wasSet = false;
    tm = aTm;
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

  public boolean setAc(AlarmController aAc)
  {
    boolean wasSet = false;
    ac = aAc;
    wasSet = true;
    return wasSet;
  }

  public boolean getSetTime()
  {
    return setTime;
  }

  public boolean getSetAlarm()
  {
    return setAlarm;
  }

  public TimeManager getTm()
  {
    return tm;
  }

  public Memory getM()
  {
    return m;
  }

  public AlarmController getAc()
  {
    return ac;
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

  public boolean changeClk()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Idle:
        if (getSetTime())
        {
          setState(State.SettingTime);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean changeAlr()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Idle:
        if (getSetAlarm())
        {
          setState(State.SettingAlarmTime);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean add1Min()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case SettingTime:
        if (getSetTime())
        {
        // line 121 "model.ump"
          tm.addOneMinute();
          setState(State.SettingTime);
          wasEventProcessed = true;
          break;
        }
        break;
      case SettingAlarmTime:
        if (getSetAlarm())
        {
        // line 129 "model.ump"
          ac.addMinute();
          setState(State.SettingAlarmTime);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean add10Min()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case SettingTime:
        if (getSetTime())
        {
        // line 122 "model.ump"
          tm.addTenMinute();
          setState(State.SettingTime);
          wasEventProcessed = true;
          break;
        }
        break;
      case SettingAlarmTime:
        if (getSetAlarm())
        {
        // line 130 "model.ump"
          ac.add10Minute();
          setState(State.SettingAlarmTime);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean add1Hour()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case SettingTime:
        if (getSetTime())
        {
        // line 123 "model.ump"
          tm.addOneHour();
          setState(State.SettingTime);
          wasEventProcessed = true;
          break;
        }
        break;
      case SettingAlarmTime:
        if (getSetAlarm())
        {
        // line 131 "model.ump"
          ac.add1Hour();
          setState(State.SettingAlarmTime);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean buttonReleased()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case SettingTime:
        setState(State.Idle);
        wasEventProcessed = true;
        break;
      case SettingAlarmTime:
        setState(State.Idle);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case Idle:
        // line 113 "model.ump"
        System.out.println("Waiting for input"); 
              displayClockTime();
        break;
      case SettingTime:
        // line 120 "model.ump"
        System.out.println("The clock time can be changed");
        break;
      case SettingAlarmTime:
        // line 128 "model.ump"
        System.out.println("The alarm time can be changed");displayAlarmTime();
        break;
    }
  }

  public void delete()
  {}

  // line 137 "model.ump"
  public void displayClockTime(){
    if(setAlarm==false){
    m.displayClockTime();
    }
  }

  // line 143 "model.ump"
  public void displayAlarmTime(){
    if(setTime==false){
    m.displayAlarmTime();
    }
  }

  // line 148 "model.ump"
  public void displayAlarmVolume(){
    m.displayAlarmVolume();
  }

  // line 151 "model.ump"
  public void displayAlarmSetting(){
    m.displayAlarmSetting();
  }

  // line 155 "model.ump"
  public void sRadioSel(){
    ac.sRadioSel();
  }

  // line 159 "model.ump"
  public void sRingerSel(){
    ac.sRingerSel();
  }

  // line 163 "model.ump"
  public void sOffSel(){
    ac.sOffSel();
  }

  // line 167 "model.ump"
  public void sIncreaseVolume(){
    ac.sIncreaseVolume();
  }

  // line 171 "model.ump"
  public void sDecreaseVolume(){
    ac.sDecreaseVolume();
  }

  // line 175 "model.ump"
  public void bSetTimePressed(){
    if(setAlarm==false){
      setTime=true;
      System.out.println("setTime button has been pressed");
      this.changeClk();
    }else{
      System.out.println("Time cannot be changed");
    }
  }

  // line 184 "model.ump"
  public void bSetTimeReleased(){
    if(setTime==true){
	  setTime=false;
      this.buttonReleased();
    }
  }

  // line 188 "model.ump"
  public void bAlarmReleased(){
    if(setAlarm==true){
	  setAlarm=false;
      this.buttonReleased();
    }
  }

  // line 193 "model.ump"
  public void bAlarmPressed(){
    if(setTime==false){
      setAlarm=true;
      System.out.println("Alarm button has been pressed");
      this.changeAlr();
    }else{
      System.out.println("Alarm cannot be changed");
    }
  }

  // line 203 "model.ump"
  public void b1MinPressed(){
    this.add1Min();
  }

  // line 207 "model.ump"
  public void b10MinPressed(){
    this.add10Min();
  }

  // line 211 "model.ump"
  public void b1HourPressed(){
    this.add1Hour();
  }

  // line 215 "model.ump"
  public void bSnoozePressed(){
    ac.bSnoozePressed();
  }
 

  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "setTime" + ":" + getSetTime()+ "," +
            "setAlarm" + ":" + getSetAlarm()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tm" + "=" + (getTm() != null ? !getTm().equals(this)  ? getTm().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "m" + "=" + (getM() != null ? !getM().equals(this)  ? getM().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "ac" + "=" + (getAc() != null ? !getAc().equals(this)  ? getAc().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}