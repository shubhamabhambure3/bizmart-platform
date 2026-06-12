import axiosClient from '../api/axiosClient'

export const getAllCompanies = async () => {
  const response = await axiosClient.get('/api/companies')
  return response.data
}

export const createCompany = async (companyRequest) => {
  const response = await axiosClient.post(
    '/api/companies',
    companyRequest
  )

  return response.data
}