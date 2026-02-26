# CLI Based – Task Tracker System

Task Tracker is a simple project used to track and manage your tasks. In this project, you will build a Command Line Interface (CLI) application that allows users to keep track of what they need to do, what they are currently working on, and what they have completed.

This project helps you practice essential programming concepts, including:

- Working with the filesystem
- Handling user inputs
- Designing a CLI-based application
- Reading and writing data

---

## Requirements

The application must:

- Run from the command line
- Accept user actions and inputs as arguments
- Store tasks in a Text file

---

## Features

Users should be able to:

- **Add tasks**
- **Update tasks**
- **Delete tasks**
- **Mark tasks as _in-progress_**
- **Mark tasks as _done_**
- **List all tasks**
- **List tasks by status:**
  - Done
  - Not Done
  - In Progress

---

## Task Properties

Each task must contain the following properties:

| Property     | Description |
|-------------|-------------|
| **id** | A unique identifier for the task |
| **description** | A short description of the task |
| **status** | The task status (`todo`, `in-progress`, `done`) |
| **createdAt** | Date and time when the task was created |
| **updatedAt** | Date and time when the task was last updated |

---

## Data Storage Rules

- When adding a new task:
  - Assign a unique **id**
  - Set **status** to `todo`
  - Set **createdAt** and **updatedAt`

- When updating a task:
  - Modify **description** or **status**
  - Update **updatedAt**

---

## Goal of the Project

By completing this project, you will gain hands-on experience with:

- CLI argument parsing
- File handling
- Basic CRUD operations
- Status management logic

---

✅ **Outcome:**  
A fully functional CLI Task Tracker that persists tasks using a text file.