import bcrypt from 'bcrypt';
import { faker } from '@faker-js/faker';
import User from '../model/User.js';


export default async function seed() {
    try {
        for (let i = 0; i < 10; i++) {
            let user = await User.create({
                name: faker.name.firstName(),
                email: faker.internet.email(),
                password: await bcrypt,
                createdAt: new Date(),
            });
            console.log('User created: ', user);
        }
    } catch (error) {
        console.log('Error: ', error);
    }
}