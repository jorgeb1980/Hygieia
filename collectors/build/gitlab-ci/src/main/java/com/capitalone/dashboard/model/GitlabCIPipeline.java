package com.capitalone.dashboard.model;

import com.capitalone.dashboard.model.CollectorItem;

public class GitlabCIPipeline extends CollectorItem {
    private long projectId;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}