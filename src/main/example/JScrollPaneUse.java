package tnt.example;


import java.awt.*;
import javax.swing.*;
public class JScrollPaneUse {
    public JScrollPaneUse() {
        JFrame jFrame = new JFrame("面板窗口");

        // 创建文本区域组件
        JTextArea textArea = new JTextArea("这是一个文本");
        // 自动换行
        textArea.setLineWrap(true);
        // 设置字体
        textArea.setFont(new Font(null, Font.PLAIN, 18));

        // 初始化滚动面板面板
        /**
         * 全参构造参数说明：
         *     view: 需要滚动显示的视图组件
         *     vsbPolicy: 垂直滚动条的显示策略
         *         ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED    // 需要时显示（默认）
         *         ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER        // 从不显示
         *         ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS       // 总是显示
         *     hsbPolicy: 水平滚动条的显示策略
         *         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED  // 需要时显示（默认）
         *         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER      // 从不显示
         *         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS     // 总是显示
         * 常用方法
         *     设置滚动显示视图内容组件：setViewportView(Component view)
         *     设置垂直滚动条的显示策略：setVerticalScrollBarPolicy(int policy)
         *     设置水平滚动条的显示策略：setHorizontalScrollBarPolicy(int policy)
         */
        JScrollPane jScrollPane = new JScrollPane(
                textArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        jFrame.setContentPane(jScrollPane);

        // 窗口设置为公共代码，后面全部省略
        jFrame.setVisible(true);
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}