package bizmart.backend.listing.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bizmart.backend.listing.dto.ListingRequest;
import bizmart.backend.listing.dto.ListingResponse;
import bizmart.backend.listing.entity.Listing;
import bizmart.backend.listing.repository.ListingRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListingService {

	private final ListingRepository listingRepository;

	public ListingResponse createListing(
			ListingRequest request) {

		Listing listing =
				Listing.builder()
						.companyId(
								request.getCompanyId())
						.valuationId(
								request.getValuationId())
						.askingPrice(
								request.getAskingPrice())
						.status(
								request.getStatus())
						.createdAt(
								LocalDateTime.now())
						.updatedAt(
								LocalDateTime.now())
						.build();

		Listing savedListing =
				listingRepository.save(
						listing);

		return mapToResponse(
				savedListing);
	}

	public List<ListingResponse> getAllListings() {

		List<Listing> listings =
				listingRepository.findAll();

		List<ListingResponse> responses =
				new ArrayList<ListingResponse>();

		for (Listing listing : listings) {
			responses.add(
					mapToResponse(listing));
		}

		return responses;
	}

	public ListingResponse getListingById(
			Long id) {

		Optional<Listing> optionalListing =
				listingRepository.findById(id);

		if (optionalListing.isEmpty()) {
			throw new RuntimeException(
					"Listing not found");
		}

		return mapToResponse(
				optionalListing.get());
	}

	public List<ListingResponse> getListingsByCompanyId(
			Long companyId) {

		List<Listing> listings =
				listingRepository.findByCompanyId(
						companyId);

		List<ListingResponse> responses =
				new ArrayList<ListingResponse>();

		for (Listing listing : listings) {
			responses.add(
					mapToResponse(listing));
		}

		return responses;
	}

	public ListingResponse updateListing(
			Long id,
			ListingRequest request) {

		Optional<Listing> optionalListing =
				listingRepository.findById(id);

		if (optionalListing.isEmpty()) {
			throw new RuntimeException(
					"Listing not found");
		}

		Listing listing =
				optionalListing.get();

		listing.setCompanyId(
				request.getCompanyId());

		listing.setValuationId(
				request.getValuationId());

		listing.setAskingPrice(
				request.getAskingPrice());

		listing.setStatus(
				request.getStatus());

		listing.setUpdatedAt(
				LocalDateTime.now());

		Listing updatedListing =
				listingRepository.save(
						listing);

		return mapToResponse(
				updatedListing);
	}

	public void deleteListing(
			Long id) {

		Optional<Listing> optionalListing =
				listingRepository.findById(id);

		if (optionalListing.isEmpty()) {
			throw new RuntimeException(
					"Listing not found");
		}

		listingRepository.deleteById(id);
	}

	private ListingResponse mapToResponse(
			Listing listing) {

		return ListingResponse.builder()
				.id(listing.getId())
				.companyId(
						listing.getCompanyId())
				.valuationId(
						listing.getValuationId())
				.askingPrice(
						listing.getAskingPrice())
				.status(
						listing.getStatus())
				.createdAt(
						listing.getCreatedAt())
				.updatedAt(
						listing.getUpdatedAt())
				.build();
	}
}