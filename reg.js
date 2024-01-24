import React, { useState } from 'react';
import './App.css'; // CSS file with styles

function App() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const validateForm = () => {
    const emailRegex = /^[A-Za-z0-9+_.-]+@(gmail\.com|yahoo\.com|hotmail\.com)$/;
    setErrorMessage(''); // Reset error message

    if (!emailRegex.test(email)) {
      setErrorMessage('Invalid email address format.');
      return false;
    }

    if (email === '' || password === '') {
      setErrorMessage('Please enter both email and password.');
      return false;
    }

    return true;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const isValid = validateForm();

    if (isValid) {
      // Perform login actions (e.g., API call, authentication)
      console.log('Logging in...');
    }
  };

  return (
    <div className="form-container">
      <h2>User Authentication</h2>
      <form onSubmit={handleSubmit}>
        <h3>Login</h3>
        <label htmlFor="login-email">Email Address:</label>
        <input
          type="text"
          id="login-email"
          name="login-email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />

        <label htmlFor="login-password">Password:</label>
        <input
          type="password"
          id="login-password"
          name="login-password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />

        <span className="error-message">{errorMessage}</span>

        <button type="submit">Login</button>
      </form>

      <div className="signup-link">
        <p>
          Don't have an account? <a href="registration_page.html">Signup</a>
        </p>
        <p>
          <a href="password_reset.html">Forgot Password?</a>
        </p>
      </div>
    </div>
  );
}

export default App;