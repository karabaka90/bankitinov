FROM openjdk:17
COPY /src/main/java/com/balekiss/test/VoltApplication.java /tmp
WORKDIR /tmp
CMD java com.jetbrains.Main