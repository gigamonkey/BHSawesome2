#!/usr/bin/env bash

set -euo pipefail

sqlite3 hashes.db < show-dupes.sql
