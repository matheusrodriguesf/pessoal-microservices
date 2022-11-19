import bcrypt from 'bcrypt';
import { faker } from '@faker-js/faker';
import User from '../model/user.js';


export default async function seed() {
    try {
        await User.sync({ force: true });
        for (let i = 0; i < 10; i++) {
            let user = await User.create({
                name: faker.name.firstName(),
                email: faker.internet.email(),
                password: await bcrypt.hash(faker.internet.password(), 10),
                createdAt: new Date(),
            });
            console.log("Usuário cria com sucesso: ", user.toJSON());
        }
    } catch (error) {
        console.log('Error: ', error);
    }
}