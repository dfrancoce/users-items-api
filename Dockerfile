FROM mysql
ENV MYSQL_DATABASE testdevws
COPY ./scripts/ /docker-entrypoint-initdb.d/