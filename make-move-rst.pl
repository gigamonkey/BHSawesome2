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

sub exercises_prefix {
  my ($olddir) = @_;
  my ($prefix) = $olddir =~ /Unit\d+-(.*)$/;
  $prefix =~ s/\W//g;
  return $prefix;
}

my $newdir;

print "#!/usr/bin/env bash\n\n";

while (<>) {
  if (/^- (.*)/) {
    $newdir = unit_directory($1);
    print "mkdir -p $newdir/Figures\n";
  }

  if (m{^\s+- (_sources/.*?)/(.*)}) {
    my $olddir = $1;
    my $file = $2;
    if ($olddir ne $newdir) {
      if ($file =~ /Exercises.rst$/) {
        my $prefix = exercises_prefix($olddir);
        print "git mv $olddir/$file $newdir/$prefix$file\n";
      } else {
        print "git mv $olddir/$file $newdir/$file\n";
      }
    } else {
      print "# $file doesn't move\n";
    }
  }
}

__END__
