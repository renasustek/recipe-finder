import React, { useState } from 'react';
import ChooseSubjects from '../components/ChooseSubjects'
import ChooseTopics from '../components/ChooseTopics';
import axios from "axios";
import Box from '@mui/material/Box';
import Input from '@mui/material/Input';

const ariaLabel = { 'aria-label': 'description' };

function UserGoalForm({ username, password }) {
  const [subjectIds, setSubjectIds] = useState([]);
  const [roadmapName, setRoadmapName] = useState("RoadmapName");

  const handleSubjectChange = (newSubjectIds) => {
    setSubjectIds(newSubjectIds);
  };


  return (
    <div>
      <div>
      <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1 },
      }}
      noValidate
      autoComplete="off"
    >
     
      <Input  value={roadmapName} onChange={(e) => setRoadmapName(e.target.value)} inputProps={ariaLabel} />
    </Box>
        
        <ChooseSubjects username={username} password={password} onSubjectChange={handleSubjectChange} />
        <ChooseTopics username={username} password={password} subjectIds={subjectIds} roadmapName={roadmapName}/>
      </div>
    </div>

  );
}

export default UserGoalForm;