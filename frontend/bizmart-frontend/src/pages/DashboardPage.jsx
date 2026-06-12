import { useNavigate } from 'react-router-dom'
import { logout } from '../services/authService'

function DashboardPage() {
  const navigate = useNavigate()

  const handleLogout = () => {
    logout()
    navigate('/login')
  }

  return (
    <div style={{ padding: '20px' }}>
      <h1>Dashboard</h1>

      <p>Welcome to BizMart</p>

      <button
        onClick={handleLogout}
      >
        Logout
      </button>
    </div>
  )
}

export default DashboardPage