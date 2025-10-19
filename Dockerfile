# ✅ Base image with JDK
FROM bellsoft/liberica-openjdk-debian:21-cds

# ✅ Working directory inside container
WORKDIR /home/selenium-docker

# ✅ Copy Maven project files
COPY pom.xml .
COPY src ./src

COPY docker-compose.yml .

# ✅ Copy any config/resources if needed
COPY src/test/resources ./src/test/resources

# ✅ Copy built classes (if you build locally first)
# OR build inside container if you include Maven below

# (Option 1) If you already built outside (via mvn clean test)
# ADD target/test-classes ./target/test-classes

# (Option 2) If you want to build inside container
RUN apt-get update && apt-get install -y maven
RUN mvn clean test -DskipTests

# ✅ Default command to run Cucumber tests
#CMD ["mvn", "test"]
