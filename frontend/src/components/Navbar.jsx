import { NavLink } from "react-router-dom";

export default function Navbar() {
    const linkClasses = ({ isActive }) =>
        isActive 
            ? "text-[#ff5317] font-semibold" 
            : "text-white hover:text-[#ff5317] transition-colors duration-200";

    return (
        <nav className="text-sm sm:text-base md:text-xl w-full text-white p-2 sm:p-4 fixed z-50 top-0 left-0 right-0">
            <div className="flex items-center justify-center bg-gray-900/90 backdrop-blur-md w-full max-w-[500px] mx-auto p-2 sm:p-3 rounded-full shadow-lg border border-gray-700/50">

                {/* Center - Nav links */}
                <div className="flex gap-4 sm:gap-6 md:gap-10 items-center">
                    <NavLink 
                        to={"/"} 
                        className="text-[#ff5317] font-bold text-lg sm:text-xl hover:scale-110 transition-transform duration-200"
                    >
                        WALL
                    </NavLink>
                    <NavLink 
                        to="/features" 
                        className={linkClasses}
                    >
                        Features
                    </NavLink>
                    <NavLink 
                        to="/about" 
                        className={linkClasses}
                    >
                        About
                    </NavLink>
                </div>
            </div>
        </nav>
    );
}
