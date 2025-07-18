#!/usr/bin/env perl -i

use warnings;
use strict;

while (<>) {
    s{"https?://docs.oracle.com/javase/\d+/(docs/api)/(.*?)"}{"https://docs.oracle.com/en/java/javase/22/$1/java.base/$2"}g;
    print;
}

__END__
