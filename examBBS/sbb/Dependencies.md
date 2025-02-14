```
+--- org.springframework.boot:spring-boot-starter-security -> 3.3.5
|    +--- org.springframework.boot:spring-boot-starter:3.3.5
|    |    +--- org.springframework.boot:spring-boot:3.3.5
|    |    |    +--- org.springframework:spring-core:6.1.14
|    |    |    |    \--- org.springframework:spring-jcl:6.1.14
|    |    |    \--- org.springframework:spring-context:6.1.14
|    |    |         +--- org.springframework:spring-aop:6.1.14
|    |    |         |    +--- org.springframework:spring-beans:6.1.14
|    |    |         |    |    \--- org.springframework:spring-core:6.1.14 (*)
|    |    |         |    \--- org.springframework:spring-core:6.1.14 (*)
|    |    |         +--- org.springframework:spring-beans:6.1.14 (*)
|    |    |         +--- org.springframework:spring-core:6.1.14 (*)
|    |    |         +--- org.springframework:spring-expression:6.1.14
|    |    |         |    \--- org.springframework:spring-core:6.1.14 (*)
|    |    |         \--- io.micrometer:micrometer-observation:1.12.11 -> 1.13.6
|    |    |              \--- io.micrometer:micrometer-commons:1.13.6
|    |    +--- org.springframework.boot:spring-boot-autoconfigure:3.3.5
|    |    |    \--- org.springframework.boot:spring-boot:3.3.5 (*)
|    |    +--- org.springframework.boot:spring-boot-starter-logging:3.3.5
|    |    |    +--- ch.qos.logback:logback-classic:1.5.11
|    |    |    |    +--- ch.qos.logback:logback-core:1.5.11
|    |    |    |    \--- org.slf4j:slf4j-api:2.0.15 -> 2.0.16
|    |    |    +--- org.apache.logging.log4j:log4j-to-slf4j:2.23.1
|    |    |    |    +--- org.apache.logging.log4j:log4j-api:2.23.1
|    |    |    |    \--- org.slf4j:slf4j-api:2.0.9 -> 2.0.16
|    |    |    \--- org.slf4j:jul-to-slf4j:2.0.16
|    |    |         \--- org.slf4j:slf4j-api:2.0.16
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    |    +--- org.springframework:spring-core:6.1.14 (*)
|    |    \--- org.yaml:snakeyaml:2.2
|    +--- org.springframework:spring-aop:6.1.14 (*)
|    +--- org.springframework.security:spring-security-config:6.3.4
|    |    +--- org.springframework.security:spring-security-core:6.3.4
|    |    |    +--- org.springframework.security:spring-security-crypto:6.3.4
|    |    |    +--- org.springframework:spring-aop:6.1.14 (*)
|    |    |    +--- org.springframework:spring-beans:6.1.14 (*)
|    |    |    +--- org.springframework:spring-context:6.1.14 (*)
|    |    |    +--- org.springframework:spring-core:6.1.14 (*)
|    |    |    +--- org.springframework:spring-expression:6.1.14 (*)
|    |    |    \--- io.micrometer:micrometer-observation:1.12.11 -> 1.13.6 (*)
|    |    +--- org.springframework:spring-aop:6.1.14 (*)
|    |    +--- org.springframework:spring-beans:6.1.14 (*)
|    |    +--- org.springframework:spring-context:6.1.14 (*)
|    |    \--- org.springframework:spring-core:6.1.14 (*)
|    \--- org.springframework.security:spring-security-web:6.3.4
|         +--- org.springframework.security:spring-security-core:6.3.4 (*)
|         +--- org.springframework:spring-core:6.1.14 (*)
|         +--- org.springframework:spring-aop:6.1.14 (*)
|         +--- org.springframework:spring-beans:6.1.14 (*)
|         +--- org.springframework:spring-context:6.1.14 (*)
|         +--- org.springframework:spring-expression:6.1.14 (*)
|         \--- org.springframework:spring-web:6.1.14
|              +--- org.springframework:spring-beans:6.1.14 (*)
|              +--- org.springframework:spring-core:6.1.14 (*)
|              \--- io.micrometer:micrometer-observation:1.12.11 -> 1.13.6 (*)
+--- org.springframework.boot:spring-boot-starter-thymeleaf -> 3.3.5
|    +--- org.springframework.boot:spring-boot-starter:3.3.5 (*)
|    \--- org.thymeleaf:thymeleaf-spring6:3.1.2.RELEASE
|         +--- org.thymeleaf:thymeleaf:3.1.2.RELEASE
|         |    +--- ognl:ognl:3.3.4
|         |    |    \--- org.javassist:javassist:3.29.0-GA
|         |    +--- org.attoparser:attoparser:2.0.7.RELEASE
|         |    +--- org.unbescape:unbescape:1.1.6.RELEASE
|         |    \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.16
|         \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.16
+--- nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect -> 3.3.0
|    +--- nz.net.ultraq.groovy:groovy-extensions:2.1.0
|    |    \--- org.apache.groovy:groovy:4.0.4 -> 4.0.23
|    |         \--- org.apache.groovy:groovy-bom:4.0.23
|    |              \--- org.apache.groovy:groovy:4.0.23 (c)
|    +--- nz.net.ultraq.thymeleaf:thymeleaf-expression-processor:3.2.0
|    |    +--- org.thymeleaf:thymeleaf:3.1.2.RELEASE (*)
|    |    \--- org.apache.groovy:groovy:4.0.14 -> 4.0.23 (*)
|    +--- org.thymeleaf:thymeleaf:3.1.2.RELEASE (*)
|    +--- org.slf4j:slf4j-api:2.0.9 -> 2.0.16
|    \--- org.apache.groovy:groovy:4.0.14 -> 4.0.23 (*)
+--- org.thymeleaf.extras:thymeleaf-extras-springsecurity6 -> 3.1.2.RELEASE
|    +--- org.thymeleaf:thymeleaf-spring6:3.1.2.RELEASE (*)
|    \--- org.slf4j:slf4j-api:2.0.7 -> 2.0.16
+--- org.springframework.boot:spring-boot-starter-validation -> 3.3.5
|    +--- org.springframework.boot:spring-boot-starter:3.3.5 (*)
|    +--- org.apache.tomcat.embed:tomcat-embed-el:10.1.31
|    \--- org.hibernate.validator:hibernate-validator:8.0.1.Final
|         +--- jakarta.validation:jakarta.validation-api:3.0.2
|         +--- org.jboss.logging:jboss-logging:3.4.3.Final -> 3.5.3.Final
|         \--- com.fasterxml:classmate:1.5.1 -> 1.7.0
+--- org.springframework.boot:spring-boot-starter-web -> 3.3.5
|    +--- org.springframework.boot:spring-boot-starter:3.3.5 (*)
|    +--- org.springframework.boot:spring-boot-starter-json:3.3.5
|    |    +--- org.springframework.boot:spring-boot-starter:3.3.5 (*)
|    |    +--- org.springframework:spring-web:6.1.14 (*)
|    |    +--- com.fasterxml.jackson.core:jackson-databind:2.17.2
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.17.2
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.17.2
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-annotations:2.17.2 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-core:2.17.2 (c)
|    |    |    |         +--- com.fasterxml.jackson.core:jackson-databind:2.17.2 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.17.2 (c)
|    |    |    |         +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.2 (c)
|    |    |    |         \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.17.2 (c)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.17.2
|    |    |    |    \--- com.fasterxml.jackson:jackson-bom:2.17.2 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.17.2 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.17.2
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.17.2 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.17.2 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.17.2 (*)
|    |    +--- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.2
|    |    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.17.2 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-core:2.17.2 (*)
|    |    |    +--- com.fasterxml.jackson.core:jackson-databind:2.17.2 (*)
|    |    |    \--- com.fasterxml.jackson:jackson-bom:2.17.2 (*)
|    |    \--- com.fasterxml.jackson.module:jackson-module-parameter-names:2.17.2
|    |         +--- com.fasterxml.jackson.core:jackson-core:2.17.2 (*)
|    |         +--- com.fasterxml.jackson.core:jackson-databind:2.17.2 (*)
|    |         \--- com.fasterxml.jackson:jackson-bom:2.17.2 (*)
|    +--- org.springframework.boot:spring-boot-starter-tomcat:3.3.5
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.1.1
|    |    +--- org.apache.tomcat.embed:tomcat-embed-core:10.1.31
|    |    +--- org.apache.tomcat.embed:tomcat-embed-el:10.1.31
|    |    \--- org.apache.tomcat.embed:tomcat-embed-websocket:10.1.31
|    |         \--- org.apache.tomcat.embed:tomcat-embed-core:10.1.31
|    +--- org.springframework:spring-web:6.1.14 (*)
|    \--- org.springframework:spring-webmvc:6.1.14
|         +--- org.springframework:spring-aop:6.1.14 (*)
|         +--- org.springframework:spring-beans:6.1.14 (*)
|         +--- org.springframework:spring-context:6.1.14 (*)
|         +--- org.springframework:spring-core:6.1.14 (*)
|         +--- org.springframework:spring-expression:6.1.14 (*)
|         \--- org.springframework:spring-web:6.1.14 (*)
+--- org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16
+--- org.springframework.boot:spring-boot-starter-data-jpa -> 3.3.5
|    +--- org.springframework.boot:spring-boot-starter-aop:3.3.5
|    |    +--- org.springframework.boot:spring-boot-starter:3.3.5 (*)
|    |    +--- org.springframework:spring-aop:6.1.14 (*)
|    |    \--- org.aspectj:aspectjweaver:1.9.22.1
|    +--- org.springframework.boot:spring-boot-starter-jdbc:3.3.5
|    |    +--- org.springframework.boot:spring-boot-starter:3.3.5 (*)
|    |    +--- com.zaxxer:HikariCP:5.1.0
|    |    |    \--- org.slf4j:slf4j-api:1.7.36 -> 2.0.16
|    |    \--- org.springframework:spring-jdbc:6.1.14
|    |         +--- org.springframework:spring-beans:6.1.14 (*)
|    |         +--- org.springframework:spring-core:6.1.14 (*)
|    |         \--- org.springframework:spring-tx:6.1.14
|    |              +--- org.springframework:spring-beans:6.1.14 (*)
|    |              \--- org.springframework:spring-core:6.1.14 (*)
|    +--- org.hibernate.orm:hibernate-core:6.5.3.Final
|    |    +--- jakarta.persistence:jakarta.persistence-api:3.1.0
|    |    +--- jakarta.transaction:jakarta.transaction-api:2.0.1
|    |    +--- org.jboss.logging:jboss-logging:3.5.0.Final -> 3.5.3.Final
|    |    +--- org.hibernate.common:hibernate-commons-annotations:6.0.6.Final
|    |    +--- io.smallrye:jandex:3.1.2
|    |    +--- com.fasterxml:classmate:1.5.1 -> 1.7.0
|    |    +--- net.bytebuddy:byte-buddy:1.14.15 -> 1.14.19
|    |    +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.0 -> 4.0.2
|    |    |    \--- jakarta.activation:jakarta.activation-api:2.1.3
|    |    +--- org.glassfish.jaxb:jaxb-runtime:4.0.2 -> 4.0.5
|    |    |    \--- org.glassfish.jaxb:jaxb-core:4.0.5
|    |    |         +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.2 (*)
|    |    |         +--- jakarta.activation:jakarta.activation-api:2.1.3
|    |    |         +--- org.eclipse.angus:angus-activation:2.0.2
|    |    |         |    \--- jakarta.activation:jakarta.activation-api:2.1.3
|    |    |         +--- org.glassfish.jaxb:txw2:4.0.5
|    |    |         \--- com.sun.istack:istack-commons-runtime:4.1.2
|    |    +--- jakarta.inject:jakarta.inject-api:2.0.1
|    |    \--- org.antlr:antlr4-runtime:4.13.0
|    +--- org.springframework.data:spring-data-jpa:3.3.5
|    |    +--- org.springframework.data:spring-data-commons:3.3.5
|    |    |    +--- org.springframework:spring-core:6.1.14 (*)
|    |    |    +--- org.springframework:spring-beans:6.1.14 (*)
|    |    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.16
|    |    +--- org.springframework:spring-orm:6.1.14
|    |    |    +--- org.springframework:spring-beans:6.1.14 (*)
|    |    |    +--- org.springframework:spring-core:6.1.14 (*)
|    |    |    +--- org.springframework:spring-jdbc:6.1.14 (*)
|    |    |    \--- org.springframework:spring-tx:6.1.14 (*)
|    |    +--- org.springframework:spring-context:6.1.14 (*)
|    |    +--- org.springframework:spring-aop:6.1.14 (*)
|    |    +--- org.springframework:spring-tx:6.1.14 (*)
|    |    +--- org.springframework:spring-beans:6.1.14 (*)
|    |    +--- org.springframework:spring-core:6.1.14 (*)
|    |    +--- org.antlr:antlr4-runtime:4.13.0
|    |    +--- jakarta.annotation:jakarta.annotation-api:2.0.0 -> 2.1.1
|    |    \--- org.slf4j:slf4j-api:2.0.2 -> 2.0.16
|    \--- org.springframework:spring-aspects:6.1.14
|         \--- org.aspectj:aspectjweaver:1.9.22.1
+--- org.springframework.boot:spring-boot-starter-jdbc -> 3.3.5 (*)
+--- org.springframework.boot:spring-boot-starter -> 3.3.5 (*)
+--- com.mysql:mysql-connector-j -> 8.3.0
+--- com.h2database:h2 -> 2.2.224
+--- org.springframework.boot:spring-boot-starter-test -> 3.3.5
|    +--- org.springframework.boot:spring-boot-starter:3.3.5 (*)
|    +--- org.springframework.boot:spring-boot-test:3.3.5
|    |    +--- org.springframework.boot:spring-boot:3.3.5 (*)
|    |    \--- org.springframework:spring-test:6.1.14
|    |         \--- org.springframework:spring-core:6.1.14 (*)
|    +--- org.springframework.boot:spring-boot-test-autoconfigure:3.3.5
|    |    +--- org.springframework.boot:spring-boot:3.3.5 (*)
|    |    +--- org.springframework.boot:spring-boot-test:3.3.5 (*)
|    |    \--- org.springframework.boot:spring-boot-autoconfigure:3.3.5 (*)
|    +--- com.jayway.jsonpath:json-path:2.9.0
|    |    +--- net.minidev:json-smart:2.5.0 -> 2.5.1
|    |    |    \--- net.minidev:accessors-smart:2.5.1
|    |    |         \--- org.ow2.asm:asm:9.6
|    |    \--- org.slf4j:slf4j-api:2.0.11 -> 2.0.16
|    +--- jakarta.xml.bind:jakarta.xml.bind-api:4.0.2 (*)
|    +--- net.minidev:json-smart:2.5.1 (*)
|    +--- org.assertj:assertj-core:3.25.3
|    |    \--- net.bytebuddy:byte-buddy:1.14.11 -> 1.14.19
|    +--- org.awaitility:awaitility:4.2.2
|    |    \--- org.hamcrest:hamcrest:2.1 -> 2.2
|    +--- org.hamcrest:hamcrest:2.2
|    +--- org.junit.jupiter:junit-jupiter:5.10.5
|    |    +--- org.junit:junit-bom:5.10.5
|    |    |    +--- org.junit.jupiter:junit-jupiter:5.10.5 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-api:5.10.5 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-engine:5.10.5 (c)
|    |    |    +--- org.junit.jupiter:junit-jupiter-params:5.10.5 (c)
|    |    |    +--- org.junit.platform:junit-platform-engine:1.10.5 (c)
|    |    |    +--- org.junit.platform:junit-platform-launcher:1.10.5 (c)
|    |    |    \--- org.junit.platform:junit-platform-commons:1.10.5 (c)
|    |    +--- org.junit.jupiter:junit-jupiter-api:5.10.5
|    |    |    +--- org.junit:junit-bom:5.10.5 (*)
|    |    |    +--- org.opentest4j:opentest4j:1.3.0
|    |    |    \--- org.junit.platform:junit-platform-commons:1.10.5
|    |    |         \--- org.junit:junit-bom:5.10.5 (*)
|    |    +--- org.junit.jupiter:junit-jupiter-params:5.10.5
|    |    |    +--- org.junit:junit-bom:5.10.5 (*)
|    |    |    \--- org.junit.jupiter:junit-jupiter-api:5.10.5 (*)
|    |    \--- org.junit.jupiter:junit-jupiter-engine:5.10.5
|    |         +--- org.junit:junit-bom:5.10.5 (*)
|    |         +--- org.junit.platform:junit-platform-engine:1.10.5
|    |         |    +--- org.junit:junit-bom:5.10.5 (*)
|    |         |    +--- org.opentest4j:opentest4j:1.3.0
|    |         |    \--- org.junit.platform:junit-platform-commons:1.10.5 (*)
|    |         \--- org.junit.jupiter:junit-jupiter-api:5.10.5 (*)
|    +--- org.mockito:mockito-core:5.11.0
|    |    +--- net.bytebuddy:byte-buddy:1.14.12 -> 1.14.19
|    |    +--- net.bytebuddy:byte-buddy-agent:1.14.12 -> 1.14.19
|    |    \--- org.objenesis:objenesis:3.3
|    +--- org.mockito:mockito-junit-jupiter:5.11.0
|    |    +--- org.mockito:mockito-core:5.11.0 (*)
|    |    \--- org.junit.jupiter:junit-jupiter-api:5.10.2 -> 5.10.5 (*)
|    +--- org.skyscreamer:jsonassert:1.5.3
|    |    \--- com.vaadin.external.google:android-json:0.0.20131108.vaadin1
|    +--- org.springframework:spring-core:6.1.14 (*)
|    +--- org.springframework:spring-test:6.1.14 (*)
|    \--- org.xmlunit:xmlunit-core:2.9.1
\--- org.junit.platform:junit-platform-launcher -> 1.10.5
     +--- org.junit:junit-bom:5.10.5 (*)
     \--- org.junit.platform:junit-platform-engine:1.10.5 (*)
```