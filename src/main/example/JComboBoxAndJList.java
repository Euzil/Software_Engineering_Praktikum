package tnt.example;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;

class JComboBoxAndJList {
    public JComboBoxAndJList() {
        JFrame jFrame = new JFrame("列表窗口");
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("水果");

        /**
         * 下拉框：这里的数组列表可以使用Vector<String>集合进行
         */
        final JComboBox<String> jComboBox = new JComboBox<>(new String[]{"香蕉", "雪梨", "苹果", "荔枝"});
        // 添加条目选中状态改变的监听器
        jComboBox.addItemListener(e -> {
            // 只处理选中的状态
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("选中: " + jComboBox.getSelectedIndex() + " = " + jComboBox.getSelectedItem());
            }
        });
        jPanel.add(jLabel);
        jPanel.add(jComboBox);

        /**
         * 列表框
         */
        final JList<String> jList = new JList<>();
        // 设置一下首选大小
        jList.setPreferredSize(new Dimension(200, 100));
        // 允许可间断的多选
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // 设置选项数据（内部将自动封装成 ListModel ），这里的数组列表可以使用Vector<String>集合进行
        jList.setListData(new String[]{"香蕉", "雪梨", "苹果", "荔枝"});
        // 添加选项选中状态被改变的监听器
        jList.addListSelectionListener(e -> {
            // 获取所有被选中的选项索引
            int[] indices = jList.getSelectedIndices();
            // 获取选项数据的 ListModel
            ListModel<String> listModel = jList.getModel();
            // 输出选中的选项
            for (int index : indices) {
                System.out.println("选中: " + index + " = " + listModel.getElementAt(index));
            }
            System.out.println();
        });
        jPanel.add(jList);

        jFrame.setContentPane(jPanel);
        // 省略公共代码
    }
}
