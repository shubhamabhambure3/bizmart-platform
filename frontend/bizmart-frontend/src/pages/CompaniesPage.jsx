import { useState, useEffect } from 'react'
import Navbar from '../components/Navbar'
import {
  createCompany,
  getAllCompanies
} from '../services/companyService'

function CompaniesPage() {

  const [companyName, setCompanyName] = useState('')
  const [industry, setIndustry] = useState('')
  const [description, setDescription] = useState('')
  const [foundedYear, setFoundedYear] = useState('')
  const [employeeCount, setEmployeeCount] = useState('')
  const [location, setLocation] = useState('')
  const [success, setSuccess] = useState('')
  const [error, setError] = useState('')
  const [companies, setCompanies] = useState([])

  const handleCreateCompany = async () => {
    try {
      await createCompany({
        companyName,
        industry,
        description,
        foundedYear: Number(foundedYear),
        employeeCount: Number(employeeCount),
        location
      })

      setSuccess('Company created successfully')
      setError('')

    } catch (err) {
      setError('Company creation failed')
      setSuccess('')
    }
  }

  const loadCompanies = async () => {
    try {
      const data = await getAllCompanies()
      setCompanies(data)
    } catch (err) {
      console.error(err)
    }
  }

  useEffect(() => {
    loadCompanies()
  }, [])

  return (
    <>
      <Navbar />

      <div className="container mt-4">
        <h1>Companies</h1>

        <p className="text-muted">
          Manage your business portfolio.
        </p>

        <div className="card mt-4">
          <div className="card-body">

            <h5>Create Company</h5>

            {error && (
              <div className="alert alert-danger">
                {error}
              </div>
            )}

            {success && (
              <div className="alert alert-success">
                {success}
              </div>
            )}

            <div className="mb-3">
              <label className="form-label">
                Company Name
              </label>

              <input
                type="text"
                className="form-control"
                value={companyName}
                onChange={(e) =>
                  setCompanyName(e.target.value)
                }
              />
            </div>

            <div className="mb-3">
              <label className="form-label">
                Industry
              </label>

              <input
                type="text"
                className="form-control"
                value={industry}
                onChange={(e) =>
                  setIndustry(e.target.value)
                }
              />

              <div className="mb-3">
                <label className="form-label">
                  Description
                </label>

                <textarea
                  className="form-control"
                  rows="3"
                  value={description}
                  onChange={(e) =>
                    setDescription(e.target.value)
                  }
                />
              </div>

              <div className="mb-3">
                <label className="form-label">
                  Founded Year
                </label>

                <input
                  type="number"
                  className="form-control"
                  value={foundedYear}
                  onChange={(e) =>
                    setFoundedYear(e.target.value)
                  }
                />
              </div>

              <div className="mb-3">
                <label className="form-label">
                  Employee Count
                </label>

                <input
                  type="number"
                  className="form-control"
                  value={employeeCount}
                  onChange={(e) =>
                    setEmployeeCount(e.target.value)
                  }
                />
              </div>

              <div className="mb-3">
                <label className="form-label">
                  Location
                </label>

                <input
                  type="text"
                  className="form-control"
                  value={location}
                  onChange={(e) =>
                    setLocation(e.target.value)
                  }
                />

              </div>
              <button
                type="button"
                className="btn btn-primary"
                onClick={handleCreateCompany}
              >
                Create Company
              </button>
              <div className="card mt-4">
                <div className="card-body">

                  <h5>Companies</h5>

                  {companies.length === 0 ? (
                    <p className="text-muted">
                      No companies found.
                    </p>
                  ) : (
                    <ul className="list-group">

                      {companies.map((company) => (
                        <li
                          key={company.id}
                          className="list-group-item"
                        >
                          <strong>{company.companyName}</strong>
                          <br />
                          {company.industry}
                        </li>
                      ))}

                    </ul>
                  )}

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default CompaniesPage