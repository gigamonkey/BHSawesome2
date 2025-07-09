#!/usr/bin/env bash

set -euo pipefail

pat="$1"

# Ripgrep normally processes things in parallel so output can come out in any order.
# So we loop through the files and rg them one at a time.
./list-files.py --full pretext/full-main.ptx | while read -r f; do
    if rg --pretty --with-filename "$1" "$f"; then
        echo ""
    fi
    #rg -l "$1" "$f" || true
done
