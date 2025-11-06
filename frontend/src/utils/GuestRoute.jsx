import { Navigate } from "react-router-dom";
import { isLoggedIn } from "./auth.js";

export default function GuestRoute({ children }) {
    return isLoggedIn() ? <Navigate to="/dashboard" replace /> : children;
}
