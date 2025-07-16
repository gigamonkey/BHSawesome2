%.txt: %.xsl
	xsltproc --xinclude $< pretext/full-main.ptx > $@


words.txt: pretext/full-main.ptx ./words.py
	./words.py -x activity $< > $@
