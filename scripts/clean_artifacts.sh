#!/bin/bash
git checkout mvn-repo
echo 'Start deleting extra artifacts...'
rm -Rf -- ../target/mvn-repo/com/db/benchLib/
git commit -m "deleted extra artifacts"
git checkout master
echo 'Done'