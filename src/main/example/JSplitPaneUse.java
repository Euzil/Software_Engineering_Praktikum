package tnt.example;
import java.awt.*;
import javax.swing.*;
public class JSplitPaneUse {

    class JSplitPaneUse{
        public JSplitPaneUse() {
            JFrame jFrame = new JFrame("分隔面板窗口");

            /**
             * 全参构造参数说明
             *      orientation: 分隔的方向(默认水平)，HORIZONTAL_SPLIT：水平左右分隔；VERTICAL_SPLIT：垂直上下分隔
             *      continuousLayout: 拖动分隔条时，是否连续重绘组件，如果为flase，则拖动分隔条停止后才重绘组件。
             *      leftComponent: 左边/上面 显示的组件
             *      rightComponent: 右边/下面 显示的组件
             * 常用方法
             *    setOrientation(int orientation)： 设置分隔的方向，水平(左右) 或 垂直(上下) 分隔
             *    setLeftComponent(Component comp)：设置 左边/上面 显示的组件
             *    setRightComponent(Component comp)：设置 左边/下面 显示的组件
             *    setContinuousLayout(boolean continuousLayout)： 设置 拖动分隔条 时是否 连续重绘 组件
             *    setOneTouchExpandable(boolean newValue)：分隔条上是否显示快速 折叠/展开 两边组件的小按钮
             *    setDividerSize(int newSize)：设置分隔条的大小（宽度）
             *    setDividerLocation(int location)：设置分隔条的位置，相对于 左边/顶部 的像素长度
             */
            JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, new JButton("左边按钮"), new JButton("右边按钮"));
            jSplitPane.setDividerLocation(200);

            jFrame.setContentPane(jSplitPane);
            // 省略公共代码
        }
    }
}
