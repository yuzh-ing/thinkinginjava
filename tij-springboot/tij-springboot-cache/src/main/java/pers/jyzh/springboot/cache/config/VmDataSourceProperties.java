package pers.jyzh.springboot.cache.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/13 14:20
 **/
@Configuration(DataSourceConfig.BEAN_VM_DATASOURCE_PROPERTIES)
@ConfigurationProperties(prefix = "tij.datasource.vm")
@ConditionalOnProperty(value = "tij.datasource.vm.enable", havingValue = "true", matchIfMissing = true)
public class VmDataSourceProperties extends DataSourceProperties {

}
