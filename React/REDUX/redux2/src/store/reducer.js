import { LOGIN, REGISTER } from "./actionType"


const initState = {

       products :[
          {
            id:1,
            name:"Bag",
            price:10
          },
          {
            id:2,
            name:"Mobile",
            price:10500
          },
          {
            id:3,
            name:"Biscuit",
            price:50
          },
          {
            id:4,
            name:"Books",
            price:150
          }
       ],
       users:[],
       loggedInUser:null,
      
}

export const reducer = (state=initState,action)=> {
   
       const {type,payload} = action
        switch(type){
         
             case REGISTER:
               return {
                    ...state,users:[...state.users,payload]
                } ; 
             case LOGIN :
                return {
                    ...state,loggedInUser:payload
                };
             case LOGOUT :
                return {
                    ...state,loggedInUser:null
                };
             default :
             return state;
        }     

}

