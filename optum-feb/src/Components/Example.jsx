export const Example = ()=>{


      const arr = [1,2,3,4,5,6,7];


      return (

          <>
            {arr&&arr.map((el,index)=>{

                 return(
                    <ul key={index}>
                        <li>{el}</li>
                    </ul>
                 )
            })}
          </>
      )
}