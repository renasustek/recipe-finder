import React, { useState } from 'react';
import { FaStar } from 'react-icons/fa';
import '../css/Feedback.css';

function Feedback() {
  const [rating, setRating] = useState(0);
  const [rated, setRated] = useState(false);

  const handleStarClick = (index) => {
    setRating(index + 1);
    setRated(true); //when rating is selected
  };

  const handleSubmit = () => {
    // Handle submission logic here
    console.log('Feedback successfully submitted:', rating);
  }

  const handleCancel = () => {
    // Handle cancellation logic here
    console.log('Feedback canceled');
    setRating(0);
    setRated(false); //Reset const setRated
  };

  return (
    <div className='screen'>
    <div className='rating-container'>
      <div className="feedback-text">
        <p style={{ fontWeight: 'bold', fontSize: '24px', margin: '10px' }}>Give Feedback:</p>
        <p style={{ fontSize: '16px' }}>How is your user experience with us?</p>
      </div>
      <div className="stars-container">
        {[...Array(5)].map((_, index) => (
          <FaStar
            key={index}
            size={60}
            color={index < rating ? '#1f98f4' : 'rgba(56, 125, 255, 0.17)'}
            onClick={() => handleStarClick(index)}
            style={{ cursor: 'pointer' }}
          />
        ))}
      </div>
      <div className="rated-stars">
        <p>You rated {rating} stars</p>
      </div>
      <div className="buttons-container">
        <button className={rated ? 'submit active' : 'submit'} onClick={handleSubmit}>Submit</button>
        <button className='cancel' onClick={handleCancel}>Cancel</button>
      </div>
    </div>
    </div>
  );
}

export default Feedback;
