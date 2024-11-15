import React from 'react'

import { useState, useEffect } from "react";

const Todo2 = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);

  // State for checkboxes
  const [fetchAll, setFetchAll] = useState(false);
  const [fetchCompleted, setFetchCompleted] = useState(false);
  const [fetchNotCompleted, setFetchNotCompleted] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      let url = `https://jsonplaceholder.typicode.com/todos`;

      if (fetchCompleted && !fetchNotCompleted) {
        url += `?completed=true`;
      } else if (!fetchCompleted && fetchNotCompleted) {
        url += `?completed=false`;
      } else if (fetchAll) {
        url = `https://jsonplaceholder.typicode.com/todos`;
      }

      const response = await fetch(url);
      const res = await response.json();
      setData(res);
      setLoading(false);
    };

    fetchData();
  }, [fetchAll, fetchCompleted, fetchNotCompleted]);

  const handleFetchAllChange = () => {
    setFetchAll(!fetchAll);
    if (fetchAll) {
      setFetchCompleted(false);
      setFetchNotCompleted(false);
    }
  };

  const handleFetchCompletedChange = () => {
    setFetchCompleted(!fetchCompleted);
    if (fetchCompleted) {
      setFetchAll(false);
    }
  };

  const handleFetchNotCompletedChange = () => {
    setFetchNotCompleted(!fetchNotCompleted);
    if (fetchNotCompleted) {
      setFetchAll(false);
    }
  };

  return (
    <div>
      <h3>Todos</h3>

      <p>Fetch All Todos</p>
      <input
        type="checkbox"
        checked={fetchAll}
        onChange={handleFetchAllChange}
      />

      <p>Fetch Completed Todos</p>
      <input
        type="checkbox"
        checked={fetchCompleted}
        onChange={handleFetchCompletedChange}
      />

      <p>Fetch Not Completed Todos</p>
      <input
        type="checkbox"
        checked={fetchNotCompleted}
        onChange={handleFetchNotCompletedChange}
      />

      <div>
        {loading ? (
          <p>Loading...</p>
        ) : (
          data.map((item) => (
            <div key={item.id}>
              <p>{item.title} - {item.completed ? "Completed" : "Not Completed"}</p>
              <p>{console.log(data.length)}</p>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default Todo2;

