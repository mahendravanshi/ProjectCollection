const bodyParser = require('body-parser');
const express = require('express');
const cors = require('cors');
const app = express();
const PORT = 3000; // Corrected the port number

app.use(cors()); // Enable CORS for all routes

app.use(bodyParser.json());

let tasks = [
  { id: 1, name: "Task 1", priority: 25 },
  { id: 2, name: "Task 2", priority: 30 },
  // Add more tasks as needed
];

// Get all tasks
app.get("/tasks", (req, res) => {
  res.json(tasks);
});

// Get a single task by ID
app.get("/tasks/:id", (req, res) => {
  const taskId = parseInt(req.params.id);
  const task = tasks.find((u) => u.id === taskId);

  if (task) {
    res.json(task);
  } else {
    res.status(404).json({ error: "Task not found" });
  }
});

// Create a new task
app.post("/tasks", (req, res) => {
  const newTask = req.body;
  newTask.id = tasks.length + 1;
  tasks.push(newTask);
  res.status(201).json(newTask);
});

// Update a task by ID
app.put("/tasks/:id", (req, res) => {
  const taskId = parseInt(req.params.id);
  const updateTask = req.body;
  const index = tasks.findIndex((u) => u.id === taskId);

  if (index !== -1) {
    tasks[index] = { ...tasks[index], ...updateTask };
    res.json(tasks[index]);
  } else {
    res.status(404).json({ error: "Task not found" });
  }
});

// Delete a task by ID
app.delete("/tasks/:id", (req, res) => {
  const taskId = parseInt(req.params.id);
  tasks = tasks.filter((u) => u.id !== taskId);
  res.json({ message: "Task deleted successfully" });
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
