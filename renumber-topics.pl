#!/usr/bin/env perl

#
# Fix the toctree.rst and change the file names of the referenced files so the
# topic numbers in the file names line up with what Sphinx is going to assign.
#

use warnings;
use strict;
use File::Basename;

my $unnumber = 0;

if ($ARGV[0] =~ /--?u/) {
  print "Unnumbering\n";
  $unnumber = 1;
  shift;
}

my $tocfile = shift || die "Need tocfile.";

my $dir = dirname($tocfile);

#open(my $in, $tocfile) or die "$!: Can't open $tocfile";

if ($dir =~ /Unit-(\d+)-/) {

  my $unit = $1;
  my $n = 1;

  my $in_toc;

  our @ARGV = ($tocfile);

  $^I = '';

  while (<>) {

    if (/^\.\. toctree\:/) {
      $in_toc = 1;
    } elsif ($in_toc) {
      if (/^\S/) {
        $in_toc = 0;
      } elsif (/^(\s+)(?!:)(\S+)/) {
        my $indent = $1;
        my $oldname = $2;
        my ($base) = $oldname =~ /^(?:topic-(?:\d+-\d+-)?)?(.*)/g;
        if ($base) {
          my $newname = $unnumber ? "topic-$base" : "topic-$unit-$n-$base";
          $n++;
          $_ = "$indent$newname\n";
          if ($newname ne $oldname) {
            system("git mv $dir/$oldname $dir/$newname") == 0 or die $!;
          }
        }
      }
    }
    print;
  }

} else {
  die "Can't figure out unit from $dir";
}
