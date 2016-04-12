Vagrant.configure(2) do |config|
  config.vm.box = "hashicorp/precise64"
  config.vm.provision :shell, path: "bootstrap.sh"
  config.vm.network :forwarded_port, guest: 8080, host: 8081
  config.vm.network :forwarded_port, guest: 8443, host: 8443
  
  config.vm.synced_folder "tomcat/", "/opt/tomcat", id: "vagrant-tomcat",
    owner: "vagrant",
    group: "vagrant",
    mount_options: ["dmode=775"]
end
