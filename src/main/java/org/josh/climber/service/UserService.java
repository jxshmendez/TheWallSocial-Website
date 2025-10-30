package org.josh.climber.service;

import jakarta.validation.Valid;
import org.apache.catalina.Session;
import org.apache.catalina.User;
import org.josh.climber.DTO.SessionDTO;
import org.josh.climber.DTO.UserDTO;
import org.josh.climber.DTOMapper.SessionDTOMapper;
import org.josh.climber.DTOMapper.UserDTOMapper;
import org.josh.climber.model.UserModel;
import org.josh.climber.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final UserDTOMapper mapper;
    private final SessionDTOMapper sessionMapper;

    public UserService(UserRepository userRepo, UserDTOMapper mapper, SessionDTOMapper sessionMapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.sessionMapper = sessionMapper;
    }

    public List<UserDTO> getAllUsers(){
        return userRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public UserDTO findByUsername(String username){
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
        return mapper.toDTO(user);
    }

    public UserDTO createUser(UserDTO dto){
        UserModel user = mapper.toEntity(dto);
        UserModel saved = userRepo.save(user);
        return mapper.toDTO(saved);
    }

    public UserDTO updateUser(Long userId, @Valid UserDTO user) {
        UserModel exisiting = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        exisiting.setUsername(user.username());
        exisiting.setEmail(user.email());
        exisiting.setAvatarUrl(user.avatarUrl());
        exisiting.setBio(user.bio());

        UserModel updated = userRepo.save(exisiting);
        return mapper.toDTO(updated);
    }

    public void deleteUser(Long userId) {
        if(!userRepo.existsById(userId)){
            throw new RuntimeException("User not found: " + userId);
        }

        userRepo.deleteById(userId);
    }

    public List<SessionDTO> getSessionByUser(String username){
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found " + username));

        return user.getSessions()
                .stream()
                .map(sessionMapper::toDTO)
                .toList();
    }
}