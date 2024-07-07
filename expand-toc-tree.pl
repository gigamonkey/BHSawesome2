#!/usr/bin/env perl

use warnings;
use strict;
use File::Basename;

sub unit_name {
  my ($tocfile) = @_;

  if ($tocfile =~ m{_sources/Unit(\d+)-(.*?)/}) {
    return "Unit $1: $2";
  } elsif ($tocfile =~ m{_sources/(.*?)/}) {
    return $1;
  }
}

sub expand_toc {
  my ($toc, $level) = @_;

  if ($level == 1) {
    my $unit = unit_name($toc);
    print "- $unit\n\n";
  }

  my $dir = dirname($toc);

  open(my $in, $toc) or die "$!: $toc";

  my $in_toc;

  while (<$in>) {
    chomp;

    /^\.\. toctree\:/ and $in_toc = 1;

    if ($in_toc) {
      if (/^\.\. (.*)/ and not /:$/) {
        $in_toc = 0;
        next;
      }
      if (/^\s+(?!:)(.*\.rst)/) {
        my $file = "$dir/$1";
        if (not $file =~ /toctree.rst$/) {
          print " " x ($level * 2);
          print "- $file\n\n";
        }
        expand_toc($file, $level + 1);
      }
    }
  }
}

expand_toc(shift, 0);

__END__
