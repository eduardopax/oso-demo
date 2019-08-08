# oso-demo

### Demonstration of some activities that can be done using OpenShift.

---
Pre-requirements:

* Minishift installed (required)
* Helm installed (optional in case of not testing the helm part)

*See links parts

---
#### Main commands

##### Pure OSO/Kubernetes objects

###### Create

Go to examples/oso/install folder

`oc create -f .` or `oc apply -f .` 

###### Updatek

Go to examples/oso/update folder

`oc apply -f deployment.yaml` 

###### Delete

Go to examples/oso/install folder

`oc delete -f .`

###### Example of call to see the loadbalancer by the hostname

`curl -X GET  http://IP/hostname`

##### Using Helm
`export TILLER_NAMESPACE=oso-demo`

go to examples/helm folder

###### Create

`helm install oso-demo/ -n oso-demo`

###### Update

`helm upgrade oso-demo oso-demo/`

###### Delete

`helm delete oso-demo` or `helm delete oso-demo --purge`



---
Links

Minishift
https://medium.com/@kasun.dsilva/install-openshift-minishift-in-ubuntu-18-04-fe0760d5a54d
https://developers.redhat.com/products/cdk/hello-world?tcWhenSigned=February+11,+2019&tcWhenEnds=February+11,+2020&tcEndsIn=350&tcDuration=364&tcDownloadFileName=cdk-3.7.0-2-minishift-linux-amd64&tcRedirect=5000&tcSrcLink=https://developers.redhat.com/download-manager/content/origin/files/sha256/fe/fe179b3431668578e4e4b94d352d4d42cbde0c95d4510b6b41f3517286304118/cdk-3.7.0-2-minishift-linux-amd64&p=Red+Hat+Container+Development+Kit+(CDK)&pv=3.7.0-2&tcDownloadURL=https://access.cdn.redhat.com/content/origin/files/sha256/fe/fe179b3431668578e4e4b94d352d4d42cbde0c95d4510b6b41f3517286304118/cdk-3.7.0-2-minishift-linux-amd64?_auth_=1551207483_5f413873cc55a517ed51588a0cc2e15c#fndtn-rhel

Helm
https://blog.openshift.com/getting-started-helm-openshift/

 