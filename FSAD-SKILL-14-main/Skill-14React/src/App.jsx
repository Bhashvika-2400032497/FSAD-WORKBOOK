import { BrowserRouter, Routes, Route } from "react-router-dom"

import Register from "./components/Register"
import Login from "./components/Login"
import Home from "./components/Home"
import Profile from "./components/Profile"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/profile" element={<Profile />} />
      </Routes>
    </BrowserRouter>
  )
}
export default App