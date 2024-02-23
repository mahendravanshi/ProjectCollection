import { useDispatch, useSelector } from "react-redux";
import { useState } from "react";
import { login } from "../store/action";

export const Login = ()=>{

    const [username,setUsername] = useState('');
    const [password,setPassword] = useState('');
    const users = useSelector(state=>state.users);
    const dispatch = useDispatch();
    const handleLogin = (e)=>{
        e.preventDefault();
        const payload =   users.find(user=>user.username===username&&user.password===password);
        if(payload){
            dispatch(login(payload))
            alert("Successfullly dispatched")
        }
        else{
            alert("Wrong credentials");

        }
    }

    return (
          
         <form  className="login">
            <input type="text"     placeholder="Enter username"   value={username} onChange={(e)=>setUsername(e.target.value)}/>
            <input type="password" placeholder="Enter password"   value={password} onChange={(e)=>setPassword(e.target.value)}/>
            <input type="submit" value="Login" onClick={handleLogin}/>
         </form>

      )
}