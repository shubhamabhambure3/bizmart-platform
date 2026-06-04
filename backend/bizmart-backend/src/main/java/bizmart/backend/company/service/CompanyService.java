package bizmart.backend.company.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bizmart.backend.company.dto.CompanyRequest;
import bizmart.backend.company.dto.CompanyResponse;
import bizmart.backend.company.entity.Company;
import bizmart.backend.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyRepository companyRepository;

	public CompanyResponse createCompany(CompanyRequest request) {

		Company company = Company.builder().companyName(request.getCompanyName()).industry(request.getIndustry())
				.description(request.getDescription()).foundedYear(request.getFoundedYear())
				.employeeCount(request.getEmployeeCount()).location(request.getLocation()).ownerId(request.getOwnerId())
				.createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();

		Company savedCompany = companyRepository.save(company);

		return mapToResponse(savedCompany);
	}

	public List<CompanyResponse> getAllCompanies() {

		List<Company> companies = companyRepository.findAll();
		List<CompanyResponse> responses = new ArrayList<CompanyResponse>();

		for (Company company : companies) {
			responses.add(mapToResponse(company));
		}

		return responses;
	}

	public CompanyResponse getCompanyById(Long id) {

	    Optional<Company> optionalCompany = companyRepository.findById(id);

	    if (optionalCompany.isEmpty()) {
	        throw new RuntimeException("Company not found");
	    }

	    Company company = optionalCompany.get();

	    return mapToResponse(company);
	}
	
	public CompanyResponse updateCompany(
	        Long id,
	        CompanyRequest request) {

	    Optional<Company> optionalCompany =
	            companyRepository.findById(id);

	    if (optionalCompany.isEmpty()) {
	        throw new RuntimeException("Company not found");
	    }

	    Company company =
	            optionalCompany.get();

	    company.setCompanyName(
	            request.getCompanyName());

	    company.setIndustry(
	            request.getIndustry());

	    company.setDescription(
	            request.getDescription());

	    company.setFoundedYear(
	            request.getFoundedYear());

	    company.setEmployeeCount(
	            request.getEmployeeCount());

	    company.setLocation(
	            request.getLocation());

	    company.setOwnerId(
	            request.getOwnerId());

	    company.setUpdatedAt(
	            LocalDateTime.now());

	    Company updatedCompany =
	            companyRepository.save(company);

	    return mapToResponse(updatedCompany);
	}
	
	public void deleteCompany(Long id) {

		Optional<Company> optionalCompany =
				companyRepository.findById(id);

		if (optionalCompany.isEmpty()) {
			throw new RuntimeException("Company not found");
		}

		companyRepository.deleteById(id);
	}

	private CompanyResponse mapToResponse(Company company) {

		return CompanyResponse.builder().id(company.getId()).companyName(company.getCompanyName())
				.industry(company.getIndustry()).description(company.getDescription())
				.foundedYear(company.getFoundedYear()).employeeCount(company.getEmployeeCount())
				.location(company.getLocation()).ownerId(company.getOwnerId()).createdAt(company.getCreatedAt())
				.updatedAt(company.getUpdatedAt()).build();
	}
	
	public List<CompanyResponse> getCompaniesByOwnerId(
			Long ownerId) {

		List<Company> companies =
				companyRepository.findByOwnerId(ownerId);

		List<CompanyResponse> responses =
				new ArrayList<CompanyResponse>();

		for (Company company : companies) {
			responses.add(
					mapToResponse(company));
		}

		return responses;
	}
}