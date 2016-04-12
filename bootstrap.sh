#! /usr/bin/env bash

# Variables

echo -e "\n--- Installing now... ---\n"

echo -e "\n--- Updating packages list ---\n"
apt-get -qq update

echo -e "\n--- Install base packages ---\n"
sudo apt-get -y install vim curl build-essential python-software-properties git lynx > /dev/null 2>&1

cd /opt
sudo wget --no-cookies \
--no-check-certificate \
--header "Cookie: oraclelicense=accept-securebackup-cookie" \
"http://download.oracle.com/otn-pub/java/jdk/8u77-b03/jdk-8u77-linux-x64.tar.gz" \
-O jdk-8u77-linux-x64.tar.gz
# then
sudo tar -xzvf jdk-8u77-linux-x64.tar.gz
sudo rm -f jdk-8u77-linux-x64.tar.gz
sudo mv jdk* jdk
#sudo /opt/jdk/bin/keytool -keyalg rsa -validity 365 -genkey -noprompt -alias tomcat -dname "CN=localhost, OU=IT, O=Adimeo, L=Louis, S=Sicard, C=FR" -keystore /opt/tomcat/tomcat_keystore -storepass secret -keypass secret
