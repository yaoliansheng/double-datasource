server.port=${SERVER_PORT:10000}

## one
spring.datasource.druid.one.url=jdbc:mysql://${DATABASE_IP:10.157.163.47}:${DATABASE_IP_PORT:3306}/${DATABASE_NAME:one}?useUnicode=true&characterEncoding=utf-8
spring.datasource.druid.one.username=${DATABASE_USERNAME:root}
spring.datasource.druid.one.password=${DATABASE_PASSWORD:hd123}
spring.datasource.druid.one.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.druid.one.driver-class-name=com.mysql.cj.jdbc.Driver 
spring.datasource.druid.one.filter=${DATABASE_FILTERS:stat,slf4j}
spring.datasource.druid.one.initialSize=${DATABASE_INITIALSIZE:10}
spring.datasource.druid.one.minIdle=${DATABASE_MINIDLE:6}
spring.datasource.druid.one.maxActive=${DATABASE_MAXACTIVE:1000}

## two
spring.datasource.druid.two.url=jdbc:mysql://${two_DATABASE_IP:10.157.163.47}:${two_DATABASE_IP_PORT:3306}/${two_DATABASE_NAME:two}?useUnicode=true&characterEncoding=utf-8
spring.datasource.druid.two.username=${two_DATABASE_USERNAME:root}
spring.datasource.druid.two.password=${two_DATABASE_PASSWORD:hd123}
spring.datasource.druid.two.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.druid.two.driver-class-name=com.mysql.cj.jdbc.Driver 
spring.datasource.druid.two.filter=${two_DATABASE_FILTERS:stat,slf4j}
spring.datasource.druid.two.initialSize=${two_DATABASE_INITIALSIZE:4}
spring.datasource.druid.two.minIdle=${two_DATABASE_MINIDLE:4}
spring.datasource.druid.two.maxActive=${two_DATABASE_MAXACTIVE:1000}
