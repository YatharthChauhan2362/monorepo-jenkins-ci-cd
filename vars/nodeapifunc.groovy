def call(){
    dir('node-api') {
                            sh 'docker build -t node-api .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag node-api ${env.dockerHubUser}/node-api"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/node-api"
                                sh "docker compose up -d"
                            }
                        }
    
}