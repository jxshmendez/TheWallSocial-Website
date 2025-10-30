const API_BASE_URL = "/api"

export async function getGyms(){
    const res = await fetch(`${API_BASE_URL}/gyms`);
    if(!res.ok) throw new Error("Failed to get gyms.");
    return await res.json();
}

export async function getUsers(){
    const res = await fetch(`${API_BASE_URL}/users`);
    if(!res.ok) throw new Error("Failed to get users.");
    return await res.json();
}