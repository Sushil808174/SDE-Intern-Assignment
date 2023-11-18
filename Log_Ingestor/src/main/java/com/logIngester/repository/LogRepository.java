package com.logIngester.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.logIngester.model.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

	public List<Log> findByLevel(String level);
	
	@Query("SELECT log FROM Log log WHERE log.message LIKE %:message%")
	public List<Log> findByMessageContains(@Param("message") String message);
	
	public List<Log> findByResourceId(String resourceId);
	
	
	@Query("SELECT log FROM Log log WHERE log.timestamp BETWEEN :startDate AND :endDate")
	public List<Log> findByTimestamp(LocalDateTime startDate,LocalDateTime endDate);
	
	public List<Log> findByTraceId(String traceId);
	
	public List<Log> findBySpanId(String spanId);
	
	
    @Query("SELECT log FROM Log log WHERE LOWER(log.commit) LIKE LOWER(CONCAT('%', :commit, '%'))")
	public List<Log> findByCommitContains(String commit);
    
    @Query("SELECT log FROM Log log WHERE log.metadata.parentResourceId = :parentResourceId")
    List<Log> findByParentResourceIdIgnoreCase(String parentResourceId);
    
    
    
    @Query("SELECT log FROM Log log " +
            "WHERE (:level IS NULL OR log.level = :level) " +
            "AND (:message IS NULL OR log.message LIKE %:message%) " +
            "AND (:resourceId IS NULL OR log.resourceId = :resourceId) " +
            "AND (:timestampStart IS NULL OR log.timestamp >= :timestampStart) " +
            "AND (:timestampEnd IS NULL OR log.timestamp <= :timestampEnd) " +
            "AND (:traceId IS NULL OR log.traceId = :traceId) " +
            "AND (:spanId IS NULL OR log.spanId = :spanId) " +
            "AND (:commit IS NULL OR log.commit = :commit) " +
            "AND (:parentResourceId IS NULL OR log.metadata.parentResourceId = :parentResourceId)")
    public List<Log> findByMultipleFilters(
            String level, String message, String resourceId,
            LocalDateTime timestampStart, LocalDateTime timestampEnd,
            String traceId, String spanId, String commit, String parentResourceId);
}
