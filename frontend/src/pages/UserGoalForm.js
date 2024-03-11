import React, { useState } from 'react';
import ChooseSubjects from '../components/ChooseSubjects';
import ChooseTopics from '../components/ChooseTopics';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import CreateRoadmap from '../components/CreateRoadmap';
import '../css/UserGoalForm.css';

function UserGoalForm({ username, password , setDisplayRoadmap, setCurrentState}) {
  const [subjectIds, setSubjectIds] = useState([]);
  const [roadmapName, setRoadmapName] = useState("");
  const [userTopics, setUserTopics] = useState([]);

  const handleSubjectChange = (newSubjectIds) => {
    setSubjectIds(newSubjectIds);
  };
  return (
    <div className="userGoalFormContainer">
      <Box
        component="form"
        sx={{
          display: 'flex',
          justifyContent: 'center',
          alignItems: 'center',
          '& > :not(style)': { m: 1 },
        }}
        noValidate
        autoComplete="off"
      >
        <TextField
          id="outlined-basic"
          label="Roadmap Name"
          variant="standard"
          onChange={(e) => setRoadmapName(e.target.value)}
        />
        {roadmapName.length >= 1 && roadmapName.length <= 12 ? (
          <CreateRoadmap setCurrentState={setCurrentState} setDisplayRoadmap={setDisplayRoadmap} roadmapName={roadmapName} username={username} password={password} setUserTopics={setUserTopics} userTopics={userTopics} />
        ) : (
          <div className="errorMessage">Name needs to be between 1 and 12 characters</div>
        )}
      </Box>
          
      <div className="subjectsTopicsContainer">
        <ChooseSubjects username={username} password={password} onSubjectChange={handleSubjectChange} />
      </div>
      <ChooseTopics username={username} password={password} subjectIds={subjectIds} setUserTopics={setUserTopics} userTopics={userTopics} />
    </div>
  );
}

export default UserGoalForm;
