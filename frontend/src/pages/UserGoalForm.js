import React, { useState } from 'react';
import ChooseSubjects from '../components/ChooseSubjects'
import ChooseTopics from '../components/ChooseTopics';
import axios from "axios";

function UserGoalForm({username, password}) {
  const [subjectIds, setSubjectIds] = useState([]);

  const handleSubjectChange = (newSubjectIds) => {
    setSubjectIds(newSubjectIds);
  };



    return (
      <div>
        <div>Form</div>
        <div>
          <ChooseSubjects username={username} password={password} onSubjectChange={handleSubjectChange}/>
          <ChooseTopics username={username} password={password} subjectIds={subjectIds}/>
        </div>
      </div>
            
    );
  }
  
  export default UserGoalForm;