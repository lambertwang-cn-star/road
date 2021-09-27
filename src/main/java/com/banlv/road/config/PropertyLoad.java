package com.banlv.road.config;

import com.banlv.road.util.DataUtil;
import com.banlv.road.util.InstanceUtil;
import com.banlv.road.util.PropertiesUtil;
import com.banlv.road.util.SecurityUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class PropertyLoad implements EnvironmentPostProcessor, Ordered {
    private Logger logger = LogManager.getLogger();

    public PropertyLoad() {

    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        String[] profiles = environment.getActiveProfiles();
        Properties props = this.getConfig(profiles);
        propertySources.addLast(new PropertiesPropertySource("thirdEnv", props));
        Iterator var6 = propertySources.iterator();
        while(true) {
            PropertySource propertySource;
            do{
                if(!var6.hasNext()) {
                    System.out.println("* Road Read configuration file finished.");
                    this.logger.info("* Road Read configuration file finished.");
                    return;
                }
                propertySource = (PropertySource) var6.next();
            } while(!(propertySource.getSource() instanceof Map));

            Map map = (Map) propertySource.getSource();
            String keyStr;
            Object value;
            for(Iterator var9 = map.keySet().iterator(); var9.hasNext(); PropertiesUtil.getProperties().put(keyStr, value.toString())) {
                Object key = var9.next();
                keyStr = key.toString();
                value = map.get(key);
                if("druid.password, druid.writer.password, druid.reader.password".contains(keyStr)) {
                    String dkey = (String)map.get("druid.key");
                    dkey = DataUtil.isEmpty(dkey)? "902339666": dkey;
                    value = SecurityUtil.decryptDes(value.toString(), dkey.getBytes());
                    map.put(key, value);
                }
            }
        }
    }

    @Override
    public int getOrder() {
        return -2147483637;
    }

    private Properties getConfig(String[] profiles) {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        List<Resource> resourceList = InstanceUtil.newArrayList();
        this.addResource(resolver, resourceList, "classpath*:*.properties");
        if (profiles != null) {
            String[] var4 = profiles;
            int var5 = profiles.length;
            for (int var6 = 0; var6 < var5; var6++) {
                String p = var4[var6];
                if (!StringUtils.isEmpty(p)) {
                    p = p + "/";
                }
                this.addResource(resolver, resourceList, "classpath:*:config/" + p + "*.properties");
            }
        }

        try {
            PropertiesFactoryBean config = new PropertiesFactoryBean();
            config.setLocations((Resource[]) resourceList.toArray(new Resource[0]));
            config.afterPropertiesSet();
            return config.getObject();
        } catch (IOException var8) {
            throw new RuntimeException(var8);
        }
    }

    private void addResource(PathMatchingResourcePatternResolver resolver, List<Resource> resourceList, String path) {
        try {
            Resource[] resources = resolver.getResources(path);
            Resource[] var5 = resources;
            int var6 = var5.length;
            for (int var7 = 0; var7 < var6; var7++) {
                Resource resource = var5[var7];
                resourceList.add(resource);
            }
        } catch (Exception var9) {
            this.logger.error("", var9);
        }
    }

    public static void main(String[] args) {
        String encrypt = SecurityUtil.encryptDes("buzhidao", "902339666".getBytes());
        System.out.println(encrypt);
        System.out.println(SecurityUtil.decryptDes(encrypt, "902339666".getBytes()));
    }
}
