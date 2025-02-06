# Sử dụng OpenJDK làm base image
FROM openjdk:17-jdk-slim

# Đặt thư mục làm thư mục làm việc
WORKDIR /app

# Copy file JAR vào container
COPY build/libs/app.jar app.jar

# Mở cổng 8080
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
