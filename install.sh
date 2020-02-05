#!/bin/bash

echo "You need to install [java/mvn/docker]"

#read input

#if [ $input == "java" ]; then
  sudo add-apt-repository ppa:webupd8team/java -y
  sudo apt update; sudo apt install -y oracle-java8-installer
  javac -version
  sudo apt install -y oracle-java8-set-default

#elif [ $input == "mvn" ] ; then
  echo "Installing Maven...."
  cd /opt/
  sudo wget http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
  sudo tar -xvzf apache-maven-3.3.9-bin.tar.gz
  sudo mv apache-maven-3.3.9 maven
  echo 'export M2_HOME=/opt/maven
  		export PATH=${M2_HOME}/bin:${PATH}' | sudo tee /etc/profile.d/mavenenv.sh;
  sudo chmod +x /etc/profile.d/mavenenv.sh
  source /etc/profile.d/mavenenv.sh
  mvn --version
  echo "Maven is ready to be used"

#elif [ $input == "docker" ]; then
  echo "Installing Docker...."

  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

  sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

  sudo apt-get update

  echo "Making sure the Docker is installed from Official Docker repo to get the latest version"
  dockerInstallLoc="$(apt-cache policy docker-ce)"
  echo "${dockerInstallLoc}"

  sudo apt-get install -y docker-ce

  dockerSuccess="$(sudo systemctl status docker)"
  echo "${dockerSuccess}"

  echo "Successfully installed Docker!"

  read -r -p "Do you want to add root privileges to run Docker? [Y/n]" response
  response="${response,,}"

  if [[ $response =~ ^(yes|y| ) ]] || [[ -z $response ]]; then
      echo "Adding your username into Docker group"
      sudo usermod -aG docker ${USER}
      su - ${USER}
      echo "Addition of Username to Docker group is successful!"
  else
      echo "Exited without adding root privileges to run Docker"
  fi

  echo "Docker is ready to be used"

#else
#	echo "Nothing was installed!"
#fi