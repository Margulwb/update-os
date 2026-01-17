pipeline {
    agent any
    stages {
        stage('Generate') {
            steps {
                jobDsl(
                    targets: 'jenkins/jobs/definitions.groovy',
                    removedJobAction: 'DELETE',
                    removedViewAction: 'DELETE',
                    lookupStrategy: 'JENKINS_ROOT'
                )
            }
        }
    }
}