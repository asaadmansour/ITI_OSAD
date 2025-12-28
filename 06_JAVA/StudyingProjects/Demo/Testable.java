public interface Testable {
    public Integer aa(Integer x,Integer y);
}
/* 
    we have funtional interface that is an interface that declare only one method and the class implementing
    the interface must implement the method

    java defined for us some functional interfaces ready to use 

    function<t,r> that accept a type and return a type
    consumer<t> that does not return
    predicate <t> returns t or f
    supplier<r> that return only
    Bifunction<t,u,r> accepts to values and return one
    Unary(t) one input return one output of same type "extends function"

    and each of them have defined methods to use 
    function have (apply,then,compose) //then chain after , compose chain before
    consumer (apply,then)
    predicate(and,or,negate)
    supplier(get)
    Bifunction(apply)
    Unary(apply)

    1. old way
    class demotest implements testable {
        public void test() {anybody}
    }
    2. anonymous class Bifunction
        testable t = new testable()
        {
            test() {
            anybody // so here that creates a class that implements interface and uses it's object
            and since it's a functional interface there is one method it's must implement and that is test

            }
        }
    3. lambda 
     testable t = () -> ;
        that basically do the same it creates an anonyms class and uses it's object and since it's also one mthod
        to be overriden the implementation we write is considered the override of the iterface method 
        method referencing can be used as a simpler input for lambdas so if for example we have
        toIntger in class Integer instead of defining that here again we just do () parser = Intger::toInteger and it
        passes the reference of the function to the lambda
        4.Streams use functional interfaces to define their behavior. For example .filter() uses Predicate<T> interface so when you write .filter(new Predicate<Integer>() { public boolean test(Integer n) { return n % 2 == 0; } }) the filter method internally calls the test() method from the Predicate you provide and if test() returns true the element passes through and if false it gets filtered out. Similarly .map() uses Function<T,R> and calls its apply() method to transform each element, .forEach() uses Consumer<T> and calls its accept() method to process each element, and .reduce() uses BinaryOperator<T> and calls its apply() method to combine elements.

        In streams we have a pipeline structure that works like Source → Intermediate Operations → Terminal Operation. The source is where we create the stream from a collection like list.stream() or Arrays.stream(array) or Stream.of(1,2,3). Then we have intermediate operations which transform or filter the stream and return a new Stream so they are chainable. They don't execute immediately (lazy evaluation) they wait until a terminal operation is called. Examples are .filter(Predicate) which filters elements and returns Stream<T>, .map(Function) which transforms elements and returns Stream<R>, .sorted() which sorts elements and returns Stream<T>, .distinct() which removes duplicates and returns Stream<T>, and .limit(n) which takes first n elements and returns Stream<T>. All of these return Stream so you can chain them like list.stream().filter(n -> n > 5).map(n -> n * 2).sorted().distinct().

        Then we have terminal operations which end the stream and produce a final result. They trigger the execution of all the intermediate operations. They return different types depending on what they do. Some return void like .forEach(Consumer) which just performs an action on each element. Some return Optional<T> because they might not have a value like .findFirst() which gets first element or empty if stream is empty, .findAny() which gets any element, .max(Comparator) which gets maximum element, .min(Comparator) which gets minimum element, and .reduce(BinaryOperator) which combines all elements into one. Some return collections like .collect(Collectors.toList()) which returns List<T>, .collect(Collectors.toSet()) which returns Set<T>, and .collect(Collectors.toMap()) which returns Map<K,V>. Some return primitives like .count() which returns long for number of elements, .anyMatch(Predicate) which returns boolean if any element matches, .allMatch(Predicate) which returns boolean if all elements match, and .noneMatch(Predicate) which returns boolean if no elements match.

        The key difference is intermediate operations return Stream so they are chainable and lazy, while terminal operations return other types and they end the stream and trigger execution. Also streams can contain null values so you need to filter them out using .filter(Objects::nonNull) before processing otherwise you get NullPointerException. And Optional is a container that may or may not contain a value so it's safer than null, and it has methods like .ifPresent(Consumer) to execute action if value exists, .orElse(T) to return value or default, and .map(Function) to transform value if present which returns Optional<R>.
*/
// OLD WAY (verbose):
// ├─ Define interface
// ├─ Create class implementing interface
// ├─ Override method
// └─ Create instance and use

// ANONYMOUS CLASS (less ve
// rbose):
// ├─ Define interface
// ├─ Create anonymous class inline
// └─ Override method

// LAMBDA (concise):
// ├─ Interface already exists (functional interface)
// └─ Write lambda expression

// METHOD REFERENCE (most concise):
// ├─ Interface already exists
// └─ Reference existing method

