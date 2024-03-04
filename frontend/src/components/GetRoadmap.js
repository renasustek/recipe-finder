import React from 'react';
import '../css/DisplayBoxes.css';

function GetRoadmap({roadmap}) {
 
 
  return (
      <section className='grid'>
        {roadmap?.revisionResourceDaos.map((resource) => (
        <div key={resource.id} className='card'>
          <div className='card__name'>Resource type: {resource.resourceName}</div>
          <div className='card__title'>Topic: {resource.topic}</div>
          <div>Where to Access: <a href={resource.whereToAccess}>{resource.whereToAccess}</a></div>
          <div className='card__description'>Description: {resource.description}</div>
          <div />
        </div>
      ))}
      </section>
  );
}

export default GetRoadmap;
