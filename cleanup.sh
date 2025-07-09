#!/usr/bin/env bash

set -euo pipefail

for file in "$@"; do
    out=$(mktemp)
    if xsltproc cleanup.xsl "$file" > "$out"; then
        mv "$out" "$file"
        uv run format-ptx.py -i "$file"
    else
        echo "Problem processing $file"
    fi
done
