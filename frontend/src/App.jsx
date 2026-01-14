import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import AboutPage from "./pages/AboutPage";
import FeaturesPage from "./pages/FeaturesPage";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";


export default function App() {
    return (
    <div className="min-h-screen bg-gray-50 text-gray-900">
        <Router>
            <Navbar/>
            <Routes>
                <Route path={"/"} element={<HomePage />} />
                <Route path={"/features"} element={<FeaturesPage />} />
                <Route path={"/about"} element={<AboutPage />} />
            </Routes>
            <Footer/>
        </Router>
    </div>
    );

}
