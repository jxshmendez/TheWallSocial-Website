import {NavLink} from "react-router-dom";


export default function HomePage() {


    return (
        <div className="overflow-hidden">
            {/* Hero Section */}
            <section className={"min-h-screen flex flex-col items-center justify-center px-4 relative bg-gradient-to-b from-gray-50 via-gray-100/50 to-gray-50"}>
                {/* Decorative background elements */}
                <div className="absolute inset-0 overflow-hidden pointer-events-none bg-[#EDE8D1]">
                    <div className="absolute top-20 left-10 w-72 h-72 bg-[#ff5317]/5 rounded-full blur-3xl"></div>
                    <div className="absolute bottom-20 right-10 w-96 h-96 bg-gray-300/20 rounded-full blur-3xl"></div>
                </div>
                
                <div className="relative z-10 text-center space-y-6">
                    <h1 className="anton-sc-regular text-2xl sm:text-2xl md:text-8xl lg:text-9xl xl:text-[5rem] font-bold text-[#292A23] text-center drop-shadow-lg">
                        FOR THOSE WHO LIVE ON THE
                    </h1>
                    <h1 className="anton-sc-regular text-6xl sm:text-7xl md:text-8xl lg:text-9xl xl:text-[10rem] md:pb-4 font-bold text-[#E7692F] text-center drop-shadow-lg">
                        WALL
                    </h1>
                    <p className="inter-regular text-sm sm:text-base md:text-lg tracking-wide ">BUILT FOR CLIMBERS BY CLIMBERS</p>

                    <div className="mt-12 flex flex-col sm:flex-row gap-4 justify-center items-center">
                        <NavLink 
                            to={"/waitlist"}
                            className="anton-sc-light px-8 py-4 tracking-wide border-2 border-[#292A23] text-[#292A23] text-sm sm:text-base font-semibold rounded-full hover:bg-[#E7692F] hover:border-[#E7692F] transition-all duration-300 hover:scale-105"
                        >
                            JOIN THE WAITLIST
                        </NavLink>
                    </div>
                </div>
            </section>

            {/* Track, Connect, Climb Section */}
            <section className="min-h-screen flex items-center justify-center px-4 relative overflow-hidden bg-cover bg-center bg-no-repeat"
            style={{
                backgroundImage: 'url(/HomepageSection2.png)',
                minHeight: 'calc(100vh + env(safe-area-inset-top, 0px))',
                paddingTop: 'env(safe-area-inset-top, 0px)',
                marginTop: 'calc(-1 * env(safe-area-inset-top, 0px))',
                backgroundAttachment: 'fixed'
            }}
            >
                {/* Dark overlay to ensure text readability */}
                <div className="absolute inset-0 bg-gray-900/40" style={{
                    top: 'calc(-1 * env(safe-area-inset-top, 0px))',
                    height: 'calc(100% + env(safe-area-inset-top, 0px))'
                }}></div>
                
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
