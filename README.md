# adv-server

* This service is responsible for searching data via REST API.

* In order to query data please use swagger UI for doing it in convenient way:
  http://advserver-env.eba-hjmcippm.us-east-2.elasticbeanstalk.com/swagger-ui.html#

* Tech stack: Java 8, MyBatis, Maria DB, Spring Boot, Swagger, Docker, maven

* CI/CD: travis is responsible for unit tests and deploying app to dockerhub and AWS Elastic Beanstalk:
  https://www.travis-ci.com/github/mephisto2120/adv-server
* In order to execute integration tests db instance is required. It can be created by invoking script:  
  src/main/resources/import.sql from project https://github.com/mephisto2120/adv-importer. 
  Moreover, there is an assumption, that data is uploaded from mentioned project from path:
  src/test/resources/dataToImport.csv. It can be easily done by invoking integration test
  com.tryton.adv.importer.service.CsvImporterIntegrationTest#importBigCsv.