package az.edu.itbrains.services.impls;

import az.edu.itbrains.dtos.UserDtos.UserRegisterDto;
import az.edu.itbrains.models.UserEntity;
import az.edu.itbrains.repositories.UserRepository;
import az.edu.itbrains.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        UserEntity user = userRepository.findByEmail(userRegisterDto.getEmail());
        if (user != null)
        {
            throw new UsernameNotFoundException("Istifadeci tapilmadi");
        }
        UserEntity newUser = modelMapper.map(userRegisterDto, UserEntity.class);
        newUser.setPassword(encoder.encode(userRegisterDto.getPassword()));
        userRepository.save(newUser);
    }

    @Override
    public UserEntity findByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        return user;
    }
}
