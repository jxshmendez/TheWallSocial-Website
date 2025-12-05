import {jwtDecode} from 'jwt-decode'

export default function LoggedInNavbar() {

    const token = localStorage.getItem('token');

    let userId: number | null = null;
    if(token){
        const decoded = jwtDecode<{userId: number}>(token);
        userId = decoded.userId;
    }

    const handleLogout = () => {
        localStorage.removeItem("token");
        window.location.href = "/"; // refresh and redirect to home
    };

    return (
        <nav className="flex justify-between items-center p-4 bg-[#ff5317] text-white">
            <h1 className="text-2xl font-bold ">WALL</h1>
            <div>
                <a href="/dashboard" className="mr-4 hover:underline">Dashboard</a>
                {userId && (
                    <a
                        href={`/users/${userId}`}
                        className={"hover:underline"}
                        >
                        Profile
                    </a>
                )}

                <button onClick={handleLogout} className="hover:underline">Logout</button>
            </div>
        </nav>
    );
}
