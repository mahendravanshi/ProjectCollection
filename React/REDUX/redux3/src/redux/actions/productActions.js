import { SELECTED_PRODUCTS, SET_PRODUCTS } from "../constants/actionType"

export const setProducts = (payload)=>{
    
       return {
           type:SET_PRODUCTS,payload
       }
     
}

export const selectProduct = (payload) =>{

      return{
         type:SELECTED_PRODUCTS,payload
      }
}


