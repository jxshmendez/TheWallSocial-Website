import { useEffect, useState } from "react";
import { getUsers } from "../services/api";

export default function UsersPage() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        getUsers().then(setUsers).catch(console.error);
    }, []);

    return (
        <div className="p-6">
            <h2 className="text-2xl font-semibold mb-4">Users</h2>
            <ul className="space-y-2">
                {users.map((user) => (
                    <li key={user.userId} className="p-3 bg-gray-100 rounded-lg">
                        <p className="font-medium">{user.username}</p>
                        <p className="text-sm text-gray-600">{user.bio}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}
