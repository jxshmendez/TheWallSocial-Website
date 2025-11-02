import { NavLink } from "react-router-dom";

export default function Navbar() {
    const linkClasses = ({ isActive }) =>
        isActive ? "text-[#E35335]" : "text-black";

    return (
        <nav className="noto-sans-display text-xl w-full bg-[#fef6e0] text-black p-4 border-b border-transparent">
            <div className="relative flex items-center justify-between border-b border-[#ff5317] w-[97%] mx-auto pb-3">
                <div className="flex gap-10">
                    <NavLink to="/" className={linkClasses}>Home</NavLink>
                    <NavLink to="/features" className={linkClasses}>Features</NavLink>
                    <NavLink to="/about" className={linkClasses}>About</NavLink>
                </div>

                <h1 className="anton-sc-regular text-5xl text-[#ff5317] absolute left-1/2 transform -translate-x-1/2 font-bold tracking-wide">
                    WALL
                </h1>

                <div className="flex justify-end min-w-[8rem]">
                    <NavLink
                        to="/waitlist"
                        className="bg-[#ff5317] text-black px-4 py-1.5 rounded-md hover:bg-[#FFDEAD] transition">
                        Waitlist
                    </NavLink>
                </div>
            </div>
        </nav>
    );
}
