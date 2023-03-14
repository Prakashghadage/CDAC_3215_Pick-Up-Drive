import React from 'react';
import { Link } from 'react-router-dom';
export default function NavBar() {
  return (
    <div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">
      <img src="images/PND-logo.png"  width="180" height="40" />
    </a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">

<div className='col-12'>
<Link className="btn btn-outline-primary" to="/location">Locations</Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<Link className="btn btn-outline-primary" to="/login">Login</Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <Link className="btn btn-outline-primary" to="/register">Register</Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <Link className="btn btn-outline-primary" to="/loginadmin">Admin</Link>
</div>
      
     
    </div>
  </div>
</nav>
    </div>
  )
}
