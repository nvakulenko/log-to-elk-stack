#!/usr/bin/env bash

#./build_app.sh                                          &&
eval $(minikube docker-env)                             &&
# docker image build -t spring_boot .                     &&
kubectl create -f kubernetes/minikube/svc.yml           &&
kubectl create -f kubernetes/minikube/deployment.yml