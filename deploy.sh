#!/bin/bash
# Shell Script to deploy Spring-Boot war file

nohup java -jar Application.war >> app.log &
