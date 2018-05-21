package jvm.classloading;

/**
 * @Author pierre.chen
 * @Date 18-5-20
 */
class Candy {

    static {
        System.out.println("Loading Candy ");
    }
}

class Gum {

    static {
        System.out.println("Loading Gum ");
    }
}

class Cookie {

    static {
        System.out.println("Loading Cookie");
    }
}

public class StaticInit {


    public static void main(String[] args) {
//        System.out.println("inside main");
//        new Candy();
//        System.out.println("After creating Candy ");
//        Class.forName("jvm.classloading.Gum");
//        System.out.println("After Class.forName(\"Gum\")");
        Cookie cookie = new Cookie();
        System.out.println(Cookie.class.isInstance(cookie));
//        System.out.println("After creating Cookie");
    }

}



