package util;

import java.util.Calendar;
import java.util.Date;

import model.ComunidadAutonoma;
import model.Localidad;
import model.Provincia;

public class DateUtil {
	
	public static Date addDays(Date date, int days){
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days); //minus number would decrement the days
	        return cal.getTime();
	}
	
	public static Date addMonths(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, days); //minus number would decrement the months
        return cal.getTime();
	}
	
	public static Date addYears(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, days); //minus number would decrement the years
        return cal.getTime();
	}
	
	public static Boolean checkSunday(Date date){
		
		@SuppressWarnings("deprecation")
		Integer i = date.getDay();

		return i==0;
	}
	
	public static Boolean checkWeekend(Date date){
		
		@SuppressWarnings("deprecation")
		Integer i = date.getDay();

		return i==6 || i==0;
	}
	
	@SuppressWarnings("deprecation")
	public static Boolean checkJudicial(Date date){
		
		Boolean res = false;
		
		if(date.getMonth()==11 && (date.getDate()==24 || date.getDate()==31)){
			res = true;
		}

		return res;
	}
	
	@SuppressWarnings("deprecation")
	public static Integer numberOfSundays(Date finaldate, Date startdate){
		Long tim = finaldate.getTime()-startdate.getTime();
		Double daysD = Math.floor(tim / (1000 * 60 * 60 * 24));
		Integer days = daysD.intValue();
		Integer weekDay = addDays(finaldate, 0).getDay();
		Integer res = (days-weekDay+7)/7;
		return res; 
	}
	
	@SuppressWarnings("deprecation")
	public static Integer numberOfWeekendDays(Date finaldate, Date startdate){
		Long tim = finaldate.getTime()-startdate.getTime();
		Double daysD = Math.floor(tim / (1000 * 60 * 60 * 24));
		Integer days = daysD.intValue();
		//Sundays
		Integer weekDay1 = addDays(finaldate, 0).getDay();
		Integer res1 = (days-weekDay1+7)/7;
		//Saturdays
		Integer weekDay2 = addDays(finaldate, -6).getDay();
		Integer res2 = (days-weekDay2+7)/7;
		return res1+res2; 
	}
	
	@SuppressWarnings("deprecation")
	public static Integer numberOfWorkingDaysIn(Integer m, Date d, ComunidadAutonoma ca, Provincia c, Localidad l){
		Date aux = new Date();
		aux.setMonth(m);
		aux.setYear(d.getYear());
		Integer res = 0;
		for(int i=1; i<=31; i++){
			aux.setDate(i);
			if(aux.getDay()!=0  && aux.getDay()!=6 && !LoadEntities.checkHoliday(ca, c, l, aux)){
				res++;
			}
		}
		System.out.println(res);
		return res; 
	}

}
