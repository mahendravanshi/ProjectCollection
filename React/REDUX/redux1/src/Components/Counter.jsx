import { useDispatch, useSelector } from "react-redux"
import { decrementCount, incrementCount, resetCount } from "../CounterRedux/action";
import { store } from "../store";


import style from "./Counter.module.css"
export default function Counter(){
     
      const dispatch = useDispatch();
      const { count } = useSelector((store) => store.countReducer);
       console.log(count);
       return (
            
            
            <>
              <h1>Counter : {count}</h1>
              <div className={style.buttonCount} >
              <button onClick={()=>dispatch(incrementCount(1))}>Increase Counter</button>
              <button onClick={()=>dispatch(decrementCount(1))}>Decrease  Counter</button>
              <button onClick={()=>dispatch(resetCount(0))}>Reset Counter</button>
              </div>
            </>
       )
       


}



