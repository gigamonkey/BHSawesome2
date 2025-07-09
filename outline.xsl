<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="text"/>

  <xsl:template match="/">
    <xsl:text>-*- mode: list-outline; -*-&#10;&#10;</xsl:text>
    <xsl:apply-templates select="//chapter"/>
  </xsl:template>

  <xsl:template match="chapter">
    <xsl:text>- Unit: </xsl:text>
    <xsl:value-of select="normalize-space(title)"/>
    <xsl:text> (2 weeks)&#10;&#10;</xsl:text>
    <xsl:apply-templates select="section"/>
  </xsl:template>

  <xsl:template match="section">
    <xsl:text>  - </xsl:text>
    <xsl:value-of select="normalize-space(title)"/>
    <xsl:text> (1)&#10;&#10;</xsl:text>
    <xsl:apply-templates select="subsection"/>
  </xsl:template>

  <xsl:template match="subsection">
    <xsl:text>    - </xsl:text>
    <xsl:value-of select="normalize-space(title)"/>
    <xsl:text>&#10;&#10;</xsl:text>
  </xsl:template>


  <!-- Suppress other content -->
  <xsl:template match="text()|@*|node()"/>
</xsl:stylesheet>
