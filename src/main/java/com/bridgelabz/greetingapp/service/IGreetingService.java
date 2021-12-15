package com.bridgelabz.greetingapp.service;

import java.util.List;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
    User getById(long id);
    List<User> getAllGreetingMessages();
}
