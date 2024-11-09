package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(Users user) throws Exception{

        if(usersRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalStateException("Email already exist");
        }
        user.setFullname(user.getFirstName()+" "+user.getLastName());
        usersRepository.save(user);
        return user;
    }

    public UsersDTO verifyUser(Users user) {

        System.out.println("Fullname");
        System.out.println(user.getEmail());
        System.out.println("Password");
        System.out.println(user.getPassword());
        Users verifiedUser = usersRepository.findUserByPassword(user.getEmail(), user.getPassword()).orElseThrow(() -> new IllegalStateException("Username and Password mismatch"));
        return new UsersDTO(verifiedUser);
    }

    public UsersDTO getUsersCarts(Users user) {

        Users users = usersRepository.findCartsById(user.getId()).orElseThrow(() -> new IllegalStateException("Username and Password mismatch"));

        UsersDTO usersDTO = UsersMapper.usersToUsersDTO(users);

        return usersDTO;
    }

    @Transactional
    public UsersDTO updateUser(Users users){

        users.setFullname(users.getFirstName() + " " + users.getLastName());

        usersRepository.save(users);
        UsersDTO usersDTO = new UsersDTO(users);

        return usersDTO;
    }
}
