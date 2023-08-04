package tnt.example;
import java.awt.*;
import javax.swing.*;
class JTabbedPaneUse {
    public JTabbedPaneUse() {
        JFrame jFrame = new JFrame("选项卡面板窗口");

        /**
         * 全参构造参数说明:
         *     tabPlacement: 选项卡标题的位置, 值为 JTabbedPane.TOP/BOTTOM/LEFT/RIGHT, 默认为 TOP
         *     tabLayoutPolicy: 选项卡位置不能放入所有的选项卡时，放置选项卡的策略，值JTabbedPane.WRAP_TAB_LAYOUT/SCROLL_TAB_LAYOUT
         * 常用方法
         *     addTab(String 标题, Icon 图标, Component 内容组件, String 提示文本)：添加选择项卡
         *     insertTab(String title, Icon icon, Component component, String tip, int index)：在指定位置插入选项卡
         *     remove(Component component)：移除指定内容控件的选项卡
         *     remove(int index)：移除指定位置的选项
         *     setSelectedIndex(int index)：设置当前选中的选项卡
         *     getSelectedIndex()：获取当前选中的选项卡索引
         *     getSelectedComponent()：获取当前选中的选项卡对应的内容组件
         *     setTitleAt(int index, String title)：设置 index 位置的选项卡的标题
         *     setIconAt(int index, Icon icon)：设置 index 位置的选项卡的图标
         *     setEnabledAt(int index, boolean enabled)：设置 index 位置的选项卡是否可用
         *     setComponentAt(int index, Component component)：将 index 位置的内容组件设置为 component
         */
        // 初始化一个选项面板，默认选项卡在顶部，放不下了换行
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        // 创建选项卡
        jTabbedPane.addTab("选项卡1", new JButton("测试按钮"));
        jTabbedPane.addTab("选项卡2", new JButton("测试按钮"));
        jFrame.setContentPane(jTabbedPane);

        // 省略公共代码
    }
}
