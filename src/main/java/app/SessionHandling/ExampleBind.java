package app.SessionHandling;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class ExampleBind implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event){
        HttpSession session = event.getSession();
        System.out.println(" USER HAS LOGGED IN SUCCESSFULLY! ");
        System.out.println("The event name is " + event.getName() + " The even value is " + event.getValue() +
                " The session id is " + session.getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session destroyed");
        System.out.println("The event name is " + event.getName() + " The even value is " + event.getValue() +
                " The session id is " + session.getId());
        session.invalidate();
    }

}
