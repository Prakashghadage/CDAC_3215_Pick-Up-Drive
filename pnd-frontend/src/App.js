
import './App.css';
import Register from './pages/Register';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import NavBar from './components/NavBar';
import Home from './pages/Home';
import Login from './pages/Login';
import Location from './pages/Location';
import Car from './pages/Car';
import LoginAdmin from './pages/loginAdmin';
import Cars from './pages/Cars';

function App() {
  return (
    <div className="App">
      <Router>
        <NavBar />
        <Routes>
          <Route exact path='/' element={<Home />}/>
          <Route exact path='/login' element={<Login />} />
          <Route exact path='/register' element={<Register />} />
          <Route exact path='/location' element={<Location />} />
          <Route exact path='/car' element={<Car />} />
          <Route exact path='/loginadmin' element={<LoginAdmin />} />
          <Route exact path='/cars' element={<Cars />} />
          

        </Routes>
      </Router>
    
    </div>
  );
}

export default App;
