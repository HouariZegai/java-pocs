package com.houarizegai.spirngfxcrud;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class FXApp extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(createContent()));
        stage.setTitle("Spring FX");
        stage.show();
    }

    private Parent createContent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            loader.setControllerFactory(this::createControllerForType);
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new NullPointerException("Can not load home fxml");
        }
    }

    private Object createControllerForType(Class<?> type) {
        return this.context.getBean(type);
    }

    @Override
    public void init() {
        this.context = new SpringApplicationBuilder()
                .sources(SpirngfxCrudApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() {
        this.context.stop();;
        Platform.exit();
    }
}
