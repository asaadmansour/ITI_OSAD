# JSON-B (JSON Binding API)

**JSR 367** - The standard Java API for automatic JSON ↔ Object binding.

## 📁 Structure

```
JsonB/
├── Employee.java      # POJO class
├── JsonBTest.java     # Test examples
└── lib/               # JAR dependencies
```

---

## 📖 What We Learned

### Automatic Serialization (Object → JSON)

```java
Jsonb jsonb = JsonbBuilder.create();

// Single object
Employee emp = new Employee(1, "Asaad", "SWE");
String json = jsonb.toJson(emp);
// Output: {"id":1,"jobTitle":"SWE","name":"Asaad"}

// Array
Employee[] emps = {e1, e2};
String jsonArray = jsonb.toJson(emps);

// List/Collection
List<Employee> empList = new ArrayList<>();
String jsonList = jsonb.toJson(empList);
```

### Automatic Deserialization (JSON → Object)

```java
// Single object
Employee restored = jsonb.fromJson(json, Employee.class);

// Array
Employee[] restoredArray = jsonb.fromJson(jsonArray, Employee[].class);

// Collection (deserialize to array first, then convert)
Employee[] tempArray = jsonb.fromJson(jsonList, Employee[].class);
List<Employee> restoredList = new ArrayList<>(Arrays.asList(tempArray));
```

---

## 🔧 How to Compile & Run

```bash
# Compile
javac -cp "lib/*:." Employee.java JsonBTest.java

# Run
java -cp "lib/*:." JsonBTest
```

---

## 📦 Dependencies

- `javax.json.bind-api-1.0.jar` - JSON-B API
- `yasson-1.0.11.jar` - Eclipse Yasson implementation
- `javax.json-api-1.1.4.jar` - JSON-P API (required by Yasson)
- `javax.json-1.1.4.jar` - JSON-P implementation

---

## 💡 Key Points

1. **No manual parsing** - Just `toJson()` and `fromJson()`
2. **POJO requirements**:
   - Default (no-arg) constructor
   - Getters and Setters
3. **Reusable instance** - Create `Jsonb` once, use many times
4. **Generic collections** - Deserialize to array first, then convert to List
5. **Built on JSON-P** - Uses streaming API internally for performance
