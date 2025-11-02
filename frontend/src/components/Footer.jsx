export default function Footer() {
    return (
        <>
            <footer className="flex flex-col items-center justify-center w-full py-20 bg-[#ff5317] text-white/70m">
                <h1 className={"font-bold text-2xl border-b-2 pt-4"}>THE WALL</h1>
                <h2 className={"font-bold text-xl"}>UNDER DEVELOPMENT</h2>
                <p className="mt-4 text-center">Copyright © 2025 <a href="http://instagram.com/wall.social/">The Wall Social</a>. All rights reservered.</p>
                <div className="flex items-center gap-4 mt-5">
                    <a href="http://instagram.com/wall.social/" className="hover:-translate-y-0.5 transition-all duration-300">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M17 2H7a5 5 0 0 0-5 5v10a5 5 0 0 0 5 5h10a5 5 0 0 0 5-5V7a5 5 0 0 0-5-5" stroke="#fff" strokeOpacity=".5" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                            <path d="M16 11.37a4 4 0 1 1-7.914 1.173A4 4 0 0 1 16 11.37m1.5-4.87h.01" stroke="#fff" strokeOpacity=".5" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                        </svg>
                    </a>
                </div>
            </footer>
        </>
    );
};