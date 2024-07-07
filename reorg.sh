#!/usr/bin/env bash

set -euo pipefail
set -x

# Move the files to their new locations
./make-move-rst.pl new-source-files.txt > move-rst.sh
chmod +x move-rst.sh
./move-rst.sh

# Remove old toctree.rst
rm _sources/**/toctree.rst

# Write new toctree.rst files.
./new-toctrees.pl new-source-files.txt

# Move all the images to a single directory.
# FIXME: there are a handful of Figures collisions which we'll need to sort out.
#mkdir -p _sources/Figures
#ls _sources/*/Figures/* | while read -r f; do mv $f _sources/Figures/; done


# Rewrite Figures references
#perl -pi -e 's/:\s+Figures/: ..\/Figures/;' $(ls _sources/**/*.rst )

./move-figures.sh

find _sources/ -empty -type d -delete

cp new-index.rst _sources/index.rst
