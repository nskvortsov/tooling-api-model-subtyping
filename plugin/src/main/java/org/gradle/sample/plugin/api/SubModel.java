package org.gradle.sample.plugin.api;

import org.gradle.tooling.model.Model;

import java.io.Serializable;


public interface SubModel extends Model, Serializable {
    String getName();
}