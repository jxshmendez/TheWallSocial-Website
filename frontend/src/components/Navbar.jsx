import { NavLink } from "react-router-dom";
import './Navbar.css';

export default function Navbar() {
    const linkClasses = ({ isActive }) =>
        isActive 
            ? "text-[#ff5317] font-semibold text-sm" 
            : "text-black hover:text-[#ff5317] font-semibold transition-colors duration-200 text-sm";

    return (
        <nav className="text-sm sm:text-base md:text-xl w-full text-white p-2 sm:p-4 fixed z-50 top-0 left-0 right-0">
            <div className="navbar-glass flex items-center justify-center w-full max-w-[400px] mx-auto p-2 sm:p-3 relative">

                {/* Center - Nav links */}
                <div className="flex gap-4 sm:gap-6 md:gap-10 items-center">
                    <NavLink 
                        to={"/"} 
                        className="text-[#ff5317] font-bold text-lg sm:text-xl hover:scale-110 transition-transform duration-200"
                    >
                        WALL
                    </NavLink>
                    <NavLink 
                        to="/about" 
                        className={linkClasses}
                    >
                        ABOUT
                    </NavLink>
                    <NavLink 
                        to="/features" 
                        className={linkClasses}
                    >
                        FEATURES
                    </NavLink>
                </div>
            </div>
        </nav>
    );
}


