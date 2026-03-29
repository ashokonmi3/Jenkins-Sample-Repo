/*
========================================================
TOPIC: Jenkinsfile - Options Block (buildDiscarder)
========================================================

WHAT IS OPTIONS BLOCK?
- Used to define pipeline-level behavior settings
- Does NOT execute build logic
- Helps in control, governance, and optimization

WHY USE OPTIONS?
- Manage old builds (disk space control)
- Prevent Jenkins performance issues
- Add execution rules (timeout, concurrency, retry)

WHAT IS buildDiscarder?
- Automatically deletes old builds and artifacts
- Prevents storage overflow in Jenkins

WHAT IS logRotator?
- Defines retention rules for:
  • build logs
  • build history
  • artifacts

KEY PARAMETERS USED HERE:

1. daysToKeepStr = '30'
   → Keeps build logs for 30 days

2. numToKeepStr = '2'
   → Keeps only last 2 builds

NOTE:
- Jenkins applies both rules
- Old builds are deleted based on age OR count

IMPORTANT INTERVIEW LINE:
"Options block is used to control pipeline execution behavior,
not business logic."

========================================================
*/

pipeline {

    agent any   // Run on any available Jenkins node

    options {

        buildDiscarder(logRotator(

            artifactDaysToKeepStr: '',   // No limit by days for artifacts

            artifactNumToKeepStr: '',    // No limit by count for artifacts

            daysToKeepStr: '30',         // Keep builds for 30 days

            numToKeepStr: '2'            // Keep only last 2 builds

        ))
    }

    stages {

        stage('Build Stage') {

            steps {

                echo "Hello, this is build stage"   // Print message in console

            }
        }
    }
}