import React, {useState, useEffect} from 'react'
import axios from 'axios';

export default function Cars() {
    const [car, setCar] = useState([]);
    useEffect(() => {
        axios.get('http://localhost:8080/cars/getAll')
          .then(response => {
            console.log(response);
            setCar(response.data);
          })
          .catch(error => {
            console.log(error);
          });
      }, []);
  return (
        <div>
      <h2 style={{paddingTop : 100}}>List of Cars</h2>
      <div className='container'>
        <div className='py-4'>
        <table className="table border shadow">
  <thead>
    <tr>
    <th scope="col">Id</th>
    <th scope="col">Image</th>
      <th scope="col">Brand</th>
      <th scope="col">Category</th>
      <th scope="col">Color</th>
      <th scope="col">Model</th>
      <th scope="col">Production year</th>
      <th scope="col">Rate</th>

    </tr>
  </thead>
  <tbody>
    {
        car.map((car, index) => (
            <tr>
              <th scope="row" key={index}>{index+1}</th>
              <td><img src={car.image} style={{width: 100, height: 60}}/></td>
              <td>{car.brand}</td>
              <td>{car.category}</td>
              <td>{car.color}</td>
              <td>{car.model}</td>
              <td>{car.productionYear}</td>
              <td>{car.rate}</td>
              <td>
                  <button className='btn btn-warning mx-2'>Update</button>&nbsp;
                  <button className='btn btn-danger mx-2'>Delete</button>
              </td>
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
