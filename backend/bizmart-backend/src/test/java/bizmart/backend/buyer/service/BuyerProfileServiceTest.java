package bizmart.backend.buyer.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bizmart.backend.buyer.dto.BuyerProfileRequest;
import bizmart.backend.buyer.dto.BuyerProfileResponse;

@SpringBootTest
class BuyerProfileServiceTest {

	@Autowired
	private BuyerProfileService buyerProfileService;

	@Test
	void shouldCreateBuyerProfile() {

		BuyerProfileRequest request =
				new BuyerProfileRequest();

		request.setUserId(1L);

		request.setInvestmentBudget(
				BigDecimal.valueOf(50000000));

		request.setPreferredIndustry(
				"IT Services");

		request.setLocation(
				"Pune");

		BuyerProfileResponse response =
				buyerProfileService.createBuyerProfile(
						request);

		assertNotNull(response);

		assertNotNull(response.getId());
	}
}