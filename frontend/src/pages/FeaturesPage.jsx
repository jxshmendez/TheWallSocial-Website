import './FeaturesPage.css';

export default function FeaturesPage() {
    const features = [
        {
            title: "Track Your Progress",
            description: "Log your climbs, track your routes, and monitor your improvement over time."
        },
        {
            title: "Connect with Climbers",
            description: "Follow other climbers, share achievements, and build your climbing network."
        },
        {
            title: "Discover Routes",
            description: "Explore new climbing routes, gyms, and outdoor locations near you."
        },
        {
            title: "Community Challenges",
            description: "Participate in community challenges and compete with climbers worldwide."
        }
    ];

    return (
        <div className="min-h-screen bg-[#EDE8D1] pt-20 pb-20" style={{fontFamily: '"Geist", sans-serif'}}>
            <div className="max-w-6xl mx-auto px-4 sm:px-6 lg:px-8">
                {/* Header */}
                <div className="text-center mb-16 mt-12">
                    <h1 className="text-4xl sm:text-5xl md:text-6xl lg:text-7xl text-[#ff5317] mb-4" style={{fontWeight: 800}}>
                        FEATURES
                    </h1>
                    <p className="text-gray-600 text-lg sm:text-xl max-w-2xl mx-auto" style={{fontWeight: 400}}>
                         
                    </p>
                </div>

                {/* Features Grid */}
                <div className="grid grid-cols-1 md:grid-cols-2 gap-6 lg:gap-8">
                    {features.map((feature, index) => (
                        <div
                            key={index}
                            className="group glass-card p-6 sm:p-8 transition-all duration-300 hover:-translate-y-2"
                        >
                            <h3 className="text-xl sm:text-2xl text-gray-900 mb-3" style={{fontWeight: 700}}>
                                {feature.title}
                            </h3>
                            <p className="text-gray-600 leading-relaxed" style={{fontWeight: 400}}>
                                {feature.description}
                            </p>
                        </div>
                    ))}
                </div>

                {/* Coming Soon Section */}
                <div className="mt-16 text-center">
                    <div className="group glass-card rounded-2xl p-8 sm:p-12 text-black shadow-xl">
                        <h2 className="text-2xl sm:text-3xl md:text-4xl mb-4" style={{fontWeight: 700}}>
                            MOBILE APP UNDER DEVELOPMENT
                        </h2>
                    </div>
                </div>
            </div>
        </div>
    );
}