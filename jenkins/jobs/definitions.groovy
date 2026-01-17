folder('ansible-folder')

pipelineJob('ansible-folder/deploy-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Margulwb/update-os.git')
                        credentials('github-token')
                    }
                    branches('feature/jenkinsfile-generate')
                }
            }
            scriptPath('Jenkinsfile.ansible-playbook')
        }
    }
}