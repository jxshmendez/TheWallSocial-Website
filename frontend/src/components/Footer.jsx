export default function Footer() {
    return (
        <>
            <footer className="flex flex-col items-center justify-center w-full py-8 sm:py-10 bg-gradient-to-b from-gray-800 to-gray-900 text-white relative overflow-hidden">
                {/* Decorative background */}
                <div className="absolute inset-0 opacity-10">
                    <div className="absolute top-0 left-0 w-full h-full bg-[linear-gradient(45deg,transparent_30%,rgba(255,83,23,0.1)_50%,transparent_70%)]"></div>
                </div>
                
                <div className="relative z-10 text-center space-y-3 px-4">
                    <h1 className={"font-bold text-xl sm:text-2xl border-b-2 border-white/20 pb-2 pt-2 inline-block"}>
                        THE WALL
                    </h1>
                    <h2 className={"font-semibold text-sm sm:text-base text-gray-300"}>UNDER DEVELOPMENT</h2>
                    <p className="text-center text-xs sm:text-sm text-gray-400">
                        Copyright © 2026{" "}
                        <a 
                            href="http://instagram.com/wall.social/" 
                            className="hover:text-[#ff5317] transition-colors duration-200 underline decoration-gray-500 hover:decoration-[#ff5317]"
                            target="_blank"
                            rel="noopener noreferrer"
                        >
                            The Wall Social
                        </a>
                        . All rights reserved.
                    </p>
                    <div className="flex items-center justify-center gap-6 mt-3">
                        <a 
                            href="http://instagram.com/wall.social/"
                            target="_blank"
                            rel="noopener noreferrer"
                            className="hover:-translate-y-1 hover:scale-110 transition-all duration-300 group"
                        >
                            <svg 
                                width="24" 
                                height="24" 
                                viewBox="0 0 24 24" 
                                fill="none" 
                                xmlns="http://www.w3.org/2000/svg"
                                className="group-hover:stroke-[#ff5317] transition-colors duration-300"
                            >
                                <path 
                                    d="M17 2H7a5 5 0 0 0-5 5v10a5 5 0 0 0 5 5h10a5 5 0 0 0 5-5V7a5 5 0 0 0-5-5"
                                    stroke="currentColor"
                                    strokeWidth="2"
                                    strokeLinecap="round"
                                    strokeLinejoin="round" 
                                />
                                <path 
                                    d="M16 11.37a4 4 0 1 1-7.914 1.173A4 4 0 0 1 16 11.37m1.5-4.87h.01"
                                    stroke="currentColor"
                                    strokeWidth="2"
                                    strokeLinecap="round"
                                    strokeLinejoin="round" 
                                />
                            </svg>
                        </a>
                    </div>
                </div>
            </footer>
        </>
    );
};