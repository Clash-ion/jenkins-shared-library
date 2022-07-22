package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def dockerBuild(String imageName) {
        script.sh "docker build -t  $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub',
            usernameVariable: 'USER',
            passwordVariable: 'PASS'
        )
    ]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
    }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }

}
