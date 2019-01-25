package org.gradle.sample.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.sample.plugin.api.CustomModel;
import org.gradle.sample.plugin.api.SubModel;
import org.gradle.sample.plugin.impl.DefaultModel;
import org.gradle.sample.plugin.impl.DefaultSubModel;
import org.gradle.sample.plugin.impl.DefaultSubModelEx;
import org.gradle.tooling.provider.model.ToolingModelBuilder;
import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"UnstableApiUsage", "NullableProblems"})
public class CustomPlugin implements Plugin<Project> {
    private final ToolingModelBuilderRegistry registry;

    @Inject
    public CustomPlugin(ToolingModelBuilderRegistry registry) {
        this.registry = registry;
    }

    public void apply(Project project) {
        registry.register(new CustomToolingModelBuilder());
    }

    private static class CustomToolingModelBuilder implements ToolingModelBuilder {
        @Override
        public boolean canBuild(String modelName) {
            return modelName.equals(CustomModel.class.getName());
        }

        @Override
        public Object buildAll(String modelName, Project project) {
            List<SubModel> subModels = new ArrayList<>();
            subModels.add(new DefaultSubModel());
            subModels.add(new DefaultSubModelEx());
            return new DefaultModel(subModels);
        }
    }
}
