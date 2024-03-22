import React, { useState } from 'react';
import '../css/DisplayBoxes.css';
import axios from 'axios';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import IconButton from '@mui/material/IconButton';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import { set } from 'rsuite/esm/utils/dateUtils';

function DisplayRoadmap({ setCurrentState, roadmap, username, password }) {
  // const [confirmDelete, setConfirmDelete] = useState(false);
  const [showConfirmDelete, setShowConfirmDelete] = useState(false);
  const [showEditName, setShowEditName] = useState(false)
  const [editedName, setEditedName] = useState("")
  const apiUrl = `http://localhost:8080/roadmap/${roadmap.id}`;
  const credentials = btoa(`${username}:${password}`);
  const basicAuth = `Basic ${credentials}`;

  const confirmDelete = () => {
    setShowConfirmDelete(!showConfirmDelete);
  }

  const handleDelete = async () => {
    console.log(editedName)
    axios.delete(apiUrl, {
      headers: {
        Authorization: basicAuth,
      },
    }).catch(error => {
      console.error(error);
    });
    setCurrentState(1);
  };


  const editNameRequest = async () => {
    axios.put(apiUrl, { "name": editedName }, {
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: basicAuth,

      }
    })
    setCurrentState(1);

    setEditedName("")
  }

  const editName = () => {
    setShowEditName(!showEditName)
  }

  return (
    <section >
      <section>
        <div className="centered-header">{roadmap.name}
          <IconButton aria-label="delete" onClick={editName}>
            <EditIcon />
          </IconButton></div>
        <div>
          <IconButton aria-label="delete" onClick={confirmDelete}>
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
            <div className='revisionRecourceDescription'>For: <div>{resource.levelOfExpertise
    
            }</div></div>

            <div />
          </div>
        ))}
      </div>
      {showConfirmDelete === true && (
        <div className="overlay">
          <div className="title">
            Delete this roadmap?
            <div className="buttons">
              <button className="button buttonYes" onClick={handleDelete}>Yes</button>
              <button className="button buttonNo" onClick={confirmDelete}>No</button>
            </div>
          </div>
        </div>
      )}
      {showEditName === true && (
        <div className="overlay">
          <div className="title">
            Edit this roadmapName?
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
                onChange={(e) => setEditedName(e.target.value)}
              />
            </Box>

            {editedName.length >= 1 && editedName.length <= 12 ? (
              <div className="buttons">
                <button className="button buttonYes" onClick={editNameRequest}>Yes</button>
                <button className="button buttonNo" onClick={editName}>No</button>
              </div>) : (
              <div className="errorMessage">Name needs to be between 1 and 12 characters</div>
            )}

          </div>
        </div>
      )}
    </section>


  );
}

export default DisplayRoadmap;
