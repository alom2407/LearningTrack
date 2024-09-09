Here are the notes that have been tracked so far:

---

### **1. Custom Exceptions in Java**
**Note Type**: Summary  
**Summary**:  
Custom exceptions are user-defined exceptions that extend the `Exception` class (for checked exceptions) or `RuntimeException` (for unchecked exceptions). They are used to handle application-specific errors with clearer intent and reusability. A custom exception class provides specific error messages and is thrown when a particular condition in business logic fails. By creating a custom exception, error handling becomes more organized and easier to understand.

Example: `InvalidAgeException` used to validate age in an application.

---

### **2. PriorityQueue in Java**
**Note Type**: Bullet Points  
**Summary**:
- PriorityQueue is a type of queue that orders elements based on priority.
- Internally uses a binary heap, ensuring efficient insertion and deletion with O(log n) complexity.
- Default ordering uses natural ordering (if elements implement Comparable), or a custom comparator can be provided.
- Elements are removed based on priority, not FIFO.
- Operations: add(), poll(), peek() for insertion, retrieval, and deletion of highest priority element.
- Custom ordering can be achieved using the Comparator interface.

Example with Comparator:
```java
import java.util.PriorityQueue;
import java.util.Comparator;

class Job {
    int jobId;
    int priority;

    public Job(int jobId, int priority) {
        this.jobId = jobId;
        this.priority = priority;
    }

    public String toString() {
        return "Job ID: " + jobId + ", Priority: " + priority;
    }
}

public class PriorityQueueCustomObject {
    public static void main(String[] args) {
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job.priority));

        jobQueue.add(new Job(1, 3));  // Low priority
        jobQueue.add(new Job(2, 1));  // Highest priority
        jobQueue.add(new Job(3, 2));  // Medium priority

        while (!jobQueue.isEmpty()) {
            System.out.println("Polled: " + jobQueue.poll()); 
        }
    }
}
```

---

### **3. When to Use ArrayList and LinkedList in Java**
**Note Type**: Summary  
**Summary**:
- ArrayList is backed by a dynamic array, providing O(1) access time for random access by index. It is ideal for use cases where the list is frequently read and rarely modified (e.g., searching and reading data).
- LinkedList is a doubly linked list, offering O(1) time for insertions and deletions at the ends or middle of the list. It is ideal for dynamic scenarios where frequent modifications (insertions/deletions) are needed.
- ArrayList should be used when random access is more frequent, and list modification is rare.
- LinkedList should be used when frequent insertions and deletions occur, and random access is less important.

Real-Life Example:  
**Undo Operation in a Text Editor**  
A LinkedList is suitable for storing user actions because undo operations typically involve removing the most recent action, which requires fast removal from the end of the list.

---

### **4. Thread Pool in Java**
**Note Type**: Bullet Points  
**Summary**:
- **Thread Pool**: A group of reusable threads used to manage a large number of short-lived tasks.
- **Executor Framework**: Provides various types of thread pools through the `ExecutorService` interface.
- **Types of Thread Pools**:
    - **Fixed Thread Pool**: A pool with a fixed number of threads.
    - **Cached Thread Pool**: Dynamically creates new threads as needed.
    - **Single Thread Executor**: Executes tasks sequentially using a single thread.
    - **Scheduled Thread Pool**: Schedules tasks to run after a delay or periodically.
- **ThreadPoolExecutor** is configurable with core pool size, maximum pool size, and work queues.
- **Best Practices**: Use fixed thread pools for known workloads, always shut down the pool, and avoid unbounded queues.

---

### **5. ThreadFactory in Java**
**Note Type**: Summary  
**Summary**:
- **ThreadFactory** is an interface used to create new threads in a controlled way, typically with an `ExecutorService`.
- Allows customization of threads (e.g., thread names, priorities, daemon status).
- Useful for debugging (custom thread names) and managing thread properties consistently.
- The `newThread(Runnable r)` method is used to create a new thread.

Example:
```java
class CustomThreadFactory implements ThreadFactory {
    private int threadId = 1;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("CustomThread-" + threadId++);
        thread.setDaemon(true);
        return thread;
    }
}
```

---

### **6. Java Memory Management**
**Note Type**: Bullet Points  
**Summary**:
- **Java Memory Areas**: Heap, Stack, Method Area, PC Registers, and Native Method Stack.
- **Heap Memory**: Divided into Young Generation (Eden, Survivor spaces) and Old Generation.
- **Garbage Collection**: Automatically reclaims memory. Types include Serial, Parallel, CMS, and G1 collectors.
- **Memory Leaks**: Occur when objects are not properly dereferenced, leading to memory not being reclaimed.
- **References**: Strong, Weak, Soft, and Phantom references determine object reachability.
- **Finalization**: Deprecated `finalize()` method; replaced by `try-with-resources` for managing resources.

---

### **7. Java Reflection and Annotations**
**Note Type**: Summary  
**Summary**:
- **Reflection** allows a program to inspect and modify its structure at runtime.
- Provides capabilities such as retrieving methods, fields, constructors of a class, and invoking methods dynamically.
- **Annotations** provide metadata about code without affecting execution.
- **Meta-annotations** (e.g., `@Retention`, `@Target`) control where and how annotations are applied.
- **Custom Annotations** can be created using `@interface`.

---

### **8. Advanced Java Generics**
**Note Type**: Summary  
**Summary**:
- **Generic Classes and Methods**: Allow operations on various types with type safety at compile time.
- **Bounded Types**: Use `extends` and `super` to restrict type parameters.
- **Wildcards (`?`)**: Unbounded, upper bounded (`extends`), and lower bounded (`super`).
- **Type Erasure**: Generic type information is erased at runtime.
- **Covariance** (`extends`) and **Contravariance** (`super`) enable working with subtypes and supertypes.

---

### **9. Java Database Connectivity (JDBC)**
**Note Type**: Summary  
**Summary**:
- **JDBC**: An API to connect and interact with databases using SQL.
- **Key Components**:
    - **DriverManager**: Manages database drivers and connections.
    - **Connection**: Represents a connection to the database.
    - **Statement and PreparedStatement**: Execute SQL queries.
    - **ResultSet**: Holds query results.
- **PreparedStatement**: Allows parameterized queries, preventing SQL injection.
- **CRUD Operations**: Create, Read, Update, Delete operations using SQL.
- **Connection Pooling**: Reuses connections for better performance (e.g., HikariCP).
- **Transactions**: Supports `commit()` and `rollback()`.
- **Batch Processing**: Executes multiple SQL statements in a batch.

---

### **10. Security in Java**
**Note Type**: Bullet Points  
**Summary**:
- **Java Cryptography Architecture (JCA)**: Provides cryptographic operations like encryption, decryption, signing, and verification.
- **Symmetric Encryption**: Uses the same key for encryption and decryption (e.g., AES).
- **Asymmetric Encryption**: Uses public/private key pairs (e.g., RSA).
- **Message Digest**: A one-way hash function (e.g., SHA-256) for data integrity.
- **Digital Signature**: Ensures authenticity and integrity with private/public key signing.
- **Certificates**: Authenticates identities and ensures secure communication via Java KeyStore (JKS).

---

### **11. Java Performance Tuning and Optimization**
**Note Type**: Bullet Points  
**Summary**:
- **JVM Tuning**:
    - Use `-Xms` and `-Xmx` to adjust heap size.
    - Select the appropriate garbage collector (`Serial`, `Parallel`, `G1`).
- **Profiling Tools**:
    - Use **VisualVM** and **JConsole** to monitor memory, CPU, and GC.
    - **Flight Recorder** provides detailed diagnostics.
- **Memory Optimization**:
    - Use object pooling.
    - Avoid memory leaks with `try-with-resources`.
- **Best Practices**:
    - Use efficient data structures (e.g., `HashMap`, `ConcurrentHashMap`).
    - Use `StringBuilder` for string concatenation.
    - Minimize synchronization and use concurrent collections.

---

Let me know if you want to update or dive into any of these topics further!