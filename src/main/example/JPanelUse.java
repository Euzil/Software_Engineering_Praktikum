package tnt.example;


import java.awt.*;
import javax.swing.*;


public class JPanelUse {
    public static void main(String[] args) {
        // 初始化窗口
        JFrame jFrame = new JFrame("面板窗口");
        jFrame.setVisible(true);
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 初始化面板：采用默认的流式布局或指定布局
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // 设置面板大小
        jPanel.setSize(100, 100);
        // 设置面板背景颜色
        jPanel.setBackground(new Color(175, 114, 114));
        // 将面板添加到窗口
        jFrame.add(jPanel);


        JButton jButton = new JButton("图片按钮", new ImageIcon("bj.jpg"));
        jButton.addActionListener(e -> {
            System.out.println("图片按钮被点击了");
        });
        jPanel.add(jButton);

    }
}
