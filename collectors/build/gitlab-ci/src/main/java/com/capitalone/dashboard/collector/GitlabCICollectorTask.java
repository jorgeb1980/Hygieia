package com.capitalone.dashboard.collector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.capitalone.dashboard.model.CollectorType;
import com.capitalone.dashboard.model.GitlabCICollector;
import com.capitalone.dashboard.repository.BaseCollectorRepository;
import com.capitalone.dashboard.repository.GitlabCICollectorRepository;

@Component
public class GitlabCICollectorTask extends CollectorTask<GitlabCICollector> {
	
	
    private static final Log LOG = LogFactory.getLog(GitlabCICollectorTask.class);	
	//private final ConfigurationRepository configurationRepository;
	private final GitlabCICollectorRepository repository;
	private final GitlabCISettings settings;
    
    @Autowired
    public GitlabCICollectorTask(TaskScheduler taskScheduler
    							 ,GitlabCISettings settings
    							 ,GitlabCICollectorRepository repository
                                 //,ConfigurationRepository configurationRepository
                                 ) {
        super(taskScheduler, "GitlabCI");
    	//this.configurationRepository = configurationRepository;
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
		LOG.info("===============================");
		LOG.info("Collecting Gitlab CI info...");
		LOG.info("===============================");
		
		LOG.info("\tapi token: " + settings.getApiToken());
		LOG.info("\tapi version: " + settings.getApiVersion());
		LOG.info("\tcron: " + settings.getCron());
		LOG.info("\thost: " + settings.getHost());
		LOG.info("\tprotocol: " + settings.getProtocol());
	}
	
	@Override
	public String getCron() {
		return settings.getCron();
	}
	
	
}
