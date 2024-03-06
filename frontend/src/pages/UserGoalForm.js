import React, { useState } from 'react';
import ChooseSubjects from '../components/ChooseSubjects'
import ChooseTopics from '../components/ChooseTopics';
import axios from "axios";

function UserGoalForm({username, password}) {
  const [subjectIds, setSubjectIds] = useState([]);

  const handleSubjectChange = (newSubjectIds) => {
    setSubjectIds(newSubjectIds);
  };

  const createRoadmap = async (roadmapName) => {
       
    const credentials = btoa(`${username}:${password}`);
    const basicAuth = `Basic ${credentials}`;
    const apiUrl = `http://localhost:8080/roadmap/${username}`; 
    try{
        const response = await axios.post(apiUrl, {
          name : roadmapName
        }, {
            headers: {
                Authorization: basicAuth,
                'Content-Type': 'application/json'
            }
        });
        console.log(response.data);
    } catch(error){
        console.error(error);
    }
}

  console.log(subjectIds);

    return (
      <div>
        <div>Form</div>
        <div>
          <ChooseSubjects username={username} password={password} onSubjectChange={handleSubjectChange}/>
          <ChooseTopics username={username} password={password} subjectIds={subjectIds}/>
          <button onClick={() => createRoadmap("created")}>Click here to create roadmap</button>
        </div>
      </div>
            
    );
  }
  
  export default UserGoalForm;