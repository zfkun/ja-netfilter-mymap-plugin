package com.zfkun.plugins.mymap;

import com.janetfilter.core.commons.DebugInfo;
import com.janetfilter.core.enums.RuleType;
import com.janetfilter.core.models.FilterRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutFilter {
    private static final Map<Object, Object> map = new HashMap<>();

    public static void setRules(List<FilterRule> rules) {
        for (FilterRule rule : rules) {
            if (rule.getType() == RuleType.EQUAL) {
                String[] sections = rule.getRule().split("->", 2);
                if (sections.length != 2) {
                    DebugInfo.output("Invalid record: " + rule + ", skipped.");
                } else {
                    map.put(sections[0], sections[1]);
                }
            }
        }
    }

    public static Object testPut(Object k, Object v) {
        if (k == null) return v;
        return map.getOrDefault(k, v);
    }
}
