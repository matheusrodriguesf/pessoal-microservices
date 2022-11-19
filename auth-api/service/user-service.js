import UserRepository from "../repository/user-repository.js";
import status from "http-status";
import UserException from "../exception/user-exception.js";

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
}
export default new UserService();