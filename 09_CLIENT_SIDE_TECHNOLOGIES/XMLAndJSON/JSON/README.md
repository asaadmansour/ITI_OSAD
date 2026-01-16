# JSON Processing in Java

This folder contains examples and implementations of different JSON processing approaches in Java.

## 📁 Project Structure

| Folder | Description | Library Used |
|--------|-------------|--------------|
| [JsonP](./JsonP) | JSON Processing API (JSR 374) - Manual parsing | `javax.json` |
| [JsonB](./JsonB) | JSON Binding API (JSR 367) - Automatic binding | `javax.json.bind` |
| [Gson](./Gson) | Google's JSON library - Third-party | `com.google.gson` |
| [libraryJson](./libraryJson) | Sample JSON data files | - |

---

## 🔄 Comparison

| Feature | JSON-P | JSON-B | Gson |
|---------|--------|--------|------|
| Type | Java Standard (JSR 374) | Java Standard (JSR 367) | Third-party (Google) |
| Approach | Manual parsing | Automatic binding | Automatic binding |
| Object → JSON | `Json.createObjectBuilder().add()...` | `jsonb.toJson(obj)` | `gson.toJson(obj)` |
| JSON → Object | `json.getString("key")` | `jsonb.fromJson(str, Class)` | `gson.fromJson(str, Class)` |
| Learning Curve | More verbose | Simple | Simple |
| Use Case | Full control, low-level | Standard Java EE | Spring Boot, Android |

---

## 📚 Quick Navigation

### JSON-P (Processing)
- [JsonReader](./JsonP/objectModel/JsonReader) - Reading JSON from files
- [JsonWriter](./JsonP/objectModel/JsonWriter) - Writing JSON to files

### JSON-B (Binding)
- [JsonBTest.java](./JsonB/JsonBTest.java) - Serialize/deserialize objects, arrays, collections

### Gson
- [GsonTest.java](./Gson/GsonTest.java) - Google's library for JSON processing

---