import React from 'react'
import Carousel from 'react-bootstrap/Carousel';
import Card from 'react-bootstrap/Card';
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

export default function Home() {
  return (
    <div>
      <Carousel>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="images/joey-banks-YApiWyp0lqo-unsplash.jpg"
          alt="First slide"
        />
        <Carousel.Caption>
          <h3>The cheapest rates</h3>
          <p>Satisfactory service for your lovable drive.</p>
          <Link className="btn btn-outline-light" to="/register">Book Now</Link>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="images/nischal-kanishk-xIaxQ82FlyU-unsplash.jpg"
          alt="Second slide"
        />

        <Carousel.Caption>
          <h3>Get your favorite here</h3>
          <p>Make your holiday unforgettable with our drive.</p>
          <Link className="btn btn-outline-light" to="https://www.landroverdarien.com/land-rover-technology/">Learn more</Link>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="images/zakaria-zayane-pb_1XXdKldQ-unsplash.jpg"
          alt="Third slide"
        />

        <Carousel.Caption>
          <h3>Rent it out</h3>
          <p>
            We try our best to make your drive memorable.
          </p>
          <Link className="btn btn-outline-light" to="/about">about us</Link>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
    <Card style={{ display: 'flex', flexDirection: 'row' }}>
      <Card.Img variant="left" src="holder.js/100px180" />
      <Card.Body>
        <Card.Title>Card Title</Card.Title>
        <Card.Text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </Card.Text>
        <Button variant="primary">Go somewhere</Button>
      </Card.Body>
    </Card>
    <Card style={{ display: 'flex', flexDirection: 'row' }}>
      <Card.Img variant="right" src="holder.js/100px180" />
      <Card.Body>
        <Card.Title style={{align : 'left'}}>Card Title</Card.Title>
        <Card.Text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </Card.Text>
        <Button variant="primary">Go somewhere</Button>
      </Card.Body>
    </Card>
    <Card style={{ display: 'flex', flexDirection: 'row' }}>
      <Card.Img variant="left" src="holder.js/100px180" />
      <Card.Body>
        <Card.Title>Card Title</Card.Title>
        <Card.Text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </Card.Text>
        <Button variant="primary">Go somewhere</Button>
      </Card.Body>
    </Card>


    </div>
  )
}
