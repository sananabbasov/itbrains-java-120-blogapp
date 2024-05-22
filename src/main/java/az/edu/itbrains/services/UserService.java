package az.edu.itbrains.services;

import az.edu.itbrains.dtos.UserDtos.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);
}
