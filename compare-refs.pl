#!/usr/bin/env perl

use warnings;
use strict;

open(my $refs, "git for-each-ref --format='%(refname:lstrip=2) %(creatordate:iso) %(contents:subject) (%(objectname:short=7))' |") or die $!;

my %h;

while (<$refs>) {
  my ($ref, $id) = split(/ /, $_, 2);
  push @{$h{$id}}, $ref;
}

foreach my $k (reverse sort keys %h) {
  print $k, $/;
  foreach my $ref (@{$h{$k}}) {
    print "  $ref\n";
  }
  print $/;
}

__END__
