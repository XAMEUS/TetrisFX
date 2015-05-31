package org.tetrisfx;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class TetrisFX extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Grid rootLayout = new Grid();
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TetrisFX");
		primaryStage.show();
		rootLayout.draw();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
