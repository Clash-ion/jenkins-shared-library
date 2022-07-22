def call() {
    echo 'building image ...'
    withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub',
            usernameVariable: 'USER',
            passwordVariable: 'PASS'
        )
    ]) {
        sh 'docker build -t  clashia/java-maven-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push clashia/java-maven-app:jma-2.0'
    }
}
