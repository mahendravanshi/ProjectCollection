import { Ultra } from "next/font/google";
import Image from "next/image";

const getData = async () => {
  const res = await fetch("http://localhost:3000/api/blog/posts", {
    headers: {
      'Content-Type': 'application/json'
    }
  });

  
  // if (!res.ok) {
  //   throw new Error(`Failed to fetch data: ${res.status} ${res.statusText}`);
  // }
 
  const posts = await res.json();
  return posts.data;
}

// const getData=async()=>{
//   try {
//     const data=await fetch('https://jsonplaceholder.typicode.com/posts')
//     const res=await data.json()
//     console.log(res);
//   } catch (error) {
//     console.error(error);
//   }
// }



export default  async function Home() {
  const allPosts = await  getData();
  console.log(allPosts);
  
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <h1>Next JS</h1>
      <div>
        {allPosts&&allPosts.map((post, id) => (
          <ul key={id}>
            <li>Title: {post.title}</li>
            <br></br>
            <li>Body: {post.body}</li>
            <hr></hr>
          </ul>
        ))}
      </div>
    </main>
  );
}
