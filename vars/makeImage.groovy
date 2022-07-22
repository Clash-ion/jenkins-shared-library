import com.example.Docker

def call(String imageName) {
    echo 'building image ...'
    def docker
    docker = new Docker(this)
    docker.dockerBuild(imageName)
    docker.dockerLogin()
    docker.dockerPush(imageName)
    return docker
}
