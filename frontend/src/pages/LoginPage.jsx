import {useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import{useAuth} from "../context/AuthContext";

export default function LoginPage(){
    const {login} = useAuth();
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        username: "",
        password: ""
    });

    const [message, setMessage] = useState("");

    const handleChange = (e) => {
        setFormData({...formData, [e.target.name]: e.target.value});
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try{
            const res = await axios.post("/api/auth/login", formData);
            const token = res.data.token;
            login(token);
            setMessage(res.data.message || "Login Successful");

            navigate("/dashboard");

        } catch (err){
            setMessage(err.response?.data || "Login Failed")
        }
    };

    return(
        <section className={"min-h-screen flex flex-col justify-center items-center bg-[#fef6e0] text-black p-6"}>
            <h1 className={"text-6xl anton-sc-regular mb-10 text-[#ff5317]"}>LOGIN</h1>

            <form
                onSubmit={handleSubmit}
                className={"w-full max-w-sm bg-white p-8 rounded-2xl shadow-md border border-[#ff5317]"}
            >
                <div className={"mb-5"}>
                    <label htmlFor="username" className={"block font-semibold mb-1"}>
                        Username
                    </label>
                    <input
                        type={"text"}
                        id={"username"}
                        name={"username"}
                        value={formData.username}
                        onChange={handleChange}
                        className={"w-full p-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-[#ff5317]"}
                        required
                    />
                </div>

                <div className={"mb-5"}>
                    <label htmlFor="password" className={"block font-semibold mb-1"}>
                        Password
                    </label>
                    <input
                        type={"password"}
                        id={"password"}
                        name={"password"}
                        value={formData.password}
                        onChange={handleChange}
                        className={"w-full p-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-[#ff5317]"}
                        required
                    />
                </div>

                <button
                    type={"submit"}
                    className={"w-full py-2 bg-[#ff5317] text-white font-semibold rounded-md hover:bg-[#e44b15] transition-all"}
                >
                    Login
                </button>

                {message && (
                    <p className={"mt-4 text-centre text-sm text-gray-700"}>{message}</p>
                )}
            </form>

            <p className="mt-4 text-sm text-gray-600">
                Don't have an account?{" "}
                <button
                    onClick={() => navigate("/register")}
                    className="text-[#ff5317] font-semibold hover:underline"
                >
                    Register
                </button>
            </p>
        </section>
    )
}