import { fetchDataFailure, fetchDataRequest, fetchDataSuccess } from "./action";



export const fetchData = () => async (dispatch) =>{

       dispatch(fetchDataRequest());
       
       try {

         const res = await fetch("https://jsonplaceholder.typicode.com/users");
         const data  = await res.json();
         console.log("Data in reducer",data);
         dispatch(fetchDataSuccess(data));
        
       } catch (error) {
            dispatch(fetchDataFailure(error));
       }
       
}




