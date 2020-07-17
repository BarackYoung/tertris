import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class start extends Application{
    @Override
    public void start(Stage primaryStage)  {
        AudioClip ac;
        ac = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\Faster.mp3").toURI().toString());
        ac.setCycleCount(1000);  //设置循环次数
        ac.play();   //开始播放
        Button bu1 = new Button("开始游戏");
        Button bu2 = new Button("游戏设置");
        Button bu3 = new Button("历史战绩") ;
        Button bu4 = new Button("游戏帮助");
        bu1.setScaleX(2);
        bu1.setScaleY(1.5);
        bu2.setScaleY(1.5);
        bu2.setScaleX(2);
        bu3.setScaleY(1.5);
        bu3.setScaleX(2);
        bu4.setScaleY(1.5);
        bu4.setScaleX(2);
        bu1.setLayoutX(450);
        bu1.setLayoutY(200);
        bu2.setLayoutX(450);
        bu2.setLayoutY(300);
        bu3.setLayoutX(450);
        bu3.setLayoutY(400);
        bu4.setLayoutX(450);
        bu4.setLayoutY(500);
        Pane pane1 = new Pane();
        bu1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ac.stop();
                try {
                    new maingame().displaymaingameStage();
                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bu2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                try {
                    new Setings().displaySettingStage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bu3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                java.io.File file2 = new java.io.File("score.dat");
                Scanner input = null;
                try {
                    input = new Scanner(file2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int[] Ranking = new int[10];
                int i = 0;
                while (input.hasNext()){
                    Ranking[i]=input.nextInt();
                }
                try {
                    new Ranking().displayRankingStage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage.show();
            }
        });
        bu4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new About().displayAboutStage();
            }
        });
       Image image = new Image("img/捕获.jpg");
       double x = image.getWidth();
       double y = image.getHeight();
       ImageView iv1 = new ImageView();
        iv1.setImage(image);
        pane1.setVisible(true);
//        ImageIcon img=new ImageIcon("/img/06617fd11581395a.jpg");
       pane1.getChildren().add(iv1);
        pane1.getChildren().addAll(bu1,bu2,bu3,bu4);
        Scene scene = new Scene(pane1,x-200 ,y-200);
        primaryStage.setTitle("俄罗斯方块");
        primaryStage.setResizable(false);
        primaryStage.setWidth(x-200);
        primaryStage.setHeight(y-200);
        primaryStage.setX(50);
        primaryStage.setY(50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
