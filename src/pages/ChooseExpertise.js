import React from  'react';
import CourseBlock from '../components/CourseBlock';
import img1 from '../images/mathematics.jpeg';
import img2 from '../images/networks.jpeg';
import img3 from '../images/python.jpeg';
import '../css/ChooseExpertise.css';

function ChooseExpertise() {
  const contentBlocks = [
    { title: 'Mathematics For A Levels for OCR A Student Book 1', imageUrl: img1 },
    { title: 'Introduction to Operating Systems and Networks', imageUrl: img2 },
    { title: 'Python Programming Novice to Expert', imageUrl: img3 },
    { title: 'Mathematics For A Levels for OCR A Student Book 1', imageUrl: img1 },
    { title: 'Introduction to Operating Systems and Networks', imageUrl: img2 },
    { title: 'Python Programming Novice to Expert', imageUrl: img3 },
  ];

  return (
    <div className="course-container">
      {contentBlocks.map((content, index) => (
       <div key={index} className="content-block">
       <CourseBlock {...content} />
     </div>
      ))}
    </div>
  );
}

export default ChooseExpertise;