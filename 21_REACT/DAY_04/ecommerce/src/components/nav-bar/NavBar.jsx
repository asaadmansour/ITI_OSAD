import { Link } from "react-router-dom";
import LanguageContext from "../../contexts/languageContext";
import { useContext } from "react";
export default function NavBar() {
    const { language, changeLanguage } = useContext(LanguageContext);
    return (
        <nav className="w-full bg-slate-100 shadow-sm fixed">
            <div className="max-w-7xl mx-auto flex items-center justify-between px-4 py-3">
                <Link className="text-lg font-semibold" to="/products">Products App</Link>
                <div className="flex items-center gap-4">
                    <Link className="text-sm text-slate-600 hover:text-slate-900 transition" to="/register">Register</Link>
                    <Link className="text-sm text-slate-600 hover:text-slate-900 transition"to="/login">Login</Link>
                    <Link className="text-sm text-slate-600 hover:text-slate-900 transition"to="/cart">Cart</Link>
                    <button
                        onClick={() => changeLanguage(language === "en" ? "ar" : "en")}
                        className="text-sm text-slate-600 hover:text-slate-900 font-medium border border-slate-300 rounded px-2 py-0.5 transition"
                    >
                        {language === "en" ? "AR" : "EN"}
                    </button>
                </div>
            </div>
        </nav>
    )
}