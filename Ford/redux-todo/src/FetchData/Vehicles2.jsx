import { useState,useEffect } from "react"
import './Vehicles2.css';

export const Vehicles2 = ()=>{

     const baseUrl = `http://localhost:8080/vehicles/getAll`;
      const [data,setData] = useState([]);
      const [isLoading,setIsLoading] = useState(false);
      const [url,setUrl] = useState(baseUrl);
      const [selectedFilter,setSelectedFilter] = useState('all');

      useEffect(()=>{
          const fetchData = async ()=>{

            try {
                setIsLoading(true)
              const response = await fetch(url);
              const res = await response.json();
              setData(res)
              setIsLoading(false)
              
             
            } catch (error) {
                console.log(error.message);
            }
          }
        
           fetchData();
      },[url])

      const selectAvailable = ()=>{
          
        setSelectedFilter("isAvailable");
        setUrl(`http://localhost:8080/vehicles/getAll?isAvailable=true`);

      }

      const selectNotAvailable = ()=>{
          
        setSelectedFilter("isNotAvailable");
        setUrl(`http://localhost:8080/vehicles/getAll?isAvailable=false`);
       
        
      }

      const selectAllAvailable = ()=>{   
        setSelectedFilter("all");
        setUrl(baseUrl);
       
      }

       return(
            <div>
            <div>
                Show Vehicles Here
            </div>
            <div>
                <label htmlFor="getIsAvailable">Get All Available Vehicles</label>
                <input type="radio" name="" id="" checked={selectedFilter==="isAvailable"} onChange={selectAvailable}/>
                <label htmlFor="getIsAvailable">Get All Unavailable Vehicles</label>
                <input type="radio" name="" id="" checked={selectedFilter==="isNotAvailable"} onChange={selectNotAvailable}/>
                <label htmlFor="getIsAvailable">Get All  Vehicles</label>
                <input type="radio" name="" id="" checked={selectedFilter==="all"} onChange={selectAllAvailable}/>
            </div>
            <div>
                {isLoading ? (<h1>Loading...</h1>):(
                    <div id="dataContainer">
                        {data&&data.map((item)=>(
                            <ul key={item.id}>
                                <li>{item.brandName}</li>
                                <li>{item.isAvailable.toString()}</li>
                            </ul>
                        ))}
                    </div>)
                }
                
            </div>
            </div>
       )
}