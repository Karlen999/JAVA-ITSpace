package am.itspace.listing_app.repository;


import am.itspace.listing_app.model.Listing;
import am.itspace.listing_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing, Integer> {

}
