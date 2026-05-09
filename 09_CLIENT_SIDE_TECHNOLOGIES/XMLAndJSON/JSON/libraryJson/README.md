# Library JSON

Sample JSON data file demonstrating nested JSON structure.

## 📁 Structure

```
libraryJson/
└── library.json      # Sample JSON data
```

---

## 📖 JSON Structure

The `library.json` file demonstrates deeply nested JSON:

```
library (object)
├── location (string)
├── description (string)
├── librarian (string)
└── books (array)
    └── book (object)
        ├── title (string)
        ├── ISBN (string)
        ├── author (string)
        ├── preface (string)
        └── parts (array)
            └── part (object)
                ├── title (string)
                └── chapters (array)
                    └── chapter (object)
                        ├── title (string)
                        ├── summary (string)
                        └── sections (array)
```

---

## 💡 Purpose

This file serves as sample data for practicing:
- Reading nested JSON structures
- Navigating through multiple levels of objects and arrays
- Understanding real-world JSON complexity
