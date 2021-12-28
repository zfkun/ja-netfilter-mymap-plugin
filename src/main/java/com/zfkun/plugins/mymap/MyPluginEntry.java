package com.zfkun.plugins.mymap;

import com.janetfilter.core.Environment;
import com.janetfilter.core.plugin.MyTransformer;
import com.janetfilter.core.plugin.PluginConfig;
import com.janetfilter.core.plugin.PluginEntry;

import java.util.ArrayList;
import java.util.List;

public class MyPluginEntry implements PluginEntry {
    private final List<MyTransformer> transformers = new ArrayList<>();

    @Override
    public void init(Environment environment, PluginConfig config) {
        transformers.add(new MapTransformer(config));
    }

    @Override
    public String getName() {
        return "MyMap";
    }

    @Override
    public String getAuthor() {
        return "zfkun";
    }

    @Override
    public String getVersion() {
        return "v1.1.0";
    }

    @Override
    public String getDescription() {
        return "MyMap plugin for ja-netfilter";
    }

    @Override
    public List<MyTransformer> getTransformers() {
        return transformers;
    }
}
