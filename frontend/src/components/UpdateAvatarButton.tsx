import {useState} from "react";
import axios from "axios";

interface UpdateAvatarProps {
    currentAvatar: string;
    onUpdated: (newAvatar: string) => void;
}

export default function UpdateAvatarButton({
    currentAvatar,
    onUpdated } : UpdateAvatarProps) {
    const [editing, setEditing] = useState<boolean>(false);
    const [avatar, setAvatar] = useState<string>(currentAvatar);
    const [loading, setLoading] = useState<boolean>(false);

    async function saveAvatar() {
        try {
            setLoading(true);
            const token = localStorage.getItem("token");
            await axios.patch(
                "/api/users/avatar",
                avatar,
                {
                    headers: {
                        Authorization: `Bearer ${token}`,
                        "Content-Type": "text/plain",
                    },
                }
            );

            onUpdated(avatar);
            setEditing(false);
        } catch (err) {
            console.log("Failed to update avatar", err);
        } finally {
            setLoading(false);
        }
    }

    if(!editing) {
        return (
            <button onClick={() => setEditing(true)}>
                <a href="https://www.flaticon.com/free-icons/pencil" title="pencil icons"></a>
            </button>
        )
    }

}