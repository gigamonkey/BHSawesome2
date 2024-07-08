#!/usr/bin/env perl

use warnings;
use strict;

my $previous;

my $have_section = 0;

while (<>) {
  if (/^=+\s*$/) {
    #print "Section: $previous";
    if ($have_section) {
      print STDERR "$ARGV:$. Multiple sections\n";
    }
    $have_section = 1;
  } elsif (/^-+\s*$/) {
    if (not $have_section) {
      print STDERR "$ARGV:$. sub-section before section\n";
    }
    #print "Subsection: $previous";
    #print;
  } elsif (/^:+\s*$/) {
    # Chapter
    #print $previous;
    #print;
  } elsif (/^(\S)\1+\s*$/) {
    print $previous;
    print;
  }
} continue {
  $previous = $_;
  if (eof) {
    close ARGV;
    $have_section = 0;
    $previous = undef;
  }
}

__END__
