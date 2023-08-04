package tnt.example;

import java.awt.*;
import javax.swing.*;

class JButtonAndRadioAndCheckBox {
    public JButtonAndRadioAndCheckBox() {
        JFrame jFrame = new JFrame("标签窗口");
        JPanel jPanel = new JPanel();

        /**
         * 普通图片按钮
         */
        JButton jButton = new JButton("图片按钮", new ImageIcon("bj.jpg"));
        jButton.addActionListener(e -> {
            System.out.println("图片按钮被点击了");
        });
        jPanel.add(jButton);

        /**
         * 单选按钮
         */
        // 创建按钮组，将单选按钮添加到该组，确保只能选择其一
        ButtonGroup buttonGroup = new ButtonGroup();
        // 创建单选按钮
        JRadioButton man = new JRadioButton("男");
        JRadioButton woman = new JRadioButton("女");
        // 设置第一个被选中
        man.setSelected(true);
        // 将按钮添加到按钮组中
        buttonGroup.add(man);
        buttonGroup.add(woman);
        // 将按钮添加到面板中
        jPanel.add(man);
        jPanel.add(woman);

        /**
         * 多选按钮
         */
        // 添加多选按钮
        JCheckBox jCheckBox1 = new JCheckBox("香蕉");
        JCheckBox jCheckBox2 = new JCheckBox("苹果");
        JCheckBox jCheckBox3 = new JCheckBox("梨子");
        JCheckBox jCheckBox4 = new JCheckBox("黄瓜");
        // 添加事件监听，添加第一个复选框的状态被改变的监听（其他复选框如果需要监听状态改变，则可按此方法添加监听）
        jCheckBox1.addChangeListener(e -> {
            // 获取事件源（即复选框本身）
            JCheckBox jCheckBox = (JCheckBox) e.getSource();
            System.out.println(jCheckBox.getText() + " 是否选中: " + jCheckBox.isSelected());
        });
        jCheckBox1.setSelected(true);
        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);
        jPanel.add(jCheckBox3);
        jPanel.add(jCheckBox4);


        jFrame.setContentPane(jPanel);
        // 省略公共代码
    }
}
