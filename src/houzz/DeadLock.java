package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : DeadLock
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class DeadLock {
    /*
    https://baike.baidu.com/item/deadlock/6975805?fr=aladdin

    所谓死锁： 是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去。
    此时称系统处于死锁状态或系统产生了死锁，这些永远在互相等待的进程称为死锁进程。
    In an operating system, a deadlock occurs when a process or thread enters a waiting state because a requested
    system resource is held by another waiting process, which in turn is waiting for another resource held by another
    waiting process. If a process is unable to change its state indefinitely because the resources requested by it are
    being used by another waiting process, then the system is said to be in a deadlock

    死锁产生：这四个条件是死锁的必要条件，只要系统发生死锁，这些条件必然成立，而只要上述条件之不满足，就不会发生死锁
    Mutual exclusion: The resources involved must be unshareable; otherwise, the processes would not be prevented from using
       the resource when necessary. Only one process can use the resource at any given instant of time. [6]
    Hold and wait or resource holding: a process is currently holding at least one resource and
        requesting additional resources which are being held by other processes.
    No preemption: a resource can be released only voluntarily by the process holding it.
    Circular wait: each process must be waiting for a resource which is being held by another process,
       which in turn is waiting for the first process to release the resource. In general, there is a set of waiting
       processes, P = {P1, P2, …, PN}, such that P1 is waiting for a resource held by P2, P2 is waiting for a resource held
       by P3 and so on until PN is waiting for a resource held by P1

    预防（Detection）Resource preemption/Banker's Algorithm
    1、对它所必须使用的而且属于同一类的所有资源，必须一次申请完；
    2、在申请不同类资源时，必须按各类设备的编号依次申请。例如：进程PA，使用资源的顺序是R1，R2； 进程PB，使用资源的顺序是R1，R2；若采用动态分配有可能形成环路条件，造成死锁。
    采用有序资源分配法：R1的编号为1，R2的编号为2；
    PA：申请次序应是：R1，R2
    PB：申请次序应是：R1，R2
     */
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args){
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
    static class Lock1 implements Runnable{
        @Override
        public void run(){
            try{
                System.out.println("Lock1 running");
                while(true){
                    synchronized(DeadLock.obj1){
                        System.out.println("Lock1 lock obj1");
                        Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                        synchronized(DeadLock.obj2){
                            System.out.println("Lock1 lock obj2");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    static class Lock2 implements Runnable{
        @Override
        public void run(){
            try{
                System.out.println("Lock2 running");
                while(true){
                    synchronized(DeadLock.obj2){
                        System.out.println("Lock2 lock obj2");
                        Thread.sleep(3000);
                        synchronized(DeadLock.obj1){
                            System.out.println("Lock2 lock obj1");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
