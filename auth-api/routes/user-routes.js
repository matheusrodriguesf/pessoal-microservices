import { Router } from 'express';
import UserController from '../controller/user-controller.js';
import auth from '../config/auth.js';

const router = Router();

router.post("/api/user/auth", UserController.getAceessToken);

router.use(auth);
router.get('/api/v1/users/email/:email', UserController.findByEmail);

export default router;