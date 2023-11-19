import React from "react";
import { useEffect } from "react";

const LeftSection = ({ filteredData ,isReset,setFilteredData}) => {
    useEffect(() => {
        if (isReset) {
          // Clear the filtered data
          setFilteredData([]);
        }
      }, [isReset]);

  return (
    <div className="container-fluid">
      <h2>Filtered Logs</h2>

      <table className="table">
        <thead>
          <tr>
            <th>Level</th>
            <th>Message</th>
            <th>Resource ID</th>
            <th>Timestamp</th>
            <th>Trace ID</th>
            <th>Span ID</th>
            <th>Commit</th>
            <th>Parent Resource ID</th>
          </tr>
        </thead>
        <tbody>
          {filteredData.map((log, index) => (
            <tr key={index}>
              <td>{log.level}</td>
              <td>{log.message}</td>
              <td>{log.resourceId}</td>
              <td>{log.timestamp}</td>
              <td>{log.traceId}</td>
              <td>{log.spanId}</td>
              <td>{log.commit}</td>
              <td>{log.metadata.parentResourceId}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default LeftSection;
