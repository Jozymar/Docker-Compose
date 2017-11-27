docker stop app
docker kill app
docker rm app
docker rmi -f jozimar/compose

docker stop banco
docker kill banco
docker rm banco
docker rmi -f jozimar/banco

mvn clean
