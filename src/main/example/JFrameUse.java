package tnt.example;


import java.awt.*;
import javax.swing.*;

public class JFrameUse {
    public static void main(String[] args) {
        // 初始化窗口
        JFrame jFrame = new JFrame("这个是窗口的标题");
        // 设置窗口的位置和大小
        jFrame.setBounds(400, 300, 500, 500);
        // 设置窗口的背景颜色
        jFrame.setBackground(new Color(175, 114, 114));
        // 设置窗口是否可见
        jFrame.setVisible(true);
        // 设置窗口是否可以缩放
        jFrame.setResizable(false);
        /**
         * 设置窗口的相对位置。
         * 如果 comp 整个显示区域在屏幕内, 则将窗口放置到 comp 的中心;
         * 如果 comp 显示区域有部分不在屏幕内, 则将该窗口放置在最接近 comp 中心的一侧;
         * comp 为 null, 表示将窗口放置到屏幕中心。
         */
        jFrame.setLocationRelativeTo(null);
        /**
         * 设置窗口关闭按钮点击后的默认操作, 参考值:
         *     WindowConstants.DO_NOTHING_ON_CLOSE: 不执行任何操作。
         *     WindowConstants.HIDE_ON_CLOSE: 隐藏窗口（不会结束进程）, 再次调用 setVisible(true) 将再次显示。
         *     WindowConstants.DISPOSE_ON_CLOSE: 销毁窗口, 如果所有可显示的窗口都被 DISPOSE, 则可能会自动结束进程。
         *     WindowConstants.EXIT_ON_CLOSE: 退出进程。
         */
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}