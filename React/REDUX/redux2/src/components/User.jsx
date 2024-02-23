import { useSelector } from "react-redux";

export const User = () => {
    const users = useSelector(state => state.users);
    console.log(users);
    
    return (
        <div>
            {users.map((el, i) => (
                <div key={i}>
                    <h1>{el.name}</h1>
                </div>
            ))}
        </div>
    );
};
