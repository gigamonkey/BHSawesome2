#!/usr/bin/env python

import re
from argparse import ArgumentParser
from sys import stderr, stdout
from textwrap import fill, dedent, indent
from xml.sax.saxutils import escape, quoteattr

from lxml import etree


def count_chapter(c):
    print(f"- {title(c)} ({count_paragraphs(c):,})\n")

    count_intro(c.xpath("introduction")[0])

    for s in c.xpath(".//section"):
        count_section(s)


def title(elem):
    return to_text(elem.xpath("title")[0]).strip()


def count_paragraphs(e):
    return sum(wordcount(p) for p in e.xpath(".//p"))


def count_intro(i):
    print(f"  - Introduction ({count_paragraphs(i):,})\n")


def count_section(s):
    print(f"  - {title(s)} ({count_paragraphs(s):,})\n")


def wordcount(e):
    return len(re.findall(r"\w+", to_text(e)))


def to_text(elem):
    return etree.tostring(elem, encoding="unicode", method="text")


def main(filename):
    tree = etree.parse(filename)
    tree.xinclude()

    chapters = tree.xpath("//chapter")

    for c in chapters:
        count_chapter(c)


if __name__ == "__main__":
    parser = ArgumentParser(
        prog="words",
        description="Count words in text of ptx file..",
    )

    parser.add_argument("file", help="Filename")

    args = parser.parse_args()

    main(args.file)
