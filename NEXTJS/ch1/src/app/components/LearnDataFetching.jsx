

import React from 'react'

async function getData(){
    const res = fetch("https://jsonplaceholder.typicode.com/posts");

    return (await res).json();
}

const LearnDataFetching = async () => {
    const url = "https://jsonplaceholder.typicode.com/posts"
    const data = await getData();
    console.log("Hi");
    console.log(data);

  return (
    <>{data&&data.map((post,id)=>(
        <div key={id}>
                <h1>Title : {post.title}</h1>
                <p>Body: {post.body}</p>
                <hr />
        </div>
    ))
    }</>
  )
  
}

export default LearnDataFetching