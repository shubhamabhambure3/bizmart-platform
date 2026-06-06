package bizmart.backend.interest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bizmart.backend.interest.dto.InterestRequest;
import bizmart.backend.interest.dto.InterestResponse;
import bizmart.backend.interest.entity.Interest;
import bizmart.backend.interest.repository.InterestRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InterestService {

	private final InterestRepository interestRepository;

	public InterestResponse createInterest(
			InterestRequest request) {

		Interest interest =
				Interest.builder()
						.buyerProfileId(
								request.getBuyerProfileId())
						.listingId(
								request.getListingId())
						.message(
								request.getMessage())
						.status(
								request.getStatus())
						.createdAt(
								LocalDateTime.now())
						.build();

		Interest savedInterest =
				interestRepository.save(
						interest);

		return mapToResponse(
				savedInterest);
	}

	public List<InterestResponse> getAllInterests() {

		List<Interest> interests =
				interestRepository.findAll();

		List<InterestResponse> responses =
				new ArrayList<InterestResponse>();

		for (Interest interest : interests) {
			responses.add(
					mapToResponse(
							interest));
		}

		return responses;
	}

	public InterestResponse getInterestById(
			Long id) {

		Optional<Interest> optionalInterest =
				interestRepository.findById(id);

		if (optionalInterest.isEmpty()) {
			throw new RuntimeException(
					"Interest not found");
		}

		return mapToResponse(
				optionalInterest.get());
	}

	public List<InterestResponse> getInterestsByBuyerProfileId(
			Long buyerProfileId) {

		List<Interest> interests =
				interestRepository.findByBuyerProfileId(
						buyerProfileId);

		List<InterestResponse> responses =
				new ArrayList<InterestResponse>();

		for (Interest interest : interests) {
			responses.add(
					mapToResponse(
							interest));
		}

		return responses;
	}

	public List<InterestResponse> getInterestsByListingId(
			Long listingId) {

		List<Interest> interests =
				interestRepository.findByListingId(
						listingId);

		List<InterestResponse> responses =
				new ArrayList<InterestResponse>();

		for (Interest interest : interests) {
			responses.add(
					mapToResponse(
							interest));
		}

		return responses;
	}

	public InterestResponse updateInterest(
			Long id,
			InterestRequest request) {

		Optional<Interest> optionalInterest =
				interestRepository.findById(id);

		if (optionalInterest.isEmpty()) {
			throw new RuntimeException(
					"Interest not found");
		}

		Interest interest =
				optionalInterest.get();

		interest.setBuyerProfileId(
				request.getBuyerProfileId());

		interest.setListingId(
				request.getListingId());

		interest.setMessage(
				request.getMessage());

		interest.setStatus(
				request.getStatus());

		Interest updatedInterest =
				interestRepository.save(
						interest);

		return mapToResponse(
				updatedInterest);
	}

	public void deleteInterest(
			Long id) {

		Optional<Interest> optionalInterest =
				interestRepository.findById(id);

		if (optionalInterest.isEmpty()) {
			throw new RuntimeException(
					"Interest not found");
		}

		interestRepository.deleteById(
				id);
	}

	private InterestResponse mapToResponse(
			Interest interest) {

		return InterestResponse.builder()
				.id(
						interest.getId())
				.buyerProfileId(
						interest.getBuyerProfileId())
				.listingId(
						interest.getListingId())
				.message(
						interest.getMessage())
				.status(
						interest.getStatus())
				.createdAt(
						interest.getCreatedAt())
				.build();
	}
}