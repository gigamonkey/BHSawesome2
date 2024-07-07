#!/usr/bin/env perl

use warnings;
use strict;
use File::Basename;

my %figures;
my %copies;

open(my $in, "all-figures.txt") or die $!;

while (<$in>) {
  chomp;
  my $name = basename($_);
  my $dir = dirname($_);
  $copies{$name}++;
  $figures{$name} = $dir;
}

# Feed this the output of ag --no-group Figure run from the _sources directory
while (<>) {
  my ($dir, $fig) = /^(.*?)\/.* (Figures\/.*$)/;
  if ($dir) {
    if (not -e "$dir/$fig") {
      my $n = basename($fig);
      if ($copies{$n} == 1) {
        print "git mv $figures{$n}/$n $dir/Figures/\n";
      } elsif ($copies{$n} == 0) {
        print STDERR "Don't know where $n is.\n";
      } else {
        print "$dir -> $fig $figures{$n} $copies{$n} copies of $n.\n";
      }
    }
  }



}


__END__
