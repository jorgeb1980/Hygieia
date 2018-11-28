#!/bin/bash

if [ "$SKIP_PROPERTIES_BUILDER" = true ]; then
  echo "Skipping properties builder"
  exit 0
fi

# mongo container provides the HOST/PORT
# api container provided DB Name, ID & PWD

if [ "$TEST_SCRIPT" != "" ]
then
        #for testing locally
        PROP_FILE=application.properties
else 
	PROP_FILE=config/hygieia-gitlab-scm-collector.properties
fi
  
if [ "$MONGO_PORT" != "" ]; then
	# Sample: MONGO_PORT=tcp://172.17.0.20:27017
	MONGODB_HOST=`echo $MONGO_PORT|sed 's;.*://\([^:]*\):\(.*\);\1;'`
	MONGODB_PORT=`echo $MONGO_PORT|sed 's;.*://\([^:]*\):\(.*\);\2;'`
else
	env
	echo "ERROR: MONGO_PORT not defined"
	exit 1
fi

echo "MONGODB_HOST: $MONGODB_HOST"
echo "MONGODB_PORT: $MONGODB_PORT"


cat > $PROP_FILE <<EOF
#Database Name
dbname=${HYGIEIA_API_ENV_SPRING_DATA_MONGODB_DATABASE:-dashboarddb}

#Database HostName - default is localhost
dbhost=${MONGODB_HOST:-10.0.1.1}

#Database Port - default is 27017
dbport=${MONGODB_PORT:-27017}

#Database Username - default is blank
dbusername=${HYGIEIA_API_ENV_SPRING_DATA_MONGODB_USERNAME:-dashboarduser}

#Database Password - default is blank
dbpassword=${HYGIEIA_API_ENV_SPRING_DATA_MONGODB_PASSWORD:-dbpassword}

#Collector schedule (required)
gitlab-ci.cron=${GITLAB_CI_CRON:-0 0/5 * * * *}

#Gitlab host (optional, defaults to "gitlab.com")
gitlab-ci.host=${GITLAB_CI_HOST:-}

#Gitlab protocol (optional, defaults to "http")
gitlab-ci.protocol=${GITLAB_CI_PROTOCOL:-}

#Gitlab port (optional, defaults to protocol default port)
gitlab-ci.port=${GITLAB_CI_PORT:-}

#Gitlab path (optional, defaults to no path)
gitlab-ci.path=${GITLAB_CI_PATH:-}
  
#Gitlab API Token (required, access token can be retrieved through gitlab, collector will have the permissions of the user associated to the token)
gitlab-ci.apiToken=${GITLAB_CI_API_TOKEN:-}

#Gitlab API Version (optional, defaults to current version of 4)
gitlab-ci.apiVersion=${GITLAB_CI_API_VERSION:-4}

EOF

echo "

===========================================
Properties file created `date`:  $PROP_FILE
Note: passwords hidden
===========================================
`cat $PROP_FILE |egrep -vi password`
 "

exit 0
