import React, { useState } from 'react'
import { useDispatch, useSelector} from 'react-redux'
import { decrementByAmount, decrementCount, incrementByAmount, incrementCount } from '../Redux/counterSlice';

export const Counter = () => {

    const {count} = useSelector(state=>state.counter)
    const [amount,setAmount] = useState(0);
    const dispatch = useDispatch();
    console.log(count);

    const incrementBy = ()=>{
         dispatch(incrementByAmount(amount));
         setAmount(0);
    }

    const decrementBy = () =>{
        dispatch(decrementByAmount(amount));
        setAmount(0);
    }
   
  return (
    <div>
        <h3>Counter App</h3>
        <h2>{count}</h2>
        <button onClick={()=>dispatch(incrementCount())}>Increment</button>
        <button onClick={()=>dispatch(decrementCount())}>Decrement</button>
        <input type='number' placeholder='Please enter the number by amount to increase or decrease' value={amount} onChange={e=>setAmount(Number(e.target.value))} />
         <button onClick={incrementBy}>Increment Count By Amount</button>
         <button onClick={decrementBy}>Decrement Count By Amount</button>
    </div>
  )
}
