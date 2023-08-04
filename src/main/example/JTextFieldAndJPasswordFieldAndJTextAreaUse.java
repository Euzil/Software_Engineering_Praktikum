package tnt.example;

import java.awt.*;
import javax.swing.*;
class JTextFieldAndJPasswordFieldAndJTextAreaUse {
    public JTextFieldAndJPasswordFieldAndJTextAreaUse() {
        JFrame jFrame = new JFrame("列表窗口");
        JPanel jPanel = new JPanel(new GridLayout(3,1));

        /**
         * 文本框
         */
        final JTextField jTextField = new JTextField(10);
        jTextField.setFont(new Font(null, Font.PLAIN, 20));
        jPanel.add(new JLabel("用户名"));
        jPanel.add(jTextField);

        /**
         * 密码框
         */
        final JPasswordField jPasswordField = new JPasswordField(32);
        jPanel.add(new JLabel("密 码"));
        jPanel.add(jPasswordField);

        /**
         * 文本域
         */
        // 创建一个 5 行 10 列的文本区域
        JTextArea jTextArea = new JTextArea(5, 10);
        // 自动换行
        jTextArea.setLineWrap(true);
        jPanel.add(new JLabel("文本域"));
        jPanel.add(jTextArea);

        jFrame.setContentPane(jPanel);
        // 省略公共代码
    }
}
