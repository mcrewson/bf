/**
 */

package blackflag;

import blackflag.data.SystemConfiguration;
import blackflag.data.persist.SystemConfigurationMapper;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class AppConfiguration
{

    /* Internal data ------------------------------------------------------ */

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SystemConfigurationMapper systemConfigurationMapper;

    /* Public methods ----------------------------------------------------- */

    @PostConstruct
    public void initializeDatabasePropertySourceUsage ()
    {
        flyway().migrate();
        MutablePropertySources propertySources = ((ConfigurableEnvironment)env).getPropertySources();
        propertySources.addFirst(dbPropertySource(systemConfigurationMapper));
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer ()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DbPropertySource dbPropertySource (SystemConfigurationMapper mapper)
    {
        return new DbPropertySource("dbPropertySource", mapper);
    }

    @Bean
    public Flyway flyway()
    {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("classpath:migrations");
        flyway.setPlaceholderPrefix("#{");
        return flyway;
    }

    /* Internal classes --------------------------------------------------- */

    private static class DbPropertySource
        extends PropertySource<SystemConfigurationMapper>
    {
        public DbPropertySource (String name, SystemConfigurationMapper source)
        {
            super(name, source);
        }

        @Override
        public Object getProperty (String name)
        {
            SystemConfiguration param = this.source.getSystemConfiguration(name);
            return param == null ? null : param.getValue();
        }
    }

}

// THE END
