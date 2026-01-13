package org.josh.climber.service;

import jakarta.validation.Valid;
import org.josh.climber.DTO.session.response.SessionDTO;
import org.josh.climber.DTO.user.response.UserDTO;
import org.josh.climber.DTO.user.response.UserPreviewDTO;
import org.josh.climber.DTOMapper.SessionDTOMapper;
import org.josh.climber.DTOMapper.UserDTOMapper;
import org.josh.climber.DTOMapper.UserPreviewDTOMapper;
import org.josh.climber.model.UserModel;
import org.josh.climber.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles all operations related to Users
 */
@Service
public class UserService {

    private final UserRepository userRepo;
    private final UserDTOMapper mapper;
    private final SessionDTOMapper sessionMapper;
    private final UserPreviewDTOMapper previewMapper;

    public UserService(UserRepository userRepo, UserDTOMapper mapper,
                       SessionDTOMapper sessionMapper,
                       UserPreviewDTOMapper previewMapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.sessionMapper = sessionMapper;
        this.previewMapper = previewMapper;
    }

    public List<UserPreviewDTO> getAllUsers(){
        return userRepo.findAll()
                .stream()
                .map(previewMapper::toDTO)
                .toList();
    }

    public UserDTO findByUsername(String username){
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
        return mapper.toDTO(user);
    }

    public UserPreviewDTO getPreviewById(Long userId) {
        UserModel user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found " + userId));
        return previewMapper.toDTO(user);
    }


    public UserPreviewDTO getPreviewByUsername(String username) {
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
        return previewMapper.toDTO(user);
    }


    public UserPreviewDTO updateBio(Long userId, String bio){
        UserModel existing = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        existing.setBio(bio);
        UserModel updated = userRepo.save(existing);
        return previewMapper.toDTO(updated);
    }

    public UserPreviewDTO updateAvatar(Long userId, String avatarUrl) {
        UserModel existing = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        existing.setAvatarUrl(avatarUrl);
        UserModel updated = userRepo.save(existing);
        return previewMapper.toDTO(updated);
    }

    public UserDTO updateUser(Long userId, @Valid UserDTO user) {
        UserModel existing = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        existing.setUsername(user.username());
        existing.setEmail(user.email());
        existing.setAvatarUrl(user.avatarUrl());
        existing.setBio(user.bio());

        UserModel updated = userRepo.save(existing);
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