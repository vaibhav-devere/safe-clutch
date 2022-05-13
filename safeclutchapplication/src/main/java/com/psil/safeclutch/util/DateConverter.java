package com.psil.safeclutch.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

/**
 * 
 * @author vpottumu
 *
 */
@Component
public class DateConverter {
  
	private static final  String Pattern = "dd-MM-yyyy";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Pattern);

    /**
     * converting date to string
     * @param date
     * @return
     */
    public String toText(LocalDate date) {
        return formatter.format(date);
        
    }
    
    /**
     * converting string to date
     * @param text
     * @return
     */
    public LocalDate toDate(String text) {
       return  LocalDate.parse(text, formatter);
        
    }
    
    /**
     * returning no of days between the dates
     * @param startDate
     * @param endDate
     * @return
     */
    public int days(LocalDate startDate, LocalDate endDate){
           long days=ChronoUnit.DAYS.between(startDate,endDate);
        return (int) days;
    }
    
    /**
     * returning the no of months between the dates
     * @param startDate
     * @param endDate
     * @return
     */
    public int months(LocalDate startDate, LocalDate endDate){
        long months=ChronoUnit.MONTHS.between(startDate,endDate);
        return (int)months;
    }
	
		
}
