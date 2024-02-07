const Todo = () => {
  const [todos, setTodos] = useState({
    task: "",
    priority: "",
  });

  const [editTodo, setEditTodo] = useState(null);
 

  const handleSubmit = (e) => {};
  
  return (
    <>
      <form action="">
        <input
          type="text"
          placeholder="Enter your task"
          onChange={() => setTodos({ ...todos, task: e.target.value })}
        />
        <input
          type="text"
          placeholder="Enter your priority"
          onChange={() => setTodos({ ...todos, priority: e.target.value })}
        />
        <input type="submit" onClick={handleSubmit(e)} value="Submit Todo" />
      </form>

      <div>
        {todos &&
          todos.map((el, index) => {

            <div key={index}>
              <h1>{el.task}</h1>
              <h3>{el.priority}</h3>
            </div>
            

        })}
        



      </div>
    </>
  );
};
