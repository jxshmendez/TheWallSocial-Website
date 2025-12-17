export interface JwtPayload {
    userId: number;
    sub: string; // username
    exp: number; // expiry
    iat: number // issued at
}