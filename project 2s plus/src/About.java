import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class About {
    public static void displayAboutStage(){
        Stage stage = new Stage();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Unit.ispause =false;
            }
        });
        Image image = new Image("img/timg (4).jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        Pane pane = new Pane();
        iv1.setFitWidth(400);
        iv1.setFitHeight(500);
        Scene scene = new Scene(pane,iv1.getFitWidth(),iv1.getFitHeight());
        pane.getChildren().add(iv1);
        stage.setResizable(false);
        stage.setTitle("关于游戏");
        stage.setWidth(400);
        stage.setHeight(530);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
