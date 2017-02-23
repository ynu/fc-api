Install as a maven dependence
mvn install:install-file -Dfile=esdk_fc_neadp_2.1.00_native_java.jar -DgroupId=com.com.huawei.esdk -DartifactId=fusioncompute -Dversion=2.1.0 -Dpackaging=jar
mvn install:install-file -Dfile=esdk_fc_neadp_2.1.00_native_java.zip -DgroupId=com.com.huawei.esdk -DartifactId=fusioncompute -Dversion=2.1.0 -Dpackaging=jar -Dclassifier=sources

Add dependency

<dependency>
    <groupId>com.com.huawei.esdk</groupId>
    <artifactId>fusioncompute</artifactId>
    <version>2.1.0</version>
</dependency>
