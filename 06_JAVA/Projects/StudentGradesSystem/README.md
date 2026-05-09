# 🎓 Student Grades System

A console-based Java application for managing students, courses, and grade registrations.

---

## 📋 Overview

This project demonstrates **generics**, **inner classes**, and **menu-driven console UI** to create a student grade tracking system.

## 🏗️ Architecture

```
Main
  └── MenuController
        ├── List<Student>
        └── List<Course>

Student implements Identifiable
  └── CourseRegistration (Private Inner Class)
        ├── Course
        └── Grade

Course implements Identifiable

Utils (Utility Class)
  ├── StringTokenizerCourseCreation()
  ├── printMenu()
  └── isIdThere<T>()
```

## 📁 Files

| File | Description |
|------|-------------|
| `Main.java` | Application entry point |
| `MenuController.java` | Handles menu operations and CRUD logic |
| `Student.java` | Student model with nested `CourseRegistration` |
| `Course.java` | Course model with name, id, credit hours |
| `Identifiable.java` | Interface for ID-based entities |
| `Utils.java` | Utility methods with generics |

## 🔑 Key Concepts Demonstrated

### Generic Utility Method
```java
public static <T extends Identifiable> T isIdThere(Integer id, List<T> list) {
    for (T item : list) {
        if (id.equals(item.getId())) {
            return item;
        }
    }
    return null;
}
```

### Private Inner Class
```java
private class CourseRegistration {
    private Course course;
    private Double grade;
}
```

## 💡 Features

| Option | Action |
|--------|--------|
| 1 | Enter Student Details |
| 2 | Print Student Details |
| 3 | Register Student Courses |
| 4 | Enter a Course |
| 5 | Close the App |

## ▶️ How to Run

```bash
# Compile
javac *.java

# Run
java Main
```
