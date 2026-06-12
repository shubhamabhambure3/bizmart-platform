import { useNavigate } from 'react-router-dom'
import { logout } from '../services/authService'
import Navbar from '../components/Navbar'

function DashboardPage() {
  const navigate = useNavigate()

  const handleLogout = () => {
    logout()
    navigate('/login')
  }

  return (
    <>
      <Navbar />
      <div className="container mt-4">
        <h1>Dashboard</h1>

        <p className="text-muted">
          Welcome to BizMart Business Acquisition Marketplace
        </p>

        <div className="row mt-4">

          <div className="col-md-4 mb-3">
            <div className="card">
              <div className="card-body">
                <h5>Companies</h5>
                <p>Manage your companies.</p>
              </div>
            </div>
          </div>

          <div className="col-md-4 mb-3">
            <div className="card">
              <div className="card-body">
                <h5>Listings</h5>
                <p>Manage acquisition listings.</p>
              </div>
            </div>
          </div>

          <div className="col-md-4 mb-3">
            <div className="card">
              <div className="card-body">
                <h5>Buyer Matching</h5>
                <p>View buyer opportunities.</p>
              </div>
            </div>
          </div>

        </div>
      </div>
    </>
  )
}

export default DashboardPage