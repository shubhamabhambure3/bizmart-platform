package bizmart.backend.company.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bizmart.backend.company.dto.CompanyRequest;
import bizmart.backend.company.dto.CompanyResponse;

@SpringBootTest
class CompanyServiceTest {

	@Autowired
	private CompanyService companyService;

	@Test
	void shouldCreateCompany() {

		CompanyRequest request =
				new CompanyRequest();

		request.setCompanyName(
				"JUnit Test Company");

		request.setIndustry(
				"IT Services");

		request.setDescription(
				"Created from JUnit Test");

		request.setFoundedYear(
				2024);

		request.setEmployeeCount(
				10);

		request.setLocation(
				"Pune");

		request.setOwnerId(
				1L);

		CompanyResponse response =
				companyService.createCompany(
						request);

		assertNotNull(
				response);

		assertNotNull(
				response.getId());
	}
}