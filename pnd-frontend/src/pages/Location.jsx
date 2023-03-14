import React, {useState, useEffect} from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function Location() {
    const [locations, setLocations] = useState([]);
    useEffect(() => {
        axios.get('http://localhost:8080/city/show-cities')
          .then(response => {
            setLocations(response.data);
          })
          .catch(error => {
            console.log(error);
          }); 
      }, []);
  return (
    <div>
      <h2>Choose from list of locations below</h2>
      <div className='container'>
        <div className='py-4'>
        <table className="table border shadow">
  <thead>
    <tr>
      <th scope="col">City</th>
    </tr>
  </thead>
  <tbody>
    {
        locations.map((location) => (
          <tr>
            <td><Link className="btn btn-outline-primary" to="/car">{location.city}</Link></td>
          </tr>
        
        ))
    }
    </tbody>
</table>

        </div>
    </div>
    </div>
  )
}
