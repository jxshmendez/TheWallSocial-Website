import './AboutPage.css';

export default function AboutPage(){
    return (
        <div className="about-image-container min-h-screen" style={{ margin: 0, padding: 0 }}>
            <div className="about-image-wrapper">
                <img 
                    src="/About.png" 
                    alt="About WALL"
                    className="about-image"
                />
            </div>
        </div>
    );
}