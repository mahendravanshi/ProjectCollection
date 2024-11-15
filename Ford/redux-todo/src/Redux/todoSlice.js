import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  todos: [{ id: Date.now().toString(16), task: "ABC", completed: false }]
 
};

const todoSlice = createSlice({
  name: "todoSlice",
  initialState,
  reducers: {
    todoAdded: (state, action) => {
      state.todos.push(action.payload);
    },
    
    todoToggled: (state, action) => {
        const todo = state.todos.find((todo) => todo.id === action.payload);
        if (todo) todo.completed = !todo.completed;
    },

    todoDeleted: (state, action) => {

       state.todos = state.todos.filter(todo => todo.id !== action.payload);
    },
    
    todoUpdated: (state, action) => {
      const todo = state.todos.find((todo) => todo.id === action.payload.id);
      if (todo) {
        todo.task = action.payload.task;
      }
    },

  },


});


export const { todoAdded,todoDeleted,todoToggled,todoUpdated } = todoSlice.actions;
export default todoSlice.reducer;
