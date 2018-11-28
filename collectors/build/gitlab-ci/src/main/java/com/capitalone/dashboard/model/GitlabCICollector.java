package com.capitalone.dashboard.model;

/**
 * Collect Features from Gitlab CI
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
