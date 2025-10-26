package org.josh.climber.config;

import jakarta.annotation.PostConstruct;
import org.josh.climber.model.UserModel;
import org.josh.climber.model.SessionModel;
import org.josh.climber.repository.UserRepository;
import org.josh.climber.repository.SessionRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader {

    private final UserRepository userRepo;
    private final SessionRepository sessionRepo;

    public DataLoader(UserRepository userRepo, SessionRepository sessionRepo) {
        this.userRepo = userRepo;
        this.sessionRepo = sessionRepo;
    }

    @PostConstruct
    public void seedData() {
        if (userRepo.count() == 0) {
            List<UserModel> users = createDummyUsers();
            userRepo.saveAll(users);

            List<SessionModel> sessions = createDummySessions(users);
            sessionRepo.saveAll(sessions);

            System.out.println("Dummy users and sessions inserted successfully!");
        } else {
            System.out.println("Dummy data already present — skipping seeding.");
        }
    }

    private List<UserModel> createDummyUsers() {
        UserModel user1 = UserModel.builder()
                .username("josh_m")
                .email("josh@example.com")
                .avatarUrl("https://example.com/avatars/josh.png")
                .bio("Climber based in Edinburgh. Currently improving endurance and technique.")
                .createdAt(LocalDateTime.of(2025, 10, 25, 14, 0))
                .build();

        UserModel user2 = UserModel.builder()
                .username("climb_amy")
                .email("amy@example.com")
                .avatarUrl("https://example.com/avatars/amy.png")
                .bio("Indoor bouldering enthusiast. Training for Font trip!")
                .createdAt(LocalDateTime.of(2025, 10, 25, 15, 0))
                .build();

        UserModel user3 = UserModel.builder()
                .username("alex_rocks")
                .email("alex@example.com")
                .avatarUrl("https://example.com/avatars/alex.png")
                .bio("Lead climbing specialist. Loves multi-pitch routes and coffee.")
                .createdAt(LocalDateTime.of(2025, 10, 25, 16, 30))
                .build();

        return List.of(user1, user2, user3);
    }

    private List<SessionModel> createDummySessions(List<UserModel> users) {
        SessionModel session1 = SessionModel.builder()
                .user(users.get(0))
                .sessionDate(LocalDateTime.of(2025, 10, 25, 16, 0))
                .durationMinutes(120)
                .notes("Worked on overhang problems and endurance. Good progress on V5.")
                .createdAt(LocalDateTime.of(2025, 10, 25, 18, 0))
                .build();

        SessionModel session2 = SessionModel.builder()
                .user(users.get(1))
                .sessionDate(LocalDateTime.of(2025, 10, 26, 10, 0))
                .durationMinutes(90)
                .notes("Focused on slab balance and precise footwork. Completed two V3s.")
                .createdAt(LocalDateTime.of(2025, 10, 26, 12, 0))
                .build();

        SessionModel session3 = SessionModel.builder()
                .user(users.get(2))
                .sessionDate(LocalDateTime.of(2025, 10, 27, 17, 30))
                .durationMinutes(150)
                .notes("Lead practice on endurance routes. Tried a 7a+ twice.")
                .createdAt(LocalDateTime.of(2025, 10, 27, 20, 0))
                .build();

        return List.of(session1, session2, session3);
    }
}
