import NavBar from "../nav-bar/NavBar"
export default function NotFound() {
    return (
        <div className="h-screen flex flex-col">
            <NavBar />
            <div className="flex flex-1 items-center justify-center">
                <p className="text-5xl font-bold text-blue-500">
                    404 NOT FOUND
                </p>
            </div>
        </div>
    )
}