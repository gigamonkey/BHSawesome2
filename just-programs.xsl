<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <programs>
      <xsl:apply-templates select="//program" />
    </programs>
  </xsl:template>

  <xsl:template match="program">
    <xsl:copy>
      <!-- <xsl:apply-templates select="@* | node()" /> -->
      <xsl:apply-templates select="node()" />
    </xsl:copy>
  </xsl:template>

  <!-- Copy attributes -->
  <xsl:template match="@*">
    <xsl:copy />
  </xsl:template>

  <!-- Copy everything inside <program> elements -->
  <xsl:template match="program//* | program//@*">
    <xsl:copy>
      <!-- <xsl:apply-templates select="@* | node()" /> -->
      <xsl:apply-templates select="node()" />
    </xsl:copy>
  </xsl:template>

  <xsl:template match="program//text()">
    <xsl:value-of select="."/>
  </xsl:template>

</xsl:stylesheet>
