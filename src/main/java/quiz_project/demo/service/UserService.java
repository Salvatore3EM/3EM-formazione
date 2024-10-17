package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.User;
import quiz_project.demo.repository.UserRepository;
import quiz_project.demo.utils.BCryptPasswordEncoder;

import java.util.ArrayList;
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

    public User Register(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean Login(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User NewUser = new User();
        List<User> userList = new ArrayList<>();
        boolean result = false;
        userList = userRepository.findAll();
        NewUser.setEmail(user.getEmail());
        NewUser.setPassword(user.getPassword());
        for(int i = 0; i < userList.size(); i++)
        {
            User Verifica = new User();
            Verifica = userList.get(i);
            boolean passwordIsValid = bCryptPasswordEncoder.matches(NewUser.getPassword(), Verifica.getPassword());
            if(!NewUser.getEmail().equals(Verifica.getEmail()) || !passwordIsValid)
            {
                result = false;
            } else if (NewUser.getEmail().equals(Verifica.getEmail()) && passwordIsValid) {
                result = true;
            }
        }
        return result;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}