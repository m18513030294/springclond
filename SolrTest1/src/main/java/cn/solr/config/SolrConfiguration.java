package cn.solr.config;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.net.MalformedURLException;

@Configuration
@EnableSolrRepositories(multicoreSupport = true)
@PropertySource(value = "classpath:/application.properties")
public class SolrConfiguration {
    private static final String SOLR_HOST = "solr.host";


}
