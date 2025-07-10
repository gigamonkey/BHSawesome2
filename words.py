#!/usr/bin/env python

import re
from argparse import ArgumentParser

from lxml import etree


def count_level(c, subs, level, parent_count):
    count = count_paragraphs(c)

    emit(title(c), count, parent_count, level)

    intros = c.xpath("./introduction")

    if len(intros) > 0:
        emit("Introduction", count_paragraphs(intros[0]), count, level + 1)

    if subs:
        for s in c.xpath(f"./{subs[0]}"):
            count_level(s, subs[1:], level + 1, count)


def emit(title, count, parent_count, level):
    indent = " " * (level * 2)
    percent = 100 * count / parent_count
    print(f"{indent}- {title} ({count:,} - {percent:.1f}%)\n")


def title(elem):
    return to_text(elem.xpath("title")[0]).strip()


def count_paragraphs(e):
    return sum(wordcount(p) for p in e.xpath(".//p"))


def wordcount(e):
    return len(re.findall(r"\w+", to_text(e)))


def to_text(elem):
    return etree.tostring(elem, encoding="unicode", method="text")


def main(filename):
    tree = etree.parse(filename)
    tree.xinclude()

    total = count_paragraphs(tree.getroot())

    chapters = tree.xpath("//chapter")

    print("-*- mode: list-outline; -*-\n")

    print(f"Total words: {total:,}\n")

    for c in chapters:
        count_level(c, ["section", "subsection"], 0, total)


if __name__ == "__main__":
    parser = ArgumentParser(
        prog="words",
        description="Count words in text of ptx file..",
    )

    parser.add_argument("file", help="Filename")

    args = parser.parse_args()

    main(args.file)
