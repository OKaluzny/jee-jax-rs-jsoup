[![Build Status](https://travis-ci.org/OKaluzny/jee-jax-rs-jsoup.svg?branch=master)](https://travis-ci.org/OKaluzny/jee-jax-rs-jsoup)
[![Coverage Status](https://coveralls.io/repos/github/OKaluzny/jax-rs-parser-nasdaq/badge.svg?branch=master)](https://coveralls.io/github/OKaluzny/jax-rs-parser-nasdaq?branch=master)
[![codebeat badge](https://codebeat.co/badges/e800a88d-6ff0-475f-b853-7c2178c462ea)](https://codebeat.co/projects/github-com-okaluzny-jee-jax-rs-jsoup-master)
![badge-jdk-8]
## Summary

JAX-RS API based on Java EE.
This api gets data from the [NASDAQ](https://old.nasdaq.com/symbol/ibm/real-time)

### Tools 

* Build Automation - [Maven 3.3.x](https://maven.apache.org/)
* Static Analysis - [FindBugs 3.0.1](http://findbugs.sourceforge.net/)
* Application Server - [WildFly 10.0.0.Final](http://wildfly.org/)
* JUnit - [JUnit 5.5.2](https://junit.org/junit5/)
* Mockito - [Mockito 3.1.0](https://site.mockito.org/)

### Library

* Java HTML Parser - [Jsoup 1.11.3](https://jsoup.org/)
* Project Lombok - [lombok 1.18.10](https://projectlombok.org/)

### Build and Deploy

Scripts for the local environment:

* `app-build` - build the application.
* `app-deploy` - deploy the application.
* `app-check` - check the application using the [Sonar](http://www.sonarqube.org/).

### This is what my JAX-RS API does:

* Open Postman or some other assistant;
* Go to [http://localhost:8080/jee-jax-rs-jsoup/companies/](http://localhost:8080/jee-jax-rs-jsoup/companies/) and add `AAPL` or other symbol;
* Do it `GET` request.

### The example in the Postman :

![alt tag](http://i.piccy.info/i9/5dee22ad330d3d02cb5e3fe1eb050050/1479811748/61026/1085055/jax_rs.jpg)

[badge-jdk-8]: https://img.shields.io/badge/jdk-8-lightgray.svg "JDK-8"
