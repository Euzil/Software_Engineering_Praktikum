package tnt.example;

import java.awt.*;
import javax.swing.*;
class JProgressBarAndJSliderUse {
    public JProgressBarAndJSliderUse() {
        JFrame jFrame = new JFrame("列表窗口");
        JPanel jPanel = new JPanel(new GridLayout(3, 1));

        /**
         * 进度条：
         *     全参构造参数说明：JProgressBar(int orient, int min, int max)
         *         orient: 进度条的方向，SwingConstants.VERTICAL 或 SwingConstants.HORIZONTAL，默认为水平方向
         *         min: 最小进度值；max: 最大进度值
         *     常用方法：
         *         设置最小进度值、最大进度值和当前进度值：setMinimum(int min)，setMaximum(int max)，setValue(int n)
         *         获取当前进度值：getValue()
         *         获取当前进度的百分比：getPercentComplete()
         *         是否绘制百分比文本（进度条中间显示的百分数）：setStringPainted(boolean b)
         *         设置进度条进度是否为不确定模式：setIndeterminate(boolean newValue)
         *         设置进度条的方向，SwingConstants.VERTICAL 或 SwingConstants.HORIZONTAL：setOrientation(int newOrientation)
         *         添加进度条的进度改变监听器：addChangeListener(ChangeListener l)
         */
        JProgressBar jProgressBar = new JProgressBar(0, 100);
        jProgressBar.setValue(20);
        jProgressBar.addChangeListener(e -> {
            System.out.println("当前进度值: " + jProgressBar.getValue() + "; " +
                    "进度百分比: " + jProgressBar.getPercentComplete());
        });
        jPanel.add(jProgressBar);

        /**
         * 滑块：
         *     全参构造参数说明：JSlider(int orientation, int min, int max, int value)
         *         orientation: 滑块的方向，SwingConstants.VERTICAL 或 SwingConstants.HORIZONTAL，默认为水平方向
         *         min: 滑块的最小值； max: 滑块的最大值
         *         value: 滑块的初始值（默认为 最小值 和 最大值 之间的 中间值）
         *     常用方法：
         *         设置滑块的最小值、最大值、当前值：setMinimum(int min)，setMaximum(int max)，setValue(int n)
         *         获取滑块的当前值：getValue()
         *         设置主刻度标记间隔：setMajorTickSpacing(int n)
         *         设置单个主刻度内的次刻度标记间隔：setMinorTickSpacing(int n)
         *         设置是否绘制刻度线：setPaintTicks(boolean b)
         *         设置是否绘制刻度标签（刻度值文本）：setPaintLabels(boolean b)
         *         设置是否绘制滑道：setPaintTrack(boolean b)
         *         设置是否颠倒刻度值（刻度值从大到小）：setInverted(boolean b)
         *         设置滑块是否对齐到刻度。设置为 true，则滑块最终只能在有刻度的位置取值，即滑块取值不连续：setSnapToTicks(boolean b)
         *         添加滑块的值改变监听器：addChangeListener(ChangeListener l)
         */
        JSlider jSlider = new JSlider(0, 20, 10);
        // 设置主刻度间隔
        jSlider.setMajorTickSpacing(5);
        // 设置次刻度间隔
        jSlider.setMinorTickSpacing(1);
        // 绘制刻度和标签
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        jSlider.addChangeListener(e -> {
            System.out.println("当前值: " + jSlider.getValue());
        });
        jPanel.add(jSlider);

        jFrame.setContentPane(jPanel);
        // 省略公共代码
    }
}
