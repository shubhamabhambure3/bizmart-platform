import { useEffect, useState } from 'react'
import Navbar from '../components/Navbar'

import {
  generateValuation,
  getValuationByCompanyId
} from '../services/valuationService'

import {
  getAllCompanies
} from '../services/companyService'

function ValuationPage() {

  const [companies, setCompanies] =
    useState([])

  const [companyId, setCompanyId] =
    useState('')

  const [valuation, setValuation] =
    useState(null)

  const [success, setSuccess] =
    useState('')

  const [error, setError] =
    useState('')

  useEffect(() => {

    const loadCompanies =
      async () => {

        try {

          const data =
            await getAllCompanies()

          setCompanies(data)

        } catch (err) {
          console.error(err)
        }
      }

    loadCompanies()

  }, [])

  const handleGenerate =
    async () => {

      try {

        const result =
          await generateValuation(
            Number(companyId)
          )

        setValuation(result)

        setSuccess(
          'Valuation generated successfully'
        )

        setError('')

      } catch (err) {

        setSuccess('')

        setError(
          err.response?.data?.message ||
          'Valuation generation failed'
        )
      }
    }

  const handleView =
    async () => {

      try {

        const result =
          await getValuationByCompanyId(
            Number(companyId)
          )

        setValuation(result)

        setError('')

      } catch (err) {

        setError(
          err.response?.data?.message ||
          'Valuation not found'
        )
      }
    }

  return (
    <>
      <Navbar />

      <div className="container mt-4">

        <h1>Valuations</h1>

        {success &&
          <div className="alert alert-success">
            {success}
          </div>
        }

        {error &&
          <div className="alert alert-danger">
            {error}
          </div>
        }

        <div className="card shadow-sm">

          <div className="card-body">

            <div className="mb-3">

              <label className="form-label">
                Company
              </label>

              <select
                className="form-select"
                value={companyId}
                onChange={(e) =>
                  setCompanyId(
                    e.target.value
                  )
                }
              >

                <option value="">
                  Select Company
                </option>

                {companies.map(company => (

                  <option
                    key={company.id}
                    value={company.id}
                  >
                    {company.companyName}
                  </option>

                ))}

              </select>

            </div>

            <button
              className="btn btn-primary me-2"
              onClick={handleGenerate}
            >
              Generate Valuation
            </button>

            <button
              className="btn btn-secondary"
              onClick={handleView}
            >
              View Valuation
            </button>

          </div>

        </div>

        {valuation && (

          <div className="card mt-4 shadow-sm">

            <div className="card-header">
              Valuation Result
            </div>

            <div className="card-body">

              <table className="table">

                <tbody>

                  <tr>
                    <th>ID</th>
                    <td>{valuation.id}</td>
                  </tr>

                  <tr>
                    <th>Company ID</th>
                    <td>{valuation.companyId}</td>
                  </tr>

                  <tr>
                    <th>Asset Based Value</th>
                    <td>
                      {valuation.assetBasedValue}
                    </td>
                  </tr>

                  <tr>
                    <th>Revenue Based Value</th>
                    <td>
                      {valuation.revenueBasedValue}
                    </td>
                  </tr>

                  <tr>
                    <th>EBITDA Based Value</th>
                    <td>
                      {valuation.ebitdaBasedValue}
                    </td>
                  </tr>

                </tbody>

              </table>

            </div>

          </div>

        )}

      </div>
    </>
  )
}

export default ValuationPage