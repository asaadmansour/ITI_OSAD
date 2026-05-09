import type { User } from '../../Interfaces/User/User'
export default function UserCard({image,role,username,email,phone,dob}:User) {
        const roleColor = role === 'admin' 
        ? 'bg-red-500' 
        : role === 'moderator' 
            ? 'bg-yellow-500' 
            : 'bg-green-500'; 
    return (
        <div className="flex flex-col items-center w-64 border border-black rounded-3xl p-3 m-2 shadow-md">
            <div className="border border-gray-500 rounded-2xl overflow-hidden">
                <img 
                    src={image} 
                    alt="User" 
                    className="w-40 h-40 object-cover"
                />
            </div>

            <div className="mt-2">
                <span className={roleColor}>
                    {role}
                </span>
            </div>

            <div className="mt-2 text-sm">
                <p>{username}</p>
                <p>{email}</p>
                <p>{phone}</p>
                <p>{dob}</p>
            </div>
        </div>
    )
}
