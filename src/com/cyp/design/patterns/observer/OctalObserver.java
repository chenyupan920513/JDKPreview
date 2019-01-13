package cyp.design.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author pierre.chen
 * <url>http://www.runoob.com/design-pattern/observer-pattern.html</url>
 * @Date 18-5-19
 */
public class OctalObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        com.cyp.design.patterns.observer.Subject subject = (com.cyp.design.patterns.observer.Subject) o;
        System.out.println("Octal String: "
                + Integer.toOctalString(subject.getState()));
    }
}
