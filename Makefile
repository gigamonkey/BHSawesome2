%.txt: %.xsl
	xsltproc --xinclude $< pretext/full-main.ptx > $@

words.txt: pretext/full-main.ptx ./words.py
	./words.py -x activity $< > $@

CodeDigest.class: CodeDigest.java junit-4.13-beta-3.jar
	javac -cp .:junit-4.13-beta-3.jar CodeDigest.java
