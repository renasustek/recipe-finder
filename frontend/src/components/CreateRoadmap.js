import React, { useState, useEffect } from 'react';
import axios from "axios";

function CreateRoadmap ({roadmapName, userTopics, username, password, setUserTopics}){

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
          console.log(response.data);
        } catch (error) {
          console.error(error);
        }
        setUserTopics([]);
      }

    return(
        <button onClick={() => createRoadmap()}>Create Roadmap</button>
    );


}

export default CreateRoadmap;