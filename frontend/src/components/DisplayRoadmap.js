import React from 'react';
import '../css/DisplayBoxes.css';
import axios from 'axios';

import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';

function DisplayRoadmap({ roadmap }) {
  
    const handleDelete = () => {
    
    };

    return (
      <section >
        <section>
          <div className="centered-header">{roadmap.name}</div>
          <div>
            <IconButton aria-label="delete" onClick={handleDelete}>
              <DeleteIcon />
            </IconButton>

          </div>
        </section>
        <div className='grid'>
          {roadmap?.revisionResourceDaos.map((resource) => (
            <div key={resource.id} className='revisionRecource'>
              <div className='revisionRecourceType'>Resource type: {resource.resourceName}</div>
              <div className='revisionRecourceWhereToAccess'>Where to Access: <a href={resource.whereToAccess}>{resource.whereToAccess}</a></div>
              <div className='revisionRecourceDescription'>Description: <div>{resource.description}</div></div>
              <div />
            </div>
          ))}
        </div>
      </section>
    );
  }

  export default DisplayRoadmap;
