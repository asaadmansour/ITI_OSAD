# JSON-P (JSON Processing API)

**JSR 374** - The low-level standard Java API for processing JSON.

## 📁 Structure

```
JsonP/
└── objectModel/
    ├── JsonReader/     # Reading JSON from files
    ├── JsonWriter/     # Writing JSON to files
    ├── lib/            # JAR dependencies
    └── test.json       # Sample JSON file
```

---

## 📖 What We Learned

### JsonReader - Reading JSON

Manual parsing of JSON files using the Object Model API:

```java
// Create reader
JsonReader reader = Json.createReader(new FileReader("./test.json"));

// Read entire JSON as object
JsonObject json = reader.readObject();

// Access values by key (must know the structure)
String name = json.getString("name");
boolean active = json.getBoolean("isActive");

// Nested objects
JsonObject address = json.getJsonObject("address");
String city = address.getString("city");

// Arrays
JsonArray orders = json.getJsonArray("orders");
JsonObject firstOrder = orders.getJsonObject(0);

// Numbers
double amount = firstOrder.getJsonNumber("amount").doubleValue();
```

### JsonWriter - Writing JSON

Building and writing JSON using builders:

```java
// Build JSON structure
JsonObject json = Json.createObjectBuilder()
    .add("Name", "Asaad")
    .add("Age", 22)
    .add("Address", Json.createObjectBuilder()
        .add("City", "Cairo")
        .add("Country", "Egypt"))
    .add("Skills", Json.createArrayBuilder()
        .add("Java")
        .add("Python"))
    .build();

// Write to file
try (JsonWriter writer = Json.createWriter(new FileWriter("output.json"))) {
    writer.write(json);
}
```

---

## 🔧 How to Compile & Run

```bash
cd objectModel

# Compile
javac -cp "lib/*:." JsonReader/JsonReaderTest.java

# Run
java -cp "lib/*:." JsonReader.JsonReaderTest
```

---

## 📦 Dependencies

- `javax.json-api-1.1.4.jar` - API interfaces
- `javax.json-1.1.4.jar` - Glassfish implementation

---

## 💡 Key Points

1. **Manual parsing** - You must know the JSON structure beforehand
2. **Type-specific getters** - `getString()`, `getInt()`, `getBoolean()`, etc.
3. **No dot notation** - Can't do `json.getString("address.city")`, must navigate step by step
4. **FileNotFoundException** - Must handle when reading files
