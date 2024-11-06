package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(Users user){
        usersRepository.save(user);
        return user;
    }

    public String verifyUser(Users user) {

        System.out.println("Fullname");
        System.out.println(user.getFullname());
        System.out.println("Password");
        System.out.println(user.getPassword());
        Optional<Users> verifyUser = usersRepository.findUserByPassword("irfan", "1234");
        Users verifiedUser = usersRepository.findUserByPassword(user.getFullname(), user.getPassword()).orElseThrow(() -> new IllegalStateException("Username and Password mismatch"));
        return verifiedUser.getToken();
    }

    public UsersDTO getUsersCarts(Users user) {

        Users users = usersRepository.findById(47L).orElseThrow(() -> new IllegalStateException("Username and Password mismatch"));

        UsersDTO usersDTO = UsersMapper.usersToUsersDTO(users);

        return usersDTO;
    }
}
