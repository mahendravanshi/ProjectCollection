import {NextResponse} from "next/server"

export const GET = async (req,context)=>{
     
    //  console.log("REQ: ",req);
     console.log("Context: ",context)
     console.log("Context: ",context.params)
     console.log("Context: ",context.params.id)
     return NextResponse.json({"msg":"Success API ID"},{status:200});

}

// export const GET = async (req,{params})=>{
     
//     //  console.log("REQ: ",req);
     
//      console.log("Context: ",params)
//      return NextResponse.json({"msg":"Success API ID"},{status:200});

// }
