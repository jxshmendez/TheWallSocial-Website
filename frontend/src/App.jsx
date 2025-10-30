import './App.css'

import { useEffect, useState } from "react";

export default function App() {
    const [gyms, setGyms] = useState([]);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch("/api/gyms")
            .then((res) => {
                if (!res.ok) throw new Error("Failed to fetch gyms");
                return res.json();
            })
            .then((data) => setGyms(data))
            .catch((err) => setError(err.message))
            .finally(() => setLoading(false));
    }, []);

    return (
        <div className="min-h-screen bg-gray-50 text-gray-800 p-8">
            <h1 className="text-3xl font-bold mb-6 text-blue-700">
                Climber Gym List
            </h1>

            {loading && <p>Loading gyms...</p>}
            {error && <p className="text-red-500">Error: {error}</p>}

            <ul className="space-y-4">
                {gyms.map((gym) => (
                    <li
                        key={gym.gymId}
                        className="bg-white shadow rounded-lg p-4 border border-gray-200 hover:shadow-md transition"
                    >
                        <h2 className="text-xl font-semibold">{gym.name}</h2>
                        <p className="text-gray-600">{gym.location}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}

