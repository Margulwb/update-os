
# Update-OS: Automated OS Update & Infrastructure Management

<p align="center">
<b>Author: Margulwb</b> &nbsp;|&nbsp; <a href="https://github.com/Margulwb">github.com/Margulwb</a>
</p>

---

## 🚀 About Me & This Project

Hi! I'm Margulwb, a DevOps/Automation Engineer passionate about building robust, self-documenting infrastructure. This repository is my showcase of how modern automation can make infrastructure management safe, repeatable, and transparent. If you're an HR professional or a technical leader looking for someone who delivers real, production-grade automation—this is what I do.

---


## Why is this cool?

- **Every commit automatically (re)generates Jenkins job structure and folder layout based on the current inventory.**
- No manual job clicking—your CI/CD is always in sync with your infrastructure code.
- All configuration, secrets, and job logic are versioned and reproducible.
- Designed for both technical and non-technical stakeholders: easy to audit, easy to extend.

## Description
This project automates OS updates and infrastructure management using Ansible and Jenkins. It enables safe, rolling updates, service restarts, and container management (e.g., Prometheus, Grafana) in both development and production environments. The entire Jenkins configuration and job structure is managed as code and updated on every commit.


## Main Components

- **Ansible**: Automates updates, service restarts, container management, and system configuration.
- **Jenkins**: Orchestrates CI/CD, generates jobs/folders from DSL, and integrates with Ansible. Job structure is always up-to-date with your inventory.
- **Docker**: Runs Jenkins and Ansible environments in containers for full reproducibility.


## Example Directory Structure

```
update-os/
├── Jenkinsfile                  # Pipeline generating Jenkins DSL jobs
├── Jenkinsfile.ansible-playbook # Pipeline running Ansible playbooks
├── jenkins/                     # Jenkins config, roles, job DSL
│   ├── ansible/                 # Ansible roles and tasks for Jenkins
│   ├── jobs/                    # Job DSL definitions
│   └── roles/                   # Roles for Jenkins image build
├── update-os/                   # Ansible playbooks, roles, inventory
│   ├── ansible.cfg              # Ansible configuration
│   ├── Dockerfile               # Dockerfile for Ansible image
│   ├── update-os.yaml           # Main update playbook
│   ├── inventories/             # Environment inventories
│   └── roles/                   # Ansible roles (e.g., base, prometheus)
```


## Quick Start

1. **Build the Ansible image**

```sh
cd update-os/update-os
sudo docker build -t ansible:1.0 ./
```



2. **Provision Jenkins with Ansible**

Jenkins and its configuration are fully automated using Ansible. To deploy Jenkins, simply run:

```sh
ansible-playbook jenkins.yaml -i inventory/main.yaml -D
```

> 💡 On every commit, Jenkins jobs and folder structure are (re)generated to match your current inventory and codebase. No drift, no manual sync!

3. **Configure sensitive variables**

Fill in the files in `group_vars/secrets/` and `group_vars/all.yaml` with the appropriate passwords and tokens.

4. **Run the pipeline**

- The pipeline generates Jenkins jobs from DSL (`Jenkinsfile`)
- The pipeline runs Ansible playbooks (`Jenkinsfile.ansible-playbook`)


## Example Update Flow

1. Jenkins triggers the pipeline based on repository changes.
2. The pipeline generates jobs and runs the Ansible playbook.
3. The playbook performs a rolling update on hosts defined in the inventory.
4. Ansible roles stop containers, perform the update, and restart services.


## Security
- Passwords and tokens are stored in encrypted files in `group_vars/secrets/`.
- Jenkins access is secured via JCasC and user roles.


## Requirements
- Docker (see Dockerfile for version)
- Ansible (see Dockerfile for version)


---

<p align="center">
<b>Created and maintained by Margulwb</b> &nbsp;|&nbsp; <a href="https://github.com/Margulwb">github.com/Margulwb</a>
</p>

## License
MIT