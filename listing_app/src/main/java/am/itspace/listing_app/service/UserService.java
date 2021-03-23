package am.itspace.listing_app.service;

import am.itspace.listing_app.exception.UserNotFoundException;
import am.itspace.listing_app.model.User;
import am.itspace.listing_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id){
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User update(User user, int id){
        User userFromDb = userRepository.findById(id).orElseThrow( () ->new ResolutionException ("User does not exists"));
        userFromDb.setName(user.getName());
        userFromDb.setSurname(user.getSurname());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setPassword(user.getPassword());
        userFromDb.setRole(user.getRole());
        return userRepository.save(userFromDb);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }




}
