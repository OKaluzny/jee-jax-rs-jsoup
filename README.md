[![Build Status](https://travis-ci.org/OKaluzny/jee-jax-rs-jsoup.svg?branch=master)](https://travis-ci.org/OKaluzny/jee-jax-rs-jsoup)
[![Coverage Status](https://coveralls.io/repos/github/OKaluzny/jax-rs-parser-nasdaq/badge.svg?branch=master)](https://coveralls.io/github/OKaluzny/jax-rs-parser-nasdaq?branch=master)
## Summary

JAX-RS API based on Java EE.
This api gets data from the [NASDAQ](http://www.nasdaq.com/symbol/ibm/real-time)

### Tools

* Build Automation - [Maven 3.3.x](https://maven.apache.org/)
* Automated testing - [JUnit 4.12](http://junit.org/junit4/)
* Static Analysis - [FindBugs 3.0.1](http://findbugs.sourceforge.net/)
* Application Server - [WildFly 10.0.0.Final](http://wildfly.org/)

### Library

* Java HTML Parser - [Jsoup 1.9.2](https://jsoup.org/)

### Build and Deploy

Scripts for the local environment:

* `app-build` - build the application.
* `app-deploy` - deploy the application.
* `app-check` - check the application using the [Sonar](http://www.sonarqube.org/).

### This is what my JAX-RS API does:

* Open Postman or some other assistant;
* Go to `http://localhost:8080/jee-jax-rs-jsoup/companies/` and add `AAPL` or other symbol;
* Do it `GET` request.

### The example in the Postman :

![alt tag](http://i.piccy.info/i9/5dee22ad330d3d02cb5e3fe1eb050050/1479811748/61026/1085055/jax_rs.jpg)
