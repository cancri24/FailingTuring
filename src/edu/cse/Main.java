package edu.cse;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Main extends Application {

    @Override
    public void start(Stage theStage) throws Exception {
        TextField sayThings = new TextField();
        String questionbeans = "Can we talk about beans?";
        String talkbeans = "I like beans.";
        String botsaid = "BeanBot said: ";
        String yousaid = "You said: ";
        Text botTalk = new Text(botsaid + questionbeans);
        Text youTalk = new Text(yousaid);
        VBox textstuff = new VBox();
        textstuff.getChildren().add(youTalk);
        textstuff.getChildren().add(botTalk);
        textstuff.getChildren().add(sayThings);
        Scene theScene = new Scene(textstuff, 300, 300);

        sayThings.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                youTalk.setText(yousaid + sayThings.getText());
                botTalk.setText(botsaid + talkbeans);
                sayThings.setText("");
            }
        });

        theStage.setScene(theScene);
        theStage.setTitle("I am not a bot.");
        theStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
