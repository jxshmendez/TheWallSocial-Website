import {useEffect, useState} from "react";
import axios from "axios";
import {jwtDecode} from "jwt-decode";
import {JwtPayload } from "../types/JwtPayload"
import { UserPreviewDTO} from "../types/UserPreviewDTO";

interface UpdateBioButtonProps {
    currentBio: string;
    onUpdated: (newBio: string) => void;
}

export default function UpdatedBioButton({
    currentBio,
    onUpdated
} : UpdateBioButtonProps) {
    const [editing, setEditing] = useState<boolean>(false);
    const [bio, setBio] = useState<string>(currentBio);
    const [loading, setLoading] = useState<boolean>(false);

    async function saveBio(){
        try {
            setLoading(true);

            const token = localStorage.getItem("token");
            await axios.patch(
                "/api/users/bio",
                bio,
                {
                    headers: {
                        Authorization: `Bearer ${token}`,
                        "Content-Type": "text/plain",
                    },
                }
            );

            onUpdated(bio);
            setEditing(false);
        } catch (err) {
            console.log("Failed to update bio", err);
        } finally {
            setLoading(false);
        }
    }

    if (!editing) {
        return (
            <button onClick={() => setEditing(true)}
                    className="px-3 py-2 rounded bg-blue-600 text-white">
                Edit Bio
            </button>
        );
    }

    return (
        <div>
            <textarea
                value={bio}
                onChange={(e) => setBio(e.target.value)}
                rows={4}
                className="border"
           />
            <div>
                <button onClick={saveBio} disabled={loading} className={"mx-5"}>
                    Save
                </button>
                <button onClick={() => setEditing(false)}>
                    Cancel
                </button>
            </div>
        </div>
    );
}