import React, { useState } from 'react';
import '../css/DiscoverCourses.css';
import { Button } from 'rsuite';
import image1 from "../images/dataanalytics.png";
import image2 from"../images/mathematics.jpeg"
import image3 from"../images/python.jpeg"
import image4 from"../images/webdevelopement.jpeg"
import image5 from"../images/marketing.jpeg"
import image6 from"../images/weightmanagement.jpeg"

const courseData = [
    {
      title: "Data Science and Analytics",
      imageUrl: image1,
    },
    {
      title: "Mathematics Calculus I",
      imageUrl: image2,
    },
    {
      title: "Learn Python",
      imageUrl: image3,
    },
    {
      title: "Front-End Web Development",
      imageUrl: image4,
    },
    {
      title: "Digital Marketing and E-commerce",
      imageUrl: image5,
    },
    {
      title: "Weight Management",
      imageUrl: image6,
    }
  ];

 

  function DiscoverCourses() {
    const [clickedButtonIndexes, setClickedButtonIndexes] = useState(Array.from({ length: courseData.length }, () => null));
  
    const handleButtonClick = (courseIndex, buttonIndex) => {
      const newClickedButtonIndexes = [...clickedButtonIndexes];
      newClickedButtonIndexes[courseIndex] = buttonIndex;
      setClickedButtonIndexes(newClickedButtonIndexes);
    };
  
    return (
      <div className='course-wrapper'>
        {courseData.map((course, courseIndex) => (
          <div className='course-container' key={courseIndex}>
            <div className='image-container'>
              <img src={course.imageUrl} alt="" />
            </div>
            <div className='content'>
              <p style={{ margin: '10px' }}>{course.title}</p>
              <div className='button-container'>
                <div className='expertise-buttons'>
                  <Button
                    className={`expertise-button ${clickedButtonIndexes[courseIndex] === 0 ? 'clicked' : ''}`}
                    active
                    appearance="default"
                    onClick={() => handleButtonClick(courseIndex, 0)}
                  >
                    Novice
                  </Button>
                  <Button
                    className={`expertise-button ${clickedButtonIndexes[courseIndex] === 1 ? 'clicked' : ''}`}
                    active
                    appearance="default"
                    onClick={() => handleButtonClick(courseIndex, 1)}
                  >
                    Competent
                  </Button>
                  <Button
                    className={`expertise-button ${clickedButtonIndexes[courseIndex] === 2 ? 'clicked' : ''}`}
                    active
                    appearance="default"
                    onClick={() => handleButtonClick(courseIndex, 2)}
                  >
                    Expert
                  </Button>
                </div>
                <Button className='roadmap-button' active appearance="default">
                  Click here to process Personalised Roadmap
                </Button>
              </div>
            </div>
          </div>
        ))}
      </div>
    );
  }
  
  export default DiscoverCourses;