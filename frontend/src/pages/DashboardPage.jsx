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
        <section className={"min-h-screen flex items-start justify-end bg-[#fef6e0] text-black p-6"}>
            <h1 className={"text-6xl anton-sc-regular text-[#ff5317]"}>
                Hello, {username || "Climber"}
            </h1>
        </section>
    )
}