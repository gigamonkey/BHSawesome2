#!/usr/bin/env perl

#
# Check that all the files in a toctree exist.
#

use warnings;
use strict;
use File::Basename;

my $tocfile = shift || die "Need tocfile.";

my $dir = dirname($tocfile);

open(my $in, $tocfile) or die "$!: Can't open $tocfile";

my $in_toc;

while (<$in>) {

  if (/^\.\. toctree\:/) {
    $in_toc = 1;
  } elsif ($in_toc) {
    if (/^\S/) {
      $in_toc = 0;
    } elsif (/^(\s+)(?!:)(\S+)/) {
      my $indent = $1;
      my $name = $2;
      if (not -e "$dir/$name") {
        print STDERR "$tocfile:$. Can't find $dir/$name\n";
      }
    }
  }
}
