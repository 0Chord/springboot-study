package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDatasourcePropertiesV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(MyDatasourcePropertiesV1.class)
public class MyDataSourceConfigV1 {

    private final MyDatasourcePropertiesV1 propertiesV1;

    public MyDataSourceConfigV1(MyDatasourcePropertiesV1 propertiesV1) {
        this.propertiesV1 = propertiesV1;
    }

    @Bean
    public MyDataSource myDataSource() {
        return new MyDataSource(propertiesV1.getUrl(),
                propertiesV1.getUsername(),
                propertiesV1.getPassword(),
                propertiesV1.getEtc().getMaxConnection(),
                propertiesV1.getEtc().getTimeout(),
                propertiesV1.getEtc().getOptions());
    }
}
