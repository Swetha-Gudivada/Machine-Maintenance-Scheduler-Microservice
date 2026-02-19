# 🛠 Smart Maintenance System

A simple and clean **Maintenance Management System** built using **Spring Boot + MySQL**.

It helps track machines, schedule maintenance tasks, and monitor risk levels through an interactive dashboard.

---

## 🚀 Features

- ✅ Machine tracking  
- 📅 Task scheduling  
- ⚠️ Risk level classification  
- 🔴 Overdue detection  
- 📊 Health percentage calculation  
- 📥 Excel upload  
- 📄 PDF export  

---

## 🖥 Application Screens

### 📊 Dashboard

![Dashboard](/src/screenshot-s/dashboard-1.png)

![Dashboard](/src/screenshot-s/dashboard-2.png)

**Displays:**
- Total Machines
- High Risk Machines
- Overdue Machines
- Risk Distribution Chart
- Machine Records Table

---

### 📅 Upcoming Tasks

![Upcoming Tasks](/src/screenshot-s/maintenance-task.png)

- View scheduled tasks  
- Mark tasks as complete  
- Track maintenance progress  

---

### ➕ Schedule Task

![Schedule Task](screenshot-s/schedule-task.png)

- Assign new maintenance tasks  
- Select machine and date  
- Automatically updates status  

---

## 🏗 Tech Stack

| Layer      | Technology       |
|------------|-----------------|
| Backend    | Spring Boot     |
| Database   | MySQL           |
| ORM        | Spring Data JPA |
| Frontend   | Thymeleaf       |
| Charts     | Chart.js        |
| Build Tool | Maven           |

---

## ⚙️ How to Run

```bash
git clone https://github.com/yourusername/Machine-Maintenance-Scheduler-Microservice.git
cd Machine-Maintenance-Scheduler-Microservice
.\mvnw.cmd spring-boot:run
