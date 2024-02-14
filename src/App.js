import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import '@fortawesome/fontawesome-free/css/all.min.css'; // Import Font Awesome CSS
import Navbar from './components/Navbar';
import Home from './components/pages/Home';
import SignUp from './components/pages/SignUp'; // Import your SignUp component
import './App.css';
import ChooseExpertise from './pages/ChooseExpertise';
import GetRoadmap from './pages/GetRoadmap';


function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/sign-up" element={<SignUp />} />
          <Route path="/choose-expertise" element={<ChooseExpertise />} />
          <Route path="/get-roadmap" element={<GetRoadmap />} />

          {/* Add other routes/components as needed */}
        </Routes>
      </Router>
    </>
  );
}

export default App;
