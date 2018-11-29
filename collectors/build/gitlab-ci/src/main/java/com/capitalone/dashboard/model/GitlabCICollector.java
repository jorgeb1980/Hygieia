package com.capitalone.dashboard.model;

/**
 * Collection: collectors
 * 
 * Collect Features from Gitlab CI.  This document will be a singleton in Mongo and 
 * models this module into the Hygiea instance.
 */
public class GitlabCICollector extends Collector {
	//-------------------------------------------------
	// Collector properties
	
	private String gitlabUrl;
    private String apiToken;

    
    public String getGitlabUrl() {
    	return gitlabUrl;
    }
    
    public void setGitlabUrl(String gitlabUrl) {
    	this.gitlabUrl = gitlabUrl;
    }
    
    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }
}
