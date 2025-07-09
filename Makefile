%.txt: %.xsl
	xsltproc --xinclude $< pretext/full-main.ptx > $@
