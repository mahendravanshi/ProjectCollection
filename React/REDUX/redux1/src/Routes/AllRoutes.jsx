import { Routes, Route } from "react-router-dom";
import Home from "../Components/Home";
import Dashboard from "../Components/Dashboard";
import Product from "../Components/Product";
import Contact from "../Components/Contact";

function AllRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/dashboard" element={<Dashboard/>}/>
      <Route path="/product" element={<Product/>}/>
      <Route path="/contact" element={<Contact/>}/>
      <Route path="*" element={<h1>404 not found</h1>}/>
    </Routes>
    
  );
}

export default AllRoutes
