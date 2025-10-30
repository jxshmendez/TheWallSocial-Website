import { useEffect, useState } from "react";
import { getGyms } from "../services/api";

export default function GymsPage() {
    const [gyms, setGyms] = useState([]);

    useEffect(() => {
        getGyms().then(setGyms).catch(console.error);
    }, []);

    return (
        <div className="p-6">
            <h2 className="text-2xl font-semibold mb-4">Gyms</h2>
            <ul className="space-y-2">
                {gyms.map((gym) => (
                    <li key={gym.gymId} className="p-3 bg-gray-100 rounded-lg">
                        <p className="font-medium">{gym.name}</p>
                        <p className="text-sm text-gray-600">{gym.location}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}
