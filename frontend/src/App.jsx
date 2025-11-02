import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import GymsPage from "./pages/GymsPage";
import UsersPage from "./pages/UsersPage";
import RoutesPage from "./pages/RoutesPage";
import JoinPage from "./pages/JoinPage";
import AboutPage from "./pages/AboutPage";
import FeaturesPage from "./pages/FeaturesPage";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";


export default function App() {
    return (
    <div className="min-h-screen bg-[#fef6e0] text-black">
        <Router>
            <Navbar />
            <Routes>
                <Route path={"/"} element={<HomePage />} />
                <Route path={"/features"} element={<FeaturesPage />} />
                <Route path={"/about"} element={<AboutPage s/>} />
                <Route path="/routes" element={<RoutesPage />} />
                <Route path="/waitlist" element={<JoinPage />} />
            </Routes>
        </Router>
        <Footer />
    </div>
    );

}
