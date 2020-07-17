import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;


public class gameover  {
    public static void displaygameoverStage() {
        Pane pane = new Pane();
        Image img=new Image("img/timg (3).jpg");
        ImageView iv1 = new ImageView();
        Button button = new Button("排行榜");
        Button button1=new Button("退出游戏");
        button.setScaleX(2);
        button.setScaleY(1.5);
        button.setLayoutX(50);
        button.setLayoutY(250);
        button1.setLayoutX(230);
        button1.setLayoutY(250);
        button1.setScaleY(1.5);
        button1.setScaleX(2);

        AudioClip ac;
        ac = new AudioClip(new File("C:\\Users\\13302\\IdeaProjects\\project 2s plus\\src\\music\\《开心消消乐》音效素材-声音.游戏 SceneBGM.aa5_爱给网_aigei_com.mp3").toURI().toString());
        ac.stop();   //开始播放
        ac.setCycleCount(1000);  //设置循环次数

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    new Ranking().displayRankingStage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });


        Stage primaryStage = new Stage();
        iv1.setImage(img);
        iv1.setFitHeight(400);
        iv1.setFitWidth(350);
        pane.getChildren().add(iv1);
        pane.getChildren().addAll(button,button1);
        Scene scene = new Scene(pane,iv1.getFitWidth(),iv1.getFitHeight());
        primaryStage.setTitle("游戏结束");
        primaryStage.setWidth(iv1.getFitWidth());
        primaryStage.setHeight(iv1.getFitHeight());
        primaryStage.setX(400);
        primaryStage.setY(200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
