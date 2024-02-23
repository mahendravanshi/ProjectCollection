import { useSelector } from "react-redux"
import "../App.css"

export const Product = ()=>{

    const products = useSelector(state=>state.products);
       
       console.log(products);     
       return(
             
             <div className="productsMain">
               {products.map(({id,name,price})=>(
                   
                      <div key={id}>
                         <p>{name}</p>
                         <p>{price}</p>
                      </div>

               ))}
             </div>
       )
}



