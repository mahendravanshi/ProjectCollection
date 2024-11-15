import React from 'react'


interface User {
    id:number;
    name:string;

}

const UsersPage = async () => {
    
    let url = 'https://jsonplaceholder.typicode.com/users';

    const res =await  fetch(url,{
        next:{revalidate:10}
    });
    const users:User[] = await res.json();


  return (
    <>
    <h1>Users</h1>
    <p>{new Date().toLocaleTimeString()}</p>
    <ul>
        {users.map(user=>
        <li key={user.id}>
            {user.name}
        </li>)}
    </ul>
    </>
  )
}

export default UsersPage