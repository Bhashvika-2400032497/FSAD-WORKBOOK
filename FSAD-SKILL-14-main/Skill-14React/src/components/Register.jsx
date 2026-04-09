import { useState } from "react"
import axios from "axios"
import { useNavigate } from "react-router-dom"
function Register() {
    const navigate = useNavigate()
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const submit = (e) => {
        e.preventDefault()
        axios.post("http://localhost:8080/auth/register", {
            name, email, password }).then(() => { navigate("/login") })
         }
    return (
        <div>
            <h2>Register</h2>
            <form onSubmit={submit}>
                <input placeholder="Name" onChange={(e) => setName(e.target.value)} />
                <input placeholder="Email" onChange={(e) => setEmail(e.target.value)} />
                <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} />
                <button>Register</button>
            </form>
       </div>
    )
}
export default Register