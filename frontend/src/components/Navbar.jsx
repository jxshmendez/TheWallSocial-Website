import { NavLink } from "react-router-dom";
import './Navbar.css';

export default function Navbar() {

    const linkClasses = ({ isActive }) => {
        const baseClasses = "text-base transition-colors duration-200 ";

        // If we're on the About page, all links should be white

        // Normal styling for other pages
        return isActive
            ? baseClasses + "text-[#E7692F]"
            : baseClasses + "text-[#292A23] hover:text-[#E7692F]";
    };

    return (
        <nav className="text-sm w-full p-2 sm:p-4 fixed z-50 top-0 left-0 right-0 bg-[#EDE8D1]">
            <div className="flex items-center justify-center w-full max-w-[400px] mx-auto p-2 sm:p-3 relative">
                {/* Center - Nav links */}
                <div className="flex gap-4 sm:gap-6 md:gap-10 items-center">
                    <NavLink
                        to="/about"
                        className={linkClasses}
                    >
                        About
                    </NavLink>
                    <NavLink
                        to="/features"
                        className={linkClasses}
                    >
                        Features
                    </NavLink>
                    <NavLink
                        to="/"
                        className={linkClasses}
                    >
                        Waitlist
                    </NavLink>
                </div>
            </div>
        </nav>
    );
}