# 📝 CLI-Based Task Tracker System

The **Task Tracker System** is a Command Line Interface (CLI) application designed to help users manage tasks efficiently. The system supports task creation, updates, deletion, and status tracking, while persisting data using a text file.

This project is ideal for practicing **Object-Oriented Programming (OOP)**, **file handling**, and **CLI argument parsing**.

---

## 🎯 Project Objectives

This project helps reinforce:

- CLI application design
- File reading & writing
- CRUD operations
- OOP principles
- Input validation & error handling

---

## ✅ Functional Requirements

The application must:

- Run from the command line
- Accept commands via CLI arguments
- Persist tasks using a text file
- Support full task lifecycle management

---

## 🚀 Features

Users can:

- **Add tasks**
- **Update tasks**
- **Delete tasks**
- **Mark tasks as _in-progress_**
- **Mark tasks as _done_**
- **List all tasks**
- **Filter tasks by status**
  - `todo`
  - `in-progress`
  - `done`

---

## 📦 Task Data Model

Each task contains:

| Field | Type | Description |
|------|------|-------------|
| `id` | int | Unique identifier |
| `description` | String | Short task description |
| `status` | Enum | `TODO`, `IN_PROGRESS`, `DONE` |
| `createdAt` | LocalDateTime | Creation timestamp |
| `updatedAt` | LocalDateTime | Last modification timestamp |

---

## 🧱 Class Design

---

### **1️⃣ Task**

**Responsibility:** Represents a task entity.

**Fields:**

- `id`
- `description`
- `status`
- `createdAt`
- `updatedAt`

**Methods:**

- `getters/setters`
- `toFileString()` → Serializes task for storage
- `fromFileString()` → Parses stored task data

---

### **2️⃣ Status (Enum)**

**Responsibility:** Restricts valid task states.

**Values:**

- `TODO`
- `IN_PROGRESS`
- `DONE`

---

### **3️⃣ TaskRepository**

**Responsibility:** Handles file persistence.

**Methods:**

- `loadTasks()` → Reads tasks from file
- `saveTasks()` → Writes tasks to file
- `appendTask()` → Adds new task entry

---

### **4️⃣ TaskService**

**Responsibility:** Business logic layer.

**Methods:**

- `addTask(description)`
- `updateTask(id, description)`
- `deleteTask(id)`
- `markInProgress(id)`
- `markDone(id)`
- `listTasks()`
- `listTasksByStatus(status)`

---

### **5️⃣ CommandHandler**

**Responsibility:** CLI argument parsing.

**Methods:**

- `handle(args)`
- `handleAdd()`
- `handleUpdate()`
- `handleDelete()`
- `handleMarkDone()`
- `handleList()`

---
### **Util**
**Responsibility:** Handles User-Input
- 'DateTime.Util'
- 'FileUtil'
- 'IDGeneratorUtil'

---
### **Exceptions**
**Responsibility:** Handles Possible Exceptions
- 'TaskNotFoundException' - Thrown when a task ID does not exist.
- 'InvalidCommandException' - Thrown when CLI command is invalid.
- 'InvalidInputException' - Thrown when user input is invalid.
- 'FileStorageException' - Thrown when file operations fail.
---

### **8 Main**

**Responsibility:** Entry point.

---

## 💾 File Storage Format

Tasks are stored in:

```

tasks.txt

```

**Line Format:**

```

id|description|status|createdAt|updatedAt

```

**Example:**

```

1|Finish Java project|TODO|2026-02-26T20:15|2026-02-26T20:15

```

---

## ⚠️ Validation Rules

- Description must not be empty
- ID must exist for update/delete
- Status transitions must be valid
- Handle missing file safely

---

## 🛡 Error Handling

The system must gracefully handle:

- Invalid commands
- Missing arguments
- Invalid ID format
- Task not found
- File I/O exceptions

---

## ⭐ Skill Enhancement Suggestions

To improve coding skills, consider adding:

- ✅ Task priority (`LOW`, `MEDIUM`, `HIGH`)
- ✅ Due dates
- ✅ Search tasks by keyword
- ✅ Sorting (date/status/priority)
- ✅ Pretty table output
- ✅ JSON storage instead of text
- ✅ Unit tests (JUnit)

---

## 🗂 Suggested File Structure

```
task-tracker/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │     ├── Task.java
│   │     └── Status.java
│   │
│   ├── repository/
│   │     └── TaskRepository.java
│   │
│   ├── service/
│   │     └── TaskService.java
│   │
│   ├── handler/
│   │     └── CommandHandler.java
│   │
│   ├── util/
│   │     ├── DateTimeUtil.java
│   │     ├── FileUtil.java
│   │     └── IdGeneratorUtil.java
│   │
│   └── exception/
│         ├── TaskNotFoundException.java
│         ├── InvalidCommandException.java
│         ├── InvalidInputException.java
│         └── FileStorageException.java
│
├── data/
│   └── tasks.txt
│
└── README.md

```

---

## ✅ Expected Outcome

A fully functional CLI Task Tracker that:

✔ Uses clean OOP design  
✔ Persists data correctly  
✔ Supports CRUD operations  
✔ Implements status management  
✔ Demonstrates file handling  

---
