#!/usr/bin/env bash

#
# Reorganize book based on my course outline.
#

set -euo pipefail

rm -f main-toc.txt
touch main-toc.txt

make_chapter() {
    local dir="$1"
    shift
    mkdir -p "$dir"
    cat <<EOF > "$dir/toctree.ptx"
<?xml version="1.0" encoding="UTF-8"?>

<chapter xml:id="$dir" xml:lang="en-US" xmlns:xi="http://www.w3.org/2001/XInclude">
  <title>$dir</title>
  <introduction>
  </introduction>

EOF

    for file in "$@"; do
        name="$(basename "$file")"
        git mv "$file" "$dir"
        cat <<EOF >> "$dir/toctree.ptx"
  <xi:include href="./$name" />
EOF
    done
    echo "</chapter>" >> "$dir/toctree.ptx";

    cat <<EOF >> main-toc.txt
    <xi:include href="./$dir/toctree.ptx" />
EOF
}

make_chapter introduction \
             Unit1-Using-Objects-and-Methods/topic-1-1-intro-algorithms.ptx

make_chapter primitive-types-and-variables \
             Unit1-Using-Objects-and-Methods/topic-1-2-variables.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-3-expressions.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-4-assignment.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-5-casting.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-6-compound-operators.ptx

make_chapter procedural-abstraction \
             Unit1-Using-Objects-and-Methods/topic-1-9-method-signatures.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-10-calling-class-methods.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-11-Math.ptx \
             Unit3-Class-Creation/topic-3-5-methods.ptx

make_chapter reference-types \
             Unit1-Using-Objects-and-Methods/topic-1-15-strings.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-14-calling-instance-methods.ptx \
             Unit3-Class-Creation/topic-3-3-anatomy-of-class.ptx \
             Unit3-Class-Creation/topic-3-4-constructors.ptx

make_chapter objects \
             Unit3-Class-Creation/topic-3-6-methods-references.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-12-objects.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-13-constructors.ptx \
             Unit3-Class-Creation/topic-3-8-scope-access.ptx \
             Unit3-Class-Creation/topic-3-9-this.ptx \
             Unit3-Class-Creation/topic-3-7-static-vars-methods.ptx

make_chapter abstraction-and-program-design \
             Unit3-Class-Creation/topic-3-1-abstraction.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-7-APIs-and-libraries.ptx \
             Unit1-Using-Objects-and-Methods/topic-1-8-comments.ptx \
             Unit3-Class-Creation/topic-3-2-impacts.ptx


make_chapter booleans-and-conditionals \
             Unit2-Selection-and-Iteration/topic-2-1-algorithms.ptx \
             Unit2-Selection-and-Iteration/topic-2-2-booleans.ptx \
             Unit2-Selection-and-Iteration/topic-2-3-ifs.ptx \
             Unit2-Selection-and-Iteration/topic-2-4-nested-ifs.ptx \
             Unit2-Selection-and-Iteration/topic-2-5-compound-ifs.ptx  \
             Unit2-Selection-and-Iteration/topic-2-6-comparing-booleans.ptx

make_chapter loops \
             Unit2-Selection-and-Iteration/topic-2-7-while-loops.ptx \
             Unit2-Selection-and-Iteration/topic-2-8-for-loops.ptx \
             Unit2-Selection-and-Iteration/topic-2-9-loop-algorithms.ptx \
             Unit2-Selection-and-Iteration/topic-2-10-strings-loops.ptx

make_chapter arrays \
             Unit4-Data-Collections/topic-4-3-array-basics.ptx \
             Unit4-Data-Collections/topic-4-4-array-traversal.ptx \
             Unit4-Data-Collections/topic-4-5-array-algorithms.ptx \
             Unit2-Selection-and-Iteration/topic-2-11-nested-loops.ptx \
             Unit2-Selection-and-Iteration/topic-2-12-loop-analysis.ptx

make_chapter text-files \
             Unit4-Data-Collections/topic-4-1-data-ethics.ptx \
             Unit4-Data-Collections/topic-4-2-data-sets.ptx \
             Unit4-Data-Collections/topic-4-6-input-files.ptx

make_chapter array-lists \
             Unit4-Data-Collections/topic-4-7-wrapper-classes.ptx \
             Unit4-Data-Collections/topic-4-8-arraylists.ptx \
             Unit4-Data-Collections/topic-4-9-arraylist-traversal.ptx \
             Unit4-Data-Collections/topic-4-10-arraylist-algorithms.ptx

make_chapter 2d-arrays \
             Unit4-Data-Collections/topic-4-11-2Darrays.ptx \
             Unit4-Data-Collections/topic-4-12-2Darray-traversal.ptx \
             Unit4-Data-Collections/topic-4-13-2Darray-algorithms.ptx

make_chapter algorithms \
             Unit4-Data-Collections/topic-4-14-searching.ptx \
             Unit4-Data-Collections/topic-4-15-sorting.ptx \
             Unit4-Data-Collections/topic-4-16-recursion.ptx \
             Unit4-Data-Collections/topic-4-17-recursive-search-sort.ptx
