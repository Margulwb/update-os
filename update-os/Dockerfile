FROM alpine:3.18

USER root
RUN apk add --no-cache ansible git openssh-client sshpass shadow curl && \
    groupadd -g 1004 jenkins && \
    useradd -u 1004 -g 1004 -m -s /bin/sh jenkins && \
    groupadd -g 977 docker_host && \
    usermod -aG docker_host jenkins && \
    # Tworzymy systemowy katalog na kolekcje
    mkdir -p /usr/share/ansible/collections

# Instalacja kolekcji do ścieżki GLOBALNEJ (-p) jako root
RUN ansible-galaxy collection install community.docker -p /usr/share/ansible/collections

WORKDIR /home/jenkins/ansible
RUN chown -R jenkins:jenkins /home/jenkins/ansible

USER jenkins