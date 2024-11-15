import React, { useEffect, useState } from 'react';

export const Vehicles = () => {


    const genericUrl = `http://localhost:8080/vehicles/getAll`;
    const [url,setUrl] = useState(genericUrl);
    const [data,setData] = useState([]);
    const [showData,setShowdata] = useState(false);
    const [selectedFilter,setSelectedFilter] = useState(null);

   
    useEffect(()=>{

        console.log("useEffect triggered with URL:", url);
        const fetchData = async ()=>{

            try {
             
              const response  = await fetch(url);
              const res =await  response.json();
              console.log("API Response Data ",res);
              setData(res);
              
            } catch (error) {
              console.log(error.message);
              
            }
        }
        
         fetchData();
    },[url])
    
    const fetchAllVehicles = ()=>{
        console.log("All vehicles clicked");
        
        setSelectedFilter('all');
        setUrl(genericUrl);
        setShowdata(true)
    }

    const fetchAllAvailableVehicles = ()=>{
        console.log("Availables vehicles clicked");
        setSelectedFilter('available');
        setUrl(`${genericUrl}?isAvailable=true`);
        setShowdata(true)
    }
    
    const fetchAllUnavailableVehicles = ()=>{
        console.log("Unavailables vehicles clicked");
        setSelectedFilter('unavailable');
        setUrl(`${genericUrl}?isAvailable=false`);
        setShowdata(true)
    }

    return(
        
         <div>
            <div>
                <span>
                <label htmlFor="allVehicles">Get All Vehicle</label>
                <input type="radio" name="vehicle" id="allVehicles" checked={selectedFilter==='all'} onChange={fetchAllVehicles}/>
                </span>

                <span>
              
                <label htmlFor="availableVehicles">Get Available Vehicle</label>
                <input type="radio" name="vehicle" id="availableVehicles" checked={selectedFilter==='available'} onChange={fetchAllAvailableVehicles}/>
                </span>
                
                <span>
                <label htmlFor='unavailabelVehicles'>Get Unavailable Vehicle</label>
                <input type="radio" name="vehicle" id="unavailabelVehicles" checked={selectedFilter==='unavailable'} onChange={fetchAllUnavailableVehicles}/>
                </span>
            </div>

            <div>
                {
                    !showData ?(
                        <div>...Click to getData</div>
                    ):(
                        <div>
                            {data&&data.map((vehicle)=>(
                                <div key={vehicle.id}>
                                     <p>{vehicle.brandName}</p>
                                    <p>isAvailable:{vehicle.isAvailable.toString()}</p>
                                </div>
                            ))}
                        </div>
                    )
                }
            </div>
         </div>
    )
}
    
