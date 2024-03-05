import React, { useState, useEffect } from 'react';
import axios from "axios";
import "../css/RoadmapFactory.css"
import GetRoadmap from '../components/GetRoadmap';
import UserGoalForm from './UserGoalForm';

function RoadmapFactory({username, password}) {
    const [roadmap, setRoadmap] = React.useState(null);
    const [showUserGoalForm, setShowUserGoalForm] = useState(false);

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
          setRoadmap(response.data);
        })
        .catch((error) => {
          console.error('Error fetching data:', error);
          setRoadmap(false)
        });
    }, []);
    
    const userGoalFormButton = () => {
      setShowUserGoalForm(!showUserGoalForm);
  }
    return(
      <div>
        <div className='topMenu'>
          <div>Hi {username}, welcome to your roadmap factory.</div>
          <div>View subjects</div>
          <div>View roadmaps</div>
        </div>
        
        
        <div className="content">         
        {roadmap ? <GetRoadmap roadmap={roadmap}/> : <button onClick={userGoalFormButton}>Create new +</button>}
      
        </div>
        <div>

        {showUserGoalForm ? 
        <UserGoalForm username={username} password={password}/> 
        : <div>fuck off</div>}
        </div>
      
      </div>
    );

}

export default RoadmapFactory;