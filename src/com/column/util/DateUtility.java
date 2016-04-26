/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.column.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;


public class DateUtility {

    private static Logger logger = Logger.getLogger(DateUtility.class);

    public static long getCurrentTimeLong(String userDate) {
        String strDate = "";
        Long lngDate = 0l;
    	System.out.println(userDate);
        try {
            if (userDate != null) {
                //System.out.println(userDate.length());
                if (!userDate.equals("")) {

                    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    java.util.Date date1 = (java.util.Date) formatter.parse(userDate);
//                    System.out.println(date1.toString());
                    lngDate = date1.getTime() / 1000l;
                } else {
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    strDate = dateFormat.format(date);//"05/01/2012";//dd/mm/yyyy
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    java.util.Date date1 = (java.util.Date) formatter.parse(strDate);
                    lngDate = date1.getTime() / 1000l;
                }
            }
//            lngDate = lngDate - (15 * 60);
        } catch (Exception e) {
            logger.error("Exception ::::: ", e);
        }
        return lngDate;
    }


}
