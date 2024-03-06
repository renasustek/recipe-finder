import React, { useState, useEffect } from 'react';
import axios from "axios";
import "../css/RoadmapFactory.css"
import DisplayRoadmap from '../components/DisplayRoadmap';
import UserGoalForm from './UserGoalForm';

function RoadmapFactory({ username, password }) {
  const [roadmaps, setRoadmaps] = React.useState(null);
  const [showUserGoalForm, setShowUserGoalForm] = useState(false);
  const [selectedRoadmap, setSelectedRoadmap] = useState("⬇️ Select roadmap ⬇️")
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
  console.log(roadmaps);



  const handleRoadmapChange = (e) => {
    const selectedIndex = e.target.value;
    setSelectedRoadmap(selectedIndex);
  
    if (selectedIndex === "no roadmap selected") {
      setDisplayRoadmap(null);
    } else {
      const matchedRoadmap = roadmaps[selectedIndex];
      if (matchedRoadmap) {
        setDisplayRoadmap(matchedRoadmap);
      } else {
        setDisplayRoadmap(null);
      }
    }
  };
 
  const userGoalFormButton = () => {
    setShowUserGoalForm(!showUserGoalForm);
  }
  return (
    <div>
      <div className='topMenu'>
        <div>Hi {username}, welcome to your roadmap factory.</div>
        <div>View roadmaps</div>
      </div>


      <div className="content">
        <select onChange={handleRoadmapChange} value={selectedRoadmap}>
          <option value="no roadmap selected">-- Select roadmap --</option>
          {roadmaps && roadmaps.length > 0 ? (
            roadmaps.map((eachRoadmap, index) => (
              <option key={index} value={index}>{eachRoadmap.name}</option>
            ))
          ) : (
            <option>Loading or no roadmaps...</option>
          )}
        </select>
      </div>

      <div>
        {displayRoadmap == null ?
          <div>
            <div>
              Do you want to create a new roadmap?
            </div>
            <button onClick={userGoalFormButton}>Create new +</button>
          </div>
          : <DisplayRoadmap roadmap={displayRoadmap} />}


      </div>


      <div>

        {showUserGoalForm ?
          <UserGoalForm username={username} password={password} />
          : <div>fuck off</div>}
      </div>

    </div>
  );

}

export default RoadmapFactory;