import UserService from "../service/user-service.js";

class UserController {

    async getAceessToken(req, res) {
        try {
            const user = await UserService.getAceessToken(req);
            res.status(200).json(user);
        } catch (error) {
            res.status(error.status).json({ message: error.message });
        }
    }

    async findByEmail(req, res) {
        try {
            const user = await UserService.findByEmail(req);
            res.status(200).json(user);
        } catch (error) {
            res.status(error.status).json({ message: error.message });
        }
    }
}
export default new UserController();