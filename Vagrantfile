Vagrant.configure("2") do |config|
  config.vm.box = "generic/ubuntu2204"
  config.vm.hostname = "docker-ubuntu"
  config.vm.box_version = "4.3.12"

  # Network configuration
  config.vm.network "private_network", ip: "192.168.56.10"

  # Provider-specific configuration
  config.vm.provider "hyperv" do |vb|
    vb.memory = "2048"
    vb.cpus = 2
    # vb.name = 'docker-ubuntu'
  end

  # Sync current directory to /vagrant in VM
  config.vm.synced_folder ".", "/vagrant"

  # Provisioning script
  config.vm.provision "shell", inline: <<-SHELL
    # Update package list
    apt-get update

    # Install Docker
    curl -fsSL https://get.docker.com -o get-docker.sh
    sh get-docker.sh

    # Add vagrant user to docker group
    usermod -aG docker vagrant

    # Install Docker Compose
    curl -L "https://github.com/docker/compose/releases/download/v2.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    chmod +x /usr/local/bin/docker-compose
  SHELL
end