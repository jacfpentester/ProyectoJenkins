// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda del Corte Ingles')
    scm {
        git('https://github.com/jacfpentester/jenkinsPTienda.git', 'master'){ 
            node -> 
                node / gitConfigName('jacf')
                node / gitConfigEmail('jacfpentester@gmail.com')
        }
    }
    triggers {
      //  scm('H/5 * * * *')
            //  scm('H/5 * * * *')

        githubPush()
    }
    
    steps {
        shell("bash levantar.sh")
    }
}