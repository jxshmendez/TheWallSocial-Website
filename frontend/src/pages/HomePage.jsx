import {NavLink} from "react-router-dom";


export default function HomePage() {


    return (
        <div className="overflow-hidden">
            {/* Hero Section */}
            <section className={"min-h-screen flex flex-col items-center justify-center px-4 relative bg-gradient-to-b from-gray-50 via-gray-100/50 to-gray-50"}>
                {/* Decorative background elements */}
                <div className="absolute inset-0 overflow-hidden pointer-events-none bg-[#eed9c4]">
                    <div className="absolute top-20 left-10 w-72 h-72 bg-[#ff5317]/5 rounded-full blur-3xl"></div>
                    <div className="absolute bottom-20 right-10 w-96 h-96 bg-gray-300/20 rounded-full blur-3xl"></div>
                </div>
                
                <div className="relative z-10 text-center space-y-6">
                    <h1 className={"anton-sc-regular text-4xl sm:text-5xl md:text-6xl lg:text-7xl xl:text-[8rem] font-bold text-center leading-tight"}>
                        <span className="text-gray-800 drop-shadow-lg">FOR THOSE WHO LIVE ON THE</span>
                    </h1>
                    <h1 className="anton-sc-regular text-6xl sm:text-7xl md:text-8xl lg:text-9xl xl:text-[12rem] pb-2 md:pb-4 font-bold text-[#ff5317] text-center leading-tight drop-shadow-lg">
                        WALL
                    </h1>
                    <p className="text-gray-600 font-semibold text-sm sm:text-base md:text-lg tracking-wide lacquer-regular xl:text-3xl">built for climbers, by CLIMBERS</p>

                    <div className="mt-12 flex flex-col sm:flex-row gap-4 justify-center items-center">
                        <NavLink 
                            to={"/features"} 
                            className="px-8 py-4 border-2 border-[#ff5317] text-[#ff5317] text-sm sm:text-base font-semibold rounded-full hover:bg-[#ff5317] hover:text-white transition-all duration-300 hover:scale-105"
                        >
                            FEATURES
                        </NavLink>
                        <NavLink 
                            to={"/about"} 
                            className="group relative px-8 py-4 bg-gradient-to-r from-[#ff5317] to-[#e44b15] text-white text-sm sm:text-base font-semibold rounded-full shadow-lg hover:shadow-xl hover:scale-105 transition-all duration-300 overflow-hidden"
                        >
                            <span className="relative z-10">LEARN</span>
                            <div className="absolute inset-0 bg-gradient-to-r from-[#e44b15] to-[#ff5317] opacity-0 group-hover:opacity-100 transition-opacity duration-300"></div>
                        </NavLink>
                    </div>
                </div>
            </section>

            {/* Track, Connect, Climb Section */}
            <section className="min-h-screen flex items-center justify-center px-4 relative overflow-hidden bg-cover bg-center bg-no-repeat"
            style={{
                backgroundImage: 'url(/HomepageSection2.png)',
                minHeight: '100vh',
                minHeight: '-webkit-fill-available',
                marginTop: 'calc(-1 * env(safe-area-inset-top))',
                paddingTop: 'env(safe-area-inset-top)'
            }}
            >
                {/* Dark overlay to ensure text readability */}
                <div className="absolute inset-0 bg-gray-900/40" style={{top: 0}}></div>
                
                <div className="relative z-10 flex flex-col items-center">
                    <img 
                        src="/Climb Tab.svg" 
                        alt="Performance Tab"
                        className="w-[380px] h-[610px] sm:w-[550px] sm:h-[738px] md:w-[550px] md:h-[920px] block mb-0"
                    />
                    <h2 className="text-2xl sm:text-3xl md:text-4xl lg:text-5xl xl:text-6xl font-bold text-white text-center -mt-24 sm:-mt-32 md:-mt-40 leading-none" id="trackText">
                        <span className="inline-block mr-2 sm:mr-4 hover:scale-110 transition-transform duration-300 cursor-default">Track,</span>
                        <span className="inline-block mr-2 sm:mr-4 hover:scale-110 transition-transform duration-300 cursor-default">Connect.</span>
                        <span className="inline-block hover:scale-110 transition-transform duration-300 cursor-default">Climb</span>
                    </h2>
                    <p className="mt-4 text-gray-300 text-center text-sm sm:text-base md:text-lg max-w-2xl mx-auto">
                        The platform for climbers to track their progress, connect with the community, and push their limits.
                    </p>
                </div>
                
            </section>

            {/* Community Section */}
            <section 
                className="min-h-screen bg-gradient-to-br from-gray-100 to-gray-50 flex flex-col items-center justify-center px-4 relative overflow-hidden bg-cover bg-center bg-no-repeat"
                style={{backgroundImage: 'url(/Homepage.png)'}}
            >
                {/* Dark overlay to ensure text readability */}
                <div className="absolute inset-0 bg-gray-900/40"></div>
                
                {/* Decorative elements */}
                <div className="absolute top-0 left-0 w-full h-full opacity-30 z-[1]">
                    <div className="absolute top-20 right-20 w-64 h-64 bg-[#ff5317]/10 rounded-full blur-2xl"></div>
                    <div className="absolute bottom-20 left-20 w-80 h-80 bg-[#ff5317]/10 rounded-full blur-2xl"></div>
                </div>
                
                <div className="relative z-10 text-center space-y-6">
                    <h2 className={"text-2xl sm:text-3xl md:text-4xl lg:text-5xl xl:text-6xl font-bold text-white text-center"}>
                        Create A Community
                    </h2>
                    <p className="text-white/90 text-sm sm:text-base md:text-lg lg:text-xl max-w-2xl mx-auto mt-6">
                        Join other climbers sharing routes, achievements, and experiences. Build your climbing network and grow together.
                    </p>
                </div>
            </section>
        </div>

    );
}
