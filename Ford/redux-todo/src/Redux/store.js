import { configureStore } from '@reduxjs/toolkit'
import todoSlice from './todoSlice'
import counterSlice from './counterSlice';
export const store = configureStore({
      reducer:{
          todos:todoSlice,
          counter:counterSlice
      }
})




