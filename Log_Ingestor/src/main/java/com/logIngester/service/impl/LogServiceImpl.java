package com.logIngester.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logIngester.model.Log;
import com.logIngester.repository.LogRepository;
import com.logIngester.service.LogService;


@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogRepository logRepository;
	
	@Override
	public Log ingestLog(Log log) {
		logRepository.save(log);
		return log;
	}

	
	@Override
	public List<Log> findAllLogs(){
		return logRepository.findAll();
	}
	
	@Override
	public List<Log> findByLevel(String level) {
		return logRepository.findByLevel(level);
	}

	
	@Override
	public List<Log> findByMessageContaining(String message) {
		return logRepository.findByMessageContains(message);
	}

	
	@Override
	public List<Log> findByResourceId(String resourceId) {
		return logRepository.findByResourceId(resourceId);
	}

	
	@Override
	public List<Log> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate) {
		return logRepository.findByTimestamp(startDate, endDate);
	}


	@Override
	public List<Log> findByTraceId(String traceId) {
		return logRepository.findByTraceId(traceId);
	}


	@Override
	public List<Log> findBySpanId(String spanId) {
		return logRepository.findBySpanId(spanId);
	}


	@Override
	public List<Log> findByCommit(String commit) {
		return logRepository.findByCommitContains(commit);
	}


	@Override
	public List<Log> findByParentResourceId(String parentResourceId) {
		return logRepository.findByParentResourceIdIgnoreCase(parentResourceId);
	}


	@Override
	public List<Log> findByMultipleFields(String level, String message, String resourceId, LocalDateTime timeStampStart,
			LocalDateTime timeStampEnd, String traceId, String spanId, String commit, String parentResourceId) {
		return logRepository.findByMultipleFilters(level, message, resourceId, timeStampStart, timeStampEnd, traceId, spanId, commit, parentResourceId);
	}
	

}
