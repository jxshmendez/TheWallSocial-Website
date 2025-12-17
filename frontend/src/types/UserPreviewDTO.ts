export interface UserPreviewDTO {
    userId: number;
    username: string;
    bio: string;
    avatarUrl: string;
    followingCount: number;
    followerCount: number;
}

/*
    JAVA DTO:
    Long userId,
    String username,
    String bio,
    String avatarUrl,
    Integer followingCount,
    Integer followerCount
*/