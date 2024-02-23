import { useState } from "react"
import { useDispatch} from "react-redux";
import { REGISTER } from "../store/actionType";


export const Register = () =>{

        const [name,setName] = useState('');
        const [username,setUsername] = useState('');
        const [password,setPassword] = useState('');
        const [confirmPassword,setConfirmPassword] = useState('');
       
        const dispatch= useDispatch();
        const handleSubmit = (e)=>{
           
            e.preventDefault();
            dispatch({
                type:REGISTER,
                payload:{
                    name,username,password
                }
            })
        }
      
      return(

           <form  className="register">
              <input type="text"     placeholder="Enter name"       value={name} onChange={(e)=>setName(e.target.value)}/>
              <input type="text"     placeholder="Enter username"   value={username} onChange={(e)=>setUsername(e.target.value)}/>
              <input type="password" placeholder="Enter password"   value={password} onChange={(e)=>setPassword(e.target.value)}/>
              <input type="password" placeholder="Confirm Password" value={confirmPassword} onChange={(e)=>setConfirmPassword(e.target.value)}/>
              <input type="submit" value="Add User" onClick={handleSubmit} />
           </form>
      )
}