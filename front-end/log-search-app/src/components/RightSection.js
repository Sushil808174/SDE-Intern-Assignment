// RightSection.js

import React, { useState } from 'react';
import axios from 'axios';
import LeftSection from './LeftSection';

const RightSection = ({onFilterSubmit,setIsReset}) => {
  const [level,setLevel] = useState(null);
  const [message,setMessage] = useState(null);
  const [resourceId,setResourceId] = useState(null);
  const [timestampStart,setTimeStamp] = useState(null);
  const [timestampEnd,setTimeStampEnd] = useState(null);
  const [traceId,setTraceId] = useState(null);
  const [spanId,setSpanId] = useState(null);
  const [commit,setCommit] = useState(null);
  const [metaData,setMetaData] = useState(null);
  const [filteredData,setFilteredData] = useState([]);

  const handleFilterSubmit = async () => {
    try {
        const queryParams = {
          level,
          message,
          resourceId,
          timestampStart,
          timestampEnd,
          traceId,
          spanId,
          commit,
          parentResourceId: metaData,
        };
      
        // Filter out null or undefined values
        const filteredQueryParams = Object.fromEntries(
          Object.entries(queryParams).filter(([_, value]) => value != null)
        );
      
        const response = await axios.get('http://localhost:3000/logs/findByMultipleFilters', {
          params: filteredQueryParams,
        });
      
        const data = response.data;
        console.log(data);
        console.log(response);
        setFilteredData(data);
        onFilterSubmit(data);
      } catch (error) {
        console.error('Error fetching filtered data:', error);
      }
 
  };
  

  const handleFilterReset = () => {
        setFilteredData([]);
        setIsReset(true);
      
  };

  return (
    <div className="right-section">
      <input
        type="text"
        name="level"
        value={level}
        onChange={(e) => setLevel(e.target.value)}
        placeholder="Level"
        className='w-75 rounded m-3 p-1 fs-5'
      />
      <input
        type="text"
        name="message"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
        placeholder="Message"
        className='w-75 rounded m-3 p-1 fs-5'
      />
      <input
        type="text"
        name="resourceId"
        value={resourceId}
        onChange={(e) => setResourceId(e.target.value)}
        placeholder="ResourceId"
        className='w-75 rounded m-3 p-1 fs-5'
      />
      <input
        type="text"
        name="timeStamp"
        value={timestampStart}
        onChange={(e) => setTimeStamp(e.target.value)}
        placeholder="timestamp"
        className='w-75 rounded m-3 p-1 fs-5'
      />
      <input
        type="text"
        name="traceId"
        value={traceId}
        onChange={(e) => setTraceId(e.target.value)}
        placeholder="Trace Id"
        className='w-75 rounded m-3 p-1 fs-5'
      />
      <input
        type="text"
        name="spanId"
        value={spanId}
        onChange={(e) => setSpanId(e.target.value)}
        placeholder="span Id"
        className='w-75 rounded m-3 p-1 fs-5'
      />
      <input
        type="text"
        name="commit"
        value={commit}
        onChange={(e) => setCommit(e.target.value)}
        placeholder="commit"
        className='w-75 rounded m-3 p-1 fs-5'
      />
      <input
        type="text"
        name="metadata"
        value={metaData}
        onChange={(e) => setMetaData(e.target.value)}
        placeholder="metadata"
        className='w-75 rounded m-3 p-1 fs-5'
      />

      {/* Add other input fields for different filter criteria */}
      <div>
        <button className='btn m-2 rounded bg-success text-white' onClick={handleFilterSubmit}>Submit</button>
        <button className='btn m-2 rounded bg-danger text-white' onClick={handleFilterReset}>Reset</button>
      </div>

    </div>
  );
};

export default RightSection;


// private String level;
//     private String message;
//     private String resourceId;
//     private LocalDateTime timestamp;
//     private String traceId;
//     private String spanId;
//     private String commit;
 
//     @Embedded
//     private MetaData metadata;