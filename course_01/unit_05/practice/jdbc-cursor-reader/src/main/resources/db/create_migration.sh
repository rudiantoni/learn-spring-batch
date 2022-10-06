# This script creates files based in utc timestamp granting liabilty when creating database migrations.
# By default, the file will be empty and placed inside a directory called migrations.
# Those must be in the same directory level as the script.
#
# If you want to create a rollback for this migration, use the create_migration_and_rollback.sh script instead.
# If you want to change the output directory, change OUTPUT_FOLDER.
#
# Just enter a name you want when asked, and it will be created with the following pattern:
# OUTPUT_FILE_PREFIX + CURRENT_UTC_TIMESTAMP + "_" + FILE_NAME + OUTPUT_FILE_SUFFIX
#


echo "Type a name for your file:"
echo "---- It's not recommended to contains blank spaces in the file name."
echo "---- SIGINT (CTRL + C) to cancel."
read FILE_NAME

OUTPUT_FOLDER="./migrations"
OUTPUT_FILE_PREFIX="V"
CURRENT_UTC_TIMESTAMP=$(date -u +%s)
OUTPUT_FILE_SUFFIX=".sql"
FILE_NAME=$OUTPUT_FILE_PREFIX$CURRENT_UTC_TIMESTAMP"_"$FILE_NAME$OUTPUT_FILE_SUFFIX
echo Creating file $FILE_NAME in $OUTPUT_FOLDER

touch $OUTPUT_FOLDER/$FILE_NAME

echo Finished creating file.
