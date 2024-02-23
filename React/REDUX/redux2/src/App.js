import { Router } from 'react-router-dom';
import './App.css';
import { Home } from './components/Home';
import { Nav } from './components/Nav';

export default function App() {

  return (
    <div className="App">
      <Router>
        <Nav></Nav>
        <Home></Home>
      </Router>
    </div>
  );
}




