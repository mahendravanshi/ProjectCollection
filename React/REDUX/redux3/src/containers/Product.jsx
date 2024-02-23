import { useSelector } from "react-redux";


export const Product = ()=>{
    

    const products = useSelector(state=>state.allProducts.product);
      
      const {title} = products;
      
    return(
       <div className="four column wide">
            <div className="ui link cards">
            <div className="card" >
                <div className="image"></div>
                <div className="content"></div>
                <div className="header">{title}</div>
            </div>
            </div>
       </div>
    )
}




