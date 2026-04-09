import { useNavigate } from "react-router-dom"

function Home() {
    const navigate = useNavigate()
    const logout = () => {
        localStorage.removeItem("userId")
        navigate("/login")
    }
    return (
        <div>
              <h1>Home Page</h1>
            <button onClick={() => navigate("/profile")}>  Profile </button>
            <button onClick={logout}> Logout </button>
        </div>
    )
}
export default Home