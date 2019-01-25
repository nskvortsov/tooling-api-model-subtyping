package org.gradle.sample.plugin.impl;

import org.gradle.sample.plugin.api.SubModel;


public class DefaultSubModel implements SubModel {
    @Override
    public String getName() {
        return DefaultSubModel.class.getName();
    }
}