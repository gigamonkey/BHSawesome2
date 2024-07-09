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

sub unit_name {
  my ($unit) = @_;
  $unit =~ s/Unit \d+: //;
  return $unit;
}

sub write_toc {
  my ($unit, $files) = @_;

  my $dir = unit_directory($unit);
  my $name = unit_name($unit);
  my $under = ":" x length($name);

  print "Writing $dir/toctree.rst\n";
  open(my $toc, ">$dir/toctree.rst") or die "$!: Can't open $dir/toctree.rst";
  print $toc <<EOF;
.. image:: ../../_static/BHSawesomeLogo.png
    :width: 350
    :align: center

$name
$under

Summary TK

.. toctree::
   :caption $name Table of Contents
   :maxdepth: 3

EOF
  foreach my $file (@$files) {
    print $toc "   $file\n";
  }
  print $toc "\n";
}


my $oldunit = "";
my $newunit;
my @files;

while (<>) {
  if (/^- (.*)/) {
    $newunit = $1;

    print STDERR "Saw $newunit; old is $oldunit\n";

    if ($newunit ne $oldunit and scalar @files > 0) {
      write_toc($oldunit, \@files);
      @files = ();
    }
    $oldunit = $newunit;
  }

  if (m{^\s+- (_sources/.*?)/(.*)}) {
    my $file = $2;
    print STDERR "Pushing $file\n";
    push @files, $file;
  }
}

print STDERR "At end of file old is $oldunit; files is @{[scalar @files]}\n";

if (scalar @files > 0) {
  write_toc($oldunit, \@files);
}

__END__
