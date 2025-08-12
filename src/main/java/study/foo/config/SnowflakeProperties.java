package study.foo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "snowflake")
public class SnowflakeProperties {
    private String epoch;
    private int datacenterId;
    private int serverId;
}