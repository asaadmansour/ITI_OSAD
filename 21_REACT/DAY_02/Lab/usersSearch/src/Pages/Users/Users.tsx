import { useState } from "react";
import UserCard from "../../Components/UserCard/UserCard";
import type { User } from "../../Interfaces/User/User";
import imgAsaad from '../../assets/1.jpg';
import imgMona from '../../assets/2.jpg';
import imgSara from '../../assets/3.png';
import imgKarim from '../../assets/4.png';
let usersData: User[] = [
    {
        image: imgAsaad,
        role: "admin",
        username: "Asaad",
        email: "asaad@gmail.com",
        phone: "01021523344",
        dob: "Feb 15"
    },
    {
        image: imgMona,
        role: "user",
        username: "Mona",
        email: "mona123@gmail.com",
        phone: "01134567890",
        dob: "Jun 8"
    },
    {
        image: imgKarim,
        role: "moderator",
        username: "Karim",
        email: "karim.dev@gmail.com",
        phone: "01298765432",
        dob: "Nov 21"
    },
    {
        image: imgSara,
        role: "user",
        username: "Sara",
        email: "sara.ali@gmail.com",
        phone: "01055667788",
        dob: "Mar 3"
    }
];

export default function Users({search}) {
    // function setUserData(user:User){
    //     setUsers ([...users,user])
    // }
    const filtered = usersData.filter(user => 
        user.username.toLowerCase().includes(search.toLowerCase()) ||
        user.email.toLowerCase().includes(search.toLowerCase())
    )
    // const [users,setUsers] = useState<User[]>(usersData);
    return (
        <div className="flex justify-center items-center min-h-screen">
        <div className="grid grid-cols-2 gap-20">
            {filtered.map((user,index)=> (
                <UserCard 
                key={index} 
                image={user.image}
                role={user.role}
                username={user.username}
                email={user.email}
                phone={user.phone}
                dob={user.dob}
                />
            ))}
        </div>
        </div>
    )
}
