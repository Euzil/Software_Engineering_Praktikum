package tnt.example;

import java.awt.*;
import javax.swing.*;
class WindowListenerUse{
    public WindowListenerUse() {
        JFrame jFrame = new JFrame("窗口监听");
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口被关闭了");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口被激活了");
            }
        });
        jFrame.setVisible(true);
    }
}
