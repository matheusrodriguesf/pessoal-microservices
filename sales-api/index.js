import express from 'express';
const app = express();
const env = process.env;
const PORT = env.PORT || 8082;

app.get('/status', (req, res) => {
    res.json({
        service: 'Sales API',
        status: 'ok',
        code: 200
    });
});

app.listen(PORT, () => {
    console.log(`Server is listening on port ${PORT}`);
});