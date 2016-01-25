#! /bin/bash 

SCRIPT_PATH=`dirname $0`
FILES_PATH=$1

echo Executing transformation with informations : 
echo script path $SCRIPT_PATH
echo files paths to transform $FILES_PATH

for zipfile in *.zip
 do echo unzip file $zipfile
    unzip $zipfile
done 

for jsonfile in *.json
 do echo generate file from json file $jsonfile
    java -jar $SCRIPT_PATH/target/bebop-plan-de-vol.static.jar $jsonfile
done


