#!/usr/bin/env bash

cd _sources

# Move all the images to a single directory
ls */Figures/* | while read -r f; do git mv $f ./Figures/; done

# Rewrite Figures references
perl -pi -e 's/:\s+Figures/: ..\/Figures/;' $(ls **/*.rst )
