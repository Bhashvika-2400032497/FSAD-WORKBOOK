import { useState } from "react"
import axios from "axios"
import { useNavigate } from "react-router-dom"
function Login() {
    const navigate = useNavigate()
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const submit = (e) => {
        e.preventDefault()
        axios.post("http://localhost:8080/auth/login", {
            email, password
        }).then(res => {
            if (res.data) {
                localStorage.setItem("userId", res.data.id)
                navigate("/home")
            } else {
                alert("Invalid Login")
            }
        })
    }
    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={submit}>
                <input placeholder="Email" onChange={(e) => setEmail(e.target.value)} />
                <input type="password"  placeholder="Password"  onChange={(e) => setPassword(e.target.value)} />
                <button>Login</button>
            </form>
        </div>
    )
}
export default Login