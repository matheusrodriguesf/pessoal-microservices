import User from "../model/user.js";

class UserRepository {

    /**
     * Retorna um usuário pelo email
     * @param {User} user
     * @return {Promise<User>}
     * @throws {Error}
     */
    async findByEmail(email) {
        try {
            return await User.findOne({ where: { email } });
        } catch (error) {
            console.error(error.message);
            throw new Error(error.message);
        }
    }

    /**
     * Retorna um usuário pelo id
     * @param {User} user
     * @return {Promise<User>}
     * @throws {Error}
     * 
     */
    async findById(id) {
        try {
            return await User.findByPk(id);
        } catch (error) {
            console.error(error.message);
            throw new Error(error.message);
        }
    }
}

export default new UserRepository();