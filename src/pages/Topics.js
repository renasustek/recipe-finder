import React, { useState, useEffect } from 'react';
import axios from "axios";
import '../css/DisplayBoxes.css';

function Subjects( {subjectId }) {

    return(
        <div>{subjectId}</div>
    );
}

export default Subjects;