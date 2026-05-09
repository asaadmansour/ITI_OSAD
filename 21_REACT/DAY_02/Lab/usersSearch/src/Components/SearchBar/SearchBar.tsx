import { useState } from "react";

export default function SearchBar({onSearch}) {

    return (
        <form className="my-6 flex justify-center">
            <input
                type="text"
                placeholder="Search users..."
                className="w-72 px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                onChange={(e)=> onSearch(e.target.value)}
            />
        </form>
    );
}