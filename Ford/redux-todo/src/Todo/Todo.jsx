import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { todoAdded, todoDeleted, todoToggled, todoUpdated } from '../Redux/todoSlice';

export const Todo = () => {
    
    const inittialNewTodo = {
        id:Date.now().toString(16),
        task:"",
        completed:false
    }
    const { todos } = useSelector(state => state.todos);
    const dispatch = useDispatch();
    const [newTodo,setNewTodo] = useState(inittialNewTodo);
    const [edit,setEdit] = useState(false);
    console.log(todos);
   
    
    const addOrEditTodo = ()=>{
            if(!edit){
                dispatch(todoAdded(newTodo));
               setNewTodo({...inittialNewTodo,id:Date.now().toString(16)});
            }
            else{
                dispatch(todoUpdated(newTodo));
                setEdit(false);
            }
    }


    const editTodo = (todo)=>{
         setNewTodo(todo);
         setEdit(true);
    }
     

    return (
        <div>
            <input type="text" placeholder='What is on your mind' value={newTodo.task} onChange={(e)=>setNewTodo({...newTodo,task:e.target.value})} />
            <button type="text" onClick={addOrEditTodo}>{edit?"Edit Todo":"Add to do"}</button>
            <div>
                <h1>All Todo here</h1>
                <ul>
                    {
                        todos && todos.map((todo)=> (
                            <li key={todo.id}>
                                <p>{todo.task}</p>
                               <div > 
                                <span >{todo.completed ? 'Completed' : 'Not Completed'}</span>
                                <br />
                               <button onClick={()=>dispatch(todoToggled(todo.id))}>{todo.completed?'Mark as Incomplete':'Mark as Completed'}</button>
                               </div>
                                <button onClick={() => dispatch(todoDeleted(todo.id))}>Delete Todo</button>
                                <button onClick={()=>editTodo(todo)}>Edit Todo</button>
                            </li>
                        ))
                    }
                </ul>
            </div>
        </div>
    )
}
