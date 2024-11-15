"use client";

import { useRouter } from 'next/navigation'
const LearnUseRouter = () => {

    const router = useRouter();
    // console.log(router);
  return (
    <>
       <h1>Learn useRouter</h1> 
        <button type="button" onClick={()=>router.push("/admin/dashboard")}>Go to admin dashboard</button>
    </>
  )
}

export default LearnUseRouter;


