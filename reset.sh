#!/usr/bin/env bash

rm -rf build build_info published
git restore --staged --worktree _sources
git clean -fdx _sources
