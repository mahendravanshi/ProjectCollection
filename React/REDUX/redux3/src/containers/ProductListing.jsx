import { useSelector } from "react-redux"
import { Product } from "./Product";

export const ProductListing = ()=>{


      return(
         <div className="ui grid container">
            <Product/>
         </div>
      )
}