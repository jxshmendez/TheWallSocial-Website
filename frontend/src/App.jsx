import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import RegisterPage from "./pages/RegisterPage.jsx";
import AboutPage from "./pages/AboutPage";
import FeaturesPage from "./pages/FeaturesPage";
import LoginPage from "./pages/LoginPage";
import LoggedInNavbar from "./components/LoggedInNavbar";
import DashboardPage from "./pages/DashboardPage";
import GuestRoute from "./utils/GuestRoute";
import ProtectedRoute from "./utils/ProtectedRoute";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import {useAuth} from "./context/AuthContext";

export default function App() {
    const {loggedIn} = useAuth();

    return (
    <div className="min-h-screen bg-[#fef6e0] text-black">
        <Router>
            {loggedIn ? <LoggedInNavbar/> : <Navbar/>}
            <Routes>
                <Route path={"/"} element={<HomePage />} />
                <Route path={"/dashboard"} element={<DashboardPage/>}/>
                <Route path={"/features"} element={<FeaturesPage />} />
                <Route path={"/about"} element={<AboutPage s/>} />
                <Route
                    path="/register"
                    element={
                        <GuestRoute>
                            <RegisterPage />
                        </GuestRoute>
                    }
                />
                <Route
                    path="/login"
                    element={
                        <GuestRoute>
                            <LoginPage />
                        </GuestRoute>
                    }
                />

                <Route
                    path="/dashboard"
                    element={
                        <ProtectedRoute>
                            <DashboardPage />
                        </ProtectedRoute>
                    }
                />

            </Routes>
            {loggedIn? null : <Footer/>}
        </Router>
    </div>
    );

}
