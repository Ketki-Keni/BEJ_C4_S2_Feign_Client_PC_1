/*
 * Author : Ketki Keni
 * Date : 13-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.bej.service;

import com.bej.domain.User;
import com.bej.exception.UserAlreadyExistsException;
import com.bej.exception.UserNotFoundException;
import com.bej.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
//        if(userRepository.findById(user.getUserId()).isPresent())
//        {
//            throw new UserAlreadyExistsException();
//        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public User findByUserIdAndPassword(int userId, String password) throws UserNotFoundException {
        System.out.println("userId: "+userId);
        System.out.println("password: "+password);
        User loggedInUser = userRepository.findByUserIdAndPassword(userId,password);
        System.out.println(loggedInUser);
        if(loggedInUser == null)
        {
            throw new UserNotFoundException();
        }
        return loggedInUser;
    }
}
