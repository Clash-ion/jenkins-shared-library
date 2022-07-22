def call() {
    echo "building jar file for branch $BRANCH_NAME"
    sh 'mvn package'
}
