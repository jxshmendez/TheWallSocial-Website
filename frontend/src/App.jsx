import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import AboutPage from "./pages/AboutPage";
import FeaturesPage from "./pages/FeaturesPage";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";


export default function App() {
    return (
    <div className="min-h-screen bg-gray-50 text-gray-900">
        <svg style={{display: 'none'}}>
            <filter id="displacementFilter">
                <feTurbulence 
                    type="turbulence" 
                    baseFrequency="0.01" 
                    numOctaves="2" 
                    result="turbulence" 
                />
                <feDisplacementMap 
                    in="SourceGraphic"
                    in2="turbulence"    
                    scale="200" 
                    xChannelSelector="R" 
                    yChannelSelector="G" 
                />
            </filter>
        </svg>
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
