package com.logIngester.service;

import java.time.LocalDateTime;
import java.util.List;

import com.logIngester.model.Log;

public interface LogService {
	
	/**
     * Ingests a log into the system.
     *
     * @param log The log to be ingested.
     * @return The ingested log.
     */
	public Log ingestLog(Log log);
	
	
	/**
	 * Finds all logs.
	 *
	 * @return List of all logs in database.
	 */
	public List<Log> findAllLogs();
	
	
	/**
     * Finds logs by the specified log level.
     *
     * @param level The log level to filter by.
     * @return List of logs matching the specified log level.
     */
	public List<Log> findByLevel(String level);
	
	
	/**
     * Finds logs with messages containing the specified term.
     *
     * @param message The term to search for in log messages.
     * @return List of logs with messages containing the specified term.
     */
	public List<Log> findByMessageContaining(String message);
	
	
	 /**
     * Finds logs related to the specified resource ID.
     *
     * @param resourceId The resource ID to filter by.
     * @return List of logs related to the specified resource ID.
     */
	public List<Log> findByResourceId(String resourceId);
	
	
	 /**
     * Finds logs within the specified timestamp range.
     *
     * @param startDate The start date of the timestamp range.
     * @param endDate   The end date of the timestamp range.
     * @return List of logs within the specified timestamp range.
     */
	public List<Log> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);
	
	
	/**
     * Finds logs related to the specified trace ID.
     *
     * @param traceId The trace id to filter by.
     * @return List of logs related to the specified trace ID.
     */
	 public List<Log> findByTraceId(String traceId);
	 
	 
	 /**
     * Finds logs related to the specified span ID.
     *
     * @param spanId The span id to filter by.
     * @return List of logs related to the specified span ID.
     */
	 public List<Log> findBySpanId(String spanId);
	 
	 
	 /**
     * Finds logs related to the specified commit.
     *
     * @param commit, commit to filter by.
     * @return List of logs related to the specified commit.
     */
	 public List<Log> findByCommit(String commit);
	 
	 
	 /**
     * Finds logs related to the specified parentResource ID.
     *
     * @param parentResourceId, The parentResource Id to filter by.
     * @return List of logs related to the specified parentResource ID.
     */
	 public List<Log> findByParentResourceId(String parentResourceId) ;
	 
	 
	
	 /**
	  * Finds logs related to the all specified fields.
	  * @param level, 
	  * @param message
	  * @param resourceId
	  * @param timeStampStart
	  * @param timeStampEnd
	  * @param traceId
	  * @param spanId
	  * @param commit
	  * @param parentResourceId
	  * @return List of all filtered logs by specified fields.
	  */
	 public List<Log> findByMultipleFields(String level,String message,String resourceId,
			 LocalDateTime timeStampStart,LocalDateTime timeStampEnd,String traceId,String spanId
			 ,String commit,String parentResourceId);

}
