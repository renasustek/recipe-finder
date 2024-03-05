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
    
    const userGoalForm = () => {
      setShowUserGoalForm(!showUserGoalForm);
  }
    return(
      <div>
        <div className='sideMenu'>
          <div>Hi {username}, welcome to your roadmap factory.</div>
          <div>View all avaliable subjects and topics</div>
          <div>Generate Roadmap</div>
        </div>
        
        
        <div>
         {roadmap ? <GetRoadmap roadmap={roadmap}/> : <button onClick={userGoalForm}>Create Roadmap DOWN ARROW HERE</button>}//add component for create roadmap button
        
        </div>
        <div>
          {/* here you need to implement session, it only shows the data if you pass in an already authenticated user  */}
          {/* as im creating this page before user login is properly implemented */}
        {showUserGoalForm ? <UserGoalForm username={"renas"} password={"renas"}/> : <div>fuck off</div>}
        </div>
      
      </div>
    );

}

export default RoadmapFactory;