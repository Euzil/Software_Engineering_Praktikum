

import java.awt.Canvas;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
    @Override
    public void paint(Graphics g) {
        // TODO 自动生成的方法存根
        super.paint(g);//直接输入paint提示出来函数；
        g.drawRect(0, 0, 50 ,50);//矩形 rectangle
        g.fillRect(0, 50, 50, 50);
        g.drawOval(50, 0, 50, 50);//圆，oval 与椭圆一致，不过圆的宽高一致，特殊椭圆  oval
        g.fillOval(50, 50, 50, 50);//填充，后面为度数
        g.drawRoundRect(100, 0, 50, 50, 10, 10);//圆角矩形 round(V A P 圆形，整数，环绕) rect
        g.fillRoundRect(100, 50, 50, 50, 10, 10);
        int X[]= {150,175,200};
        int Y[]= {50,0,50};
        int X1[]= {150,175,200};
        int Y1[]= {100,50,100};
        g.drawPolygon(X,Y, 3);// 任意多边形  polygon(多边形)   点点相连，三个变量，前两个为数组变量，分别是点的x坐标数组，y的坐标数组，最后一个为点的个数；
        g.fillPolygon(X1, Y1, 3);
        g.drawOval(200, 0, 100, 50);//椭圆
        g.fillOval(200, 50, 100, 50);
        int X2[]= {300,325,375,350};
        int Y2[]= {0,50,50,0};
        int Y3[]= {50,100,100,50};
        g.drawPolygon(X2, Y2, 4);//平行四边形， 注意drawPolygon在使用时，是按顺序连接点的
        g.fillPolygon(X2, Y3, 4);
        g.drawArc(400, 0, 50, 50, 0, 180);//扇形
        g.fillArc(400, 50, 50, 50, 0, 180);
        g.drawString("好好学习", 0, 150);// 注意，字符串型的x,y在字符中，而不是左上顶点；
        char []a= {'好','好','学','习'};
        g.drawChars(a, 0, 4, 50, 150);// data数组，offset为数据初始偏移量，length为要绘制的字符数，x,y文本基线的xy坐标，
        g.drawLine(100,150, 200, 150);//x1,y1,x2,y2 连线，
        g.drawString("软件1701 郝极平", 0, 200);
        g.drawString("学号2017011525", 100, 200);
    }
}

