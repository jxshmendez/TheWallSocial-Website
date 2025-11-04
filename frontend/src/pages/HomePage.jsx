

export default function HomePage() {


    return (
        <div className="">
            <section className={"min-h-screen flex flex-col items-center justify-center"}>
                <h1 className={"anton-sc-regular text-[8rem] font-bold"}>
                    <span className="text-[#3256d2]">FOR THOSE WHO LIVE ON THE</span>
                </h1>
                <h1 className="anton-sc-regular text-[12rem] font-bold text-[#ff5317]">
                    WALL
                </h1>
                <p className="mt-2 text-gray-700 font-bold">Built For Climbers, By Climbers</p>

                <div className="mt-8">
                    <button className="px-6 py-3 bg-[#ff5317] text-gray-900 font-semibold rounded-md
                     hover:bg-[#FFDEAD] transition">
                        Get Started
                    </button>
                    <button className="ml-4 px-6 py-3 border border-[#ff5317] text-black
                     hover:bg-[#E35335] hover:text-gray-900 transition rounded-md">
                        Learn More
                    </button>
                </div>
                </section>

            <section className="min-h-screen bg-[#101820] flex items-center justify-center relative">
                <h2 className="text-5xl font-bold text-white" id="trackText">
                    <span className="inline-block mr-2">Track,</span>
                    <span className="inline-block mr-2">Connect.</span>
                    <span className="inline-block">Climb</span>
                </h2>
            </section>


            <section className={"min-h-screen bg-[#ff5317] flex flex-col items-center justify-center"}>
                    <h2 className={"text-5xl font-bold text-amber-100"}>Create A Community</h2>
            </section>
        </div>

    );
}
