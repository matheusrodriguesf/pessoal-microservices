import UserRepository from "../repository/user-repository.js";
import status from "http-status";
import UserException from "../exception/user-exception.js";
import bcrypt from "bcrypt";
import jwt from "jsonwebtoken";
import { API_SECRET } from "../config/secrets.js";


class UserService {

    async findByEmail(req) {
        try {
            const { email } = req.params;
            if (!email) {
                throw new UserException("Email não informado", status.BAD_REQUEST);
            }
            const user = await UserRepository.findByEmail(email);
            if (!user) {
                throw new UserException("Usuário não encontrado", status.NOT_FOUND);
            }
            return {
                id: user.id,
                name: user.name,
                email: user.email,
                createdAt: user.createdAt,
                updatedAt: user.updatedAt
            }
        } catch (error) {
            throw new UserException(error.message, error.status ? error.status : status.INTERNAL_SERVER_ERROR);
        }
    }

    async getAceessToken(req) {
        try {
            const { email, password } = req.body;
            if (!email || !password) {
                throw new UserException("Email e/ou senha não informados", status.BAD_REQUEST);
            }
            const user = await UserRepository.findByEmail(email);
            if (!user) {
                throw new UserException("Usuário não encontrado", status.NOT_FOUND);
            }
            const isValidPassword = await bcrypt.compare(password, user.password);
            if (!isValidPassword) {
                throw new UserException("Senha inválida", status.UNAUTHORIZED);
            }
            const authUser = {
                id: user.id,
                name: user.name,
                email: user.email,
            };
            const acessToken = jwt.sign({ authUser }, API_SECRET, { expiresIn: "1h" });
            return {
                status: status.OK,
                acessToken: acessToken
            }
        } catch (error) {
            throw new UserException(error.message, error.status ? error.status : status.INTERNAL_SERVER_ERROR);
        }
    }
}
export default new UserService();