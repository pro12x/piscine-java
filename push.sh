#!/bin/bash

# Message varible argument
message=$1

# Initialize a git repository and push it to GitHub and Gitea
# git init
# git checkout -b main

# Add all files to the repository
git add .

# Status of the repository
git status

# Commit the files
# git commit -m "Initial commit"
git commit -m "$message pushed at $(date)"
sleep 2

# Create a new branch
# git branch -M main

# Push the repository to GitHub
# git remote add github https://github.com/pro12x/piscine-java.git

# Push the repository to Gitea
# git remote add gitea https://learn.zone01dakar.sn/git/fmokomba/piscine-java.git

# Push the repository to both GitHub and Gitea
# git push -u github main
git push github main
# git push -u gitea main
git push gitea main --force

# End of script