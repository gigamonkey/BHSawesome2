#!/usr/bin/env bash

set -euo pipefail

cat <<EOF > pretext/files.txt
-*- mode: text; mode: jumper-line; -*-

EOF

./list-files.py pretext/full-main.ptx >> pretext/files.txt
