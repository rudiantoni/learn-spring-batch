# This script creates files based in utc timestamp granting liabilty when creating database migrations.
# By default, the migration file will be empty but the rollback will be created with a warning text at the top.
# They will be placed inside a directory called migrations and rollback.
# Those must be in the same directory level as the script.
#
# If you want to create a migration without rollback, use the create_migration.sh script instead.
# If you want to change the output directory, change OUTPUT_FOLDER and/or OUTPUT_FOLDER_SECOND.
#
# Just enter a name you want when asked, and it will be created with the following pattern:
# OUTPUT_FILE_PREFIX + CURRENT_UTC_TIMESTAMP + "_" + FILE_NAME + OUTPUT_FILE_SUFFIX
#

echo "Type a name for your file:"
echo "---- It's not recommended to contains blank spaces in the file name."
echo "---- SIGINT (CTRL + C) to cancel."
read FILE_NAME

OUTPUT_FOLDER="./migrations"
OUTPUT_FOLDER_SECOND="./rollback"

OUTPUT_FILE_PREFIX="V"
CURRENT_UTC_TIMESTAMP=$(date -u +%s)
OUTPUT_FILE_SUFFIX=".sql"
FILE_NAME=$OUTPUT_FILE_PREFIX$CURRENT_UTC_TIMESTAMP"_"$FILE_NAME$OUTPUT_FILE_SUFFIX

echo Creating file $FILE_NAME in $OUTPUT_FOLDER
# Migration file creation
touch $OUTPUT_FOLDER/$FILE_NAME

echo Creating file $FILE_NAME in $OUTPUT_FOLDER_SECOND
# Rollback file creation
echo "-- --------------------------------------------" > $OUTPUT_FOLDER_SECOND/$FILE_NAME
echo "-- WARNING: THIS IS A DATABASE ROLLBACK SCRIPT!" >> $OUTPUT_FOLDER_SECOND/$FILE_NAME
echo "-- --------------------------------------------" >> $OUTPUT_FOLDER_SECOND/$FILE_NAME

# Uncomment this line below if you just want to create an empty rollback file, but comment the previous lines
#touch $OUTPUT_FOLDER/$FILE_NAME

# End
echo Finished creating files.
