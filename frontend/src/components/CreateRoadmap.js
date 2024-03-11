import React, { useState, useEffect } from 'react';
import axios from "axios";
import Button from '@mui/material/Button';

function CreateRoadmap ({roadmapName, userTopics, username, password, setUserTopics, setDisplayRoadmap, setCurrentState}){

    const createRoadmap = async () => {
        const credentials = btoa(`${username}:${password}`);
        const basicAuth = `Basic ${credentials}`;
        const apiUrl = `http://localhost:8080/roadmap/${username}`;
        try {
          const response = await axios.post(apiUrl, {
            roadmapName: roadmapName,
            userTopics: userTopics
          }, {
            headers: {
              Authorization: basicAuth,
              'Content-Type': 'application/json'
            }
          });
          setDisplayRoadmap(response.data);
          setCurrentState(3);
        } catch (error) {
          console.error(error);
        }
        setUserTopics([]);
      }

    return(
      <Button variant="contained" onClick={() => createRoadmap()}>Create Roadmap</Button>
    );


}

export default CreateRoadmap;