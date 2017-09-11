package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : OOP
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class OOP {
    /*
    OOP : encapsulation Inheritance Polymorphism

    Define Inheritance?
    It is the process where one object acquires the properties of another. With the use of inheritance the information is made manageable in a hierarchical order

    What is Polymorphism?
    Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.

    What is Encapsulation?
    It is the technique of making the fields in a class private and providing access to the fields via public methods. If a field is declared private, it cannot be accessed by anyone outside the class, thereby hiding the fields within the class. Therefore encapsulation is also referred to as data hiding.

    What is an Interface?
    An interface is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.
        Give some features of Interface? It includes −
            Interface cannot be instantiated
            An interface does not contain any constructors. All of the methods in an interface are abstract.

    Explain garbage collection in Java?
    It uses garbage collection to free the memory. By cleaning those objects that is no longer reference by any of the program.

    What is Abstraction?
    It refers to the ability to make a class abstract in OOP. It helps to reduce the complexity and also improves the maintainability of the system.

    What is Abstract class?
    These classes cannot be instantiated and are either partially implemented or not at all implemented. This class contains one or more abstract methods which are simply method declarations without a body.

    When Abstract methods are used?
    If you want a class to contain a particular method but you want the actual implementation of that method to be determined by child classes, you can declare the method in the parent class as abstract.

    What is a static variable?
    Class variables also known as static variables are declared with the static keyword in a class,
    but outside a method, constructor or a block.

    Why is String class considered immutable?
    The String class is immutable, so that once it is created a String object cannot be changed. Since String is immutable it can safely be shared between many threads ,which is considered very important for multithreaded programming.

    Why is StringBuffer called mutable?
    The String class is considered as immutable, so that once it is created a String object cannot be changed. If there is a necessity to make alot of modifications to Strings of characters then StringBuffer should be used.

    What is the difference between StringBuffer and StringBuilder class?
    Use StringBuilder whenever possible because it is faster than StringBuffer. But, if thread safety is necessary then use StringBuffer objects.

    What is finalize method?
    It is possible to define a method that will be called just before an object's final destruction by the garbage collector. This method is called finalize, and it can be used to ensure that an object terminates cleanly.

    What is an Exception?
    An exception is a problem that arises during the execution of a program. Exceptions are caught by handlers positioned along the thread's method invocation stack.

    When throws keyword is used?
    If a method does not handle a checked exception, the method must declare it using the
    throwskeyword. The throws keyword appears at the end of a method's signature.

    When throw keyword is used?
    An exception can be thrown, either a newly instantiated one or an exception that you just caught, by using throw keyword.

    What is function overloading?
    If a class has multiple functions by same name but different parameters, it is known as Method Overloading.

    What is function overriding?
    If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding.

    Difference between Overloading and Overriding?
    Method overloading increases the readability of the program. Method overriding provides the specific implementation of the method that is already provided by its super class parameter must be different in case of overloading, parameter must be same in case of overriding.

    What's the difference between constructors and other methods?
    Constructors must have the same name as the class and can not return a value. They are only called once while regular methods could be called many times.

    What is synchronization?
    Synchronization is the capability to control the access of multiple threads to shared resources. synchronized keyword in java provides locking which ensures mutual exclusive access of shared resource and prevent data race.

    What do you mean by Checked Exceptions?
    It is an exception that is typically a user error or a problem that cannot be foreseen by the programmer. For example, if a file is to be opened, but the file cannot be found, an exception occurs. These exceptions cannot simply be ignored at the time of compilation.

    Explain Runtime Exceptions?
    It is an exception that occurs that probably could have been avoided by the programmer. As opposed to checked exceptions, runtime exceptions are ignored at the time of compliation.

    Which are the two subclasses under Exception class?
    The Exception class has two main subclasses : IOException class and RuntimeException Class. When throws keyword is used?
    If a method does not handle a checked exception, the method must declare it using the
    throwskeyword. The throws keyword appears at the end of a method's signature.

    When throw keyword is used?
    An exception can be thrown, either a newly instantiated one or an exception that you just caught, by using throw keyword.

    How finally used under Exception Handling?
    The finally keyword is used to create a block of code that follows a try block. A finally block of code always executes, whether or not an exception has occurred.

     */
}
