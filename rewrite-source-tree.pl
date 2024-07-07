#!/usr/bin/env perl

use warnings;
use strict;
use File::Basename;

sub unit_directory {
  my ($name) = @_;
  $name =~ s/://g;
  $name =~ s/ +/-/g;
  #$name =~ s/-(\d+)-/"-" . sprintf("%02d", $1) . "-"/e;
  return "_sources/$name";
}

my $newdir;

while (<>) {
  if (/^- (.*)/) {
    $newdir = unit_directory($1);
    print "mkdir -p $newdir\n";
  }

  if (m{^\s+- (_sources/.*?)/(.*)}) {
    my $olddir = $1;
    my $file = $2;
    if ($olddir ne $newdir) {
      print "git mv $olddir/$file $newdir/$file\n";
    } else {
      print "# $file doesn't move\n";
    }
  }
}

__END__
