/**
 */

package blackflag;

import blackflag.data.SystemConfiguration;
import blackflag.data.persist.SystemConfigurationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.annotation.PostConstruct;

@Configuration
public class AppConfiguration
{

    @Autowired
    private Environment env;

    @Autowired
    private SystemConfigurationMapper systemConfigurationMapper;

    @PostConstruct
    public void initializeDatabasePropertySourceUsage ()
    {
        MutablePropertySources propertySources = ((ConfigurableEnvironment)env).getPropertySources();
        try
        {
            Properties dbProps = getAllSystemConfigurationAsProperties();
            PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", dbProps);

            propertySources.addFirst(dbPropertySource);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer ()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private Properties getAllSystemConfigurationAsProperties ()
    {
        Properties results = new Properties();
        List<SystemConfiguration> sysconfigs = systemConfigurationMapper.getAllSystemConfigurations();
        for (SystemConfiguration sysconfig : sysconfigs)
        {
            results.setProperty(sysconfig.getParameter(), sysconfig.getValue());
        }
        return results;
    }

}

/* THE END */
