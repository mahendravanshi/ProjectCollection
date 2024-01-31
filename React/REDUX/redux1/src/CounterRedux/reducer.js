import { DECREASE_COUNT, INCREASE_COUNT, RESET_COUNT } from "../actionType";

const init = {
  count: 0,
};

export const reducer = (state=init, action) => {
  const { type, payload } = action;
 const {count} = state;
  switch (type) {
    case INCREASE_COUNT: {
      return { ...state, count: count==10?count:count+payload};
    }

    case DECREASE_COUNT: {
      return { ...state, count: count==0?count:count-payload};
    }
     
    
    case RESET_COUNT :{
        return {...state,count:payload};
    }
    
    default:return state;
      



  }

};







