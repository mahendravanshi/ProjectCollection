import Image from "next/image";



export default function HomePage() {
  return (
    <div>
      Home Page
      {/* <div>
        <Image src={'/home.jpg'} width={1000} height={1000}
      style={{objectFit:'cover'}}
      alt="car factory"/>
      </div> */}
      <div className="flex flex-row">
        <Image src="/home.jpg" alt="asdf" />
      </div>

    </div>
  );
}


