import { useEffect, useState } from "react";
import { jwtDecode } from "jwt-decode";


export default function DashboardPage(){
    const [username, setUsername] = useState("");

    useEffect(() => {
        const token  = localStorage.getItem("token");
        if (token) {
            try {
                const decoded = jwtDecode(token);
                setUsername(decoded.sub);
            } catch (error) {
                console.log("Invalid token: ", error)
            }
        }
    }, []);

    return (
        <section className="min-h-screen flex flex-col items-center bg-[#fef6e0] text-black overflow-y-auto">
            <div className="w-full max-w-xl flex flex-col gap-6 mt-10 p-4">
                {/* Example post cards */}
                <div className="bg-white shadow-md rounded-2xl p-4">
                    <h2 className="font-bold text-xl text-[#ff5317]">Post Title</h2>
                    <p className="mt-2 text-gray-700">Content</p>
                </div>
                <div className="bg-white shadow-md rounded-2xl p-4">
                    <h2 className="font-bold text-xl text-[#ff5317]">Post Title</h2>
                    <p className="mt-2 text-gray-700">Content</p>
                </div>
                <div className="bg-white shadow-md rounded-2xl p-4">
                    <h2 className="font-bold text-xl text-[#ff5317]">Post Title</h2>
                    <p className="mt-2 text-gray-700">Content</p>
                </div>

            </div>
        </section>
    )
}