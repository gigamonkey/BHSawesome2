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

my $olddir = "";
my $newdir;
my @files;


while (<>) {
  if (/^- (.*)/) {
    my $unit = $1;
    my $under = ":" x length($unit);
    $newdir = unit_directory($unit);

    if ($newdir ne $olddir and $#files > 0) {
      print "Writing $newdir/toctree.rst\n";
      open(my $toc, ">$newdir/toctree.rst") or die $!;
      print $toc <<EOF;
.. image:: ../../_static/BHSawesomeLogo.png
    :width: 350
    :align: center

$unit
$under

Summary TK

.. toctree::
   :caption $unit Table of Contents
   :maxdepth 3

EOF
      foreach my $file (@files) {
        print $toc "   $file\n";
      }
      print $toc "\n";
      $olddir = $newdir;
      @files = ();
    }
  }

  if (m{^\s+- (_sources/.*?)/(.*)}) {
    my $olddir = $1;
    my $file = $2;
    push @files, $file;
  }
}

__END__
