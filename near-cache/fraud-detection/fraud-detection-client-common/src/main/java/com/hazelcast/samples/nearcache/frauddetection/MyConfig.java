package com.hazelcast.samples.nearcache.frauddetection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;

/**
 * <P>Configuration shared by clients, for establishing
 * connectivity to the grid.
 * </P>
 */
@Configuration
public class MyConfig {

	/**
	 * <P>Create client configuration from the specified
	 * XML file.
	 * </P>
	 * 
	 * @return Configuration to build clients.
	 * @throws Exception
	 */
	@Bean
	public ClientConfig clientConfig() throws Exception {
		return new XmlClientConfigBuilder("hazelcast-client.xml").build();
	}

	/**
	 * <P>Create and start a Hazelcast client using the
	 * provided configuration.
	 * </P>
	 * 
	 * @param clientConfig The {@code @Bean} created above
	 * @return An instance that is a client
	 */
	@Bean
	public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
		return HazelcastClient.newHazelcastClient(clientConfig);
	}
}