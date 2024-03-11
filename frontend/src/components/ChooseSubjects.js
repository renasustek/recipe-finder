import React, { useState, useEffect } from 'react';
import axios from "axios";
import '../css/SubjectsStyle.css';

function ChooseSubjects({ username, password, onSubjectChange }) {
  const [subjects, setSubjects] = React.useState([]);
  const [selectedSubjectIds, setSelectedSubjectIds] = useState([]);


  useEffect(() => {
    const apiUrl = 'http://localhost:8080/subjects';

    // Encode credentials in Base64
    const credentials = btoa(`${username}:${password}`);
    const basicAuth = `Basic ${credentials}`;

    axios.get(apiUrl, {
      headers: {
        Authorization: basicAuth,
      },
    })
      .then((response) => {
        setSubjects(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }, []);

  const toggleSubjectSelection = (subjectId) => {
    setSelectedSubjectIds((prevSelected) => {
      const isSelected = prevSelected.includes(subjectId);
      const newSelected = isSelected
        ? prevSelected.filter((id) => id !== subjectId)
        : [...prevSelected, subjectId];
      onSubjectChange(newSelected);
      return newSelected;
    });
  };



  return (
    <section className='grid'>
      {subjects.map((eachSubject) => (
        <div key={eachSubject.id} className='card'>
          <button className='subjectButton' onClick={() => toggleSubjectSelection(eachSubject.id)}>{eachSubject.subject}</button>
        </div>
      ))}
    </section>
  );
}
export default ChooseSubjects;