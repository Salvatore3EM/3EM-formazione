package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.User;
import quiz_project.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void editUserById(Long id, User NewUser) {
        User OldUser = userRepository.findById(id).orElse(null);
        if(OldUser != null)
        {
            OldUser.setName(NewUser.getName());
            OldUser.setLastname(NewUser.getLastname());
            OldUser.setEmail(NewUser.getEmail());
            OldUser.setPassword(NewUser.getPassword());
            userRepository.save(OldUser);
        }
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}