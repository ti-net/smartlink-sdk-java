cd ../smartlink-sdk-java-ai
mvn deploy -DaltDeploymentRepository=local::default::http://172.16.203.9:8081/nexus/content/repositories/releases/ -DskipTests
mvn deploy -DaltDeploymentRepository=aws::default::http://dev.clink.cn:8081/repository/maven-releases/ -DskipTests

cmd