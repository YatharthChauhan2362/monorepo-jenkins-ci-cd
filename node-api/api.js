const express = require('express');
const app = express();
const port = 3003;

app.get('/', (req, res) => {
    res.send('API is running!');
});

app.get('/yc', (req, res) => {
    res.send('Yatharth Chauhan Here!');
});

app.listen(port, () => {
    console.log(`Server is running at http://localhost:${port}`);
});
