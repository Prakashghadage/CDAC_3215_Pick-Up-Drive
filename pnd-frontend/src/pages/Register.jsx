import React, { useState } from 'react';
import Axios from 'axios';

export default function 
() {

    const[username, setUsername]=useState('')
    const[email, setEmail]=useState('')
    const[password, setPassword]=useState('')

    const postData=(e)=>{
               e.preventDefault();
               alert("Data registered successfully!!")
               Axios.post('http://localhost:8080/pnd/users/adduser',{
                username,
                email,
                password
               }).then(res => console.log("data posted",res)).catch(err => console.log(err))
    }
   

  return (
    <div>
      <div className='container'>
      <div className='row'>
          <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
              <h2 className='text-center m-4'>Register</h2>
              <div className='mb-3'>
                    <label htmlFor='uname' className='form-label'>
                       Username
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter username" name="uname" value={username} onChange={(e)=>setUsername(e.target.value)}/>
                    <label htmlFor='email' className='form-label'>
                       Email
                    </label>
                    <input type={"email"} className="form-control" placeholder="Enter valid email id" name="email" value={email} onChange={(e)=>setEmail(e.target.value)}/>
                    <label htmlFor='pass' className='form-label'>
                       Password
                    </label>
                    <input type={"password"} className="form-control" placeholder="Enter password" name="pass" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                   <button type="submit" className="btn btn-outline-success" onClick={postData}>
                        Submit
                   </button>
                   <button type="submit" className="btn btn-outline-danger">
                        Reset
                   </button>
              </div>
          </div>
      </div>
    </div>
        
    </div>
  )
}
