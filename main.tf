#variable "google_credentials_file" {
#  description = "Path to the Google Cloud service account key file"
#  default     = "secrets/smitbackend-05508106981c.json"
#}
#1

variable "gcp_sa_key" {
  description = "Google Cloud service account key file"
}
variable "project_id" {
  description = "Google Cloud project ID"
  default     = "smitbackend"
}

variable "region" {
  description = "GCP region for the cluster"
  default     = "us-central1-a"
}

provider "google" {
  #credentials = file(env.GCP_SA_KEY)
  project     = var.project_id
  region      = var.region
}

resource "google_container_cluster" "my_cluster" {
  name               = "my-gke-cluster"
  location           = var.region
  remove_default_node_pool = true
  initial_node_count = 1
}


#  node_pool {
#    name               = "default-pool"
#    machine_type       = "e2-medium"
#    initial_node_count = 1
#  }
#}

resource "google_container_node_pool" "default" {
  name       = "default-pool"
  location   = var.region
  cluster    = google_container_cluster.my_cluster.name
  node_count = 1

  node_config {
    machine_type = "e2-medium"
    image_type   = "COS_CONTAINERD"
  }
}

resource "google_container_node_pool" "nodes" {
  name       = "nodes-pool"
  location   = var.region
  cluster    = google_container_cluster.my_cluster.name
  node_count = 1

  node_config {
    machine_type = "e2-medium"
    image_type   = "COS_CONTAINERD"
  }
}
