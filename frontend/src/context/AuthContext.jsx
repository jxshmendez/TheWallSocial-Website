import { createContext, useContext, useState, useEffect} from "react";

const AuthContext = createContext();
export function AuthProvider({children}) {
    const [loggedIn, setLoggedIn] = useState(false);

    useEffect(() => {
        const token = localStorage.getItem("token");
        setLoggedIn(!!token);
    }, []);

    const login = (token) => {
        localStorage.setItem("token", token);
        setLoggedIn(true);
    };

    const logout = () => {
        localStorage.removeItem("token");
        setLoggedIn(false);
    };

    return (
        <AuthContext.Provider value={{ loggedIn, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
}

// eslint-disable-next-line react-refresh/only-export-components
export const useAuth = () => useContext(AuthContext);