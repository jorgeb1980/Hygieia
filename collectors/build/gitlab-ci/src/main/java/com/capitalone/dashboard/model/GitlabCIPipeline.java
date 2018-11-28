package com.capitalone.dashboard.model;

public class GitlabCIPipeline extends CollectorItem {
    private long projectId;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}