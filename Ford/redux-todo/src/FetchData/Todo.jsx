import { useState, useEffect, useCallback } from "react";

const Todo = () => {
    const oldUrl = `https://jsonplaceholder.typicode.com/todos`;

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [url, setUrl] = useState(oldUrl);
    const [select, setSelect] = useState(false);
    

    useEffect(() => {
        const fetchData = async () => {
          const response = await fetch(url);
          const res = await response.json();
          setData(res);
          
        };
        fetchData();
    }, [url]);

    const fetchTodo = () => {
        setUrl(oldUrl);
        setLoading(false);
    };

    const fetchAvailableTodos = () => {
       
        setUrl(`https://jsonplaceholder.typicode.com/todos?completed=true`);
        setLoading(false);
    };

    const fetchUnAvailableTodos = () => {
        setUrl(`https://jsonplaceholder.typicode.com/todos?completed=false`);
        setLoading(false);
    };

   
    return (
        <div>
            <h3>Todos</h3>
            <p>Fetch All Todos</p>
            <input type="radio" name="todo"  onChange={fetchTodo} />
            <p>Fetch Completed Todos</p>
            <input type="radio" name="todo" onChange={fetchAvailableTodos} />
            <p>Fetch Not Completed Todos</p>
            <input type="radio" name="todo" onChange={fetchUnAvailableTodos} />
            
            
            <div>
                {loading ? (
                    <p>Click to getData</p>
                ) : (
                       data.map((item)=>(
                          <div key={item.id}>
                             <p>{item.completed.toString()}</p>
                          </div>
                       ))
                    )
                }
            </div>
        </div>
    );
};

export default Todo;
