import { LOGIN, LOGOUT, REGISTER } from "./actionType"


export const register = (payload)=>{
    
     return {type:REGISTER,payload}
}

export const login = (payload)=>{
     
     return {type:LOGIN,payload};
}

export const logout = ()=>{

     return {type:LOGOUT};
}