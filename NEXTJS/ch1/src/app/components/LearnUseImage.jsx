import React from 'react'
import Image from 'next/image'
import MyImg from "../../../public/image/home.jpg"
const LearnUseImage = () => {
  return (
    <>
      <Image src={MyImg} 
      alt="Car Factory"
      width={500} 
      height={400}/>
    </>
  )
}


export default LearnUseImage