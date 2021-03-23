package am.itspace.listing_app.endpoint;

import am.itspace.listing_app.exception.UserNotFoundException;
import am.itspace.listing_app.model.User;
import am.itspace.listing_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> users(){
       return userService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity user(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody User user){
        if (user.getId() > 0){
            throw new RuntimeException("Id must be 0");
        }
        userService.save(user);
        return ResponseEntity.ok(user.getId());
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody User user, @PathVariable("id") int id){
        userService.update(user, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        try {
            userService.findById(id);
        }catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
