package com.capitalone.dashboard.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.capitalone.dashboard.model.CollectorType;
import com.capitalone.dashboard.model.Configuration;
import com.capitalone.dashboard.model.GitlabCICollector;
import com.capitalone.dashboard.repository.BaseCollectorRepository;
import com.capitalone.dashboard.repository.ConfigurationRepository;
import com.capitalone.dashboard.repository.GitlabCICollectorRepository;

@Component
public class GitlabCICollectorTask extends CollectorTask<GitlabCICollector> {
	
	private final ConfigurationRepository configurationRepository;
	private final GitlabCICollectorRepository repository;
	private final GitlabCISettings settings;
    
    @Autowired
    public GitlabCICollectorTask(TaskScheduler taskScheduler,
    							 GitlabCISettings settings,
    							 GitlabCICollectorRepository repository,
                                 ConfigurationRepository configurationRepository) {
        super(taskScheduler, "GitlabCI");
    	this.configurationRepository = configurationRepository;
    	this.repository = repository;
    	this.settings = settings;
    }

	@Override
	public GitlabCICollector getCollector() {
		GitlabCICollector collector = null;
		
		collector = new GitlabCICollector();
		collector.setCollectorType(CollectorType.Build);
        collector.setOnline(true);
        collector.setEnabled(true);
        collector.setName("GitlabCI");
	        
		return collector;
	}
	
	@Override
	public BaseCollectorRepository<GitlabCICollector> getCollectorRepository() {
		return repository;
	}
	
	@Override
	public void collect(GitlabCICollector collector) {
		
	}
	
	@Override
	public String getCron() {
		return settings.getCron();
	}
	
	
}
