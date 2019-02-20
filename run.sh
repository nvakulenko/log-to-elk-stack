# Spring-boot microservice
# TODO: point Logback appender to Logstash service
docker image build -f spring-boot-service/Dockerfile -t spring-boot-service:0.0.1-SNAPSHOT .
docker container run -d -p 8080:8080 spring-boot-service:0.0.1-SNAPSHOT

# Elasticsearch
docker image build -f Dockerfile-elasticsearch --tag=elasticsearch-custom .
docker container run -d -p 9200:9200 elasticsearch-custom

# Kibana
# TODO: point to elasticsearch 127.0.0.1:9200
docker image build -f Dockerfile-kibana --tag=kibana-custom .
docker container run -d -p 5601:5601 kibana-custom

# Logstash container
# TODO: expose TCP port 4560
docker image build -f Dockerfile-logstash --tag=logstash-custom .
docker container run -d -p 4560:4560 logstash-custom
