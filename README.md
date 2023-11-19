
# Dyte Log Ingestor and Query Interface

Creating a log ingestor system and query interface with Java and Spring Boot. This project provides a RESTful API for ingesting logs and querying log data based on various filters.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Database (MySQL)
- Axios (for API requests in the front end)
- React (for the front-end user interface)

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Node.js
- npm (Node Package Manager)
- Database server (MySQL)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Sushil808174/SDE-Intern-Assignment


# Table of Contents

## API Endpoints

1. Check API
2. Ingest Log Entry
3. Find All Logs
4. Find by Level
5. Find by Message
6. Find by Resource ID
7. Find by Timestamp Range
8. Find by Trace ID
9. Find by Span ID
10. Find by Commit
11. Find by Parent Resource ID
12. Find by Multiple Filters

## API Endpoints
1. Check API
- Description: Check the status of the API.
- Method: GET
- URL: `http://localhost:3000/logs/hello-world`
- Response: "Hello world!" with HTTP status 202.
2. Ingest Log Entry
- Description: Ingest a log entry into the system.
- Method: POST
- URL: `http://localhost:3000/logs/ingest-log`
- Request Example:
   ```bash
       {
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


- Response: Ingested log with HTTP status 201.

3. Find All Logs
- Description: Find all logs in the database.
- Method: GET
- URL: `http://localhost:3000/logs/all-logs`
- Response: List of all logs in the database with HTTP status 200.
4. Find by Level
- Description: Find logs by the specified log level.
- Method: GET
- URL: `http://localhost:3000/logs/findByLevel/{level}`
- Response: List of logs matching the specified log level with HTTP status 200.
5. Find by Message
- Description: Find logs with messages containing the specified term.
- Method: GET
- URL: `http://localhost:3000/logs/findByMessage/{message}`
- Response: List of logs containing the specified term in messages with HTTP status 200.
6. Find by Resource ID
- Description: Find logs related to the specified resource ID.
- Method: GET
- URL: `http://localhost:3000/logs/findByResourceId/{resourceId}`
- Response: List of logs related to the specified resource ID with HTTP status 200.
7. Find by Timestamp Range
- Description: Find logs within the specified timestamp range.
- Method: GET
- URL: `http://localhost:3000/logs/findByTimestampBetween/{startDate}/{endDate}`
- Response: List of logs within the specified timestamp range with HTTP status 200.
8. Find by Trace ID
- Description: Find logs with trace ID containing the specified term.
- Method: GET
- URL: `http://localhost:3000/logs/findByTraceId/{traceId}`
- Response: List of logs related to the specified trace ID with HTTP status 200.
9. Find by Span ID
- Description: Find logs with span ID containing the specified term.
- Method: GET
- URL: `http://localhost:3000/logs/findBySpanId/{spanId}`
- Response: List of logs related to the specified span ID with HTTP status 200.
10. Find by Commit
- Description: Find logs with commit containing the specified term.
- Method: GET
- URL: `http://localhost:3000/logs/findByCommit/{commit}`
- Response: List of logs containing the specified commit with HTTP status 200.
11. Find by Parent Resource ID
- Description: Find logs related to the specified parent resource ID.
- Method: GET
- URL: `http://localhost:3000/logs/findByParentResourceId/{parentResourceId}`
- Response: List of logs related to the specified parent resource ID with HTTP status 200.
12. Find by Multiple Filters
- Description: Find logs based on multiple filters.
- Method: GET
- URL: `http://localhost:3000/logs/findByMultipleFilters`
- Response: List of logs based on the specified fields with HTTP status 200.
- Param: you can filter according to your choice.
