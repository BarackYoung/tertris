import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public  class Setings  {
    public static boolean isbackmusic =true;//是否选择背景音乐
    public static boolean isbuttonsoundeffect=true;//是否要按键音效
    public static boolean isxiaohangsoundeffect=true;//是否要消行音效
    public static int period=500;//下落的时间间隔
    public static void displaySettingStage() {

        CheckBox backmusic = new CheckBox("音乐");
        backmusic.setTextFill(Color.color(0.6,0.9,0.3));
        backmusic.setSelected(true);
        backmusic.setLayoutX(50);
        backmusic.setLayoutY(100);
        if (backmusic.isSelected()==true){
            isbackmusic = true;
        }else {
            isbackmusic =false;
        }

        backmusic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (backmusic.isSelected()==true){
                    isbackmusic = true;
                }else {
                    isbackmusic =false;
                }
            }
        });

        CheckBox butonsoundeffect = new CheckBox("按键音效");
        butonsoundeffect.setTextFill(Color.color(0.6,0.9,0.3));
        butonsoundeffect.setLayoutX(50);
        butonsoundeffect.setLayoutY(150);
        butonsoundeffect.setSelected(true);
        if (butonsoundeffect.isSelected()==true){
            isbuttonsoundeffect =true;
        }else {
            isbuttonsoundeffect =false;
        }

butonsoundeffect.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        if (butonsoundeffect.isSelected()==true){
            isbuttonsoundeffect =true;
        }else {
            isbuttonsoundeffect =false;
        }
    }
});
        CheckBox xiaohangsoundeffect = new CheckBox("消行音效");
        xiaohangsoundeffect.setSelected(true);
        xiaohangsoundeffect.setLayoutX(50);
        xiaohangsoundeffect.setLayoutY(200);
        xiaohangsoundeffect.setTextFill(Color.color(0.6,0.9,0.3));
        if (xiaohangsoundeffect.isSelected()==true){
            isxiaohangsoundeffect =true;
        }else {
            isxiaohangsoundeffect =false;
        }

        xiaohangsoundeffect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (xiaohangsoundeffect.isSelected()==true){
                    isxiaohangsoundeffect =true;
                }else {
                    isxiaohangsoundeffect =false;
                }
            }
        });

        ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("老年人模式");
        rb1.setToggleGroup(group);
        rb1.setFont(Font.font(null, FontPosture.ITALIC,15));
        rb1.setTextFill(Color.color(0.9,0.3,0.4));
        rb1.setLayoutX(50);
        rb1.setLayoutY(250);
        rb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (rb1.isSelected()==true){
                    period = 700;
                }
            }
        });

        RadioButton rb2 = new RadioButton("中年人模式");
        rb2.setToggleGroup(group);
        rb2.setSelected(true);
        rb2.setFont(Font.font(null, FontPosture.ITALIC,15));
        rb2.setTextFill(Color.color(1,0.1,0.1));
        rb2.setLayoutX(160);
        rb2.setLayoutY(250);
        rb2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (rb2.isSelected()==true){
                    period=500;
                }
            }
        });

        RadioButton rb3 = new RadioButton("激情模式");
        rb3.setToggleGroup(group);
        rb3.setFont(Font.font(null, FontPosture.ITALIC,15));
        rb3.setTextFill(Color.color(0.8,0.7,0.1));
        rb3.setLayoutX(280);
        rb3.setLayoutY(250);
       rb3.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               if (rb3.isSelected()==true){
                   period=300;
               }
           }
       });

        Stage primaryStage = new Stage();
        Pane pane = new Pane();
        Image img=new Image("/img/timg (5).jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(img);
        pane.getChildren().add(iv1);
        pane.getChildren().addAll(backmusic,xiaohangsoundeffect,butonsoundeffect,rb1,rb2,rb3);
        Scene scene = new Scene(pane,iv1.getFitWidth(),iv1.getFitHeight());
        primaryStage.setTitle("设置");
        primaryStage.setResizable(false);
        primaryStage.setWidth(img.getWidth());
        primaryStage.setHeight(img.getHeight()+20);
        primaryStage.setX(600);
        primaryStage.setY(100);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
}
