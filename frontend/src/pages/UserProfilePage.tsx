import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import FollowButton from "../components/FollowButton";
import { UserPreviewDTO } from "../types/UserPreviewDTO";

export default function UserProfilePage() {
    const {userId} = useParams();
    const [user, setUser] = useState<UserPreviewDTO | null>(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if (!userId) return;

        async function loadUser() {
            try {
                const token = localStorage.getItem("token");

                const res = await axios.get<UserPreviewDTO>(
                    `/api/users/id/${userId}`,
                    {
                        headers: { Authorization: `Bearer ${token}` },
                    }
                );

                setUser(res.data);
            } catch (err) {
                console.error("Failed to load user", err);
            } finally {
                setLoading(false);
            }
        }

        loadUser();
    }, [userId]);

    if(!user) return <p>User not found</p>;

    return (
        <div className={"max-w-xl mx_auto p-4 space-y-4"}>
            <div className={"flex items-center gap-4"}>
                <img
                    src={user.avatarUrl || "/default-avatar.png"}
                    alt={user.username}
                    className={"w-20 h-20 rounded-full object-cover"}
                />

                <div className={"flex-1"}>
                    <h1 className={"text-2xl font-bold"}>{user.username}</h1>
                    <p className={"text-gray-600"}>{user.bio || "Empty"}</p>
                </div>

                <FollowButton targetUserId={user.userId}/>
            </div>
        </div>
    );
}