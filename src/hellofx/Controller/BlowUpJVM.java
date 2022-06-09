package hellofx.Controller;

import hellofx.Controller.MusicControllers.ButtonSoundPlayController;
import hellofx.Controller.MusicControllers.MusicPlayController;
import javafx.fxml.FXML;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class BlowUpJVM {

    public static void testStackOverFlow() {
        BlowUpJVM.testStackOverFlow();
    }

    public static void testPergemOutOfMemory() {
        while (true) {
            final OOM oom = new OOM();
            Proxy.newProxyInstance(oom.getClass().getClassLoader(), oom.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    Object result = method.invoke(oom, args);
                    return result;
                }
            });
        }
    }

    public static void testStackOutOfMemory() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                    }
                }
            });
            thread.start();
        }
    }


    public static void testOutOfHeapMemory() {
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        while (true) {
            StringBuffer B = new StringBuffer();
            for (int i = 0; i < 10000; i++) {
                B.append(i);
            }
            list.add(B);
        }
    }


    @FXML
    public void outOfHeapMemory() {
        testOutOfHeapMemory();
    }

    @FXML
    public void outOfMemory() {
        testStackOutOfMemory();
    }

    @FXML
    public void pergemOutOfMemory() {
        testPergemOutOfMemory();
    }

    @FXML
    public void stackOverFlow() {
        testStackOverFlow();
    }

    @FXML
    public void trashToMap() throws IOException {
        ViewController.toMap();
        MusicPlayController.checkNowStage();
        ButtonSoundPlayController.buttonSoundPlay();
    }
}

class OOM {
    String abc;

    public OOM() {
        abc = new String("testPergemOutOfMemory");
    }
}
