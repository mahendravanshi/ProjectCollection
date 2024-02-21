import { useState } from "react";
import { useSelector } from "react-redux";

export const User = () => {
      
    const users = useSelector(state=>state.users);
    console.log(users);
    const [user,setUser] = useState(users);
    
    return (
        <div>
           {
            users.map((el,i)=>{
                return <div key={i}>
                    <h1>{el.name}</h1>
                    <h1></h1>
                </div>
            })
           }
        </div>
    )
}