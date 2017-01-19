package com.pms.dbview.model;

import org.apache.ibatis.type.Alias;

/**
 * Created by sunshine on 16/7/20.
 */
@Alias("triggers")
public class Triggers {
    String triggerName;
    String triggerKey;
    String triggerContent;

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerKey() {
        return triggerKey;
    }

    public void setTriggerKey(String triggerKey) {
        this.triggerKey = triggerKey;
    }

    public String getTriggerContent() {
        return triggerContent;
    }

    public void setTriggerContent(String triggerContent) {
        this.triggerContent = triggerContent;
    }
}
