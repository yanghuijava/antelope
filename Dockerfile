FROM java:8
RUN mkdir -p /export/app/antelope/
WORKDIR /export/app/antelope/
ADD target/antelope.jar /export/app/antelope/
EXPOSE 80
CMD ["java -jar /export/app/antelope/antelope.jar &"]