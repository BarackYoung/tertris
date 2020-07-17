import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Unit extends maingame{
    public static int time = 0;//用来计算存活时间
    public static int score = 10;//用来计算分数
    private static int numbersofmoveleft = 0;//
    private static int numbersofmoveright = 0;//控制左右移动的次数
    public static boolean isxiaohang = false;//判断是否消行
    public static boolean ispause = false;//判断是否停止
   public static  int x=5;//方块在数组中的位置
   public  static   int y = 0;//
    public static int xialuotishi_x ;//下落提示的方块的位置
    public static int xialuotishi_y;//
   public static int SPEED = 40;//下落格子
   public static int[][][] shape = {//像pj1一样定义7种方块
            {//0,一字
                    {0, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 1, 0, 0}
            },
            {//2，T
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 0, 0},
            },
            {//3，L
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 1}
            },
            {//4，反L

                    {0, 1, 0},
                    {0, 1, 0},
                    {1, 1, 0}
            },
            {//5，Z
                    { 1, 1, 0},
                    { 0, 1, 1},
                    { 0, 0, 0}
            },
            {//6，反Z
                    { 0, 1, 1},
                    { 1, 1, 0},
                    { 0, 0, 0}
            },
            {//7，田子
                    { 1, 1},
                    { 1, 1},
            }
    };
    static Random rnd = new Random(System.currentTimeMillis());//产生随机数
    Random colorrnd = new Random();
    static List<Rectangle>  units=new ArrayList<Rectangle>();//定义一个容器用来装方块
    static List<Rectangle>  nextunits = new ArrayList<Rectangle>();//用来装下一个方块的容器
    static List<Rectangle> xialuotishi = new ArrayList<Rectangle>();//用来装下落提示的容器
    public static int[][] map = new int[17][11];//定义地图，和pj1一样
    public static int[] whichblock  = new int[1000];//产生随机方块的数组
    public static int order = 0;//下落次序，和数组配套使用
    public static int type;//方块类型
    public Unit(){

        for (int i = 0;i<whichblock.length;i++){
            whichblock[i] = rnd.nextInt(7);
        }
        for (int i =0;i<17;i++){
            for (int j = 0;j<11;j++){
                map[i][j]=0;
            }
        }
        type = whichblock[order];//方块类型

        //把方块显示出来
        for (int i = 0;i< 17;i++){
            for (int j = 0;j<11;j++){
                if (i >= y && j >= x && i < y + shape[type].length && j < x + shape[type].length && shape[type][i - y][j - x] == 1){
                    double r = colorrnd.nextDouble();
                    double g = colorrnd.nextDouble();
                    double b = colorrnd.nextDouble();
                    Rectangle unit = new Rectangle();
                    unit.setHeight(40);
                    unit.setWidth(40);
                    unit.setArcWidth(20);
                    unit.setArcHeight(20);
                    unit.setFill(Color.color(r,g,b));
                    unit.setX(x*40+ j*40-220);
                    unit.setY(y*40+i*40+50);
                    units.add(unit);
                }
            }
        }
//        for (int i = 0;i<4;i++){
//            Rectangle u = new Rectangle();
//            xialuotishi.add(u);
//        }

        for (int i = 0;i<4;i++){
            Rectangle u = new Rectangle();
            u.setX(units.get(i).getX());
            u.setY(units.get(i).getY());
            u.setHeight(40);
            u.setWidth(40);
            u.setArcHeight(30);
            u.setArcWidth(30);
            u.setFill(Color.color(0.2,0.3,0.4,0.2));
            xialuotishi.add(u);
        }



        for (int i = 0;i<shape[whichblock[order+1]][1].length;i++){
            for (int j = 0;j<shape[whichblock[order+1]][1].length;j++){
                if (Unit.shape[whichblock[order+1]][i][j]==1){
                    double r = colorrnd.nextDouble();
                    double g = colorrnd.nextDouble();
                    double b = colorrnd.nextDouble();
                    Rectangle nextu = new Rectangle();
                    nextu.setWidth(30);
                    nextu.setHeight(30);
                    nextu.setArcHeight(30);
                    nextu.setArcWidth(30);
                    nextu.setFill(Color.color(r,g,b));
                    nextu.setX(450+j*30);
                    nextu.setY(70 + i*30);
                    nextunits.add(nextu);
                }
            }
        }
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                if (ifnextblock(x,y,map,shape,type)==false&&isover()==false&&ispause ==false) {
                    time+=1;
                    newmap();
                    y++;
                    for (int i = 0;i<units.size();i++){
                        units.get(i).setY(units.get(i).getY()+SPEED);
                    }
                    xialuotishi();
                }
                else if (ifnextblock(x,y,map,shape,type)==true&&isover()==false&&ispause==false){
                    order++;
                    newmap();
                    numbersofmoveleft=0;
                    numbersofmoveright=0;
                    map(shape,type,x,y);
                    y=0;
                    x=5;
                    type = whichblock[order];//方块类型
                    int m = 0;
                    for (int i = 0;i< 17;i++){
                        for (int j = 0;j<11;j++){
                            if (i >= y && j >= x && i < y + shape[type].length && j < x + shape[type].length && shape[type][i - y][j - x] == 1){
                                units.get(m).setX(x*40+ j*40-220);
                                units.get(m).setY(y*40+i*40+50);
                                m++;
                            }
                        }
                    }
                    int n =0;
                    for (int i = 0;i<shape[whichblock[order+1]][1].length;i++){
                        for (int j = 0;j<shape[whichblock[order+1]][1].length;j++){
                            if (Unit.shape[whichblock[order+1]][i][j]==1){
                                nextunits.get(n).setX(450+j*30);
                                nextunits.get(n).setY(70 + i*30);
                                n++;
                            }
                        }
                    }
                    xialuotishi();
                }
            }
        },100,Setings.period);
  }



    public static void rotate(int[][][] shape,int type,List<Rectangle> units) {//旋转方块的方法
        int[][] tempshape = new int[shape[type][1].length][shape[type][1].length];
        for (int i = 0; i <shape[type][1].length; i++) {
            for (int j = 0; j < shape[type][1].length; j++) {
                tempshape[i][j] = shape[type][j][shape[type][1].length-1 - i];
            }
        }
        for (int i = 0; i < shape[type][1].length; i++) {
            for (int j = 0; j < shape[type][1].length; j++) {
                shape[type][i][j] = tempshape[i][j];
            }
        }
        int m =0;
        for (int i = 0;i< 17;i++){
            for (int j = 0;j<10;j++){//可能有问题
                if (i >= y && j >= x && i < y + shape[type][1].length && j < x + shape[type][1].length && shape[type][i - y][j - x] == 1){
                    units.get(m).setX((x+j+numbersofmoveleft-numbersofmoveright) * 40 -220);
                        units.get(m).setY(i*40+50);
                        m++;
                }
            }
        }
    }
  public static void moveleft(List<Rectangle> units){//左移的方法
            x--;
            numbersofmoveleft++;
            for (int i = 0; i < units.size(); i++) {
                units.get(i).setX(units.get(i).getX() - 40);
            }
  }
    public void map( int[][][] shape, int type, int x, int y) {//下落后把方块留在底部的方法
        for (int i = 0;i< 17;i++){
            for (int j = 0;j<11;j++){
                if (i >= y && j >= x && i < y + shape[type].length && j < x + shape[type].length && shape[type][i - y][j - x] == 1){
                    map[i][j]=2;
                }
            }
        }
    }
    public static boolean isleft(int[][][] shape, int[][] map, int type) {//判断是否左移的方法，左边可能有障碍物
        for (int i = 0; i <shape[type].length; i++) {
            for (int j = 0; j <shape[type].length; j++) {
                if (shape[type][i][j] == 1 && (x + j <=1 ||map[y + i + 1][x + j - 1] == 2 || map[y + i][x + j - 1] == 2)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean ifnextblock(int x,int y,int[][] map, int[][][] shape , int type) {//判断下面是否到底或碰到已有方块，到的话开始下一个方块
        for (int i = 0; i <shape[type].length; i++) {
            for (int j = 0; j <shape[type].length; j++) {
                if ((shape[type][i][j] == 1 && y + i == 14) || (shape[type][i][j] == 1 && map[y + i + 1][x + j] == 2)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void moveright(List<Rectangle> units){//右移的方法
            x++;
            numbersofmoveright++;
            for (int i = 0; i < units.size(); i++) {
                units.get(i).setX(units.get(i).getX() + 40);
            }
    }
    public static boolean isright(int[][][] shape, int[][] map, int type) {//判断是否右移的方法，右边可能有障碍物
        for (int i = 0; i <shape[type].length; i++) {
            for (int j = 0; j <shape[type].length; j++) {
                if (shape[type][i][j] == 1 && (x + j >=10 ||map[y + i + 1][x + j + 1] == 2 || map[y + i][x + j + 1] == 2)) {
                    return false;
                }
            }
        }
        return true;
    }
    public void speedup(){//直接到底的方法
       while (ifnextblock(x,y,map,shape,type)==false){
           y++;
       }
            }

            public static void newmap() {//消行功能的实现
                    int[][] tempmap = new int[17][11];//新建数组
                    int lineoffull=-1;
                    int lines = 1;
                     for (int i = 0;i<17;i++){
                         for (int j = 0;j<11;j++){
                           if (map[i][1]==2&&map[i][2]==2&&map[i][3]==2&&map[i][4]==2&&map[i][5]==2&&map[i][6]==2&&map[i][7]==2&&map[i][8]==2&&map[i][9]==2&&map[i][10]==2){
                               lineoffull=i;
                               score+=10;
                             isxiaohang = true;
                              for (int m =0;m<11;m++){
                                 map[i][m]=0;
                                 break;
                                               }
                                               break;
                  }
              }
          }
          for (int i = 0;i<17;i++){
              for (int j = 0;j<11;j++){
                  tempmap[i][j] = map[i][j];
              }
          }
          for (int i = 0;i<16;i++){
              for (int j = 0;j<11;j++){
                  if (i<=lineoffull){
                     map[i+lines][j]=tempmap[i][j];
                  }else if (i>lineoffull){
                      map[i][j]=tempmap[i][j];
                  }
              }
          }
    }
    public static boolean isover() {//判断是否结束的方法
        for (int i = 1; i < 10; i++) {
            if (map[1][i] == 2) {
                return true;
            }
        }
        return false;
    }

    public static void restart(){
        order=0;
        numbersofmoveleft=0;
        numbersofmoveright=0;
        score=0;
        x=5;
        y=0;
        for (int i =0;i<17;i++){
            for (int j = 0;j<11;j++){
                map[i][j]=0;
            }
        }
        int m = 0;
        for (int i = 0;i< 17;i++){
            for (int j = 0;j<11;j++){
                if (i >= y && j >= x && i < y + shape[type].length && j < x + shape[type].length && shape[type][i - y][j - x] == 1){
                    units.get(m).setX(x*40+ j*40-220);
                    units.get(m).setY(y*40+i*40+50);
                    m++;
                }
            }
        }
    }
    public static boolean isxuanzhuan() {//判断是否旋转的方法
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (type!=6&&shape[type][i][j] == 1 && (x + j == 10 ||x  + j == 0 || i + y == 15 || map[y + i + 1][x + j + 1] == 2 || map[y + i][x + j + 1] == 2 || map[y + i][x + j - 1] == 2)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void xialuotishi(){//下落提示方法
        xialuotishi_x = x;
        xialuotishi_y = y;
        for (int i = 0;i<4;i++){
            xialuotishi.get(i).setX(units.get(i).getX());
            xialuotishi.get(i).setY(units.get(i).getY());
        }

        while (ifnextblock(xialuotishi_x,xialuotishi_y,map,shape,type)==false){
            xialuotishi_y+=1;
            for (int i =0 ;i<xialuotishi.size();i++){
                xialuotishi.get(i).setY(xialuotishi.get(i).getY()+40);
            }
        }
    }
}
