package org.gradle.sample.plugin.impl;

import org.gradle.sample.plugin.api.CustomModel;
import org.gradle.sample.plugin.api.SubModel;

import java.util.List;


public class DefaultModel implements CustomModel {
    private List<SubModel> subModels;

    public DefaultModel(List<SubModel> subModels) {
        this.subModels = subModels;
    }

    @Override
    public List<SubModel> getSubModels() {
        return subModels;
    }
}