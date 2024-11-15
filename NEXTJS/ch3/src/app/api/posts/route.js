import connectToDatabase from "@/lib/connectDB";
import NextResponse from "next/server";
import PostModel from "@/models/Post";
export async function GET(req){

      try {
          
          await connectToDatabase();
          return NextResponse.json({"msg":"success"},{status:200});
        
      } catch (error) {
        return NextResponse.json({"msg":"something went wrong"},{status:400});
      }
}