
// App.js

import React, { useState } from 'react';
import Navbar from './components/Navbar';
import MainSection from './components/MainSection';

const App = () => {

  return (
    <div className="app-container">
      <Navbar />
      <MainSection/>
    </div>
  );
};

export default App;

