#!/usr/bin/env perl

use warnings;
use strict;


while (<>) {
    my $title = $_;
    $title =~ s/Java/java/g;
    $title =~ s/AP/ap/g;
    $title =~ s/CSA/csa/g;
    $title =~ s/CSP/csp/g;
    if ($title =~ /^[A-Z]*[^A-Z]+[A-Z].*$/) {
        print;
    }
}

__END__
