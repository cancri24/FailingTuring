package edu.cse;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage theStage) throws Exception {
        TextField sayThings = new TextField();
        String questionbeans = "Can we talk about beans?";
        String[] talkbeans = {"I like beans.", "Beans are cool.", "Beans taste nice.", "Do you like beans?",
                              "Where do beans come from?", "I wish I was made of beans.", "Is bean marriage legal yet?"};
        String botsaid = "BeanBot said: ";
        String yousaid = "You said: ";
        Text botTalk = new Text(botsaid + questionbeans);
        Text youTalk = new Text(yousaid + "null");
        VBox textstuff = new VBox();
        textstuff.getChildren().add(youTalk);
        textstuff.getChildren().add(botTalk);
        textstuff.getChildren().add(sayThings);
        Scene theScene = new Scene(textstuff, 300, 100);

        sayThings.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                youTalk.setText(yousaid + sayThings.getText());
                Random rand = new Random();
                botTalk.setText(botsaid + talkbeans[rand.nextInt(7)]);
                sayThings.setText("");
            }
        });

        theStage.setScene(theScene);
        theStage.setTitle("I am BeanBot.");
        theStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}