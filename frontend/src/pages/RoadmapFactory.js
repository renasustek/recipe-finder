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
    // Replace the URL with the correct API endpoint
    const apiUrl = `http://localhost:8080/roadmap/${username}`;
    // Encode credentials in Base64
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
    const currentSelectedRoadmap = e.target.value;
     setSelectedRoadmap(currentSelectedRoadmap);
     if(currentSelectedRoadmap == "no roadmap selected"){
      setDisplayRoadmap(null)
    }
    else{
      const flatRoadmapList = roadmaps.flat();
      const matchedRoadmap = flatRoadmapList.find(r => r.name === currentSelectedRoadmap);
      if (matchedRoadmap) {
        setDisplayRoadmap(matchedRoadmap);
      } else {
        setDisplayRoadmap(null); // or set to an empty array, depending on your requirements
      }
    }
    
  }
  useEffect(() => {
    console.log(displayRoadmap, "hello");
  }, [displayRoadmap]);
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
              <option key={index} value={eachRoadmap.name}>{eachRoadmap.name}</option>
            ))
          ) : (
            <option>Loading or no roadmaps...</option>
          )}
        </select>
        {/* {roadmap ? <GetRoadmap roadmap={roadmap}/> : <button onClick={userGoalFormButton}>Create new +</button>} */}
      </div>
      
      <div>
          {displayRoadmap == null ? <div>null</div> : <DisplayRoadmap roadmap={displayRoadmap}/>}
       

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