package com.column.util;

import org.apache.log4j.Logger;

public class DynamicQueryString {
	private static Logger logger = Logger.getLogger(DynamicQueryString.class);
	
	
	public static String getQueryString(String query,long lastRunTime, long curTime){
		
		if(query != null && query.length() > 0)
        {		 
        	if(lastRunTime > 0) 
        	{
        		query = query + " and ('ModifiedDate' > " + lastRunTime +" and 'ModifiedDate' <=" + curTime + " )" ;
        		logger.info("Query : " + query);
        	}
        	else 
        	{
        		query = query + " and ( 'ModifiedDate' <=" + curTime + " )" ;
        		logger.info("Query : " + query);
        	}
        	
        }
        else
        {
        	if(lastRunTime > 0) 
        	{
        		query = " ('ModifiedDate' > " + lastRunTime +" and 'ModifiedDate' <=" + curTime + " )" ;
        		logger.info("Query : " + query);
        	}
        	else 
        	{
        		query = " ('ModifiedDate' <=" + curTime + " )" ;
        		logger.info("Query : " + query);
        	} 
        }
		
		return query;
	}
	
}
