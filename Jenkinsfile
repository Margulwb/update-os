pipeline {
    agent any
    stages {
        stage('Generate') {
            steps {
                jobDsl(
                    scriptText: """
                        folder('ansible-folder')
                        pipelineJob('ansible-folder/deploy-job') {
                            parameters {
                                booleanParam('RUN_ANSIBLE', true)
                            }
                            definition {
                                cpsScm {
                                    scm {
                                        git {
                                            remote {
                                                url('https://github.com/Margulwb/update-os.git')
                                                credentials('github-token')
                                            }
                                            branches('*/feature/*')
                                        }
                                    }
                                    scriptPath('Jenkinsfile.ansible-playbook')
                                }
                            }
                        }
                        queue('ansible-folder/deploy-job')
                    """.stripIndent(),
                    sandbox: true,
                    removedJobAction: 'DELETE',
                    removedViewAction: 'DELETE',
                    lookupStrategy: 'JENKINS_ROOT'
                )
            }
        }
    }
}

// pipeline {
//     agent any
//     stages {
//         stage('Generate') {
//             steps {
//                 jobDsl(
//                     targets: 'jenkins/jobs/definitions.groovy',
//                     removedJobAction: 'DELETE',
//                     removedViewAction: 'DELETE',
//                     lookupStrategy: 'JENKINS_ROOT'
//                 )
//             }
//         }
//     }
// }