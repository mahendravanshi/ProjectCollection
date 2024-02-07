import { useSelector } from "react-redux";
import "./App.css";

import Counter from "./Components/Counter";
import Nav from "./Components/Nav";
import AllRoutes from "./Routes/AllRoutes";
import MyComponent from "./Components/MyComponent";
import { BrowserRouter as Router} from "react-router-dom";

function App() {

  return (
    <Router>
              <div className="App">
                <Nav />
                <AllRoutes/>
                <MyComponent/>
                
              </div>
    </Router>
  );
}


export default App;
