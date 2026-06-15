import { useNavigate } from 'react-router-dom'
import { logout } from '../services/authService'
import logo from '../assets/bizmart-logo.png'

function Navbar() {
  const navigate = useNavigate()

  const handleLogout = () => {
    logout()
    navigate('/login')
  }

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">

        <div className="navbar-brand d-flex align-items-center">
          <img
            src={logo}
            alt="BizMart"
            width="40"
            height="40"
            className="me-2"
          />
          <span>BizMart</span>
        </div>

        <div className="d-flex align-items-center">
          <button
            className="btn btn-link text-white text-decoration-none me-3"
            onClick={() => navigate('/dashboard')}
          >
            Dashboard
          </button>
          <button
            className="btn btn-link text-white text-decoration-none me-3"
            onClick={() => navigate('/companies')}
          >
            Companies
          </button>
        </div>
        <button
          className="btn btn-link text-white text-decoration-none me-3"
          onClick={() => navigate('/financials')}
        >
          Financials
        </button>
        <button
          className="btn btn-link text-white text-decoration-none me-3"
          onClick={() =>
            navigate('/valuations')
          }
        >
          Valuations
        </button>

        <button
          className="btn btn-link text-white text-decoration-none me-3"
          onClick={() => navigate('/listings')}
        >
          Listings
        </button>

        <button
          className="btn btn-link text-white text-decoration-none me-3"
          onClick={() => navigate('/buyers')}
        >
          Buyer Profile
        </button>

        <button
          className="btn btn-link text-white text-decoration-none me-3"
          onClick={() =>
            navigate('/interests')
          }
        >
          Interests
        </button>

        <button
          className="btn btn-outline-light"
          onClick={handleLogout}
        >
          Logout
        </button>

      </div>
    </nav>
  )
}

export default Navbar