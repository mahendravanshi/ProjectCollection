import { Route, Routes } from "react-router-dom"
import { Login } from "./Login"
import { Register } from "./Register"
import { User } from "./User"
import { Product } from "./Product"
import { Home } from "./Home"


export const AllRoutes = () => (
    <>
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/product" element={<Product />} />
            <Route path="/user" element={<User />} />
            <Route path="*" element={<h1>Not found</h1>} />
        </Routes>
    </>
);
