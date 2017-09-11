package houzz;

import sun.awt.Mutex;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : Thread
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ThreadProcess {
    /*
    进程线程区别
    What is the technical difference between a process and a thread?

    Both processes and threads are independent sequences of execution. The typical difference is that threads
    (of the same process) run in a shared memory space, while processes run in separate memory spaces.

    Processes

    A process has a self-contained execution environment. A process generally has a complete,
    private set of basic run-time resources; in particular, each process has its own memory space.

    Processes are often seen as synonymous with programs or applications. However, what the user
    sees as a single application may in fact be a set of cooperating processes.
    To facilitate communication between processes, most operating systems support Inter Process Communication (IPC)
    resources, such as pipes and sockets. IPC is used not just for communication between processes on the same system,
    but processes on different systems.

    Most implementations of the Java virtual machine run as a single process.
    A Java application can create additional processes using a ProcessBuilder object.
    Multiprocess applications are beyond the scope of this lesson.

    Threads

    Threads are sometimes called lightweight processes. Both processes and threads provide an
    execution environment, but creating a new thread requires fewer resources than creating a new process.

    Threads exist within a process — every process has at least one. Threads share the process's
    resources, including memory and open files. This makes for efficient, but potentially problematic, communication.

    Multithreaded execution is an essential feature of the Java platform. Every application has
    at least one thread — or several, if you count "system" threads that do things like memory management
    and signal handling. But from the application programmer's point of view, you start with just one thread,
    called the main thread. This thread has the ability to create additional threads, as we'll demonstrate
    in the next section.

    线程安全就是多线程访问时，采用了加锁机制，当一个线程访问该类的某个数据时，进行保护，其他线程不能进行访问直到该线程读取完，其他线程才可使用

    互斥锁Mutex
    A mutex object only allows one thread into a controlled section, forcing other threads which attempt to
     gain access to that section to wait until the first thread has exited from that section." Ref: Symbian
     Developer Library. (A mutex is really a semaphore with value 1.

     1.   Mutex是一个令牌，当一个线程拿到这个令牌时运行，另外想拿到令牌的线程就必须等待，直到拿到令牌的线程释放令牌。没有所有权的线程是无法释放令牌的。

     2.   Mutex（false，”string”）中的string是令牌的关键，或者可以叫令牌名，因为Mutex是跨进程的，整个系统中只会有唯一的令牌存在所以，
     也就是说你在一个应用程序中的一个线程中得到了Mutex的所有权，那在另外一个线程中的另外的线程想得到他就必须要等待。
     */

}
