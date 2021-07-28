val exampleKubeContainersYAML : String = """
        kind: List
        metadata:
          resourceVersion: ""
          selfLink: ""
        apiVersion: v1
        items:
        - apiVersion: v1
          kind: Pod
          metadata:
            creationTimestamp: '2021-07-24T21:28:48Z'
            generateName: bitbucket-backup-cronjob-1627160820-
            labels:
              app: cronjob
              controller-uid: ed767d7c-6b8b-4174-b946-8cffb953da4f
              job-name: bitbucket-backup-cronjob-1627160820
              release: bitbucket-backup
            name: bitbucket-backup-cronjob-1627160820-6fwwh
            namespace: bitbucket-backup
            ownerReferences:
              - apiVersion: batch/v1
                blockOwnerDeletion: true
                controller: true
                kind: Job
                name: bitbucket-backup-cronjob-1627160820
                uid: ed767d7c-6b8b-4174-b946-8cffb953da4f
            resourceVersion: '755009543'
            uid: ae7a45f7-9bf0-47cc-9c55-a308824f21e6
          spec:
            containers:
              - command:
                  - /bin/bash
                  - /scripts/start
                env:
                  - name: BITBUCKET_API_TOKEN_FILE
                    value: /secrets/bitbucket-token.txt
                  - name: BITBUCKET_USERNAME
                    value: oliverisaac
                  - name: BUCKET_URL
                    value: gs://myriad-backups-nearline/bitbucket/
                  - name: GPG_ENCRYPTION_KEY
                    value: B31D7CA977ECC65D8DE3B835F92676DA40432FDD
                  - name: DATA_DIRECTORY
                    value: /data
                  - name: STATUSCAKE_URL
                    value: https://push.statuscake.com/?PK=1c76e404d281176&TestID=3735263&time=0
                  - name: GPG_KEYSERVER
                    value: hkp://pool.sks-keyservers.net,hkp://keys.gnupg.net
                  - name: GCLOUD_AUTH_FILE
                    value: /secrets/google-account.json
                image: myriadmobile/bitbucket-backup:latest
                imagePullPolicy: Always
                name: cronjob
                resources: {}
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /data
                    name: data-pvc
                  - mountPath: /secrets
                    name: google-account
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: default-token-wxdtf
                    readOnly: true
            dnsPolicy: ClusterFirst
            enableServiceLinks: true
            nodeName: gke-us-alpha-ops-1625084421-1bfd3579-zjp9
            nodeSelector:
              pool: ops
            preemptionPolicy: PreemptLowerPriority
            priority: 0
            restartPolicy: Never
            schedulerName: default-scheduler
            securityContext: {}
            serviceAccount: default
            serviceAccountName: default
            terminationGracePeriodSeconds: 30
            tolerations:
              - effect: NoExecute
                key: node.kubernetes.io/not-ready
                operator: Exists
                tolerationSeconds: 300
              - effect: NoExecute
                key: node.kubernetes.io/unreachable
                operator: Exists
                tolerationSeconds: 300
            volumes:
              - name: data-pvc
                persistentVolumeClaim:
                  claimName: bitbucket-backup-cronjob-data
              - name: google-account
                secret:
                  defaultMode: 420
                  secretName: google-account
              - name: default-token-wxdtf
                secret:
                  defaultMode: 420
                  secretName: default-token-wxdtf
          status:
            conditions:
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:28:48Z'
                status: 'True'
                type: Initialized
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:32:39Z'
                message: 'containers with unready status: [cronjob]'
                reason: ContainersNotReady
                status: 'False'
                type: Ready
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:32:39Z'
                message: 'containers with unready status: [cronjob]'
                reason: ContainersNotReady
                status: 'False'
                type: ContainersReady
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:28:48Z'
                status: 'True'
                type: PodScheduled
            containerStatuses:
              - containerID: docker://adf93f57dcbc8036d5552ede280df811e4e9a4fdebe695f8d32276ba29a54bb4
                image: myriadmobile/bitbucket-backup:latest
                imageID: docker-pullable://myriadmobile/bitbucket-backup@sha256:5f4844c2b104639f55b842b85432371249e19a8a4f1a0bc85726f58cf15484f2
                lastState: {}
                name: cronjob
                ready: false
                restartCount: 0
                started: false
                state:
                  terminated:
                    containerID: docker://adf93f57dcbc8036d5552ede280df811e4e9a4fdebe695f8d32276ba29a54bb4
                    exitCode: 1
                    finishedAt: '2021-07-24T21:32:38Z'
                    reason: Error
                    startedAt: '2021-07-24T21:28:58Z'
            hostIP: 10.205.224.61
            phase: Failed
            podIP: 10.205.141.250
            podIPs:
              - ip: 10.205.141.250
            qosClass: BestEffort
            startTime: '2021-07-24T21:28:48Z'
        - apiVersion: v1
          kind: Pod
          metadata:
            creationTimestamp: '2021-07-24T21:12:46Z'
            generateName: bitbucket-backup-cronjob-1627160820-
            labels:
              app: cronjob
              controller-uid: ed767d7c-6b8b-4174-b946-8cffb953da4f
              job-name: bitbucket-backup-cronjob-1627160820
              release: bitbucket-backup
            name: bitbucket-backup-cronjob-1627160820-7ljsw
            namespace: bitbucket-backup
            ownerReferences:
              - apiVersion: batch/v1
                blockOwnerDeletion: true
                controller: true
                kind: Job
                name: bitbucket-backup-cronjob-1627160820
                uid: ed767d7c-6b8b-4174-b946-8cffb953da4f
            resourceVersion: '755000486'
            uid: 46d65d84-7890-472a-8ff7-101ff22acebf
          spec:
            containers:
              - command:
                  - /bin/bash
                  - /scripts/start
                env:
                  - name: BITBUCKET_API_TOKEN_FILE
                    value: /secrets/bitbucket-token.txt
                  - name: BITBUCKET_USERNAME
                    value: oliverisaac
                  - name: BUCKET_URL
                    value: gs://myriad-backups-nearline/bitbucket/
                  - name: GPG_ENCRYPTION_KEY
                    value: B31D7CA977ECC65D8DE3B835F92676DA40432FDD
                  - name: DATA_DIRECTORY
                    value: /data
                  - name: STATUSCAKE_URL
                    value: https://push.statuscake.com/?PK=1c76e404d281176&TestID=3735263&time=0
                  - name: GPG_KEYSERVER
                    value: hkp://pool.sks-keyservers.net,hkp://keys.gnupg.net
                  - name: GCLOUD_AUTH_FILE
                    value: /secrets/google-account.json
                image: myriadmobile/bitbucket-backup:latest
                imagePullPolicy: Always
                name: cronjob
                resources: {}
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /data
                    name: data-pvc
                  - mountPath: /secrets
                    name: google-account
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: default-token-wxdtf
                    readOnly: true
            dnsPolicy: ClusterFirst
            enableServiceLinks: true
            nodeName: gke-us-alpha-ops-1625084421-1bfd3579-zjp9
            nodeSelector:
              pool: ops
            preemptionPolicy: PreemptLowerPriority
            priority: 0
            restartPolicy: Never
            schedulerName: default-scheduler
            securityContext: {}
            serviceAccount: default
            serviceAccountName: default
            terminationGracePeriodSeconds: 30
            tolerations:
              - effect: NoExecute
                key: node.kubernetes.io/not-ready
                operator: Exists
                tolerationSeconds: 300
              - effect: NoExecute
                key: node.kubernetes.io/unreachable
                operator: Exists
                tolerationSeconds: 300
            volumes:
              - name: data-pvc
                persistentVolumeClaim:
                  claimName: bitbucket-backup-cronjob-data
              - name: google-account
                secret:
                  defaultMode: 420
                  secretName: google-account
              - name: default-token-wxdtf
                secret:
                  defaultMode: 420
                  secretName: default-token-wxdtf
          status:
            conditions:
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:12:46Z'
                status: 'True'
                type: Initialized
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:16:46Z'
                message: 'containers with unready status: [cronjob]'
                reason: ContainersNotReady
                status: 'False'
                type: Ready
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:16:46Z'
                message: 'containers with unready status: [cronjob]'
                reason: ContainersNotReady
                status: 'False'
                type: ContainersReady
              - lastProbeTime: null
                lastTransitionTime: '2021-07-24T21:12:46Z'
                status: 'True'
                type: PodScheduled
            containerStatuses:
              - containerID: docker://3909a35fb43b333b0b83537aae6d9e7519db0013bdec735d5892b1c329323bd9
                image: myriadmobile/bitbucket-backup:latest
                imageID: docker-pullable://myriadmobile/bitbucket-backup@sha256:5f4844c2b104639f55b842b85432371249e19a8a4f1a0bc85726f58cf15484f2
                lastState: {}
                name: cronjob
                ready: false
                restartCount: 0
                started: false
                state:
                  terminated:
                    containerID: docker://3909a35fb43b333b0b83537aae6d9e7519db0013bdec735d5892b1c329323bd9
                    exitCode: 1
                    finishedAt: '2021-07-24T21:16:46Z'
                    reason: Error
                    startedAt: '2021-07-24T21:13:05Z'
            hostIP: 10.205.224.61
            phase: Failed
            podIP: 10.205.141.247
            podIPs:
              - ip: 10.205.141.247
            qosClass: BestEffort
            startTime: '2021-07-24T21:12:46Z'
        - apiVersion: v1
          kind: Pod
          metadata:
            annotations:
              prometheus.io/path: /metrics
              prometheus.io/port: '8085'
              prometheus.io/scrape: 'true'
              vault.hashicorp.com/agent-init-first: 'true'
              vault.hashicorp.com/agent-inject: 'true'
              vault.hashicorp.com/agent-inject-secret-serviceaccount.json: secret/backups/gcloud-serviceaccounts/gke-bushelops-prod-us-alpha
              vault.hashicorp.com/agent-inject-status: injected
              vault.hashicorp.com/agent-inject-template-serviceaccount.json: "{{- with secret\
                \ \"secret/backups/gcloud-serviceaccounts/gke-bushelops-prod-us-alpha\" -}}\n\
                \  {{- .Data.data.jsonKey -}}\n{{- end -}}"
              vault.hashicorp.com/agent-pre-populate: 'true'
              vault.hashicorp.com/agent-pre-populate-only: 'true'
              vault.hashicorp.com/role: velero
            creationTimestamp: '2021-06-30T21:41:40Z'
            generateName: velero-bbfcdb6b8-
            labels:
              app.kubernetes.io/instance: velero
              app.kubernetes.io/managed-by: Helm
              app.kubernetes.io/name: velero
              helm.sh/chart: velero-2.21.0
              name: velero
              pod-template-hash: bbfcdb6b8
            name: velero-bbfcdb6b8-bf5vg
            namespace: velero
            ownerReferences:
              - apiVersion: apps/v1
                blockOwnerDeletion: true
                controller: true
                kind: ReplicaSet
                name: velero-bbfcdb6b8
                uid: 406b7017-1e05-48b0-bcd2-c95ee449157f
            resourceVersion: '755686268'
            uid: 754467a1-f447-4076-9c6a-6a3eeb2bba20
          spec:
            containers:
              - args:
                  - server
                  - --log-level=warning
                command:
                  - /velero
                env:
                  - name: VELERO_SCRATCH_DIR
                    value: /scratch
                  - name: VELERO_NAMESPACE
                    valueFrom:
                      fieldRef:
                        apiVersion: v1
                        fieldPath: metadata.namespace
                  - name: LD_LIBRARY_PATH
                    value: /plugins
                  - name: GOOGLE_APPLICATION_CREDENTIALS
                    value: /vault/secrets/serviceaccount.json
                image: velero/velero:v1.6.0
                imagePullPolicy: IfNotPresent
                name: velero
                ports:
                  - containerPort: 8085
                    name: monitoring
                    protocol: TCP
                resources:
                  limits:
                    cpu: 1500m
                    memory: 2Gi
                  requests:
                    cpu: 500m
                    memory: 1Gi
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /plugins
                    name: plugins
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: velero-server-token-z99pd
                    readOnly: true
                  - mountPath: /vault/secrets
                    name: vault-secrets
            dnsPolicy: ClusterFirst
            enableServiceLinks: true
            initContainers:
              - args:
                  - echo             {VAULT_CONFIG?}             | base64 -d > /tmp/config.json && vault agent -config=/tmp/config.json
                command:
                  - /bin/sh
                  - -ec
                env:
                  - name: VAULT_LOG_LEVEL
                    value: info
                  - name: VAULT_CONFIG
                    value: eyJhdXRvX2F1dGgiOnsibWV0aG9kIjp7InR5cGUiOiJrdWJlcm5ldGVzIiwibW91bnRfcGF0aCI6ImF1dGgvazhzLWJ1c2hlbG9wcy1wcm9kLXVzLWFscGhhIiwiY29uZmlnIjp7InJvbGUiOiJ2ZWxlcm8ifX0sInNpbmsiOlt7InR5cGUiOiJmaWxlIiwiY29uZmlnIjp7InBhdGgiOiIvaG9tZS92YXVsdC8udmF1bHQtdG9rZW4ifX1dfSwiZXhpdF9hZnRlcl9hdXRoIjp0cnVlLCJwaWRfZmlsZSI6Ii9ob21lL3ZhdWx0Ly5waWQiLCJ2YXVsdCI6eyJhZGRyZXNzIjoiaHR0cHM6Ly92YXVsdC5idXNoZWxvcHMuY29tIn0sInRlbXBsYXRlIjpbeyJkZXN0aW5hdGlvbiI6Ii92YXVsdC9zZWNyZXRzL3NlcnZpY2VhY2NvdW50Lmpzb24iLCJjb250ZW50cyI6Int7LSB3aXRoIHNlY3JldCBcInNlY3JldC9iYWNrdXBzL2djbG91ZC1zZXJ2aWNlYWNjb3VudHMvZ2tlLWJ1c2hlbG9wcy1wcm9kLXVzLWFscGhhXCIgLX19XG4gIHt7LSAuRGF0YS5kYXRhLmpzb25LZXkgLX19XG57ey0gZW5kIC19fSIsImxlZnRfZGVsaW1pdGVyIjoie3siLCJyaWdodF9kZWxpbWl0ZXIiOiJ9fSJ9XX0=
                image: vault:1.4.0
                imagePullPolicy: IfNotPresent
                name: vault-agent-init
                resources:
                  limits:
                    cpu: 500m
                    memory: 128Mi
                  requests:
                    cpu: 250m
                    memory: 64Mi
                securityContext:
                  runAsGroup: 1000
                  runAsNonRoot: true
                  runAsUser: 100
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: velero-server-token-z99pd
                    readOnly: true
                  - mountPath: /vault/secrets
                    name: vault-secrets
              - image: velero/velero-plugin-for-gcp:v1.2.0
                imagePullPolicy: IfNotPresent
                name: velero-plugin-for-gcp
                resources: {}
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /target
                    name: plugins
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: velero-server-token-z99pd
                    readOnly: true
                  - mountPath: /vault/secrets
                    name: vault-secrets
            nodeName: gke-us-alpha-ops-1625084421-1ea258c9-bkjc
            nodeSelector:
              pool: ops
            preemptionPolicy: PreemptLowerPriority
            priority: 0
            restartPolicy: Always
            schedulerName: default-scheduler
            securityContext: {}
            serviceAccount: velero-server
            serviceAccountName: velero-server
            terminationGracePeriodSeconds: 30
            tolerations:
              - effect: NoExecute
                key: node.kubernetes.io/not-ready
                operator: Exists
                tolerationSeconds: 300
              - effect: NoExecute
                key: node.kubernetes.io/unreachable
                operator: Exists
                tolerationSeconds: 300
            volumes:
              - emptyDir: {}
                name: plugins
              - emptyDir: {}
                name: scratch
              - name: velero-server-token-z99pd
                secret:
                  defaultMode: 420
                  secretName: velero-server-token-z99pd
              - emptyDir:
                  medium: Memory
                name: vault-secrets
          status:
            conditions:
              - lastProbeTime: null
                lastTransitionTime: '2021-06-30T21:41:49Z'
                status: 'True'
                type: Initialized
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T17:03:57Z'
                status: 'True'
                type: Ready
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T17:03:57Z'
                status: 'True'
                type: ContainersReady
              - lastProbeTime: null
                lastTransitionTime: '2021-06-30T21:41:40Z'
                status: 'True'
                type: PodScheduled
            containerStatuses:
              - containerID: docker://905714320a37f3b5a8678f7b9345555c70d18f75b4d86d9da1cc6e26b6e3dc63
                image: velero/velero:v1.6.0
                imageID: docker-pullable://velero/velero@sha256:5c20fcc24e05f8a215189ec7364b341935963b0be6a170f6a2a9604d428baf2c
                lastState:
                  terminated:
                    containerID: docker://38bde51cc4e3222f0cc21958e50e4abca3dea312c62a683a57ec6020497b0044
                    exitCode: 137
                    finishedAt: '2021-07-25T17:03:55Z'
                    reason: OOMKilled
                    startedAt: '2021-07-25T13:01:53Z'
                name: velero
                ready: true
                restartCount: 46
                started: true
                state:
                  running:
                    startedAt: '2021-07-25T17:03:56Z'
            hostIP: 10.205.224.85
            initContainerStatuses:
              - containerID: docker://9b411827bfb7fd7f39a53ea75a03ee48b3adaeb0d695d4c4d0a26cf8b543aaeb
                image: vault:1.4.0
                imageID: docker-pullable://vault@sha256:33908dea33cdfc33dcd730383cbab355727511d3626db5a51857904d76cdb972
                lastState: {}
                name: vault-agent-init
                ready: true
                restartCount: 0
                state:
                  terminated:
                    containerID: docker://9b411827bfb7fd7f39a53ea75a03ee48b3adaeb0d695d4c4d0a26cf8b543aaeb
                    exitCode: 0
                    finishedAt: '2021-06-30T21:41:44Z'
                    reason: Completed
                    startedAt: '2021-06-30T21:41:41Z'
              - containerID: docker://38d22d5785b1f97ac1f2f437e8d94a6e6e1815044d2153acaab5cd61daf9d2f3
                image: velero/velero-plugin-for-gcp:v1.2.0
                imageID: docker-pullable://velero/velero-plugin-for-gcp@sha256:c7a9c136b3cc6d76f67b494f1b7f9e054e15b8c997b7b55d26e15a29c90c2fd5
                lastState: {}
                name: velero-plugin-for-gcp
                ready: true
                restartCount: 0
                state:
                  terminated:
                    containerID: docker://38d22d5785b1f97ac1f2f437e8d94a6e6e1815044d2153acaab5cd61daf9d2f3
                    exitCode: 0
                    finishedAt: '2021-06-30T21:41:49Z'
                    reason: Completed
                    startedAt: '2021-06-30T21:41:49Z'
            phase: Running
            podIP: 10.205.147.33
            podIPs:
              - ip: 10.205.147.33
            qosClass: Burstable
            startTime: '2021-06-30T21:41:40Z'
        - apiVersion: v1
          kind: Pod
          metadata:
            creationTimestamp: '2021-07-25T06:00:09Z'
            generateName: vault-cloudssl-1627192800-
            labels:
              app.kubernetes.io/instance: vault-cloudssl
              app.kubernetes.io/name: vault-cloudssl
              controller-uid: 0a4f3757-51ae-442e-8a9f-ab0b0d361be4
              job-name: vault-cloudssl-1627192800
            name: vault-cloudssl-1627192800-v4zcp
            namespace: vault-cloudssl
            ownerReferences:
              - apiVersion: batch/v1
                blockOwnerDeletion: true
                controller: true
                kind: Job
                name: vault-cloudssl-1627192800
                uid: 0a4f3757-51ae-442e-8a9f-ab0b0d361be4
            resourceVersion: '755304030'
            uid: 2aa05201-acae-4b3d-9113-903d4f5cf2f2
          spec:
            containers:
              - env:
                  - name: CERT_FILE
                    value: /certs/tls.crt
                  - name: KEY_FILE
                    value: /certs/tls.key
                  - name: GCLOUD_AUTH_FILE
                    value: /secrets/cloudssl-auth-file.json
                  - name: GCLOUD_PROJECT
                    value: elite-firefly-216
                  - name: GCLOUD_TARGET_HTTPS_PROXY
                    value: mci1-tps--vault
                image: myriadmobile/cloudssl:v0.2
                imagePullPolicy: Always
                name: cloudssl
                resources: {}
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /certs
                    name: tls-secret
                  - mountPath: /secrets
                    name: cloudssl-authfiles
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: default-token-f8rg8
                    readOnly: true
            dnsPolicy: ClusterFirst
            enableServiceLinks: true
            nodeName: gke-us-alpha-ops-1625084421-1ea258c9-kwx3
            nodeSelector:
              pool: ops
            preemptionPolicy: PreemptLowerPriority
            priority: 0
            restartPolicy: Never
            schedulerName: default-scheduler
            securityContext: {}
            serviceAccount: default
            serviceAccountName: default
            terminationGracePeriodSeconds: 30
            tolerations:
              - effect: NoExecute
                key: node.kubernetes.io/not-ready
                operator: Exists
                tolerationSeconds: 300
              - effect: NoExecute
                key: node.kubernetes.io/unreachable
                operator: Exists
                tolerationSeconds: 300
            volumes:
              - name: tls-secret
                secret:
                  defaultMode: 420
                  secretName: vault-cloudssl-tls
              - name: cloudssl-authfiles
                secret:
                  defaultMode: 420
                  secretName: vault-cloudssl-authfiles
              - name: default-token-f8rg8
                secret:
                  defaultMode: 420
                  secretName: default-token-f8rg8
          status:
            conditions:
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T06:00:09Z'
                reason: PodCompleted
                status: 'True'
                type: Initialized
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T06:00:13Z'
                reason: PodCompleted
                status: 'False'
                type: Ready
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T06:00:13Z'
                reason: PodCompleted
                status: 'False'
                type: ContainersReady
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T06:00:09Z'
                status: 'True'
                type: PodScheduled
            containerStatuses:
              - containerID: docker://35c03c4d4ca73a53ba3c5b3341eb77560ff94cb49dc554ac943add8274889ab2
                image: myriadmobile/cloudssl:v0.2
                imageID: docker-pullable://myriadmobile/cloudssl@sha256:4393f4ea8b12b657337cbce1bafe141b970b088fe765b737e210a9ac2c8185ca
                lastState: {}
                name: cloudssl
                ready: false
                restartCount: 0
                started: false
                state:
                  terminated:
                    containerID: docker://35c03c4d4ca73a53ba3c5b3341eb77560ff94cb49dc554ac943add8274889ab2
                    exitCode: 0
                    finishedAt: '2021-07-25T06:00:13Z'
                    reason: Completed
                    startedAt: '2021-07-25T06:00:11Z'
            hostIP: 10.205.224.113
            phase: Succeeded
            podIP: 10.205.134.29
            podIPs:
              - ip: 10.205.134.29
            qosClass: BestEffort
            startTime: '2021-07-25T06:00:09Z'
        - apiVersion: v1
          kind: Pod
          metadata:
            creationTimestamp: '2021-07-25T12:00:03Z'
            generateName: vault-cloudssl-1627214400-
            labels:
              app.kubernetes.io/instance: vault-cloudssl
              app.kubernetes.io/name: vault-cloudssl
              controller-uid: 7029d703-0afb-46c3-9da4-56a9ba7b35a6
              job-name: vault-cloudssl-1627214400
            name: vault-cloudssl-1627214400-x29sc
            namespace: vault-cloudssl
            ownerReferences:
              - apiVersion: batch/v1
                blockOwnerDeletion: true
                controller: true
                kind: Job
                name: vault-cloudssl-1627214400
                uid: 7029d703-0afb-46c3-9da4-56a9ba7b35a6
            resourceVersion: '755512450'
            uid: 9fb6e385-6962-4aca-9ab9-563f18c60dab
          spec:
            containers:
              - env:
                  - name: CERT_FILE
                    value: /certs/tls.crt
                  - name: KEY_FILE
                    value: /certs/tls.key
                  - name: GCLOUD_AUTH_FILE
                    value: /secrets/cloudssl-auth-file.json
                  - name: GCLOUD_PROJECT
                    value: elite-firefly-216
                  - name: GCLOUD_TARGET_HTTPS_PROXY
                    value: mci1-tps--vault
                image: myriadmobile/cloudssl:v0.2
                imagePullPolicy: Always
                name: cloudssl
                resources: {}
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /certs
                    name: tls-secret
                  - mountPath: /secrets
                    name: cloudssl-authfiles
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: default-token-f8rg8
                    readOnly: true
            dnsPolicy: ClusterFirst
            enableServiceLinks: true
            nodeName: gke-us-alpha-ops-1625084421-1ea258c9-kwx3
            nodeSelector:
              pool: ops
            preemptionPolicy: PreemptLowerPriority
            priority: 0
            restartPolicy: Never
            schedulerName: default-scheduler
            securityContext: {}
            serviceAccount: default
            serviceAccountName: default
            terminationGracePeriodSeconds: 30
            tolerations:
              - effect: NoExecute
                key: node.kubernetes.io/not-ready
                operator: Exists
                tolerationSeconds: 300
              - effect: NoExecute
                key: node.kubernetes.io/unreachable
                operator: Exists
                tolerationSeconds: 300
            volumes:
              - name: tls-secret
                secret:
                  defaultMode: 420
                  secretName: vault-cloudssl-tls
              - name: cloudssl-authfiles
                secret:
                  defaultMode: 420
                  secretName: vault-cloudssl-authfiles
              - name: default-token-f8rg8
                secret:
                  defaultMode: 420
                  secretName: default-token-f8rg8
          status:
            conditions:
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T12:00:03Z'
                reason: PodCompleted
                status: 'True'
                type: Initialized
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T12:00:08Z'
                reason: PodCompleted
                status: 'False'
                type: Ready
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T12:00:08Z'
                reason: PodCompleted
                status: 'False'
                type: ContainersReady
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T12:00:03Z'
                status: 'True'
                type: PodScheduled
            containerStatuses:
              - containerID: docker://b9e47130e6f03c2292a9e12788a71b1baa3a12de15e499fc3ee7118fce949375
                image: myriadmobile/cloudssl:v0.2
                imageID: docker-pullable://myriadmobile/cloudssl@sha256:4393f4ea8b12b657337cbce1bafe141b970b088fe765b737e210a9ac2c8185ca
                lastState: {}
                name: cloudssl
                ready: false
                restartCount: 0
                started: false
                state:
                  terminated:
                    containerID: docker://b9e47130e6f03c2292a9e12788a71b1baa3a12de15e499fc3ee7118fce949375
                    exitCode: 0
                    finishedAt: '2021-07-25T12:00:07Z'
                    reason: Completed
                    startedAt: '2021-07-25T12:00:05Z'
            hostIP: 10.205.224.113
            phase: Succeeded
            podIP: 10.205.134.198
            podIPs:
              - ip: 10.205.134.198
            qosClass: BestEffort
            startTime: '2021-07-25T12:00:03Z'
        - apiVersion: v1
          kind: Pod
          metadata:
            creationTimestamp: '2021-07-25T18:00:07Z'
            generateName: vault-cloudssl-1627236000-
            labels:
              app.kubernetes.io/instance: vault-cloudssl
              app.kubernetes.io/name: vault-cloudssl
              controller-uid: a0770774-b43f-40b6-b296-854ad55f6cdb
              job-name: vault-cloudssl-1627236000
            name: vault-cloudssl-1627236000-w6fsk
            namespace: vault-cloudssl
            ownerReferences:
              - apiVersion: batch/v1
                blockOwnerDeletion: true
                controller: true
                kind: Job
                name: vault-cloudssl-1627236000
                uid: a0770774-b43f-40b6-b296-854ad55f6cdb
            resourceVersion: '755718363'
            uid: 62626819-ef95-4e02-a36a-7197f3338122
          spec:
            containers:
              - env:
                  - name: CERT_FILE
                    value: /certs/tls.crt
                  - name: KEY_FILE
                    value: /certs/tls.key
                  - name: GCLOUD_AUTH_FILE
                    value: /secrets/cloudssl-auth-file.json
                  - name: GCLOUD_PROJECT
                    value: elite-firefly-216
                  - name: GCLOUD_TARGET_HTTPS_PROXY
                    value: mci1-tps--vault
                image: myriadmobile/cloudssl:v0.2
                imagePullPolicy: Always
                name: cloudssl
                resources: {}
                terminationMessagePath: /dev/termination-log
                terminationMessagePolicy: File
                volumeMounts:
                  - mountPath: /certs
                    name: tls-secret
                  - mountPath: /secrets
                    name: cloudssl-authfiles
                  - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
                    name: default-token-f8rg8
                    readOnly: true
            dnsPolicy: ClusterFirst
            enableServiceLinks: true
            nodeName: gke-us-alpha-ops-1625084421-1ea258c9-kwx3
            nodeSelector:
              pool: ops
            preemptionPolicy: PreemptLowerPriority
            priority: 0
            restartPolicy: Never
            schedulerName: default-scheduler
            securityContext: {}
            serviceAccount: default
            serviceAccountName: default
            terminationGracePeriodSeconds: 30
            tolerations:
              - effect: NoExecute
                key: node.kubernetes.io/not-ready
                operator: Exists
                tolerationSeconds: 300
              - effect: NoExecute
                key: node.kubernetes.io/unreachable
                operator: Exists
                tolerationSeconds: 300
            volumes:
              - name: tls-secret
                secret:
                  defaultMode: 420
                  secretName: vault-cloudssl-tls
              - name: cloudssl-authfiles
                secret:
                  defaultMode: 420
                  secretName: vault-cloudssl-authfiles
              - name: default-token-f8rg8
                secret:
                  defaultMode: 420
                  secretName: default-token-f8rg8
          status:
            conditions:
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T18:00:07Z'
                reason: PodCompleted
                status: 'True'
                type: Initialized
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T18:00:12Z'
                reason: PodCompleted
                status: 'False'
                type: Ready
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T18:00:12Z'
                reason: PodCompleted
                status: 'False'
                type: ContainersReady
              - lastProbeTime: null
                lastTransitionTime: '2021-07-25T18:00:07Z'
                status: 'True'
                type: PodScheduled
            containerStatuses:
              - containerID: docker://908bade37b0a7e2772373f9ae127f2f2974d2a646ed5019496870aac5a470883
                image: myriadmobile/cloudssl:v0.2
                imageID: docker-pullable://myriadmobile/cloudssl@sha256:4393f4ea8b12b657337cbce1bafe141b970b088fe765b737e210a9ac2c8185ca
                lastState: {}
                name: cloudssl
                ready: false
                restartCount: 0
                started: false
                state:
                  terminated:
                    containerID: docker://908bade37b0a7e2772373f9ae127f2f2974d2a646ed5019496870aac5a470883
                    exitCode: 0
                    finishedAt: '2021-07-25T18:00:11Z'
                    reason: Completed
                    startedAt: '2021-07-25T18:00:09Z'
            hostIP: 10.205.224.113
            phase: Succeeded
            podIP: 10.205.134.198
            podIPs:
              - ip: 10.205.134.198
            qosClass: BestEffort
            startTime: '2021-07-25T18:00:07Z'


""".trimIndent()
