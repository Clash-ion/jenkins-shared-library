import com.example.Docker

// def call(String imageName) {
//     echo 'building image ...'

//     Docker docker = new Docker(this)
//     docker.dockerBuild(imageName)
//     docker.dockerLogin()
//     docker.dockerPush(imageName)
//     return docker
// }

def call(String imageName) {
    echo 'building image ...'

    return new Docker(this).dockerBuildImage(imageName)

// return docker
}
