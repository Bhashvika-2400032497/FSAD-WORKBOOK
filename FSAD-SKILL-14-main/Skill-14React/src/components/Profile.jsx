import { useEffect, useState } from "react"
import axios from "axios"

function Profile() {
    const [user, setUser] = useState({})
    const id = localStorage.getItem("userId")
    
    useEffect(() => {
        axios.get(`http://localhost:8080/auth/user/${id}`)
            .then(res => setUser(res.data))
    }, [])
    return (
        <div>
            <h2>Profile</h2>
            <p>Name: {user.name}</p>
            <p>Email: {user.email}</p>
        </div>
    )
}
export default Profile