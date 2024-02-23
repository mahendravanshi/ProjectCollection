import './App.css';
import { Header } from './containers/Header';
import { Product } from './containers/Product';
import {ProductDetail } from './containers/ProductDetail';
import { BrowserRouter as Router,Switch,Route,Routes} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Router>
      <Header/>
         <Routes>
            <Route path="/" element={<Product/>}/>
            <Route path="/product/:productId" element={<ProductDetail/>}/>
            <Route path="*" element={<h1>404 not Found</h1>}/>
         </Routes>

      </Router>
    </div>
  );
}

export default App;
