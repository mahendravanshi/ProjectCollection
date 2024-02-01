import { useSelector } from "react-redux";
import "./App.css";

import Counter from "./Components/Counter";
import Nav from "./Components/Nav";
import AllRoutes from "./Routes/AllRoutes";


function App() {

  return (
    <div className="App">
      <Counter />
      <Nav />
      <AllRoutes/>
    
    </div>
  );
}


export default App;
