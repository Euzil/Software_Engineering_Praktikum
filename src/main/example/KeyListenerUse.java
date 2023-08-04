package tnt.example;

import java.awt.*;
import javax.swing.*;
class KeyListenerUse{
    public KeyListenerUse() {
        JFrame jFrame = new JFrame("键盘监听");
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 获取键值，和 KeyEvent.VK_XXXX 常量比较确定所按下的按键
                System.out.println("按下: " + e.getKeyCode() + "，键值为：" + e.getKeyCode());
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // e.getKeyChar() 获取键入的字符
                System.out.println("键入: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("释放: " + e.getKeyCode());
            }
        });
        jFrame.setVisible(true);
    }
}
