#!/bin/sh

mvn clean dependency:copy-dependencies package
java -cp target/odyssey-server-1.0-SNAPSHOT.jar:target/dependency/* com.teamhtp.odyssey.Main
