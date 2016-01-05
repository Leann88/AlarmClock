
public class AlarmClock {
	
	private Display d;
	private Memory m;
	private Alarm a;
	private AlarmController ac;
	private TimeManager tm;
	private Controller c;
	
	public AlarmClock(){
		d =new Display();
		m = new Memory(d);
		a = new Alarm(m);
		ac = new AlarmController(m,a);
		tm= new TimeManager(m);
		c= new Controller(tm,m,ac);
	}
	
	public Display getDisplay(){
		return d;
	}
	
	public Memory getMemory(){
		return m;
	}
	
	public Alarm getAlarm(){
		return a;
	}
	
	public AlarmController getAlarmController(){
		return ac;
	}
	
	public TimeManager getTimeManager(){
		return tm;
	}
	
	public Controller getController(){
		return c;
	}
	public void displayClockTime(){
		c.displayClockTime();	
	}
	
	public void displayAlarmTime(){
		c.displayAlarmTime();	    
	}

	public void displayAlarmVolume(){    
		c.displayAlarmVolume();	 
	}
	
	public void displayAlarmSetting(){
		c.displayAlarmSetting();
		
	}
	
	public void sRadioSel(){
		c.sRadioSel();	
	}
	
	public void sRingerSel(){
		c.sRingerSel();
		
	}
	
	public void sOffSel(){
		c.sOffSel();
		
	}

		  // line 167 "model.ump"
		  public void sIncreaseVolume(){
		    c.sIncreaseVolume();
		  }

		  // line 171 "model.ump"
		  public void sDecreaseVolume(){
		    c.sDecreaseVolume();
		  }

		  // line 175 "model.ump"
		  public void bSetTimePressed(){
		    c.bSetTimePressed();
		  }

		  // line 184 "model.ump"
		  public void bSetTimeReleased(){
		      c.bSetTimeReleased();
		  }

		  // line 188 "model.ump"
		  public void bAlarmReleased(){
		      c.bAlarmReleased();
		  }

		  // line 193 "model.ump"
		  public void bAlarmPressed(){
		    c.bAlarmPressed();
		  }

		  // line 203 "model.ump"
		  public void b1MinPressed(){
		    c.b1MinPressed();
		  }

		  // line 207 "model.ump"
		  public void b10MinPressed(){
		    c.b10MinPressed();
		  }
		  public void b1HourPressed(){
		    c.b1HourPressed();
		  }
		  
		  public void bSnoozePressed(){
		    c.bSnoozePressed();
		  }

}
