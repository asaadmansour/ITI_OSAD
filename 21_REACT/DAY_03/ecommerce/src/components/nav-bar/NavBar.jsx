import { Link } from "react-router-dom";

export default function NavBar() {
    return (
        <nav className="w-full bg-slate-100 shadow-sm fixed">
            <div className="max-w-7xl mx-auto flex items-center justify-between px-4 py-3">
                <Link className="text-lg font-semibold" to="/products">Products App</Link>
                <div className="flex items-center gap-4">
                    <Link className="text-sm text-slate-700 hover:text-slate-900 transition" to="/register">Register</Link>
                    <Link className="text-sm text-slate-700 hover:text-slate-900 transition"to="/login">Login</Link>
                    <Link className="text-sm text-slate-700 hover:text-slate-900 transition"to="/cart">Cart</Link>
                </div>
            </div>
        </nav>
    )
}