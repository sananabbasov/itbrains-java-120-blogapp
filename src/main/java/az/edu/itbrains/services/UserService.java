package az.edu.itbrains.services;

import az.edu.itbrains.dtos.UserDtos.UserRegisterDto;
import az.edu.itbrains.models.UserEntity;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);
    UserEntity findByEmail(String email);

}
