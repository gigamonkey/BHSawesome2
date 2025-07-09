<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="@* | node()">
    <xsl:copy>
      <xsl:apply-templates select="@* | node()" />
    </xsl:copy>
  </xsl:template>

  <xsl:template match="ol/@marker" />

  <xsl:template match="program/@language[. = 'java']" />

  <xsl:template match="time" />

  <xsl:template match="blockquote[not(@*) and count(*) = 1 and program]">
    <xsl:apply-templates select="program"/>
  </xsl:template>

  <xsl:template match="program[count(*) = 1 and code]">
    <program>
      <xsl:apply-templates select="@*"/>
      <xsl:apply-templates select="code/node()"/>
    </program>
  </xsl:template>

  <xsl:template match="*[not(self::p)]/ul | *[not(self::p)]/ol">
    <p>
      <xsl:copy>
        <xsl:apply-templates select="@* | node()"/>
      </xsl:copy>
    </p>
  </xsl:template>

  <xsl:template match="url/@visual[. = ../@href]" />

</xsl:stylesheet>
