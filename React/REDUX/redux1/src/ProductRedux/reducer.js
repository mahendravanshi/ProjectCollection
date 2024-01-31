import { FETCH_DATA_FAILURE, FETCH_DATA_REQUEST, FETCH_DATA_SUCCESS } from "../actionType";

const initial = {
    data:[],
    loading:false,
    error:null
}


export const dataReducer = (state=inititalState)=>{
    
      const {type,payload} = action;

      switch(type){
        
          case FETCH_DATA_REQUEST :{
             
               return {...state,loading:true,error:null};
          }
          
          case FETCH_DATA_FAILURE :{
             
            return {...state,loading:false,error:payload};
          }

          case FETCH_DATA_SUCCESS :{
             
            return {...state,loading:false,data:payload};
          }

          default : return state;

      }
}
