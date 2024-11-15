import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    count:0
}

const counterSlice = createSlice({
     name:'count',
     initialState,
     reducers:{
        incrementCount:(state)=>{
            state.count++;
        },
        decrementCount:(state)=>{
            state.count--;
        },
        resetCount:(state)=>{
           state=initialState
        },
        incrementByAmount:(state,action)=>{
            state.count =state.count+ action.payload
        },
        decrementByAmount:(state,action)=>{
            state.count -=action.payload
        }

     },
})


export const {incrementCount,decrementCount,incrementByAmount,decrementByAmount,resetCount} = counterSlice.actions;
export default counterSlice.reducer;