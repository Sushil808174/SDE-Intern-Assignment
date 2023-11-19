//MainSection.js
import { useState } from 'react';
import LeftSection from './LeftSection';
import RightSection from './RightSection';

const MainSection = () => {
    const [filteredData, setFilteredData] = useState([]);
    const [isReset, setIsReset] = useState(false);
    const handleFilterSubmit = (data) => {
        setFilteredData(data);
      };

  return (
    <div className="container-fluid text-center">
        <div className='d-flex'>
            <div className='border w-75 vh-100'>
                <LeftSection filteredData={filteredData} setFilteredData={setFilteredData}/>
            </div>
            <div className='border w-25 vh-100'>
                <RightSection onFilterSubmit={handleFilterSubmit} setIsReset={setIsReset}/>
            </div>
        </div>
    </div>
  );
};

export default MainSection;
