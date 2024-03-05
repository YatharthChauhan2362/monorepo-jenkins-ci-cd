def call(){
    dir('python-app') {
                            sh 'docker build -t python-image:py-docker-img .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag python-image:py-docker-img ${env.dockerHubUser}/python-image:py-docker-img"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/python-image:py-docker-img"
                                sh "docker compose up -d"
                            }
                        }
    
}