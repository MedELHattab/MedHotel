FROM openjdk:11
COPY ./out/production/MedHotel/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","MedHotel"]