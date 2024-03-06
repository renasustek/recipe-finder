import React, { useState, useEffect } from 'react';
import axios from "axios";
import '../css/ChooseRelevantSubjects.css';

function ChooseTopics({username, password, subjectIds}) {
    const [topics, setTopics] = React.useState([]);
    

    
    const postUserTopics = async (topicId, confidenceLevel) => {
       
        const credentials = btoa(`${username}:${password}`);
        const basicAuth = `Basic ${credentials}`;
        const apiUrl = `http://localhost:8080/topics/${username}`; 
        try{
            const response = await axios.post(apiUrl, {
                username : username, 
                userTopics: [
                    { "topicId": topicId, "levelOfExpertise": confidenceLevel }
                ]
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
      return(
        <section className='grid'>
        {topics.map((eachTopic) => (
        <div key={eachTopic.id} className='card'>
          <div className='card__title'>{eachTopic.topicName}</div>
          <div>
            <button onClick={() => postUserTopics(eachTopic.id, "NOVICE")}>novice add css here</button>
            <button onClick={() => postUserTopics(eachTopic.id, "INTERMEDIATE")} >intermediate</button>
            <button onClick={() => postUserTopics(eachTopic.id, "EXPERT") }>advanced</button>
          </div>
        </div>
      ))}
      </section>
      );
   }
export default ChooseTopics;