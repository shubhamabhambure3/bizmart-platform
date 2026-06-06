package bizmart.backend.interest.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bizmart.backend.interest.dto.InterestRequest;
import bizmart.backend.interest.dto.InterestResponse;
import bizmart.backend.interest.entity.InterestStatus;

@SpringBootTest
class InterestServiceTest {

	@Autowired
	private InterestService interestService;

	@Test
	void shouldCreateInterest() {

		InterestRequest request =
				new InterestRequest();

		request.setBuyerProfileId(1L);

		request.setListingId(1L);

		request.setMessage(
				"Interested in acquisition discussion");

		request.setStatus(
				InterestStatus.PENDING);

		InterestResponse response =
				interestService.createInterest(
						request);

		assertNotNull(response);

		assertNotNull(response.getId());
	}
}