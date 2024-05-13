package br.com.univillecalendar.service;

import br.com.univillecalendar.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private String NULL_ERROR_MESSAGE = "Some value is null";

    //filed injection > @Autowired
    public UserService(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

//    public UserDto createUser(User user) throws JsonProcessingException {
//
//        log.info("Creating user: {}", this.objectMapper.writeValueAsString(user));
//
//        if(user.getFirstName() == null || user.getLastName() == null) {
//            log.error("UserService.createUser() -> user {}", this.objectMapper.writeValueAsString(user));
//            throw new GenericException(NULL_ERROR_MESSAGE);
//        }
//
//
//
//        return null;
//    }
//
//    public void saveUser(User user) {
//        log.info("UserService.saveUser() -> init process, userId {}", user.getUserId());
//
//        this.userRepository.save(user);
//
//        log.info("UserService.saveUser() -> finish process, userId {}", user.getUserId());
//    }
}
