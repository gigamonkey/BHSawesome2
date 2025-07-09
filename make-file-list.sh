#!/usr/bin/env bash

set -euo pipefail

cat <<EOF > pretext/files.txt
-*- mode: text; eval: (jumper-line-mode); -*-

EOF

./list-files.py pretext/full-main.ptx >> pretext/files.txt
