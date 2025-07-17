include all-files.mk

all: pretext/files.txt words.txt

%.txt: %.xsl
	xsltproc --xinclude $< pretext/full-main.ptx > $@

pretext/files.txt: pretext/full-main.ptx make-file-list.sh
	./make-file-list.sh

words.txt: pretext/full-main.ptx $(files) words.py
	./words.py -x activity $< > $@

CodeDigest.class: CodeDigest.java junit-4.13-beta-3.jar
	javac -cp .:junit-4.13-beta-3.jar CodeDigest.java


all-files.mk: pretext/full-main.ptx $(files)
	echo "files := $<" > $@
	./list-files.py -f $< | perl -pe 's/^/files += /' >> $@

clean:
	rm -f all-files.mk
	rm -f words.txt
	rm -f pretext/files.txt
