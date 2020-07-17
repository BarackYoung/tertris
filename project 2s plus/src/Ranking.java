import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ranking  {
    public static void displayRankingStage(){

        File file2 = new File("score.dat");
        Scanner input = null;
        try {
            input = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] Ranking = new int[1000];
        int i = 0;
        while (i<1000){
            if (input.hasNext()) {
                Ranking[i] = input.nextInt();
            }else {
                Ranking[i]=0;
            }
            i++;
        }
        Arrays.sort(Ranking);
        String[] strings = new String[1000];
        for (int m =0;m<1000;m++){
            strings[m]=String.valueOf(Ranking[999-m]);
        }

        Label label1 = new Label(strings[0]);
        label1.setTextFill(Color.color(0.7,1,0.1));
        label1.setLayoutX(200);
        label1.setLayoutY(35);
        label1.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label2 = new Label(strings[1]);
        label2.setTextFill(Color.color(0.1,0.9,0.3));
        label2.setLayoutX(200);
        label2.setLayoutY(90);
        label2.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label3 = new Label(strings[2]);
        label3.setLayoutX(200);
        label3.setLayoutY(140);
        label3.setTextFill(Color.color(0.2,0.4,0.6));
        label3.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label4 = new Label(strings[3]);
        label4.setLayoutX(200);
        label4.setLayoutY(190);
        label4.setTextFill(Color.color(0.2,0.8,0.1));
        label4.setFont(Font.font(null, FontPosture.ITALIC,30));


        Label label5 =new Label(strings[4]);
        label5.setTextFill(Color.color(1,1,0.1));
        label5.setLayoutX(200);
        label5.setLayoutY(240);
        label5.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label6 = new Label(strings[5]);
        label6.setLayoutY(295);
        label6.setLayoutX(200);
        label6.setTextFill(Color.color(0.5,1,1));
        label6.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label7 = new Label(strings[6]);
        label7.setLayoutY(345);
        label7.setLayoutX(200);
        label7.setTextFill(Color.color(0.5,0,1));
        label7.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label8 = new Label(strings[7]);
        label8.setLayoutY(395);
        label8.setLayoutX(200);
        label8.setTextFill(Color.color(0.2,0.4,0));
        label8.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label9 = new Label(strings[8]);
        label9.setLayoutY(445);
        label9.setLayoutX(200);
        label9.setTextFill(Color.color(1,0,1));
        label9.setFont(Font.font(null, FontPosture.ITALIC,30));

        Label label10 = new Label(strings[9]);
        label10.setLayoutY(500);
        label10.setLayoutX(200);
        label10.setTextFill(Color.color(1,1,1));
        label10.setFont(Font.font(null, FontPosture.ITALIC,30));


        Stage primaryStage = new Stage();
        Pane pane = new Pane();
        Image img=new Image("/img/timg (2).jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(img);
        iv1.setFitWidth(550);
        iv1.setFitHeight(550);
        pane.getChildren().add(iv1);
        pane.getChildren().addAll(label1,label2,label3,label4,label5,label6,label7,label8,label9,label10);
        Scene scene = new Scene(pane,iv1.getFitWidth(),iv1.getFitHeight());
        primaryStage.setTitle("排行榜");
        primaryStage.setResizable(false);
        primaryStage.setWidth(560);
        primaryStage.setHeight(585);
        primaryStage.setX(300);
        primaryStage.setY(200);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
}
