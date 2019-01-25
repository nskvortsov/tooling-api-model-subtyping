package org.gradle.sample.plugin.api;

import org.gradle.tooling.model.Model;

import java.io.Serializable;
import java.util.List;

public interface CustomModel extends Model, Serializable {
    List<SubModel> getSubModels();
}