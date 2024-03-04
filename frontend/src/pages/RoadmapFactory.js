import React, { useState, useEffect } from 'react';
import axios from "axios";
import "../css/RoadmapFactory.css"
import GetRoadmap from '../components/GetRoadmap';

function RoadmapFactory({username, password}) {
    const [roadmap, setRoadmap] = React.useState(null);


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
    
    
   
      console.log(roadmap)
  
    return(
      <div>
        <div className='sideMenu'>
          <div>Hi {username}, welcome to your roadmap factory.</div>
          <div>View all avaliable subjects and topics</div>
          <div>Generate Roadmap</div>
        </div>
        
        
        <div>
         {roadmap ? <GetRoadmap roadmap={roadmap}/> : <div>create roadmap</div>}
          
        </div>
      
      
      </div>
    );

}

export default RoadmapFactory;