import { useFetch } from "../CustomHooks/useFetch"

const ComponentFetch = ()=>{

      const url = 'https://api.example.com/data';
      const {data,isError,isLoading} = useFetch(url);

      return (
        <>
            {isLoading ? (
                <>
                    <h1>Loading Data...</h1>
                </>
            ) 
            : isError ? (
                <>
                    <h1>Error in Data fetching</h1>
                </>
            ) 
            : (
                data.map((el, index) => (
                    <ul key={index}>
                        <li>{el}</li>
                    </ul>
                ))
            )}
        </>
    );



}