
import Link from "next/link";

const LearnLink = () => {

    const id = 2;

  return (
    <>
      <Link href="/admin/dashboard">Go to Admin DashBoard</Link>
      <Link href={`/user/profile/${id}`}>Go to User Profile</Link>
    </>
  )
}

export default LearnLink