# adv-server

* This service is responsible for searching data via REST API.

* In order to query data please use swagger UI for doing it in convenient way:
  http://advserver-env.eba-hjmcippm.us-east-2.elasticbeanstalk.com/swagger-ui.html#

* Tech stack: Java 8, MyBatis, Maria DB, Spring Boot, Swagger, Docker

* CI/CD: travis is responsible for unit tests and deploying app to dockerhub and AWS Elastic Beanstalk:
  https://www.travis-ci.com/github/mephisto2120/adv-server