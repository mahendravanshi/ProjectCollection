import {NextResponse} from "next/server"
export async function GET(req){
    
      //URL Query Params
      
     const {searchParams} = new URL(req.url);
     console.log(searchParams);
     console.log(searchParams.get("search"));
      return NextResponse.json({"msg":"Hello NextJS API"});
}


export async function POST(req){
    
    // console.log(req);

    //request body
    // const res = await req.json();
    // console.log("ResJSON: ",res);

    const formData  = await req.formData();
    console.log("Form data: ",formData);

    return NextResponse.json({"msg":"Post Success API"},{status:201});
    
}






