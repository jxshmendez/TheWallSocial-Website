export default function AboutPage(){
    return (
        <div className="min-h-screen bg-gradient-to-b from-gray-50 to-gray-100 pt-20 pb-20">
            <div className="max-w-4xl mx-auto px-4 sm:px-6 lg:px-8">
                {/* Header */}
                <div className="text-center mb-16 mt-12">
                    <h1 className="text-4xl sm:text-5xl md:text-6xl lg:text-7xl font-bold text-[#ff5317] mb-6">
                        About WALL
                    </h1>
                </div>

                {/* Content Sections */}
                <div className="space-y-12">
                    <section className="bg-white/80 backdrop-blur-sm rounded-2xl p-6 sm:p-8 lg:p-10 shadow-lg border border-gray-200/50">
                        <h2 className="text-2xl sm:text-3xl font-bold text-gray-900 mb-4">
                            Built For Climbers, By Climbers
                        </h2>
                        <p className="text-gray-600 text-lg leading-relaxed mb-4">
                            WALL is a social platform designed specifically for the climbing community. We understand the unique needs of climbers because we are climbers ourselves.
                        </p>
                        <p className="text-gray-600 text-lg leading-relaxed">
                            Our mission is to create a space where climbers can track their progress, connect with others, share experiences, and grow together as a community.
                        </p>
                    </section>

                    <section className="bg-gradient-to-br from-gray-800 to-gray-900 rounded-2xl p-6 sm:p-8 lg:p-10 text-white shadow-lg">
                        <h2 className="text-2xl sm:text-3xl font-bold mb-4">
                            Our Vision
                        </h2>
                        <p className="text-lg leading-relaxed text-gray-300">
                            To become the go-to platform for climbers worldwide, fostering a supportive community where everyone can share their passion, learn from each other, and push their limits together.
                        </p>
                    </section>

                    <section className="bg-white/80 backdrop-blur-sm rounded-2xl p-6 sm:p-8 lg:p-10 shadow-lg border border-gray-200/50">
                        <h2 className="text-2xl sm:text-3xl font-bold text-gray-900 mb-4">
                            What's Next?
                        </h2>
                        <p className="text-gray-600 text-lg leading-relaxed mb-4">
                            We're currently developing our mobile app that will bring all these features to your fingertips. The mobile app will offer:
                        </p>
                        <ul className="list-disc list-inside text-gray-600 text-lg space-y-2 ml-4">
                            <li>Real-time route tracking</li>
                            <li>Social feed with photos and videos</li>
                            <li>Gym and route discovery</li>
                            <li>Personal climbing statistics</li>
                            <li>Community challenges and events</li>
                        </ul>
                    </section>

                    <section className="text-center bg-gradient-to-r from-[#ff5317] to-[#e44b15] rounded-2xl p-8 sm:p-12 text-white shadow-xl">
                        <h2 className="text-2xl sm:text-3xl md:text-4xl font-bold mb-4">
                            Join The Community
                        </h2>
                        <p className="text-lg sm:text-xl text-white/90 mb-6 max-w-2xl mx-auto">
                            Follow us on Instagram to stay updated on our progress and be the first to know when our mobile app launches!
                        </p>
                        <a 
                            href="http://instagram.com/wall.social/"
                            target="_blank"
                            rel="noopener noreferrer"
                            className="inline-block px-8 py-4 bg-white text-[#ff5317] font-semibold rounded-full hover:bg-gray-100 transition-all duration-300 hover:scale-105 shadow-lg"
                        >
                            Follow @wall.social
                        </a>
                    </section>
                </div>
            </div>
        </div>
    );
}