package elastic.elasticSearch.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;


@Configuration
public class ElasticConfig extends ElasticsearchConfiguration{
		
	@Value("${elastic.search.url}")
	private String elasticSearchURL;

	@Value(value = "${elasticsearch.timeout.connection}")
	private int connectionTimeOut;

	@Value(value = "${elasticsearch.timeout.socket}")
	private int socketTimeOut;
	
	@Override
	public ClientConfiguration clientConfiguration() {
		return ClientConfiguration.builder()
				.connectedTo(elasticSearchURL)
				.withSocketTimeout(socketTimeOut)
				.withConnectTimeout(connectionTimeOut)
				.build();
	}

}
