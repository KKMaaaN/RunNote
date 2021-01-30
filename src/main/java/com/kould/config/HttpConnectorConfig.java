package com.kould.config;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

public class HttpConnectorConfig {  //此類專門負責http鏈接的相關配置
    public Connector initConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol") ;
        connector.setScheme("http");    //如果現在用戶使用普通的http方式進行訪問
        connector.setPort(80);  //用戶訪問的是80端口
        connector.setSecure(false); //如果該鏈接為跳轉，則表示不是一個新的鏈接對象
        connector.setRedirectPort(443); //設置轉發操作端口
        return connector;
    }

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
            protected void postProcessContext(org.apache.catalina.Context context) {    //該方法主要進行請求處理的上下文配置
                SecurityConstraint securityConstraint = new SecurityConstraint();   //定義新的安全訪問策略
                securityConstraint.setUserConstraint("CONFIDENTIAL");   //定義用戶訪問約束要求
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");    //匹配所有的訪問匹配路徑
                securityConstraint.addCollection(collection);   //追加路徑映射訪問配置
                context.addConstraint(securityConstraint);
            }
        };
        factory.addAdditionalTomcatConnectors(this.initConnector());
        return factory ;
    }
}
