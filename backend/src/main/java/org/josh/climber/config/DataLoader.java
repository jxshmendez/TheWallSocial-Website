package org.josh.climber.config;

import jakarta.annotation.PostConstruct;
import org.josh.climber.model.*;
import org.josh.climber.repository.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader {

    private final UserRepository userRepo;
    private final GymRepository gymRepo;
    private final RouteRepository routeRepo;
    private final SessionRepository sessionRepo;
    private final AttemptRepository attemptRepo;

    public DataLoader(UserRepository userRepo,
                      GymRepository gymRepo,
                      RouteRepository routeRepo,
                      SessionRepository sessionRepo,
                      AttemptRepository attemptRepo) {
        this.userRepo = userRepo;
        this.gymRepo = gymRepo;
        this.routeRepo = routeRepo;
        this.sessionRepo = sessionRepo;
        this.attemptRepo = attemptRepo;
    }

    @PostConstruct
    public void seedData() {
        if (userRepo.count() == 0) {
            List<UserModel> users = createDummyUsers();
            userRepo.saveAll(users);

            List<GymModel> gyms = createDummyGyms();
            gymRepo.saveAll(gyms);

            List<RouteModel> routes = createDummyRoutes(gyms);
            routeRepo.saveAll(routes);

            List<SessionModel> sessions = createDummySessions(users, gyms);
            sessionRepo.saveAll(sessions);

            List<AttemptModel> attempts = createDummyAttempts(users, sessions, routes);
            attemptRepo.saveAll(attempts);

            System.out.println("Dummy users, gyms, routes, sessions, and attempts inserted successfully!");
        } else {
            System.out.println("Dummy data already present — skipping seeding.");
        }
    }

    private List<UserModel> createDummyUsers() {
        UserModel user1 = UserModel.builder()
                .username("josh_m")
                .email("josh@example.com")
                .password("Hello12")
                .bio("Climber based in Edinburgh. Working on endurance and technique.")
                .createdAt(LocalDateTime.of(2025, 10, 25, 14, 0))
                .build();

        UserModel user2 = UserModel.builder()
                .username("climb_amy")
                .email("amy@example.com")
                .bio("Indoor bouldering addict. Training for Font trip!")
                .password("Hello123")
                .createdAt(LocalDateTime.of(2025, 10, 25, 15, 0))
                .build();

        UserModel user3 = UserModel.builder()
                .username("alex_rocks")
                .email("alex@example.com")
                .password("Hello122223")
                .bio("Lead climber. Loves multi-pitch routes and espresso shots.")
                .createdAt(LocalDateTime.of(2025, 10, 25, 16, 30))
                .build();

        return List.of(user1, user2, user3);
    }

    private List<GymModel> createDummyGyms() {
        GymModel gym1 = GymModel.builder()
                .name("BlocHaus Edinburgh")
                .location("Edinburgh, UK")
                .latitude(55.9533)
                .longitude(-3.1883)
                .build();

        GymModel gym2 = GymModel.builder()
                .name("The Climbing Hangar Glasgow")
                .location("Glasgow, UK")
                .latitude(55.8642)
                .longitude(-4.2518)
                .build();

        return List.of(gym1, gym2);
    }

    private List<RouteModel> createDummyRoutes(List<GymModel> gyms) {
        RouteModel route1 = RouteModel.builder()
                .name(null)
                .grade("V5")
                .style("Overhang")
                .setter("Sam Porter")
                .isOutdoor(false)
                .gym(gyms.get(0))
                .createdAt(LocalDateTime.of(2025, 10, 20, 10, 0))
                .build();

        RouteModel route2 = RouteModel.builder()
                .name(null)
                .grade("V3")
                .style("Slab")
                .setter("Amy Johnson")
                .isOutdoor(false)
                .gym(gyms.get(0))
                .createdAt(LocalDateTime.of(2025, 10, 21, 11, 0))
                .build();

        RouteModel route3 = RouteModel.builder()
                .name("Mountain Dream")
                .grade("6c+")
                .style("Lead")
                .setter("Alex Kerr")
                .isOutdoor(true)
                .gym(gyms.get(1))
                .createdAt(LocalDateTime.of(2025, 10, 22, 9, 0))
                .build();

        return List.of(route1, route2, route3);
    }

    private List<SessionModel> createDummySessions(List<UserModel> users, List<GymModel> gyms) {
        SessionModel session1 = SessionModel.builder()
                .user(users.get(0))
                .gym(gyms.get(0))
                .sessionDate(LocalDateTime.of(2025, 10, 25, 16, 0))
                .durationMinutes(120)
                .notes("Worked on V5 problems. Focused on heel hooks and endurance.")
                .createdAt(LocalDateTime.of(2025, 10, 25, 18, 0))
                .build();

        SessionModel session2 = SessionModel.builder()
                .user(users.get(1))
                .gym(gyms.get(1))
                .sessionDate(LocalDateTime.of(2025, 10, 26, 10, 0))
                .durationMinutes(90)
                .notes("Slab balance drills. Sent 'Balance Beam' cleanly.")
                .createdAt(LocalDateTime.of(2025, 10, 26, 12, 0))
                .build();

        SessionModel session3 = SessionModel.builder()
                .user(users.get(2))
                .gym(gyms.get(1))
                .sessionDate(LocalDateTime.of(2025, 10, 27, 17, 30))
                .durationMinutes(150)
                .notes("Lead practice with long rests. Tried 'Mountain Dream'.")
                .createdAt(LocalDateTime.of(2025, 10, 27, 20, 0))
                .build();

        return List.of(session1, session2, session3);
    }

    private List<AttemptModel> createDummyAttempts(List<UserModel> users, List<SessionModel> sessions, List<RouteModel> routes) {
        AttemptModel attempt1 = AttemptModel.builder()
                .user(users.get(0))
                .session(sessions.get(0))
                .routes(routes.get(0))
                .attemptTime(300)
                .notes("Almost sent it. Fell at top crux.")
                .result(ResultType.FAIL)
                .build();

        AttemptModel attempt2 = AttemptModel.builder()
                .user(users.get(1))
                .session(sessions.get(1))
                .routes(routes.get(1))
                .attemptTime(180)
                .notes("Good balance. Topped easily.")
                .result(ResultType.SEND)
                .build();

        AttemptModel attempt3 = AttemptModel.builder()
                .user(users.get(2))
                .session(sessions.get(2))
                .routes(routes.get(2))
                .attemptTime(600)
                .notes("Fatigued halfway. Needs rest-day before next try.")
                .result(ResultType.FAIL)
                .build();

        return List.of(attempt1, attempt2, attempt3);
    }
}
