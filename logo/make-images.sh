#!/usr/bin/env bash

set -euo pipefail

magick big-b.png -crop 200x240+35+175 +repage -transparent white b.png
magick big-h.png -crop 215x240+35+175 +repage -transparent white h.png
magick big-s.png -crop 185x240+35+175 +repage -transparent white s.png
magick big-awesome.png -crop 1500x240+35+175 +repage -transparent white awesome.png

#open b.png h.png s.png awesome.png
