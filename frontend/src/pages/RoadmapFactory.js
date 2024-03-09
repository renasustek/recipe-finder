import React, { useState, useEffect } from 'react';
import axios from "axios";
import "../css/RoadmapFactory.css"
import DisplayRoadmap from '../components/DisplayRoadmap';
import UserGoalForm from './UserGoalForm';





function RoadmapFactory({ username, password }) {
  const [roadmaps, setRoadmaps] = React.useState(null);
  const [currentState, setCurrentState] = useState(1);




  const [displayRoadmap, setDisplayRoadmap] = useState(null);


  useEffect(() => {
    const apiUrl = `http://localhost:8080/roadmap/${username}`;
    const credentials = btoa(`${username}:${password}`);
    const basicAuth = `Basic ${credentials}`;

    axios.get(apiUrl, {
      headers: {
        Authorization: basicAuth,
      },
    })
      .then((response) => {
        setRoadmaps(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }, []);



  const handleRoadmapChange = (index) => {
   
    const matchedRoadmap = roadmaps[index];
    setDisplayRoadmap(matchedRoadmap);
    setCurrentState(2);  
    };

  
  return (
    <div>

      <section className='topMenu'>
      <button onClick={() => setCurrentState(1)}>Hi {username}, welcome to your roadmap factory</button>
        <div>
          {roadmaps && roadmaps.length > 0 ? (
            roadmaps.map((eachRoadmap, index) => (
              <button key={index} onClick={() => handleRoadmapChange(index)}>
                {eachRoadmap.name}
              </button>
            ))
          ) : (
            <p>Loading or no roadmaps available...</p>
          )}
          <button onClick={() => setCurrentState(3)}>Create new +</button>
        </div>
            
        </section>


      <section className='content'>

      {currentState === 1 && (
        <div>
          <p>How to use the roadmap factory</p>
        </div>
      )}

      {currentState === 2 && (
        <div>
           <DisplayRoadmap roadmap={displayRoadmap} />
        </div>
      )}

      {currentState === 3 && (
        <div>
         <UserGoalForm username={username} password={password} />
        </div>
      )}

      </section>

    </div>
  );

}

export default RoadmapFactory;