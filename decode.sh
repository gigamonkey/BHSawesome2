#!/usr/bin/env bash

set -euo pipefail

#for f in pretext/**/*.ptx; do

rg --no-heading -l '<code>' pretext/ | while read -r f; do
    out=$(mktemp)
    if xsltproc decode.xsl "$f" > "$out"; then
        mv "$out" "$f"
        uv run format-ptx.py -i "$f"
    else
        echo "Problem processing $f"
    fi
done
