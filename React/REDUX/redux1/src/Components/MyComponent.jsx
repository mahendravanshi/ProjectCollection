// MyComponent.js
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchData } from "../ProductRedux/thunjk";

const MyComponent = () => {
  const dispatch = useDispatch();
  const { data, loading, error } = useSelector((state) => state.dataReducer);

  console.log(data);

  useEffect(() => {
    dispatch(fetchData());
  }, []);
  

  if (loading) {
    return <p>Loading Data Please Wait...</p>;
  }

  if (error) {
    return <p>Error: {error}</p>;
  }
  
  return (
    <div>
      <h1>Data:</h1>
      <ul style={{display:"flex",flexDirection:"column",gap:"10px",listStyle:"none"}}>
        {data &&
          data.map((el, index) => {
            return <li key={el.id}>{el.username}</li>;
          })}
      </ul>
    </div>
  );
};



export default MyComponent;
