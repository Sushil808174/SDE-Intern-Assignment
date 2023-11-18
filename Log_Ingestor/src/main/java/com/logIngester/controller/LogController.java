package com.logIngester.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logIngester.model.Log;
import com.logIngester.service.LogService;

@RestController
@RequestMapping("/logs")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	
	/**
	 * Endpoint to check the api
	 * @return ResponseEntity with Hello world! and HTTP status.
	 */
	@GetMapping("/hello-world")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello world!",HttpStatus.ACCEPTED);
	}
	
	
	
	 /**
     * Endpoint to ingest a log into the system.
     *
     * @param log The log to be ingested.
     * @return ResponseEntity with the ingested log and HTTP status.
     */
	
	
	/**
	 * Random data for database
	 * {
		    "level": "warning",
		    "message": "Memory usage high",
		    "resourceId": "server-9876",
		    "timestamp": "2023-09-15T12:45:00Z",
		    "traceId": "ghi-pqr-789",
		    "spanId": "span-012",
		    "commit": "4f3e2d1",
		    "metadata": {
		        "parentResourceId": "server-3456"
		    }
		}

	 */
	@PostMapping("/ingest-log")
	public ResponseEntity<Log> ingestLogHandler(@RequestBody Log log){
		Log resLog = logService.ingestLog(log);
		return new ResponseEntity<>(resLog,HttpStatus.CREATED);
	}
	
	
	/**
	 * Find all the logs in database.
	 * @return List of all logs in database.
	 */
	@GetMapping("/all-logs")
	public ResponseEntity<List<Log>> findAllLogsHandler(){
		List<Log> logs = logService.findAllLogs();
		return new ResponseEntity<>(logs,HttpStatus.OK);
	}
	
	
	 /**
     * Endpoint to find logs by the specified log level.
     *
     * @param level The log level to filter by.
     * @return ResponseEntity with the list of logs matching the specified log level and HTTP status.
     */
    @GetMapping("/findByLevel/{level}")
    public ResponseEntity<List<Log>> findByLevel(@PathVariable String level) {
        List<Log> logs = logService.findByLevel(level);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }
    
    
    
    /**
     * Endpoint to find logs with messages containing the specified term.
     *
     * @param message The term to search for in log messages.
     * @return ResponseEntity with the list of logs containing the specified term in messages and HTTP status.
     */
    @GetMapping("/findByMessage/{message}")
    public ResponseEntity<List<Log>> findByMessageContaining(@PathVariable String message) {
        List<Log> logs = logService.findByMessageContaining(message);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }
    
    
    
    /**
     * Endpoint to find logs related to the specified resource ID.
     *
     * @param resourceId The resource ID to filter by.
     * @return ResponseEntity with the list of logs related to the specified resource ID and HTTP status.
     */
    @GetMapping("/findByResourceId/{resourceId}")
    public ResponseEntity<List<Log>> findByResourceId(@PathVariable String resourceId) {
        List<Log> logs = logService.findByResourceId(resourceId);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }

    
    
    /**
     * Endpoint to find logs within the specified timestamp range.
     *
     * @param startDate The start date of the timestamp range.
     * @param endDate   The end date of the timestamp range.
     * @return ResponseEntity with the list of logs within the specified timestamp range and HTTP status.
     */
    @GetMapping("/findByTimestampBetween/{startDate}/{endDate}")
    public ResponseEntity<List<Log>> findByTimestampBetween(@PathVariable LocalDateTime startDate,
                                                           @PathVariable LocalDateTime endDate) {
        List<Log> logs = logService.findByTimestampBetween(startDate, endDate);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }
    
    
    /**
     * Endpoint to find logs with traceId containing the specified term.
     *
     * @param traceId The traceId to filter by.
     * @return ResponseEntity with the list of logs related to the specified trace ID and HTTP status.
     */
    @GetMapping("/findByTraceId/{traceId}")
    public ResponseEntity<List<Log>> findByTraceId(@PathVariable String traceId) {
        List<Log> logs = logService.findByTraceId(traceId);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }

    
    /**
     * Endpoint to find logs with spanId containing the specified term.
     *
     * @param spanId, The span id to filter by.
     * @return ResponseEntity with the list of logs related to the specified span ID and HTTP status.
     */
    @GetMapping("/findBySpanId/{spanId}")
    public ResponseEntity<List<Log>> findBySpanId(@PathVariable String spanId) {
        List<Log> logs = logService.findBySpanId(spanId);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }
    
    
    
    /**
     * Endpoint to find logs with commit containing the specified term.
     *
     * @param commit The term to search for in log messages.
     * @return ResponseEntity with the list of logs containing the specified commit and http status.
     */
    @GetMapping("/findByCommit/{commit}")
    public ResponseEntity<List<Log>> findByCommit(@PathVariable String commit) {
        List<Log> logs = logService.findByCommit(commit);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }

    
    /**
     * Endpoint to find logs related to specified field parentResourceId.
     *
     * @param parentResourceId. The parentResource ID to filter by.
     * @return ResponseEntity with the list of logs containing the specified term parentResourceId and HTTP status.
     */
    @GetMapping("/findByParentResourceId/{parentResourceId}")
    public ResponseEntity<List<Log>> findByParentResourceId(@PathVariable String parentResourceId) {
        List<Log> logs = logService.findByParentResourceId(parentResourceId);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }
    
    
    /**
     * Endpoint to find all logs related to specified field.
     * @param level
     * @param message
     * @param resourceId
     * @param startDate
     * @param endDate
     * @param traceId
     * @param spanId
     * @param commit
     * @param parentResourceId
     * @return ResponseEntity with the list of logs containing the specified fields and HTTP status.
     */
    @GetMapping("/findByMultipleFilters")
    public ResponseEntity<List<Log>> findByMultipleFilters(
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) String resourceId,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate,
            @RequestParam(required = false) String traceId,
            @RequestParam(required = false) String spanId,
            @RequestParam(required = false) String commit,
            @RequestParam(required = false) String parentResourceId) {

        List<Log> logs = logService.findByMultipleFields(level, message, resourceId, startDate, endDate, traceId, spanId, commit, parentResourceId);
        return new ResponseEntity<>(logs,HttpStatus.OK);
    }

}
