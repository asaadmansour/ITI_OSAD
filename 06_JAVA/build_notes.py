
path = "/home/asaad/ITI-OSAD/06_JAVA/notes.html"

sections = """
  <!-- COLLECTIONS -->
  <section id="collections">
    <h2 class="section-title"><span class="num">4</span> Collections Framework</h2>
    <h3 class="sub-title">Hierarchy</h3>
    <div class="tree">
Iterable
  └── Collection
        ├── List  → ArrayList, LinkedList, Vector
        ├── Queue → PriorityQueue, LinkedList
        │     └── Deque → ArrayDeque, LinkedList
        └── Set   → HashSet, LinkedHashSet, TreeSet

Map (separate — does not extend Collection)
  ├── HashMap, LinkedHashMap, Hashtable
  └── SortedMap → TreeMap
    </div>
    <p><strong>Collection</strong> (interface) — a container for elements with add/remove/iterate.<br>
    <strong>Collections</strong> (utility class) — static algorithms: <code>sort()</code>, <code>shuffle()</code>, <code>binarySearch()</code>, <code>unmodifiableList()</code>.</p>

    <h3 class="sub-title">List Implementations</h3>
    <table>
      <tr><th></th><th>ArrayList</th><th>LinkedList</th><th>Vector</th></tr>
      <tr><td>Backed by</td><td>Dynamic array</td><td>Doubly linked list</td><td>Dynamic array</td></tr>
      <tr><td>Random access</td><td>O(1) ✅</td><td>O(n)</td><td>O(1)</td></tr>
      <tr><td>Insert/delete (middle)</td><td>O(n)</td><td>O(1)</td><td>O(n)</td></tr>
      <tr><td>Thread-safe</td><td>No</td><td>No</td><td>Yes (legacy)</td></tr>
      <tr><td>Use now?</td><td>✅ Default</td><td>Frequent insert/delete</td><td>❌ Use ArrayList</td></tr>
    </table>

    <h3 class="sub-title">Map Implementations <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th></th><th>HashMap</th><th>LinkedHashMap</th><th>TreeMap</th><th>Hashtable</th></tr>
      <tr><td>Order</td><td>None</td><td>Insertion order</td><td>Sorted by key</td><td>None</td></tr>
      <tr><td>Null keys</td><td>1 allowed</td><td>1 allowed</td><td>Not allowed</td><td>Not allowed</td></tr>
      <tr><td>Thread-safe</td><td>No</td><td>No</td><td>No</td><td>Yes (legacy)</td></tr>
    </table>

    <h3 class="sub-title">Set Implementations</h3>
    <ul>
      <li><strong>HashSet</strong> — no order, O(1) ops, one null allowed</li>
      <li><strong>LinkedHashSet</strong> — maintains insertion order</li>
      <li><strong>TreeSet</strong> — sorted, uses Comparable/Comparator, O(log n)</li>
      <li><strong>EnumSet</strong> — optimized for enum values, very fast</li>
    </ul>

    <h3 class="sub-title">Queue &amp; Deque</h3>
    <ul>
      <li><strong>PriorityQueue</strong> — min-heap by default, ordered by natural order or Comparator</li>
      <li><strong>Deque</strong> — double-ended queue. Implemented by <code>ArrayDeque</code> and <code>LinkedList</code></li>
      <li><strong>Stack</strong> is deprecated — use <code>ArrayDeque</code> (not synchronized, faster)</li>
    </ul>

    <h3 class="sub-title">equals() and hashCode() Contract <span class="interview-tag">interview</span></h3>
    <div class="callout danger">
      If <code>a.equals(b)</code> is true → <code>a.hashCode() == b.hashCode()</code> MUST be true.<br>
      The reverse is NOT required (same hashCode ≠ equal — that's a collision).<br>
      Always override BOTH together. Breaking this silently breaks HashMap/HashSet.
    </div>

    <h3 class="sub-title">Comparable vs Comparator <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Comparable</th><th>Comparator</th></tr>
      <tr><td>Internal ordering (<code>java.lang</code>)</td><td>External ordering (<code>java.util</code>)</td></tr>
      <tr><td><code>compareTo(T other)</code></td><td><code>compare(T o1, T o2)</code></td></tr>
      <tr><td>One natural order per class</td><td>Multiple different orderings</td></tr>
      <tr><td><code>Collections.sort(list)</code></td><td><code>Collections.sort(list, comparator)</code></td></tr>
    </table>

    <h3 class="sub-title">Fail-Fast vs Fail-Safe <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Fail-Fast</th><th>Fail-Safe</th></tr>
      <tr><td>Throws <code>ConcurrentModificationException</code> on concurrent modification</td><td>Works on a copy — no exception</td></tr>
      <tr><td>ArrayList, HashMap iterators</td><td>CopyOnWriteArrayList, ConcurrentHashMap</td></tr>
    </table>

    <h3 class="sub-title">Iteration</h3>
    <ul>
      <li><strong>Enumeration</strong> — old interface (Vector, Hashtable), no <code>remove()</code></li>
      <li><strong>Iterator</strong> — modern: <code>hasNext()</code>, <code>next()</code>, <code>remove()</code></li>
      <li><strong>ListIterator</strong> — bidirectional, for Lists only</li>
      <li><code>Map.Entry&lt;K,V&gt;</code> — nested interface; each key-value pair stored as an Entry</li>
    </ul>
  </section>

  <!-- EXCEPTIONS -->
  <section id="exceptions">
    <h2 class="section-title"><span class="num">5</span> Exception Handling</h2>
    <h3 class="sub-title">Exception Hierarchy <span class="interview-tag">interview</span></h3>
    <div class="tree">
Throwable
  ├── Error              (unchecked — JVM-level, don't catch)
  │     ├── OutOfMemoryError
  │     └── StackOverflowError
  └── Exception
        ├── RuntimeException   (unchecked)
        │     ├── NullPointerException
        │     ├── ClassCastException
        │     └── ArrayIndexOutOfBoundsException
        └── (all others)       (checked)
              ├── IOException
              └── SQLException
    </div>

    <h3 class="sub-title">Checked vs Unchecked <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Checked</th><th>Unchecked</th></tr>
      <tr><td>Compiler forces try-catch or throws declaration</td><td>Compiler does not force handling</td></tr>
      <tr><td>Exception subclasses (not RuntimeException)</td><td>RuntimeException subclasses</td></tr>
      <tr><td>Recoverable situations (file not found, network)</td><td>Bugs (null pointer, bad arguments)</td></tr>
    </table>

    <h3 class="sub-title">try-catch-finally Rules <span class="interview-tag">interview</span></h3>
    <ul>
      <li><code>finally</code> always runs — even if there's a <code>return</code> in <code>try</code></li>
      <li>If both <code>try</code> and <code>finally</code> have <code>return</code>, <strong>finally's return wins</strong></li>
      <li><code>finally</code> does NOT run on: <code>System.exit()</code>, JVM crash, infinite loop in try</li>
      <li>Nothing between <code>try</code>, <code>catch</code>, <code>finally</code> — variable declarations between them = compile error</li>
      <li>More specific exceptions MUST come before general ones (otherwise "unreachable code" compile error)</li>
      <li>Multi-catch: <code>catch (IOException | SQLException e)</code></li>
      <li>Errors are NOT caught by <code>catch (Exception e)</code> — need <code>catch (Throwable t)</code></li>
      <li>Duplicate exception in same catch = compile error</li>
    </ul>
    <div class="callout danger">Errors (StackOverflowError, OutOfMemoryError) do NOT get caught by catch(Exception e)!</div>

    <h3 class="sub-title">throw vs throws <span class="interview-tag">interview</span></h3>
    <ul>
      <li><code>throw</code> — throws the actual exception object: <code>throw new IllegalArgumentException("bad input");</code></li>
      <li><code>throws</code> — declares that a method may throw a checked exception: <code>public void read() throws IOException</code></li>
    </ul>

    <h3 class="sub-title">Try-with-Resources <span class="interview-tag">interview</span></h3>
    <p>Auto-closes any <code>AutoCloseable</code> resource after the block, even if an exception occurs:</p>
    <pre>try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
} // br closed automatically ✅</pre>

    <h3 class="sub-title">Overriding &amp; Exceptions <span class="interview-tag">interview</span></h3>
    <ul>
      <li>Parent throws checked → child can: throw same, throw subclass of it, or throw nothing</li>
      <li>Parent throws checked → child CANNOT throw a broader checked exception</li>
      <li>Parent throws unchecked → child can do anything</li>
    </ul>

    <h3 class="sub-title">Custom Exceptions</h3>
    <pre>// Checked
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}
// Unchecked
public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String msg) { super(msg); }
}</pre>

    <h3 class="sub-title">final vs finally vs finalize <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Keyword</th><th>Meaning</th></tr>
      <tr><td><code>final</code> field</td><td>Constant — cannot be reassigned</td></tr>
      <tr><td><code>final</code> method</td><td>Cannot be overridden</td></tr>
      <tr><td><code>final</code> class</td><td>Cannot be extended</td></tr>
      <tr><td><code>finally</code></td><td>Always-runs cleanup block in try-catch</td></tr>
      <tr><td><code>finalize()</code></td><td>Called by GC before object removal — deprecated, use try-with-resources</td></tr>
    </table>
  </section>

  <!-- FUNCTIONAL -->
  <section id="functional">
    <h2 class="section-title"><span class="num">6</span> Functional Programming</h2>
    <h3 class="sub-title">Functional Interfaces <span class="interview-tag">interview</span></h3>
    <p>An interface with exactly <strong>one abstract method</strong>. Can be implemented with a lambda or method reference.</p>
    <table>
      <tr><th>Interface</th><th>Method</th><th>Used in</th></tr>
      <tr><td><code>Predicate&lt;T&gt;</code></td><td><code>test(T) → boolean</code></td><td><code>filter()</code></td></tr>
      <tr><td><code>Function&lt;T,R&gt;</code></td><td><code>apply(T) → R</code></td><td><code>map()</code></td></tr>
      <tr><td><code>Consumer&lt;T&gt;</code></td><td><code>accept(T) → void</code></td><td><code>forEach()</code></td></tr>
      <tr><td><code>Supplier&lt;T&gt;</code></td><td><code>get() → T</code></td><td>lazy creation</td></tr>
      <tr><td><code>BinaryOperator&lt;T&gt;</code></td><td><code>apply(T,T) → T</code></td><td><code>reduce()</code></td></tr>
    </table>

    <h3 class="sub-title">Lambda Expressions</h3>
    <pre>Runnable r = () -> System.out.println("hi");
Predicate&lt;String&gt; isEmpty = s -> s.isEmpty();
Function&lt;Integer, Integer&gt; square = x -> x * x;</pre>

    <h3 class="sub-title">Method References</h3>
    <pre>Function&lt;String, Integer&gt; parse = Integer::parseInt;  // static
Consumer&lt;String&gt; print = System.out::println;          // instance on type
Supplier&lt;ArrayList&gt; factory = ArrayList::new;          // constructor</pre>

    <h3 class="sub-title">Streams <span class="interview-tag">interview</span></h3>
    <p>A pipeline to process data — lazy, functional, single-use, sequential or parallel.</p>
    <pre>List&lt;String&gt; result = names.stream()
    .filter(n -> n.startsWith("A"))   // intermediate (lazy)
    .map(String::toUpperCase)         // intermediate (lazy)
    .sorted()                          // intermediate (lazy)
    .collect(Collectors.toList());     // terminal (triggers execution)</pre>
    <div class="grid-2">
      <div class="card">
        <div class="card-title">Intermediate (lazy)</div>
        <ul>
          <li><code>filter()</code>, <code>map()</code>, <code>flatMap()</code></li>
          <li><code>sorted()</code>, <code>distinct()</code></li>
          <li><code>limit(n)</code>, <code>skip(n)</code>, <code>peek()</code></li>
        </ul>
      </div>
      <div class="card">
        <div class="card-title">Terminal (eager)</div>
        <ul>
          <li><code>collect()</code>, <code>forEach()</code></li>
          <li><code>reduce()</code>, <code>count()</code></li>
          <li><code>findFirst()</code>, <code>anyMatch()</code>, <code>min()</code>, <code>max()</code></li>
        </ul>
      </div>
    </div>
    <p>Use <code>.parallelStream()</code> to process using the ForkJoin common pool.</p>
  </section>

  <!-- IO -->
  <section id="io">
    <h2 class="section-title"><span class="num">7</span> I/O &amp; NIO</h2>
    <table>
      <tr><th>Byte Streams</th><th>Character Streams</th></tr>
      <tr><td>Raw binary data (images, audio)</td><td>Text data</td></tr>
      <tr><td><code>FileInputStream</code>, <code>FileOutputStream</code></td><td><code>FileReader</code>, <code>FileWriter</code></td></tr>
      <tr><td><code>BufferedInputStream/OutputStream</code></td><td><code>BufferedReader</code>, <code>BufferedWriter</code></td></tr>
    </table>
    <p><strong>Buffering:</strong> Reading directly from <code>FileReader</code> makes an OS call per character — slow. Wrapping in <code>BufferedReader</code> reads a large chunk into RAM and serves from buffer — much faster.</p>
    <pre>BufferedReader br = new BufferedReader(new FileReader("file.txt"));</pre>
    <h3 class="sub-title">Java NIO</h3>
    <ul>
      <li>Uses <strong>Buffers</strong> and <strong>Channels</strong> instead of streams</li>
      <li><strong>Channel</strong> — bidirectional (read AND write), unlike streams</li>
      <li>Supports <strong>non-blocking</strong> I/O — crucial for high-throughput servers</li>
    </ul>
  </section>

  <!-- THREADS -->
  <section id="threads">
    <h2 class="section-title"><span class="num">8</span> Multithreading &amp; Concurrency</h2>

    <h3 class="sub-title">Process vs Thread</h3>
    <ul>
      <li><strong>Process</strong> — running instance of a program, own memory space</li>
      <li><strong>Thread</strong> — unit of execution inside a process. Threads share heap but each has its own stack</li>
    </ul>

    <h3 class="sub-title">Creating Threads <span class="interview-tag">interview</span></h3>
    <pre>// 1. Extend Thread
class MyThread extends Thread { public void run() { ... } }
new MyThread().start();

// 2. Implement Runnable (preferred)
Thread t = new Thread(() -> System.out.println("running"));
t.start();

// 3. Callable (returns value, can throw checked exceptions)
Future&lt;Integer&gt; f = executor.submit(() -> computeResult());</pre>
    <div class="callout info"><code>run()</code> runs on the SAME thread. <code>start()</code> spawns a NEW thread then calls <code>run()</code> inside it.</div>

    <h3 class="sub-title">Thread Attributes &amp; States</h3>
    <p>States: <code>NEW → RUNNABLE → BLOCKED/WAITING/TIMED_WAITING → TERMINATED</code></p>
    <ul>
      <li><code>priority</code>: MIN=1, NORM=5, MAX=10 — just a hint, not guaranteed</li>
      <li><strong>Daemon thread</strong> — automatically killed when all non-daemon threads finish</li>
    </ul>

    <h3 class="sub-title">Key Thread Methods <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Method</th><th>Description</th></tr>
      <tr><td><code>start()</code></td><td>Spawns new thread, calls run()</td></tr>
      <tr><td><code>sleep(ms)</code></td><td>Pauses while HOLDING the lock</td></tr>
      <tr><td><code>wait()</code></td><td>RELEASES the lock and waits for notify()</td></tr>
      <tr><td><code>notify()</code></td><td>Wakes one waiting thread</td></tr>
      <tr><td><code>notifyAll()</code></td><td>Wakes all waiting threads</td></tr>
      <tr><td><code>join()</code></td><td>Current thread waits until this thread finishes</td></tr>
      <tr><td><code>interrupt()</code></td><td>Signals thread to stop (doesn't force it)</td></tr>
      <tr><td><code>isInterrupted()</code></td><td>Checks interrupt flag, does NOT clear it</td></tr>
      <tr><td><code>interrupted()</code></td><td>Checks interrupt flag AND clears it</td></tr>
      <tr><td><code>yield()</code></td><td>Hint to CPU to pick another thread (not guaranteed)</td></tr>
    </table>

    <h3 class="sub-title">Synchronization Tools <span class="interview-tag">interview</span></h3>
    <div class="card"><div class="card-title">synchronized keyword</div>
      <p>Monitor lock. Each synchronized block locks the object (or class for static). Auto-releases on exit.</p>
    </div>
    <div class="card"><div class="card-title">volatile</div>
      <p>Guarantees visibility only (reads from main memory, not CPU cache). Does NOT guarantee atomicity.</p>
    </div>
    <div class="card"><div class="card-title">ReentrantLock</div>
      <p>Manual <code>lock()</code>/<code>unlock()</code>, fair mode (FIFO), <code>tryLock()</code>. Can lock multiple times without deadlocking yourself. Supports <code>Condition</code> for fine-grained waiting (<code>await()</code>/<code>signal()</code>).</p>
    </div>
    <div class="card"><div class="card-title">Atomic Classes</div>
      <p>Lock-free, CPU-level CAS: <code>AtomicInteger</code>, <code>AtomicLong</code>, <code>AtomicReference</code>. Best for counters and simple shared state.</p>
    </div>
    <div class="card"><div class="card-title">Other Synchronizers</div>
      <ul>
        <li><strong>ReadWriteLock</strong> — multiple readers OR one writer at a time</li>
        <li><strong>Semaphore</strong> — limits N threads at a time (<code>acquire()</code>/<code>release()</code>)</li>
        <li><strong>CountDownLatch</strong> — wait until count reaches zero; one-time use</li>
        <li><strong>CyclicBarrier</strong> — group of threads wait for each other; reusable</li>
        <li><strong>Exchanger</strong> — two threads exchange data at a sync point</li>
        <li><strong>ThreadLocal</strong> — variable per thread, isolated copy per thread</li>
      </ul>
    </div>

    <h3 class="sub-title">Thread Pool &amp; Executor Framework <span class="interview-tag">interview</span></h3>
    <p>Instead of creating a new thread per task (expensive — ~1-2ms + 1MB stack), use a pool of ready threads.</p>
    <div class="tree">
Executor (interface)
  └── ExecutorService (interface)
        └── ThreadPoolExecutor  ← real engine
              └── ScheduledThreadPoolExecutor
    </div>
    <table>
      <tr><th>Factory Method</th><th>Description</th></tr>
      <tr><td><code>newFixedThreadPool(n)</code></td><td>Exactly n threads, queue remaining tasks</td></tr>
      <tr><td><code>newCachedThreadPool()</code></td><td>Creates threads as needed, reuses idle ones</td></tr>
      <tr><td><code>newSingleThreadExecutor()</code></td><td>One thread, sequential</td></tr>
      <tr><td><code>newScheduledThreadPool(n)</code></td><td>Scheduled/recurring tasks</td></tr>
      <tr><td><code>newVirtualThreadPerTaskExecutor()</code></td><td>Java 21 — lightweight, ideal for I/O-bound</td></tr>
    </table>

    <h3 class="sub-title">Virtual Threads (Java 21+)</h3>
    <p>When a virtual thread blocks (I/O, sleep), its state (TCB) is saved in memory and the OS thread picks up another virtual thread. Millions of concurrent tasks with a small OS thread pool.</p>
    <div class="callout success">Spring Boot 3.2+: <code>spring.threads.virtual.enabled=true</code></div>

    <h3 class="sub-title">CompletableFuture <span class="interview-tag">interview</span></h3>
    <p><code>Future</code> problems: blocks, no chaining, no combining, ugly error handling. <code>CompletableFuture</code> solves all of this.</p>
    <pre>CompletableFuture.supplyAsync(() -> fetchUser())
    .thenApply(user -> user.getName())
    .exceptionally(e -> "fallback")
    .thenAccept(System.out::println);</pre>
    <table>
      <tr><th>Method</th><th>Purpose</th></tr>
      <tr><td><code>supplyAsync()</code></td><td>Async start with return value</td></tr>
      <tr><td><code>thenApply()</code></td><td>Transform result (like map)</td></tr>
      <tr><td><code>thenAccept()</code></td><td>Consume result, no return</td></tr>
      <tr><td><code>thenCompose()</code></td><td>Chain futures (like flatMap)</td></tr>
      <tr><td><code>thenCombine()</code></td><td>Combine two parallel futures</td></tr>
      <tr><td><code>allOf()</code></td><td>Wait for ALL</td></tr>
      <tr><td><code>anyOf()</code></td><td>Use FIRST to finish</td></tr>
      <tr><td><code>exceptionally()</code></td><td>Catch and provide fallback</td></tr>
    </table>

    <h3 class="sub-title">Fork/Join Framework</h3>
    <p>Designed for CPU-bound recursive divide-and-conquer. Uses <strong>work-stealing</strong>: idle threads steal tasks from the back of busy threads' deques.</p>
    <pre>Long result = ForkJoinPool.commonPool().invoke(myRecursiveTask);</pre>
    <div class="callout info">CompletableFuture.supplyAsync() uses the common ForkJoin pool by default.</div>

    <h3 class="sub-title">When to Use Which <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Scenario</th><th>Best Choice</th></tr>
      <tr><td>I/O-bound (DB, HTTP, file)</td><td>Virtual threads</td></tr>
      <tr><td>CPU-bound computation</td><td>Fixed thread pool (sized to CPU cores)</td></tr>
      <tr><td>Recursive divide &amp; conquer</td><td>Fork/Join</td></tr>
      <tr><td>Collection processing</td><td>Parallel streams</td></tr>
      <tr><td>Async pipelines, chaining</td><td>CompletableFuture</td></tr>
      <tr><td>Scheduled/recurring tasks</td><td>ScheduledThreadPoolExecutor</td></tr>
    </table>

    <h3 class="sub-title">Deadlock, Race Condition &amp; Livelock <span class="interview-tag">interview</span></h3>
    <ul>
      <li><strong>Race condition</strong> — two threads access shared mutable data concurrently; result depends on timing</li>
      <li><strong>Deadlock</strong> — Thread A holds lock 1, waits for lock 2. Thread B holds lock 2, waits for lock 1. Both wait forever</li>
      <li><strong>Starvation</strong> — a thread never gets CPU time because higher-priority threads always run first</li>
      <li><strong>Livelock</strong> — threads keep reacting to each other but neither makes progress</li>
    </ul>
  </section>

  <!-- JDBC -->
  <section id="jdbc">
    <h2 class="section-title"><span class="num">9</span> JDBC &amp; Databases</h2>
    <h3 class="sub-title">JDBC Hierarchy</h3>
    <table>
      <tr><th>Component</th><th>Role</th></tr>
      <tr><td><code>Driver</code></td><td>Connects to the database</td></tr>
      <tr><td><code>Connection</code></td><td>Represents one DB connection</td></tr>
      <tr><td><code>Statement</code></td><td>Executes SQL — <strong>never use</strong> (SQL injection)</td></tr>
      <tr><td><code>PreparedStatement</code></td><td>Safe parameterized SQL — always use ✅</td></tr>
      <tr><td><code>CallableStatement</code></td><td>Executes stored procedures</td></tr>
      <tr><td><code>ResultSet</code></td><td>Holds query results, iterated row by row</td></tr>
    </table>

    <h3 class="sub-title">JDBC Driver Types</h3>
    <table>
      <tr><th>Type</th><th>Status</th></tr>
      <tr><td>Type 1 — JDBC-ODBC Bridge</td><td>Dead (removed Java 8)</td></tr>
      <tr><td>Type 2 — Native C/C++ library</td><td>Rarely used</td></tr>
      <tr><td>Type 3 — Middleware server</td><td>Enterprise only</td></tr>
      <tr><td>Type 4 — Pure Java → DB directly</td><td>✅ Everyone uses this</td></tr>
    </table>

    <h3 class="sub-title">DriverManager vs DataSource <span class="interview-tag">interview</span></h3>
    <ul>
      <li><strong>DriverManager</strong> — creates new connection every call (50–200ms). Testing only.</li>
      <li><strong>DataSource</strong> — borrows from a connection pool (near instant). Always use in production.</li>
    </ul>

    <h3 class="sub-title">Raw JDBC Flow</h3>
    <pre>try (Connection conn = dataSource.getConnection();
     PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
    stmt.setInt(1, userId);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        String name = rs.getString("name");
    }
} // auto-closed ✅</pre>

    <h3 class="sub-title">SQL Key Concepts <span class="interview-tag">interview</span></h3>
    <ul>
      <li><strong>INNER JOIN</strong> — only matching rows in both tables</li>
      <li><strong>LEFT JOIN</strong> — all from left, matched from right (null if no match)</li>
      <li><strong>RIGHT JOIN</strong> — all from right, matched from left</li>
      <li><strong>FULL JOIN</strong> — all from both, null where no match</li>
      <li><strong>GROUP BY</strong> — must pair with aggregate: COUNT, SUM, AVG, MAX, MIN</li>
      <li><strong>HAVING</strong> — filter on aggregate results (like WHERE but after GROUP BY)</li>
      <li><strong>Indexes</strong> — speed up reads, slow down writes; B-tree by default</li>
    </ul>
  </section>

  <!-- WEB -->
  <section id="web">
    <h2 class="section-title"><span class="num">10</span> Web, Servlets &amp; Java Files</h2>
    <h3 class="sub-title">Tomcat</h3>
    <p>Web server + servlet container. Listens for HTTP, parses to <code>HttpServletRequest</code>/<code>HttpServletResponse</code>, routes to correct servlet, manages servlet lifecycle (<code>init → service → destroy</code>), manages thread pool.</p>
    <div class="callout danger">One servlet instance, many threads — instance variables are shared. Must be thread-safe!</div>

    <h3 class="sub-title">Java File Types <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>File</th><th>What It Is</th></tr>
      <tr><td><code>.java</code></td><td>Source code you write</td></tr>
      <tr><td><code>.class</code></td><td>Compiled bytecode (after javac)</td></tr>
      <tr><td><code>.jar</code></td><td>ZIP of .class files — your app or library</td></tr>
      <tr><td><code>.war</code></td><td>JAR for web apps — deployed to Tomcat</td></tr>
      <tr><td><code>.ear</code></td><td>ZIP of WARs+JARs — enterprise, deployed to JBoss/WildFly</td></tr>
      <tr><td><code>.pom</code></td><td>Maven config — dependencies and build settings</td></tr>
    </table>
    <p><strong>Spring Boot fat jar</strong> — embeds Tomcat inside the JAR. Run with <code>java -jar myapp.jar</code>. No external Tomcat needed.</p>

    <h3 class="sub-title">Full Request Flow</h3>
    <div class="tree">
Browser → HTTP
  ↓
Nginx (SSL, static files, load balancing)
  ↓
Tomcat (HTTP → HttpServletRequest, routes to Servlet)
  ↓
Repository
  ↓
Connection Pool (HikariCP)
  ↓
JDBC PreparedStatement
  ↓
Type 4 Driver → Database
  ↓
ResultSet → Java Object (JdbcTemplate / JPA Hibernate)
  ↓
Jackson → JSON
  ↓
Tomcat → HTTP Response → Browser
    </div>
  </section>

  <!-- SOLID -->
  <section id="solid">
    <h2 class="section-title"><span class="num">11</span> SOLID Principles</h2>
    <div class="card"><div class="card-title">S — Single Responsibility</div>
      <p>One class = one reason to change. Ask: "How many reasons do I have to change this class?" More than one → split it.<br>
      ❌ User class handles data AND sends emails → ✅ User + EmailService</p>
    </div>
    <div class="card"><div class="card-title">O — Open/Closed</div>
      <p>Open for extension, closed for modification. Multiple if/else checking types → violation. Add new class, don't touch existing code.<br>
      ❌ if shape == "circle" / "square" → ✅ Shape interface → Circle, Square implement it</p>
    </div>
    <div class="card"><div class="card-title">L — Liskov Substitution <span class="interview-tag">interview</span></div>
      <p>Subclasses must be fully replaceable by their parent without breaking behavior.<br>
      ❌ Bird → fly(), but Penguin extends Bird can't fly → ✅ Split into FlyableBird and base Bird<br>
      <em>"If swapping child for parent breaks it → LSP violated."</em></p>
    </div>
    <div class="card"><div class="card-title">I — Interface Segregation</div>
      <p>Don't force classes to implement methods they don't need. Break fat interfaces into thin focused ones.<br>
      ❌ Animal with eat(), fly(), swim() → ✅ Eatable, Flyable, Swimmable — let classes implement what they need</p>
    </div>
    <div class="card"><div class="card-title">D — Dependency Inversion</div>
      <p>High-level modules should not depend on low-level modules. Both depend on abstractions. Never reference concrete classes directly — use interfaces.<br>
      ❌ UserService creates EmailService internally → ✅ UserService(NotificationSender sender) — inject the interface, swap EmailService with SMSService freely</p>
    </div>
  </section>

  <!-- DESIGN PATTERNS -->
  <section id="patterns">
    <h2 class="section-title"><span class="num">12</span> Design Patterns</h2>
    <p>Common, proven solutions engineers reached after facing the same problems repeatedly. Best practices for recurring scenarios.</p>
    <div class="grid-2">
      <div class="card"><div class="card-title">Creational</div><p>How objects are created. Singleton, Builder, Prototype, Factory, Abstract Factory.</p></div>
      <div class="card"><div class="card-title">Structural</div><p>How classes/objects are composed. Adapter, Facade, Proxy, Decorator.</p></div>
    </div>
    <div class="card"><div class="card-title">Behavioral</div><p>How objects communicate and behave. Chain of Responsibility, Observer, Strategy, Command, etc.</p></div>

    <h3 class="sub-title">Singleton — Creational</h3>
    <p>One instance only across the entire app. Thread-safe version uses double-checked locking:</p>
    <pre>private static volatile Singleton instance;

public static Singleton getInstance() {
    if (instance == null) {                  // first check (no lock — performance)
        synchronized (Singleton.class) {
            if (instance == null) {          // second check (handles race)
                instance = new Singleton();
            }
        }
    }
    return instance;
}</pre>
    <p>volatile ensures threads don't read a stale cached value. Examples: DB connection pool, config manager, logger.</p>

    <h3 class="sub-title">Builder — Creational</h3>
    <p>For objects with many constructor parameters. Readable, self-documenting, fluent API.</p>
    <pre>User user = new User.Builder()
    .name("ahmed").age(25).city("cairo").role("admin").build();</pre>

    <h3 class="sub-title">Prototype — Creational</h3>
    <p>Copy an existing object instead of creating from scratch when creation is expensive. Implement <code>Cloneable</code> and override <code>clone()</code>.</p>
    <ul>
      <li><strong>Shallow copy</strong> — copies primitive values and references (nested objects still shared)</li>
      <li><strong>Deep copy</strong> — recursively copies nested objects too</li>
    </ul>

    <h3 class="sub-title">Factory &amp; Abstract Factory — Creational</h3>
    <p><strong>Factory</strong> — separates "which class to create" from the caller. Returns via interface so caller never knows the concrete class.</p>
    <p><strong>Abstract Factory</strong> — factory of factories. For families of related objects that must go together (e.g., DarkTheme → DarkButton, DarkTextBox, DarkCheckbox).</p>
    <table>
      <tr><th>Factory</th><th>Abstract Factory</th></tr>
      <tr><td>One product category; if/else returns an object</td><td>Families of products; if/else returns a factory</td></tr>
    </table>

    <h3 class="sub-title">Structural Patterns — Quick Comparison <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Pattern</th><th>Purpose</th><th>Key Mechanic</th></tr>
      <tr><td>Adapter</td><td>Convert incompatible interface</td><td>Implements YOUR interface + holds OLD service as composition</td></tr>
      <tr><td>Facade</td><td>Simplify complex operations</td><td>One method calls MULTIPLE services in order</td></tr>
      <tr><td>Proxy</td><td>Control access to one service</td><td>Both proxy and real implement SAME interface; proxy intercepts</td></tr>
      <tr><td>Decorator</td><td>Add behavior without subclassing</td><td>Implements AND takes SAME interface; stackable</td></tr>
    </table>
    <div class="callout info">All four use composition over inheritance, wrap something without changing the original, and hide complexity from the caller.</div>
    <pre>// Decorator — Java IO is the classic example
new BufferedReader(new FileReader("file.txt"));
// BufferedReader decorates FileReader — adds buffering on top

// Stackable decorators
Pizza p = new CheeseDecorator(new ChocolateDecorator(new PlainPizza()));
p.getPrice(); // sums all layers automatically ✅</pre>

    <h3 class="sub-title">Chain of Responsibility — Behavioral</h3>
    <p>Request passes through a chain of handlers. Each handler checks its part — if OK, passes to next; otherwise stops. No handler needs to know the full chain.</p>
    <pre>employee.setNext(manager);
manager.setNext(finance);
finance.setNext(borrowHandler);
employee.handle(request); // starts the chain</pre>
    <p>Real world: Servlet Filters, Spring Security filter chain, logging levels (DEBUG→INFO→WARN→ERROR), Express middleware.</p>

    <h3 class="sub-title">Observer — Behavioral</h3>
    <p>One subject → many subscribers. When something happens, all subscribers are notified automatically. They are fully decoupled from each other.</p>
    <pre>Topic topic = new Topic();
topic.subscribe(new EmailSubscriber());
topic.subscribe(new SMSSubscriber());
topic.notify("order placed"); // both notified ✅</pre>
    <p>Real world: Java EventListener, Kafka topics + consumers, Spring @EventListener, React state management.</p>

    <h3 class="sub-title">Chain vs Observer <span class="interview-tag">interview</span></h3>
    <table>
      <tr><th>Chain of Responsibility</th><th>Observer</th></tr>
      <tr><td>One request, passes sequentially</td><td>One event, notifies all simultaneously</td></tr>
      <tr><td>Chain can stop early</td><td>All subscribers always notified</td></tr>
      <tr><td>Each handler knows only the next</td><td>Subscribers fully decoupled from each other</td></tr>
    </table>
    <div class="callout info">Both decouple the sender from receiver ✅</div>
  </section>

  <!-- INTERVIEW GOTCHAS -->
  <section id="interview">
    <h2 class="section-title" style="color: var(--accent3);">🔴 Interview Gotchas &amp; Tricky Topics</h2>
    <div class="callout danger">These are the most commonly failed topics in Java interviews. Study these carefully.</div>
    <div class="card"><div class="card-title">1. Exception catching order</div>
      <p>Specific exceptions MUST come before general ones. If <code>Exception</code> comes before <code>IOException</code>, compiler says "unreachable code". <code>Error</code> is NOT caught by <code>catch(Exception e)</code> — need <code>catch(Throwable t)</code>.</p>
    </div>
    <div class="card"><div class="card-title">2. finally with return</div>
      <p>If both <code>try</code> and <code>finally</code> have a <code>return</code>, the <code>finally</code> return wins — the try return is silently discarded.</p>
    </div>
    <div class="card"><div class="card-title">3. String == vs .equals()</div>
      <p><code>==</code> compares references. <code>.equals()</code> compares content. <code>new String("hello") == "hello"</code> is <code>false</code>. Always use <code>.equals()</code>.</p>
    </div>
    <div class="card"><div class="card-title">4. Pass-by-value with objects</div>
      <p>Java is always pass-by-value. For objects, the value is the reference. Method can mutate the object internally but cannot reassign the caller's variable — reassignment inside the method doesn't affect the original reference.</p>
    </div>
    <div class="card"><div class="card-title">5. Diamond problem</div>
      <p>Java classes can't extend multiple classes — ambiguity when both parents have the same method signature. Interfaces solve this by requiring the implementing class to override the conflicting method.</p>
    </div>
    <div class="card"><div class="card-title">6. equals() + hashCode() contract</div>
      <p>If <code>equals()</code> says two objects are equal, they MUST have the same hashCode. HashMap uses hashCode to find the bucket, then equals to find the key. Overriding only equals silently breaks collections.</p>
    </div>
    <div class="card"><div class="card-title">7. Integer cache trap</div>
      <p>Integer caches -128 to 127. <code>Integer a = 127; Integer b = 127; a == b</code> is <code>true</code>. But <code>Integer a = 200; Integer b = 200; a == b</code> is <code>false</code>. Always use <code>.equals()</code> for Integer comparison.</p>
    </div>
    <div class="card"><div class="card-title">8. String immutability &amp; memory</div>
      <p>Every modification creates a new String object. String concatenation in a loop creates O(n) objects. Always use <code>StringBuilder</code> for building strings in loops.</p>
    </div>
    <div class="card"><div class="card-title">9. volatile in Singleton</div>
      <p>Without <code>volatile</code>, a thread can see a partially constructed object due to CPU instruction reordering. <code>volatile</code> ensures full visibility across threads.</p>
    </div>
    <div class="card"><div class="card-title">10. ConcurrentModificationException</div>
      <p>Modifying a collection while iterating it throws this exception. Use <code>Iterator.remove()</code>, or collect what to remove and do it after the loop, or use fail-safe collections like <code>CopyOnWriteArrayList</code>.</p>
    </div>
    <div class="card"><div class="card-title">11. sleep() vs wait()</div>
      <p><code>sleep()</code> pauses the thread but keeps the lock. <code>wait()</code> pauses the thread AND releases the lock — allowing others to enter the synchronized block. <code>wait()</code> must be called from within a synchronized block.</p>
    </div>
    <div class="card"><div class="card-title">12. Shallow vs Deep Copy</div>
      <p><strong>Shallow</strong> — copies the object, nested references still point to originals (shared). <strong>Deep</strong> — recursively copies everything; fully independent. Default <code>clone()</code> is shallow.</p>
    </div>
    <div class="card"><div class="card-title">13. Variable shadowing</div>
      <p>A local variable with the same name as an instance field "shadows" the field in its scope. Use <code>this.field</code> to access the instance field. Easy source of bugs.</p>
    </div>
    <div class="card"><div class="card-title">14. Octal literals</div>
      <p>In Java, a number starting with <code>0</code> is octal (base 8). <code>053</code> = 5×8 + 3 = 43 decimal. Easy to confuse in interview trick questions.</p>
    </div>
  </section>

</main>
</body>
</html>
"""

with open(path, "r") as f:
    content = f.read()

old_closing = "</main>\n</body>\n</html>"
new_content = content.replace(old_closing, sections)

with open(path, "w") as f:
    f.write(new_content)

print("Done!")
print(f"Final size: {len(new_content):,} bytes")
