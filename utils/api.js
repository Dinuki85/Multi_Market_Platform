export const API_BASE = "http://localhost:8080/api/auth";

export async function registerUser(data){
    const res = await fetch(`${API_BASE}/signup`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(data),
    });
    return res.text();
}

export async function loginUser(data){
    const res = await fetch(`${API_BASE}/signin`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(data),
    });
    return res.text();
}