import React, { useState, useEffect } from 'react';
import axios from "axios";
import '../css/ChooseRelevantSubjects.css';

function ChooseTopics({ username, password, subjectIds , roadmapName, setUserTopics, userTopics}) {
  const [topics, setTopics] = React.useState([]);
  


  const addUserTopic = (topicId, levelOfExpertise) => {
    const updatedTopics = userTopics.map(topic =>
      topic.topicId === topicId
        ? { ...topic, levelOfExpertise }
        : topic 
    );

    if (!userTopics.some(topic => topic.topicId === topicId)) {
      updatedTopics.push({ topicId, levelOfExpertise });
    }

    setUserTopics(updatedTopics);
  };



  useEffect(() => {

    const credentials = btoa(`${username}:${password}`);
    const basicAuth = `Basic ${credentials}`;

    const fetchAndSetTopics = async (subjectId) => {
      const apiUrl = `http://localhost:8080/topics/${subjectId}`;
      try {
        const response = await axios.get(apiUrl, { headers: { Authorization: basicAuth } });
        setTopics(prevTopics => [...prevTopics, ...response.data]);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };


    setTopics([]);


    (async () => {
      for (const subjectId of subjectIds) {
        await fetchAndSetTopics(subjectId);
      }
    })();
  }, [subjectIds]);


  return (
    <div>
      <section className='grid'>
        {topics.map((eachTopic) => (
          <div key={eachTopic.id} className='card'>
            <div className='card__title'>{eachTopic.topicName}</div>
            <div>
              <button onClick={() => addUserTopic(eachTopic.id, "NOVICE")}>novice</button>
              <button onClick={() => addUserTopic(eachTopic.id, "INTERMEDIATE")} >intermediate</button>
              <button onClick={() => addUserTopic(eachTopic.id, "EXPERT")}>expert</button>
            </div>
          </div>
        ))}
      </section>
       <section>
       </section>
      
    </div>
  );
}
export default ChooseTopics;