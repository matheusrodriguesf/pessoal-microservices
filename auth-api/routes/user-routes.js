import { Router } from 'express';
import UserController from '../controller/user-controller.js';

const router = Router();

router.get('/api/v1/users/email/:email', UserController.findByEmail);
router.post("/api/user/auth", UserController.getAceessToken);

export default router;