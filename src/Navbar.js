import React from 'react';
import '/home/renas/workspace/recipe-finder/src/css/NavBar.css'; // Import the CSS file

function NavBar() {
    return (
        <nav className="navbar">
            <div className="navbar-container">
                <div className="navbar-logo">
                    <a href="/">RecipeFinder</a>
                </div>
                <ul className="navbar-menu">
                    <li><a href="#home">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#services">Services</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
                <div className="navbar-toggle">
                    <span className="toggle-icon">☰</span>
                </div>
            </div>
        </nav>
    );
}

export default NavBar;
