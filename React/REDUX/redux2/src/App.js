import { useDispatch, useSelector } from 'react-redux';
import './App.css';
import { Login } from './components/Login';
import { Product } from './components/Product';
import { Register } from './components/Register';
import { User } from './components/User';

function App() {

  const user = useSelector(state=>state.loggedInUser);
 const dispatch = useDispatch();

  return (
    <div className="App">
       <Product/>
       <Register/>
       <User/>
       {user ? <button onClick={()=>dispatch(logout())}>Logout</button>:<Login/>}
    </div>
  );
}

export default App;
