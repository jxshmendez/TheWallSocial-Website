import {useEffect, useState} from "react";
import axios from "axios";
import {jwtDecode} from "jwt-decode";
import {JwtPayload } from "../types/JwtPayload"
import { FollowDTO } from "../types/FollowDTO";

interface FollowButtonProps {
    targetUserId: number;
    onChange?: () => void;
}

export default function FollowButton({targetUserId, onChange}: FollowButtonProps) {
    const [isFollowing, setIsFollowing] = useState<boolean>(false);
    const [loading, setLoading] = useState<boolean>(true);
    const [userId, setUserId] = useState<number | null>(null);

    // Extract the logged-in userId from the JWT token
    useEffect(() => {
        const token = localStorage.getItem("token");
        if (token) {
            const decoded = jwtDecode<JwtPayload>(token);
            setUserId(decoded.userId);
        }
    }, []);

    // Check if user already follows profile
    useEffect(() => {
        if(!userId || !targetUserId) return;

        async function checkFollowState(){
            try {
                const token = localStorage.getItem("token");

                const res = await axios.get<FollowDTO[]>(
                    `/api/follow/users/${userId}/following`,
                    {
                        headers: { Authorization: `Bearer ${token}` }
                    }
                );

                const followingList = res.data.map(f => f.followingId);
                setIsFollowing(followingList.includes(targetUserId));
            } catch (error) {
                console.error("Error checking following state", error);
            } finally {
                setLoading(false);
            }
        }

        checkFollowState();
    }, [userId, targetUserId]);

    // Follow

    async function follow(){
        try{
            const token = localStorage.getItem("token");

            await axios.post(
                `/api/follow/users/${targetUserId}/follow`,
                {},
                {
                    headers: { Authorization: `Bearer ${token}` }
                }
            );

            setIsFollowing(true);
            onChange && onChange();
        } catch (error) {
            console.error("Failed to follow user:", error);
        }
    }

    async function unfollow(){
        try{
            const token = localStorage.getItem("token");

            await axios.delete(
                `/api/follow/users/${targetUserId}/follow`,
                {
                    headers: { Authorization: `Bearer ${token}` }
                }
            );

            setIsFollowing(false);
            onChange && onChange();
        } catch(error) {
            console.error("Failed to unfollow user:", error);
        }
    }

    if(loading){
        return <button disabled>Loading...</button>
    }

    if(userId === targetUserId) return null;

    return(
        <button
            onClick={isFollowing ? unfollow : follow}
            className={
                isFollowing
                    ? "px-3 py-2 rounded bg-gray-300 text-black"
                    : "px-3 py-2 rounded bg-blue-600 text-white"
            }
            >
            {isFollowing ? "Unfollow" : "Follow"}
        </button>
    );
}

