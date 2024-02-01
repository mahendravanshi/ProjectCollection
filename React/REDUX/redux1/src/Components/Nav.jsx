import { Link } from "react-router-dom"


export default function Nav(){

     return (

          <div style={{display:"flex",justifyContent:"space-around",gap:"10px"}}>
               
              <Link to="/" >Home</Link>
              <Link to="/contact">Contact</Link>
              <Link to="/product">Products</Link>
              <Link to="/dashboard">Dashboard</Link>

          </div>
     )
}