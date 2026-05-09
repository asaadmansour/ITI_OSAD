# Gson (Google JSON Library)

**Third-party library** by Google for JSON processing in Java.

## 📁 Structure

```
Gson/
├── Employee.java      # POJO class
├── GsonTest.java      # Test examples
└── lib/               # JAR dependencies
    └── gson-2.13.1.jar
```

---

## 📖 What We Learned

### Creating Gson Instance

```java
// Simple instance
Gson gson = new Gson();

// With pretty printing (formatted output)
Gson gson = new GsonBuilder()
    .setPrettyPrinting()
    .create();
```

### Serialization (Object → JSON)

```java
// Single object
Employee emp = new Employee(1, "Asaad", "SWE");
String json = gson.toJson(emp);

// Array
Employee[] emps = {e1, e2};
String jsonArray = gson.toJson(emps);

// List/Collection
List<Employee> empList = new ArrayList<>();
String jsonList = gson.toJson(empList);
```

### Deserialization (JSON → Object)

```java
// Single object
Employee restored = gson.fromJson(json, Employee.class);

// Array
Employee[] restoredArray = gson.fromJson(jsonArray, Employee[].class);

// Collection (deserialize to array first)
Employee[] tempArray = gson.fromJson(jsonList, Employee[].class);
List<Employee> restoredList = new ArrayList<>(Arrays.asList(tempArray));
```

---

## 🔧 How to Compile & Run

```bash
# Compile
javac -cp "lib/*:." Employee.java GsonTest.java

# Run
java -cp "lib/*:." GsonTest
```

---

## 📦 Dependencies

- `gson-2.13.1.jar` - Google Gson library

Download from: [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson)

---

## 💡 Key Points

1. **Similar to JSON-B** - Same `toJson()` and `fromJson()` pattern
2. **GsonBuilder** - Use for configuration (pretty printing, date formats, etc.)
3. **Reusable instance** - Create once, use many times
4. **Very popular** - Used in Android development and Spring Boot
5. **No Java EE required** - Works standalone, unlike JSON-B

---

## 🆚 Gson vs JSON-B

| Feature | Gson | JSON-B |
|---------|------|--------|
| Type | Third-party (Google) | Java Standard |
| Size | Single JAR (~280KB) | Multiple JARs |
| Popularity | Very high | Growing |
| Configuration | GsonBuilder | JsonbConfig |
| Android | ✅ Widely used | ❌ Not common |
