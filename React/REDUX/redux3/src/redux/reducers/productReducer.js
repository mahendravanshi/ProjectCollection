import { SET_PRODUCTS } from "../constants/actionType";


const inititalState = {

       products:[
         {
            id:1,
            title:"Dipesh",
            category:"programmer"
         }
       ],
}


export const productReducer = (state=inititalState,action)=>{
    
       const {type,payload} = action;

       switch(type){
            
            case  SET_PRODUCTS:
                return {...state,products:[...state.products,payload]}
            default:
                return state;
                       
       }
}