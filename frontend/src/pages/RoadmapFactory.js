import React, { useState, useEffect } from 'react';
import axios from "axios";
import "../css/RoadmapFactory.css"
import DisplayRoadmap from '../components/DisplayRoadmap';
import UserGoalForm from './UserGoalForm';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import CircularProgress from '@mui/material/CircularProgress';
import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';


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
  }, [currentState]);



  const handleRoadmapChange = (index) => {

    const matchedRoadmap = roadmaps[index];
    setDisplayRoadmap(matchedRoadmap);
    setCurrentState(3);
  };


  return (
    <div>

      <section className='topMenu'>
        <ButtonGroup color="primary" variant="filledTonal" aria-label="Basic button group">

          <Button onClick={() => setCurrentState(1)}>How to use</Button>
          <Button onClick={() => setCurrentState(2)}>Create new +</Button>
          <div>
            {roadmaps && roadmaps.length > 0 ? (
              roadmaps.map((eachRoadmap, index) => (
                <Button key={index} onClick={() => handleRoadmapChange(index)}>
                  {eachRoadmap.name}
                </Button>
              ))
            ) : (
              <p>loading or no roadmaps...</p>
            )}
          </div>
        </ButtonGroup>
      </section>


      <section className='content'>

        {currentState === 1 && (
          <div>
            <p>How to use the roadmap factory</p>
          </div>
        )}

        {currentState === 2 && (
          <div>
            <UserGoalForm username={username} password={password} setDisplayRoadmap={setDisplayRoadmap} setCurrentState={setCurrentState}/>
          </div>
        )}

        {currentState === 3 && (
          <div>
            <DisplayRoadmap setCurrentState={setCurrentState} roadmap={displayRoadmap} username={username} password={password}/>
          </div>
        )}
      </section>
    </div>
  );

}

export default RoadmapFactory;