package bizmart.backend.buyer.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bizmart.backend.buyer.dto.BuyerProfileRequest;
import bizmart.backend.buyer.dto.BuyerProfileResponse;
import bizmart.backend.buyer.entity.BuyerProfile;
import bizmart.backend.buyer.repository.BuyerProfileRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuyerProfileService {

	private final BuyerProfileRepository buyerProfileRepository;

	public BuyerProfileResponse createBuyerProfile(
			BuyerProfileRequest request) {

		BuyerProfile buyerProfile =
				BuyerProfile.builder()
						.userId(
								request.getUserId())
						.investmentBudget(
								request.getInvestmentBudget())
						.preferredIndustry(
								request.getPreferredIndustry())
						.location(
								request.getLocation())
						.createdAt(
								LocalDateTime.now())
						.updatedAt(
								LocalDateTime.now())
						.build();

		BuyerProfile savedBuyerProfile =
				buyerProfileRepository.save(
						buyerProfile);

		return mapToResponse(
				savedBuyerProfile);
	}

	public List<BuyerProfileResponse> getAllBuyerProfiles() {

		List<BuyerProfile> buyerProfiles =
				buyerProfileRepository.findAll();

		List<BuyerProfileResponse> responses =
				new ArrayList<BuyerProfileResponse>();

		for (BuyerProfile buyerProfile : buyerProfiles) {
			responses.add(
					mapToResponse(
							buyerProfile));
		}

		return responses;
	}

	public BuyerProfileResponse getBuyerProfileById(
			Long id) {

		Optional<BuyerProfile> optionalBuyerProfile =
				buyerProfileRepository.findById(id);

		if (optionalBuyerProfile.isEmpty()) {
			throw new RuntimeException(
					"Buyer profile not found");
		}

		return mapToResponse(
				optionalBuyerProfile.get());
	}

	public BuyerProfileResponse getBuyerProfileByUserId(
			Long userId) {

		Optional<BuyerProfile> optionalBuyerProfile =
				buyerProfileRepository.findByUserId(
						userId);

		if (optionalBuyerProfile.isEmpty()) {
			throw new RuntimeException(
					"Buyer profile not found");
		}

		return mapToResponse(
				optionalBuyerProfile.get());
	}

	public BuyerProfileResponse updateBuyerProfile(
			Long id,
			BuyerProfileRequest request) {

		Optional<BuyerProfile> optionalBuyerProfile =
				buyerProfileRepository.findById(id);

		if (optionalBuyerProfile.isEmpty()) {
			throw new RuntimeException(
					"Buyer profile not found");
		}

		BuyerProfile buyerProfile =
				optionalBuyerProfile.get();

		buyerProfile.setUserId(
				request.getUserId());

		buyerProfile.setInvestmentBudget(
				request.getInvestmentBudget());

		buyerProfile.setPreferredIndustry(
				request.getPreferredIndustry());

		buyerProfile.setLocation(
				request.getLocation());

		buyerProfile.setUpdatedAt(
				LocalDateTime.now());

		BuyerProfile updatedBuyerProfile =
				buyerProfileRepository.save(
						buyerProfile);

		return mapToResponse(
				updatedBuyerProfile);
	}

	public void deleteBuyerProfile(
			Long id) {

		Optional<BuyerProfile> optionalBuyerProfile =
				buyerProfileRepository.findById(id);

		if (optionalBuyerProfile.isEmpty()) {
			throw new RuntimeException(
					"Buyer profile not found");
		}

		buyerProfileRepository.deleteById(
				id);
	}

	private BuyerProfileResponse mapToResponse(
			BuyerProfile buyerProfile) {

		return BuyerProfileResponse.builder()
				.id(
						buyerProfile.getId())
				.userId(
						buyerProfile.getUserId())
				.investmentBudget(
						buyerProfile.getInvestmentBudget())
				.preferredIndustry(
						buyerProfile.getPreferredIndustry())
				.location(
						buyerProfile.getLocation())
				.createdAt(
						buyerProfile.getCreatedAt())
				.updatedAt(
						buyerProfile.getUpdatedAt())
				.build();
	}
}