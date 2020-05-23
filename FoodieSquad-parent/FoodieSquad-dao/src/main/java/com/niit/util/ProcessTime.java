package com.niit.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ProcessTime {

public Date getNowTime() {
  java.sql.Date nowTime= new java.sql.Date(new Date().getTime());
	return nowTime;
	
}

public String getFormatDate(Date d) {
  String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
	return nowTime;
}

public String getStringNowTime(){
java.sql.Date nowTime= new java.sql.Date(new Date().getTime());
String stringNowTime=  getFormatDate(nowTime);
return stringNowTime;
		
	}

public String getStringNowTimeWithDate(){

java.sql.Date d= new java.sql.Date(new Date().getTime());
String nowTime = new SimpleDateFormat("yyyy-年-MM-月-dd-日").format(d);
return nowTime;
		
	}

}
