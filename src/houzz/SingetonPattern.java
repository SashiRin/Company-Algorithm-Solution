package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : SingetonPattern
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SingetonPattern {
    /*

    The singleton pattern is a software design pattern that restricts the instantiation of a class to one object.
    This is useful when exactly one object is needed to coordinate actions across the system.

    In JAVA, first, ClassicSingleton employs a technique known as lazy instantiation to create the singleton; as a result,
    the singleton instance is not created until the getInstance() method is called for the first time.
    This technique ensures that singleton instances are created only when needed.

    我想说明下面几个Singleton的特点：（下面这些东西可能是尽人皆知的，没有什么新鲜的）

    私有（private）的构造函数（constructor），表明这个类是不可能形成实例了。这主要是怕这个类会有多个实例instance。
    即然这个类是不可能形成实例，那么，我们需要一个静态的方式让其形成实例：getInstance()。注意这个方法是在new自己，因为其可以访问私有的构造函数，所以他是可以保证实例被创建出来的。
    在getInstance()中，先做判断是否已形成实例，如果已形成则直接返回，否则创建实例。
    所形成的实例保存在自己类中的私有成员中。
    我们取实例时，只需要使用Singleton.getInstance()就行了

    仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，
    因此它只有在getInstance()被调用时才会真正创建；同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
    this solution is thread-safe without requiring special language constructs

    应用场景scenarios：You use a singleton when you need to manage a shared resource. For instance a printer spooler.
    Your application should only have a single instance of the spooler in order to avoid conflicting request for
    the same resource. Or a database connection or a file manager etc.
     */

    //Lazy initialization

    /*
    public final class Singleton {
        private static volatile Singleton instance = null;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized(Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    //Eager Singleton:
    //对第一行static的一些解释
    // java允许我们在一个类里面定义静态类。比如内部类（nested class）。
    //把nested class封闭起来的类叫外部类。
    //在java中，我们不能用static修饰顶级类（top level class）。
    //只有内部类可以为static。
    public class Singleton {
        //在自己内部定义自己的一个实例，只供内部调用
        private static final Singleton instance = new Singleton();
        private Singleton(){
            //do something
        }
        //这里提供了一个供外部访问本class的静态方法，可以直接访问
        public static Singleton getInstance(){
            return instance;
        }
    }


    //double-checked locking
    /*
    具体来说就是synchronized虽然保证了原子性，但却没有保证指令重排序的正确性，会出现A线程执行初始化，
    但可能因为构造函数里面的操作太多了，所以A线程的uniqueInstance实例还没有造出来，但已经被赋值了。而B线程这时过来了，
    错以为uniqueInstance已经被实例化出来，一用才发现uniqueInstance尚未被初始化。
    要知道我们的线程虽然可以保证原子性，但程序可能是在多核CPU上执行。
     */
    /*
    public class Singleton {
        private volatile static Singleton uniqueInstance;
        private Singleton(){}
        public static Singleton getInstance(){
            if(uniqueInstance == null){
                // B线程检测到uniqueInstance不为空
                synchronized(Singleton.class){
                    if(uniqueInstance == null){
                        uniqueInstance = new Singleton();
                        // A线程被指令重排了，刚好先赋值了；但还没执行完构造函数。
                    }
                }
            }
            return uniqueInstance;// 后面B线程执行时将引发：对象尚未初始化错误。
        }
    }*/
}
