import User from "../model/user";

export default class UserRepository {

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
            throw error;
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
            throw error;
        }
    }
}