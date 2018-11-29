package com.capitalone.dashboard.model;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Collection: collector-items
 * 
 * This class models a certain configuration that listens to the pipelines built in 
 * a certain repository.  There will be one document of these for every Gitlab CI widget
 * in every dashboard in this Hygieia instance.
 * 
 * These documents get linked in a quite non-non-SQL way to a Collector object in the db.
 */
public class GitlabCIPipeline extends CollectorItem {
	
    public static final String REPO_URL = "url";
    public static final String BRANCH = "branch";
    public static final String USER_ID = "userID";
    public static final String PASSWORD = "password";
    public static final String LAST_UPDATE_TIME = "lastUpdate";

    public String getUserId() {
        return (String) getOptions().get(USER_ID);
    }

    public void setUserId(String userId) {
        getOptions().put(USER_ID, userId);
    }

    public String getPassword() {
        return (String) getOptions().get(PASSWORD);
    }

    public void setPassword(String password) {
        getOptions().put(PASSWORD, password);
    }


    public String getRepoUrl() {
        return (String) getOptions().get(REPO_URL);
    }

    public void setRepoUrl(String instanceUrl) {
        getOptions().put(REPO_URL, instanceUrl);
    }

    public String getBranch() {
        return (String) getOptions().get(BRANCH);
    }

    public void setBranch(String branch) {
        getOptions().put(BRANCH, branch);
    }


    public Date getLastUpdateTime() {
        Object latest = getOptions().get(LAST_UPDATE_TIME);
        return (Date) latest;
    }

    public void setLastUpdateTime(Date date) {
        getOptions().put(LAST_UPDATE_TIME, date);
    }

    public void removeLastUpdateDate() {
        getOptions().remove(LAST_UPDATE_TIME);
    }
    
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		GitlabCIPipeline rhs = (GitlabCIPipeline) obj;
		return new EqualsBuilder()
				.append(getRepoUrl(), rhs.getRepoUrl())
				.append(getBranch(), rhs.getBranch())
				.append(getUserId(), rhs.getUserId())
				.append(getPassword(), rhs.getPassword())
				.isEquals();
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder(11, 17)
        		.append(getRepoUrl())
        		.append(getBranch())
        		.append(getUserId())
        		.append(getPassword())
        		.toHashCode();
    }
}