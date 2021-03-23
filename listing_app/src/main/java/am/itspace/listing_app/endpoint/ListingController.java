package am.itspace.listing_app.endpoint;

import am.itspace.listing_app.exception.ListiningNotFoundException;
import am.itspace.listing_app.exception.UserNotFoundException;
import am.itspace.listing_app.model.Category;
import am.itspace.listing_app.model.Listing;
import am.itspace.listing_app.model.User;
import am.itspace.listing_app.repository.CategoryRepository;
import am.itspace.listing_app.repository.UserRepository;
import am.itspace.listing_app.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/listings")
public class ListingController {

    private final ListingService listingService;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Listing> listings(){
        return listingService.findAll();
    }

    @GetMapping("/byUsers/{email}")
    public ResponseEntity getListingByUserEmail(@RequestBody User user, @PathVariable("email") String email){
        if (userRepository.findByEmail(user.getEmail()).equals(email)){
            listingService.findAll();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byCategory/{CategoryId}")
    public ResponseEntity getListingByCategoryId(@RequestBody Category category, @PathVariable("CategoryId") int id){
        if (categoryRepository.findById(category.getId()).equals(id)){
            listingService.findAll();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity listing(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(listingService.findById(id));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Listing listing){
        if (listing.getId() > 0){
            throw new RuntimeException("Id must be 0");
        }
        listingService.save(listing);
        return ResponseEntity.ok(listing.getId());
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody Listing listing, @PathVariable("id") int id){
        listingService.update(listing, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        try {
            listingService.findById(id);
        }catch (ListiningNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        listingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
