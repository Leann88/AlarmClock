/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.5095 modeling language!*/


/*
 * By: Leann Labelle
 */
/**
 * end TimeManager
 */
// line 50 "model.ump"
// line 471 "model.ump"
// line 486 "model.ump"
// line 501 "model.ump"
// line 516 "model.ump"
// line 531 "model.ump"
// line 546 "model.ump"
// line 561 "model.ump"
// line 576 "model.ump"
// line 591 "model.ump"
// line 606 "model.ump"
// line 801 "model.ump"
// line 811 "model.ump"
// line 826 "model.ump"
// line 841 "model.ump"
// line 856 "model.ump"
// line 871 "model.ump"
// line 886 "model.ump"
// line 901 "model.ump"
// line 916 "model.ump"
// line 931 "model.ump"
// line 946 "model.ump"
// line 961 "model.ump"
// line 976 "model.ump"
// line 991 "model.ump"
// line 1006 "model.ump"
// line 1021 "model.ump"
// line 1036 "model.ump"
// line 1051 "model.ump"
// line 1066 "model.ump"
// line 1081 "model.ump"
// line 1096 "model.ump"
// line 1111 "model.ump"
// line 1126 "model.ump"
// line 1141 "model.ump"
// line 1156 "model.ump"
// line 1171 "model.ump"
// line 1186 "model.ump"
// line 1201 "model.ump"
// line 1216 "model.ump"
// line 1231 "model.ump"
// line 1246 "model.ump"
// line 1261 "model.ump"
// line 1276 "model.ump"
// line 1291 "model.ump"
// line 1306 "model.ump"
// line 1321 "model.ump"
// line 1336 "model.ump"
// line 1351 "model.ump"
// line 1366 "model.ump"
// line 1381 "model.ump"
// line 1396 "model.ump"
// line 1426 "model.ump"
public class Display
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Display()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 53 "model.ump"
  public void showClockTime(int clkHour, int clkMin){
    String time= "The clock time is: ";
      if(clkHour <10){
        time= time + "0" + clkHour + ":";
      }else{
        time=time + clkHour + ":";
      }
    
    if(clkMin<10){
      time= time + "0" + clkMin;
    }else{
       time=time + clkMin;
    }
    
    System.out.println(time);
  }

  // line 69 "model.ump"
  public void showAlarmTime(int alrHour, int alrMin){
    String time= "The alarm time is: ";
      if(alrHour <10){
        time= time + "0" + alrHour + ":";
      }else{
        time=time + alrHour + ":";
      }
    
    if(alrMin<10){
      time= time + "0" + alrMin;
    }else{
       time=time + alrMin;
    }
    
    System.out.println(time);
  }

  // line 86 "model.ump"
  public void showAlarmVolume(int alrmVol){
    System.out.println("Current alarm volume " + alrmVol);
  }

  // line 90 "model.ump"
  public void showAlarmSetting(String alrSetting){
    if(alrSetting=="1"){
         System.out.println("The current alarm setting is 1 -Off-");
    }else if(alrSetting=="2"){
           System.out.println("The current alarm setting is 2 -Radio-");
    }else{
           System.out.println("The current alarm setting is 3 -Ringer-");
    }
  }

}