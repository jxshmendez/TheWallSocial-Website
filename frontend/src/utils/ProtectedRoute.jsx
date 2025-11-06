import { Navigate } from "react-router-dom";
import { isLoggedIn } from "./auth.js";

export default function ProtectedRoute({ children }) {
    return isLoggedIn() ? children : <Navigate to="/login" replace />;
}
