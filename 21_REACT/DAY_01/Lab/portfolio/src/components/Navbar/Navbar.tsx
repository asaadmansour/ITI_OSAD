export default function NavBar() {
    return (
        <nav className="sticky top-0 z-50 bg-white shadow-sm">
            <div className="container-custom flex items-center justify-between py-4">
                <div className="text-lg font-semibold">
                    Asaad Mansour
                </div>
                
                <ul className="hidden md:flex gap-8 items-center">
                    <li><a href="#about" className="hover:text-blue-600 transition-colors">About Me</a></li>
                    <li><a href="#education" className="hover:text-blue-600 transition-colors">Education</a></li>
                    <li><a href="#experience" className="hover:text-blue-600 transition-colors">Experience</a></li>
                    <li><a href="#projects" className="hover:text-blue-600 transition-colors">Projects</a></li>
                </ul>
                
                <a 
                    href="/Asaad_Mansour_CV.pdf" 
                    download="Asaad_Mansour_CV.pdf"
                    className="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors text-center inline-block"
                >
                    Download CV
                </a>
            </div>
        </nav>
    )
}   