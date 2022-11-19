import jwt from "jsonwebtoken";
import { API_SECRET } from "../config/secrets.js";
import AuthException from "../exception/auth-exception.js";
import status from "http-status";
const emptySpace = " ";

export default async function auth(req, res, next) {
    try {
        const authHeader = req.headers.authorization;
        if (!authHeader) {
            throw new AuthException("No token provided", status.UNAUTHORIZED);
        }
        const parts = authHeader.split(emptySpace);
        if (parts.length !== 2) {
            throw new AuthException("Token error", status.UNAUTHORIZED);
        }
        const [scheme, token] = parts;
        if (!/^Bearer$/i.test(scheme)) {
            throw new AuthException("Token malformatted", status.UNAUTHORIZED);
        }
        jwt.verify(token, API_SECRET, (err, decoded) => {
            if (err) {
                throw new AuthException("Token invalid", status.UNAUTHORIZED);
            }
            req.userId = decoded.id;
            return next();
        });
    } catch (error) {
        const status = error.status || status.INTERNAL_SERVER_ERROR;
        const message = error.message || "Internal Server Error";
        return res.status(status).json({ message });
    }
}