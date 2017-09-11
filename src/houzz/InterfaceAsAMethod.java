package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : InterfaceAsAMethod
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class InterfaceAsAMethod {

    /**
     * callback function
     你到一个商店买东西，刚好你要的东西没有货，于是你在店员那里留下了你的电话，过了几天店里有货了，店员就打了你的电话，
     然后你接到电话后就到店里去取了货。在这个例子里，你的电话号码就叫回调函数，你把电话留给店员就叫登记回调函数，
     店里后来有货了叫做触发了回调关联的事件，店员给你打电话叫做调用回调函数，你到店里去取货叫做响应回调事件。回答完毕。

     作者：常溪玲
     链接：https://www.zhihu.com/question/19801131/answer/13005983
     来源：知乎
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


     if you want to buy a keyboard and go shopping, but shop doesn't have keyboard you want,
     so the salesperson get your phone number. Then two days later, the salesperson call you, you come back
     shop and buy it.
     In this case, the phone number is callback function, the salesperson call you, is use the callback function

     */
    interface CallHello {
        void callHelloMethod();
    }
    static class CallHelloClass implements CallHello {

        @Override
        public void callHelloMethod() {
            System.out.println("hello world");
        }
    }

    static class Controller {

        private CallHello callHello;
        private boolean isHello;

        public Controller(CallHello callHello) {
            isHello = true;
            this.callHello = callHello;
        }
        public void printHello() {
            callHello.callHelloMethod();
        }
    }

    public static void main(String[] args) {
        CallHelloClass callHelloClass = new CallHelloClass();
        Controller controller = new Controller(callHelloClass);
        controller.printHello();
    }
}
