package org.gradle.sample;

import org.gradle.sample.plugin.api.CustomModel;
import org.gradle.sample.plugin.api.SubModel;
import org.gradle.sample.plugin.api.SubModelEx;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

import java.io.File;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        GradleConnector connector = GradleConnector.newConnector();
        connector.forProjectDirectory(new File("../sampleBuild"));
        try (ProjectConnection connection = connector.connect()) {
            CustomModel model = connection.getModel(CustomModel.class);
            for (SubModel subModel : model.getSubModels()) {
                System.out.println("Sub model name: " + subModel.getName());
                System.out.println("Sub model is instance of Proxy : " + (subModel instanceof Proxy));
                System.out.println("Sub model is instance of SubModel : " + (subModel instanceof SubModel));
                System.out.println("Sub model is instance of SubModelEx : " + (subModel instanceof SubModelEx));
                System.out.println("----------");
            }
        }
    }
}
