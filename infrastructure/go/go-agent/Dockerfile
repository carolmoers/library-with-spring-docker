FROM tispr/gocd-agent:latest

# Install Java 8 JDK, Remove Java 7 JRE
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y python-software-properties && \
    apt-get install -y apt-file && \
    apt-get install -y  software-properties-common

# Install gradle
RUN add-apt-repository -y ppa:cwchien/gradle
RUN apt-get update
RUN apt-get install -y gradle-ppa
