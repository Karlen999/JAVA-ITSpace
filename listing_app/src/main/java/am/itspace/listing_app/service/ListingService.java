package am.itspace.listing_app.service;

import am.itspace.listing_app.exception.ListiningNotFoundException;
import am.itspace.listing_app.exception.UserNotFoundException;
import am.itspace.listing_app.model.Listing;
import am.itspace.listing_app.model.User;
import am.itspace.listing_app.repository.ListingRepository;
import am.itspace.listing_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ListingRepository listingRepository;

    public List<Listing> findAll(){
        return listingRepository.findAll();
    }

    public Listing findById(int id){
        return listingRepository.findById(id).orElseThrow(ListiningNotFoundException::new);
    }

    public void save(Listing listing){
        listingRepository.save(listing);
    }

    public Listing update(Listing listing, int id){
        Listing listingFromDb = listingRepository.findById(id).orElseThrow( () ->new ResolutionException("Listing does not exists"));
        listingFromDb.setTitle(listing.getTitle());
        listingFromDb.setDescription(listing.getDescription());
        listingFromDb.setPrice(listing.getPrice());
        listingFromDb.setCategory(listing.getCategory());
        listingFromDb.setUser(listing.getUser());
        return listingRepository.save(listingFromDb);
    }

    public void deleteById(int id){
        listingRepository.deleteById(id);
    }
}
