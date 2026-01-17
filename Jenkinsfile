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
                                                url('https://github.com/Margulwb/update-os.git')
                                                credentials('github-token')
                                            }
                                            branches('feature/jenkinsfile-generate')
                                        }
                                    }
                                    scriptPath('Jenkinsfile')
                                }
                            }
                        }
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