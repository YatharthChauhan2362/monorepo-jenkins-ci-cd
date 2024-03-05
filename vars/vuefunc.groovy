def call(){
    dir('vue-app') {
                            sh 'docker build -t vue .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag vue ${env.dockerHubUser}/vue"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/vue"
                            }
                            sh "docker compose up -d"
                        }
    
}