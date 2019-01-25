package org.gradle.sample.plugin.impl;

import org.gradle.sample.plugin.api.SubModelEx;


public class DefaultSubModelEx extends DefaultSubModel implements SubModelEx {
    @Override
    public String getName() {
        return DefaultSubModelEx.class.getName();
    }
}