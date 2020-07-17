import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.scene.CacheHint.SPEED;

public class maingame {
   public static int acumulatetime;
    public static void displaymaingameStage() {
        Stage primaryStage = new Stage();
        Pane pane1 = new Pane();
        pane1.setVisible(true);
        AudioClip ac;
        ac = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\《开心消消乐》音效素材-声音.游戏 SceneBGM.aa5_爱给网_aigei_com.mp3").toURI().toString());
        ac.setCycleCount(123);  //设置循环次数
      if (Setings.isbackmusic==true){
        ac.play(); }  //开始播放

        List<AudioClip> xiaochumusic = new ArrayList<AudioClip>();

        AudioClip xiaohangmusic;
        xiaohangmusic = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\《开心消消乐》音效素材-声音.消除7.3C984C2D006_爱给网_aigei_com.mp3").toURI().toString());
        xiaohangmusic.stop();   //开始播放
        xiaohangmusic.setCycleCount(1);  //设置循环次数

        AudioClip xiaohangmusic2;
        xiaohangmusic2 = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\《开心消消乐》音效素材-声音.连轧比赛.3.0E6122ef_爱给网_aigei_com.mp3").toURI().toString());
        xiaohangmusic2.stop();   //开始播放
        xiaohangmusic2.setCycleCount(1);  //设置循环次数

        AudioClip xiaohangmusic3;
        xiaohangmusic3 = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\《开心消消乐》音效素材-声音.连轧比赛.5.ec8D43A8_爱给网_aigei_com.mp3").toURI().toString());
        xiaohangmusic3.stop();   //开始播放
        xiaohangmusic3.setCycleCount(1);  //设置循环次数

        AudioClip xiaohangmusic4;
        xiaohangmusic4 = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\《开心消消乐》音效素材-声音.连轧比赛.11.15044F3_爱给网_aigei_com.mp3").toURI().toString());
        xiaohangmusic4.stop();   //开始播放
        xiaohangmusic4.setCycleCount(1);  //设置循环次数

        AudioClip press;
        press = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\按键音效.mp3").toURI().toString());
        press.stop();   //开始播放
        press.setCycleCount(1);  //设置循环次数


        xiaochumusic.add(xiaohangmusic);
        xiaochumusic.add(xiaohangmusic2);
        xiaochumusic.add(xiaohangmusic3);
        xiaochumusic.add(xiaohangmusic4);


        Button button1 = new Button("游戏帮助");
        Button button2 = new Button("暂停/继续");
        button2.setLayoutX(480);
        button2.setLayoutY(500);
        button2.setScaleX(1.7);
        button2.setScaleY(1.5);
        button1.setLayoutX(480);
        button1.setLayoutY(400);
        button1.setScaleX(1.8);
        button1.setScaleY(1.5);
        Label label = new Label("下一个方块是");
        label.setLayoutX(450);
        label.setLayoutY(40);
        label.setTextFill(Color.color(0.2,0.8,0.2));
        label.setFont(Font.font(null, FontPosture.ITALIC,20));
        Label label2 = new Label("当前得分:");
        label2.setLayoutX(450);
        label2.setLayoutY(250);
        label2.setTextFill(Color.color(0.5,1,0.2));
        label2.setFont(Font.font(null, FontPosture.ITALIC,20));
        TextArea scoreArea= new TextArea();
        scoreArea.setLayoutX(450);
        scoreArea.setLayoutY(260);


        Random rnd = new Random();
        int[] random = new int[50];
        for (int i =0;i<random.length;i++){
            random[i]= rnd.nextInt(7);
        }

        Unit unit = new Unit();
        Unit.xialuotishi();
        for (int i = 0;i<unit.units.size();i++){
            pane1.getChildren().add(unit.units.get(i));
        }
        for (int i =0 ;i<Unit.nextunits.size();i++){
            pane1.getChildren().add(Unit.nextunits.get(i));
        }



        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Unit.ispause = true;
                new About().displayAboutStage();
            }
        });
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Unit.ispause==true){
                    Unit.ispause=false;
                }else if (Unit.ispause==false){
                    Unit.ispause=true;
                }
            }
        });

        for (int i = 0;i<Unit.xialuotishi.size();i++){
            pane1.getChildren().add(Unit.xialuotishi.get(i));
        }

        Image img=new Image("/img/acce40ee18159a8609a974ab6fd4e95d.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(img);
        iv1.setX(20);
        iv1.setY(50);
        iv1.setFitHeight(600);
        iv1.setFitWidth(400);
        Scene scene = new Scene(pane1,222,222);
        Random random1 = new Random(System.currentTimeMillis());
        double r1 = random1.nextDouble();
        double g1 = random1.nextDouble();
        double b1 = random1.nextDouble();
        Unit.xialuotishi();

        //计算时间
        Label label4 = new Label();
        label4.setLayoutX(480);
        label4.setLayoutY(570);
        label4.setFont(Font.font(null,FontPosture.ITALIC,50));
        label4.setTextFill(Color.BLUE);

        Label label5 = new Label("存活时间：");
        label5.setLayoutY(550);
        label5.setLayoutX(480);
        label5.setFont(Font.font(null,FontPosture.ITALIC,15));
        label5.setTextFill(Color.BLUE);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        String score = new String();
                        score = String.valueOf(Unit.score);
                        Label label3 = new Label(score);
                        label3.setLayoutX(455);
                        label3.setLayoutY(300);
                        label3.setFont(Font.font(null,FontPosture.ITALIC,40));
                        double r = rnd.nextDouble();
                        double g = rnd.nextDouble();
                        double b = rnd.nextDouble();
                        label3.setTextFill(Color.color(r,g,b));

                        acumulatetime = (Unit.time*Setings.period)/1000;
                        String time = String.valueOf(acumulatetime);
                        label4.setText(time);



                        if (Unit.isover()==true){
                            timer.cancel();
                            ac.stop();
                            //如果游戏结束，把分数传出去
                            BufferedWriter out = null;
                            try {
                                out = new BufferedWriter(new OutputStreamWriter(
                                        new FileOutputStream("score.dat", true)));
                                out.write(Unit.score+acumulatetime+"\r\n");
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    out.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            Unit.restart();

                            try {
                                primaryStage.close();
                                primaryStage.hide();
                                new gameover().displaygameoverStage();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        Unit.newmap();
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 11; j++) {
                                if (Unit.isxiaohang==false&&Unit.map[i][j] == 2) {
                                    Rectangle u = new Rectangle();
                                    u.setWidth(40);
                                    u.setHeight(40);
                                    u.setFill(Color.color(r1,g1,b1));
                                    u.setArcHeight(20);
                                    u.setArcWidth(20);
                                    u.setX(j * 40-20);
                                    u.setY(i * 40+50);
                                    pane1.getChildren().add(u);
                                }else if (Unit.isxiaohang ==true&&Unit.isover()==false){
                                    Random random2 = new Random(System.currentTimeMillis());
                                    int order = random2.nextInt(4);
                                    if (Setings.isxiaohangsoundeffect==true){
                                    xiaochumusic.get(order).play();}
                                    pane1.getChildren().clear();
                                    for (int m = 0;m<unit.units.size();m++){
                                        pane1.getChildren().add(unit.units.get(m));
                                    }
                                    pane1.getChildren().addAll(button1,button2);
                                    pane1.getChildren().add(0,iv1);
                                    for (int m =0 ;m<Unit.nextunits.size();m++){
                                        pane1.getChildren().add(Unit.nextunits.get(m));
                                    }
                                    pane1.getChildren().add(label);
                                    pane1.getChildren().add(label2);
                                    pane1.getChildren().add(label3);
                                    pane1.getChildren().add(label4);
                                    pane1.getChildren().add(label5);
                                    Unit.xialuotishi();
                                    for (int v =0;v<Unit.xialuotishi.size();v++){
                                        pane1.getChildren().add(Unit.xialuotishi.get(v));
                                    }
                                    Unit.isxiaohang =false;
                                }
                            }
                        }
                    }
                });
            }
        },10,10);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });


        button2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()==KeyCode.LEFT){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    if (Unit.isleft(unit.shape,unit.map,unit.type)==true) {
                        Unit.moveleft(unit.units);
                        Unit.xialuotishi();
                    }
                }else if (event.getCode()==KeyCode.RIGHT){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    if (Unit.isright(unit.shape,unit.map,unit.type)==true) {
                        Unit.moveright(unit.units);
                        Unit.xialuotishi();
                    }
                }else if (event.getCode()==KeyCode.UP){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    if (Unit.isxuanzhuan()==true) {
                        Unit.rotate(Unit.shape, Unit.type, Unit.units);
                        Unit.xialuotishi();
                    }
                }else if (event.getCode()==KeyCode.DOWN){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    unit.speedup();
                    while (Unit.ifnextblock(Unit.x,Unit.y,Unit.map,Unit.shape,unit.type)==false){
                        for (int i = 0;i<unit.units.size();i++){
                            unit.units.get(i).setY(unit.units.get(i).getY()+40);
                        }
                    }
                }
            }
        });
        button1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()==KeyCode.LEFT){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    if (Unit.isleft(unit.shape,unit.map,unit.type)==true) {
                        Unit.moveleft(unit.units);
                        Unit.xialuotishi();
                    }
                }else if (event.getCode()==KeyCode.RIGHT){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    if (Unit.isright(unit.shape,unit.map,unit.type)==true) {
                        Unit.moveright(unit.units);
                        Unit.xialuotishi();
                    }
                }else if (event.getCode()==KeyCode.UP){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    if (Unit.isxuanzhuan()==true) {
                        Unit.rotate(Unit.shape, Unit.type, Unit.units);
                        Unit.xialuotishi();
                    }
                }else if (event.getCode()==KeyCode.DOWN){
                    if (Setings.isbuttonsoundeffect==true){
                        press.play();}
                    unit.speedup();
                    while (Unit.ifnextblock(Unit.x,Unit.y,Unit.map,Unit.shape,unit.type)==false){
                        for (int i = 0;i<unit.units.size();i++){
                            unit.units.get(i).setY(unit.units.get(i).getY()+40);
                        }
                    }
                }
            }
        });
        pane1.getChildren().add(label4);
        pane1.getChildren().add(label2);
        pane1.getChildren().addAll(button1,button2);
        pane1.getChildren().add(0,iv1);
        pane1.getChildren().add(label);
        pane1.getChildren().add(label5);
        primaryStage.setTitle("俄罗斯方块");
        primaryStage.setResizable(false);
        primaryStage.setWidth(600);
        primaryStage.setHeight(700);
        primaryStage.setX(600);
        primaryStage.setY(100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
