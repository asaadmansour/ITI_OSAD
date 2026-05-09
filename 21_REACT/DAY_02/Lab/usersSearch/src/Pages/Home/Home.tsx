import Users from "../Users/Users"
import SearchBar from "../../Components/SearchBar/SearchBar"
import { useState } from "react";
export default function Home() {
    const query = ""
    const [search,setSearch] = useState(query);
    function onSearch(change:string) {
        setSearch(change)
    }
    return (
        <div className="p-6">
            <h1 className="font-bold text-4xl">Users</h1>
            <SearchBar onSearch={onSearch}/>
            <Users search={search}/>
        </div>
    )
}
