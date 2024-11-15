import { useState } from "react";
import { useDispatch } from "react-redux";

export const Counter = () => {

    const [count,setCount] = useState(0);
    const dispatch = useDispatch();

  return <div>
     <h2>Counter App</h2>
     <h2>{count}</h2>
     <div>
        <p onClick={()=>dispatch(addToDo())}>Add</p>
        <p>Subtract</p>
        <p>Reset</p>
     </div>
    </div>;
};
