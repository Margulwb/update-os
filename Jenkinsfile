pipeline {
    agent any
    stages {
        stage('Generate') {
            steps {
                jobDsl(
                    scriptText: """
                        folder('ansible-folder')
                        pipelineJob('ansible-folder/deploy-job') {
                            definition {
                                cpsScm {
                                    scm {
                                        git {
                                            remote {
                                                url('https://github.com/uzytkownik/repo.git')
                                                credentials('id-gita')
                                            }
                                            branches('main')
                                        }
                                    }
                                    scriptPath('Jenkinsfile')
                                }
                            }
                        }
                    """.stripIndent(),
                    sandbox: false,
                    // lookupStrategy: 'JENKINS_ROOT' // To pomaga przy multibranch
                )
            }
        }
    }
}