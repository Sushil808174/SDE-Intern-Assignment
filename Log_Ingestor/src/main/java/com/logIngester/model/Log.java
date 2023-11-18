package com.logIngester.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;
	
	private String level;
    private String message;
    private String resourceId;
    private LocalDateTime timestamp;
    private String traceId;
    private String spanId;
    private String commit;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "metadata_id")
    @Embedded
    private MetaData metadata;
}
