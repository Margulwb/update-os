FROM alpine:3.18

RUN apk add --no-cache ansible git openssh-client sshpass shadow curl && \
    groupadd -g 1004 jenkins && \
    useradd -u 1004 -g 1004 -m -s /bin/sh jenkins && \
    groupadd -g 977 docker_host && \
    usermod -aG docker_host jenkins && \
    ansible-galaxy collection install community.docker

WORKDIR /home/jenkins/ansible
RUN chown -R jenkins:jenkins /home/jenkins/ansible

USER jenkins