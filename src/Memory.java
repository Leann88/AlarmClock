/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.5095 modeling language!*/
/*
 * By: Leann Labelle
 */


// line 220 "model.ump"
// line 1406 "model.ump"
// line 1436 "model.ump"
public class Memory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Memory Attributes
  private int alrHour;
  private int alrMin;
  private int clkHour;
  private int clkMin;
  private int alrmVol;
  private String alrSetting;
  private Display d;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Memory(Display aD)
  {
    alrHour = 0;
    alrMin = 0;
    clkHour = 0;
    clkMin = 0;
    alrmVol = 1;
    alrSetting = "1";
    d = aD;
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

  public boolean setClkHour(int aClkHour)
  {
    boolean wasSet = false;
    clkHour = aClkHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setClkMin(int aClkMin)
  {
    boolean wasSet = false;
    clkMin = aClkMin;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlrmVol(int aAlrmVol)
  {
    boolean wasSet = false;
    alrmVol = aAlrmVol;
    wasSet = true;
    return wasSet;
  }

  public boolean setAlrSetting(String aAlrSetting)
  {
    boolean wasSet = false;
    alrSetting = aAlrSetting;
    wasSet = true;
    return wasSet;
  }

  public boolean setD(Display aD)
  {
    boolean wasSet = false;
    d = aD;
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

  public int getClkHour()
  {
    return clkHour;
  }

  public int getClkMin()
  {
    return clkMin;
  }

  public int getAlrmVol()
  {
    return alrmVol;
  }

  public String getAlrSetting()
  {
    return alrSetting;
  }

  public Display getD()
  {
    return d;
  }

  public void delete()
  {}

  // line 231 "model.ump"
  public void displayClockTime(){
    d.showClockTime(clkHour, clkMin);
  }

  // line 234 "model.ump"
  public void displayAlarmTime(){
    d.showAlarmTime(alrHour, alrMin);
  }

  // line 237 "model.ump"
  public void displayAlarmVolume(){
    d.showAlarmVolume(alrmVol);
  }

  // line 240 "model.ump"
  public void displayAlarmSetting(){
    d.showAlarmSetting(alrSetting);
  }

  // line 244 "model.ump"
  public void storeMinClk(int cMin){
    clkMin=cMin;
    displayClockTime();
  }

  // line 249 "model.ump"
  public void storeHourClk(int cHour){
    clkHour=cHour;
    displayClockTime();
  }

  // line 253 "model.ump"
  public void storeMinAlr(int aMin){
    alrMin=aMin;
    displayAlarmTime();
  }

  // line 257 "model.ump"
  public void storeHourAlr(int aHour){
    alrHour=aHour;
    displayAlarmTime();
  }

  // line 262 "model.ump"
  public void storeVol(int vol){
    alrmVol=vol;
  }

  // line 266 "model.ump"
  public void storeAlrmSet(String setting){
    alrSetting=setting;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "alrHour" + ":" + getAlrHour()+ "," +
            "alrMin" + ":" + getAlrMin()+ "," +
            "clkHour" + ":" + getClkHour()+ "," +
            "clkMin" + ":" + getClkMin()+ "," +
            "alrmVol" + ":" + getAlrmVol()+ "," +
            "alrSetting" + ":" + getAlrSetting()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "d" + "=" + (getD() != null ? !getD().equals(this)  ? getD().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}