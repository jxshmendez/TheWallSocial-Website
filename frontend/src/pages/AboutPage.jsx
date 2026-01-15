export default function AboutPage(){
    return (
        <div className="w-screen bg-black min-h-screen overflow-x-hidden" style={{ margin: 0, padding: 0 }}>
            <img 
                src="/About.png" 
                alt="About WALL"
                className="w-full h-auto block"
                style={{
                    width: '100vw',
                    maxWidth: '100%',
                    height: 'auto',
                    display: 'block',
                    margin: 0,
                    padding: 0
                }}
            />
        </div>
    );
}