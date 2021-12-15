package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.Greeting;

public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
}
