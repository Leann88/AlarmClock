/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.5095 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 466 "model.ump"
// line 481 "model.ump"
// line 496 "model.ump"
// line 511 "model.ump"
// line 526 "model.ump"
// line 541 "model.ump"
// line 556 "model.ump"
// line 571 "model.ump"
// line 586 "model.ump"
// line 601 "model.ump"
// line 616 "model.ump"
// line 621 "model.ump"
// line 626 "model.ump"
// line 631 "model.ump"
// line 636 "model.ump"
// line 641 "model.ump"
// line 646 "model.ump"
// line 651 "model.ump"
// line 656 "model.ump"
// line 661 "model.ump"
// line 666 "model.ump"
// line 671 "model.ump"
// line 676 "model.ump"
// line 681 "model.ump"
// line 686 "model.ump"
// line 691 "model.ump"
// line 696 "model.ump"
// line 701 "model.ump"
// line 706 "model.ump"
// line 711 "model.ump"
// line 716 "model.ump"
// line 721 "model.ump"
// line 726 "model.ump"
// line 731 "model.ump"
// line 736 "model.ump"
// line 741 "model.ump"
// line 746 "model.ump"
// line 751 "model.ump"
// line 756 "model.ump"
// line 761 "model.ump"
// line 766 "model.ump"
// line 771 "model.ump"
// line 776 "model.ump"
// line 781 "model.ump"
// line 786 "model.ump"
// line 791 "model.ump"
// line 796 "model.ump"
// line 806 "model.ump"
// line 821 "model.ump"
// line 836 "model.ump"
// line 851 "model.ump"
// line 866 "model.ump"
// line 881 "model.ump"
// line 896 "model.ump"
// line 911 "model.ump"
// line 926 "model.ump"
// line 941 "model.ump"
// line 956 "model.ump"
// line 971 "model.ump"
// line 986 "model.ump"
// line 1001 "model.ump"
// line 1016 "model.ump"
// line 1031 "model.ump"
// line 1046 "model.ump"
// line 1061 "model.ump"
// line 1076 "model.ump"
// line 1091 "model.ump"
// line 1106 "model.ump"
// line 1121 "model.ump"
// line 1136 "model.ump"
// line 1151 "model.ump"
// line 1166 "model.ump"
// line 1181 "model.ump"
// line 1196 "model.ump"
// line 1211 "model.ump"
// line 1226 "model.ump"
// line 1241 "model.ump"
// line 1256 "model.ump"
// line 1271 "model.ump"
// line 1286 "model.ump"
// line 1301 "model.ump"
// line 1316 "model.ump"
// line 1331 "model.ump"
// line 1346 "model.ump"
// line 1361 "model.ump"
// line 1376 "model.ump"
// line 1391 "model.ump"
// line 1421 "model.ump"
public class TimeManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TimeManager Attributes
  private int curHour;
  private int curMin;
  private Memory m;

  //TimeManager State Machines
  enum State { updateTime }
  private State state;

  //Helper Variables
  private TimedEventHandler timeoutupdateTimeToupdateTimeHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TimeManager(Memory aM)
  {
    curHour = 0;
    curMin = 0;
    m = aM;
    setState(State.updateTime);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCurHour(int aCurHour)
  {
    boolean wasSet = false;
    curHour = aCurHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurMin(int aCurMin)
  {
    boolean wasSet = false;
    curMin = aCurMin;
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

  public int getCurHour()
  {
    return curHour;
  }

  public int getCurMin()
  {
    return curMin;
  }

  public Memory getM()
  {
    return m;
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

  public boolean timeoutupdateTimeToupdateTime()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case updateTime:
        // line 10 "model.ump"
        addOneMinute();
        setState(State.updateTime);
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
      case updateTime:
        stopTimeoutupdateTimeToupdateTimeHandler();
        break;
    }
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case updateTime:
        startTimeoutupdateTimeToupdateTimeHandler();
        break;
    }
  }

  private void startTimeoutupdateTimeToupdateTimeHandler()
  {
    timeoutupdateTimeToupdateTimeHandler = new TimedEventHandler(this,"timeoutupdateTimeToupdateTime",60);
  }

  private void stopTimeoutupdateTimeToupdateTimeHandler()
  {
    timeoutupdateTimeToupdateTimeHandler.stop();
  }

  public static class TimedEventHandler extends TimerTask  
  {
    private TimeManager controller;
    private String timeoutMethodName;
    private double howLongInSeconds;
    private Timer timer;
    
    public TimedEventHandler(TimeManager aController, String aTimeoutMethodName, double aHowLongInSeconds)
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
      if ("timeoutupdateTimeToupdateTime".equals(timeoutMethodName))
      {
        boolean shouldRestart = !controller.timeoutupdateTimeToupdateTime();
        if (shouldRestart)
        {
          controller.startTimeoutupdateTimeToupdateTimeHandler();
        }
        return;
      }
    }
  }

  public void delete()
  {}

  // line 16 "model.ump"
  public void addOneMinute(){
    curMin++;
        if (curMin > 59) {
        curMin=0;
        addOneHour();
        }
         m.storeMinClk(curMin);
  }

  // line 26 "model.ump"
  public void addTenMinute(){
    curMin+=10;
        if (curMin > 59) {
        	curMin = curMin%60;
        	addOneHour();
        }        
     m.storeMinClk(curMin);
  }

  // line 39 "model.ump"
  public void addOneHour(){
    curHour++;
      if(curHour >23){
        curHour=0;
      }
    
    m.storeHourClk(curHour);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "curHour" + ":" + getCurHour()+ "," +
            "curMin" + ":" + getCurMin()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "m" + "=" + (getM() != null ? !getM().equals(this)  ? getM().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}