package tnt.example;

import java.awt.*;
import javax.swing.*;
class MouseListenerUse {
    public MouseListenerUse() {
        JFrame jFrame = new JFrame("鼠标监听");
        JPanel jPanel = new JPanel();

        /**
         * 鼠标监听器
         */
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入组件区域");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("鼠标离开组建区域");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // 获取按下的坐标（相对于组件）
                System.out.println("相对组件" + e.getPoint() + "，横坐标：" + e.getX() + ", 纵坐标：" + e.getY());
                // 获取按下的坐标（相对于屏幕）
                System.out.println("相对屏幕" + e.getLocationOnScreen() + "，横坐标：" + e.getXOnScreen() + ", 纵坐标：" + e.getYOnScreen());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("鼠标释放");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // 鼠标在组件区域内按下并释放（中间没有移动光标）才识别为被点击
                System.out.println("鼠标点击");
            }
        });

        /**
         * 鼠标移动/拖动监听器
         */
        jPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 鼠标保持按下状态移动即为拖动
                System.out.println("鼠标拖动");
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("鼠标移动");
            }
        });


        /**
         * 鼠标滚轮监听器
         */
        jPanel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // e.getWheelRotation() 为滚轮滚动多少的度量
                System.out.println("mouseWheelMoved: " + e.getWheelRotation());
            }
        });

        // 省略公共代码
    }
}
