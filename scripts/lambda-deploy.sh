#!/bin/bash
lein uberjar

echo
echo "Uploading as AWS lambda"

# config variables
: ${AWS_REGION:=us-east-1}
: ${SLACKTRAX_FN_NAME:=slacktrax}

aws lambda update-function-code \
    --region $AWS_REGION \
    --function-name $SLACKTRAX_FN_NAME \
    --publish \
    --zip-file fileb://$PWD/target/slactrax.jar

echo
echo "Updating AWS lambda configuration"

function update_function_configuration() {
    aws lambda update-function-configuration \
        --region $AWS_REGION \
        --function-name $SLACKTRAX_FN_NAME \
        --memory-size 256 \
        --timeout 60
}

function create_function() {
    aws lambda create-function \
        --function-name $SLACKTRAX_FN_NAME
        --region $AWS_REGION \
        --function-name $SLACKTRAX_FN_NAME \
        --memory-size 256 \
        --timeout 60
}
