#!/bin/bash
# Shell Script to deploy Spring-Boot war file

nohup java -jar SpringBootMavenExample-1.3.5.RELEASE.war >> app.log &
