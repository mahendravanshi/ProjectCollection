import { fetchDataFailure, fetchDataRequest, fetchDataSuccess } from "./action";



export const fetchData = () => async (dispatch) =>{

       dispatch(fetchDataRequest());

       try {

         const res = await fetch()
        
       } catch (error) {
        
       }
}