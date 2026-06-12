import Navbar from '../components/Navbar'

function CompaniesPage() {
  return (
    <>
      <Navbar />

      <div className="container mt-4">
        <h1>Companies</h1>

        <p className="text-muted">
          Manage your business portfolio.
        </p>
      </div>
    </>
  )
}

export default CompaniesPage