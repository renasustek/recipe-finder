import React from 'react'
import {Button} from 'rsuite';
import '../css/CourseBlock.css'


function CourseBlock({title, imageUrl}) {

  return (
    <div className='container'>
      
      <div className='image-container'>
        <img src={imageUrl} alt=''/>
      </div>

      <div className='text-container'>
        <h1 style={{margin:'20px'}}>{title} </h1>
        <h2 style={{color:'#FF6B00', margin: '10px'}}>Choose your Expertise Below</h2>
          <div className='button-container'>
              <Button className='expertise-button' active appearance="default" > 
                        Novice 
              </Button>
              <Button className='expertise-button' active appearance="default" > 
                        Competent 
              </Button>
              <Button className='expertise-button' active appearance="default">
                        Expert 
              </Button>
              <Button className='roadmap-button' active appearance="default" > 
                        Click here to process Personalised Roadmap 
              </Button>
          </div>
      </div>
    </div>
  )
}

export default CourseBlock