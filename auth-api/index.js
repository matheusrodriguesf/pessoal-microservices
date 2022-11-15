import express from 'express';
import seed from './seed/data.js';
const app = express();
const env = process.env;
const PORT = env.PORT || 8080;


seed();

app.get('/status', (req, res) => {
    return res.json(
        {
            service: 'Auth-API',
            status: 'ok',
            code: 200
        });
});

app.listen(PORT, () => {
    console.log(`Server listening on port ${PORT}`);
});