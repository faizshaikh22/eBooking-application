const express = require('express');
const app = express();

app.use(express.static('ebooking-application'));

const PORT = process.env.PORT || 4342
app.listen(PORT, ()=>console.log('Server is running'));
