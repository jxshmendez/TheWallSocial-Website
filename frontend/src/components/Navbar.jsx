import { NavLink } from "react-router-dom";

export default function Navbar() {
    const linkClasses = ({ isActive }) =>
        isActive ? "text-[#E35335]" : "text-white";

    return (
        <nav className="text-xl w-full  text-white p-4 fixed">
            <div className="flex items-center justify-center bg-black w-[450px] mx-auto p-3 rounded-4xl">

                {/* Center - Nav links */}
                <div className="flex gap-10 inter">
                    <NavLink to={"/"} className="text-[#ff5317]">
                        WALL
                    </NavLink>
                    <NavLink to="/features" className={linkClasses}>Features</NavLink>
                    <NavLink to="/about" className={linkClasses}>About</NavLink>
                    <NavLink
                        to="/register"
                        className="flex items-center bg-[#ff5317] text-white px-4
                          rounded-4xl hover:bg-[#FFDEAD] transition">
                        JOIN
                    </NavLink>
                </div>
            </div>
        </nav>
    );
}
