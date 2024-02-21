import { DECREASE_COUNT, INCREASE_COUNT, RESET_COUNT } from "../actionType"


export const incrementCount = (payload)=>{

    return {type:INCREASE_COUNT,payload}
}


export const decrementCount = (payload)=>{
    return {type:DECREASE_COUNT,payload};
}


export const resetCount = (payload)=>{
     return{type:RESET_COUNT,payload}
}
