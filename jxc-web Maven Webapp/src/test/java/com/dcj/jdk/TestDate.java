package com.dcj.jdk;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class TestDate {

	@Test
	public void test() {
		Calendar c2 = Calendar.getInstance();
        //年份
        int year = c2.get(Calendar.YEAR);
        //月份
        int month = c2.get(Calendar.MONTH) + 1;
        //日期
        int date = c2.get(Calendar.DATE);
        //小时
        int hour = c2.get(Calendar.HOUR_OF_DAY);
        //分钟
        int minute = c2.get(Calendar.MINUTE);
        //秒
        int second = c2.get(Calendar.SECOND);
        //星期几
        int day = c2.get(Calendar.DAY_OF_WEEK);
        System.out.println("年份：" + year);
        System.out.println("月份：" + month);
        System.out.println("日期：" + date);
        System.out.println("小时：" + hour);
        System.out.println("分钟：" + minute);
        System.out.println("秒：" + second);
        System.out.println("星期：" + day);
        
        System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));
        
        System.out.println(new Date(System.currentTimeMillis()).toString());
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date()));
	}
	
	@Test
	public void test2(){
		for (int i=1;i<=30;i++){
			Calendar calendar=new GregorianCalendar(); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			calendar.add(Calendar.DATE,i-30);
			System.out.println(i+"=="+sdf.format(calendar.getTime()));
		}
		
	}

}
