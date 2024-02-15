import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import '@fortawesome/fontawesome-free/css/all.min.css'; // Import Font Awesome CSS
import Navbar from './components/Navbar';
import Home from './pages/Home';
import SignUp from './pages/SignUp'; // Import your SignUp component
import './App.css';
import DiscoverCourses from './pages/DiscoverCourses';


function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/sign-up" element={<SignUp />} />
          <Route path="/discover-courses" element={<DiscoverCourses />} />
          {/* Add other routes/components as needed */}
        </Routes>
      </Router>
    </>
  );
}

export default App;
