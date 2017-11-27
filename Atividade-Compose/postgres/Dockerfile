FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD deus
ENV POSTGRES_DB album-banda
COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/
