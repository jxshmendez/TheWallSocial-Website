export default function LoggedInNavbar() {
    const handleLogout = () => {
        localStorage.removeItem("token");
        window.location.href = "/"; // refresh and redirect to home
    };

    return (
        <nav className="flex justify-between items-center p-4 bg-[#ff5317] text-white">
            <h1 className="text-2xl font-bold ">WALL</h1>
            <div>
                <a href="/dashboard" className="mr-4 hover:underline">Dashboard</a>
                <button onClick={handleLogout} className="hover:underline">Logout</button>
            </div>
        </nav>
    );
}
