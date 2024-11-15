import './App.css';
import { Todo } from './Todo/Todo';
import {Counter} from './Counter/Counter'
import Todos from './FetchData/Todo';
import Todo2 from './FetchData/Todo2'
import { Vehicles2 } from './FetchData/Vehicles2';
import { Signup } from './Signup/Signup';

function App() {
  return (
    <div className="App">
        {/* <Todo/> */}
        {/* <Counter/> */}
        {/* <Todo2/> */}
         <Vehicles2/>
         {/* <Signup></Signup> */}
    </div>
  );
}


export default App;

