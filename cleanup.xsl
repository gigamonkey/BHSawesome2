<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- default: copy everything through -->
  <xsl:template match="@* | node()">
    <xsl:copy>
      <xsl:apply-templates select="@* | node()" />
    </xsl:copy>
  </xsl:template>

  <!-- Remove marker attribute from ol elements -->
  <xsl:template match="ol/@marker" />

  <!-- Remove redundant language="java" attribute from program elements -->
  <xsl:template match="program/@language[. = 'java']" />

  <xsl:template match="time" />

  <!-- Unwrap single program elements wrapped in a blockquote -->
  <xsl:template match="blockquote[not(@*) and count(program) = 1 and count(*) = 1 and not(text()[normalize-space()])]">
    <xsl:apply-templates select="program"/>
  </xsl:template>

  <!-- Program elements don't need code child if it's the only child -->
  <xsl:template match="program[count(*) = 1 and count(code) = 1 and not(text()[normalize-space()])]">
    <program>
      <xsl:apply-templates select="@*"/>
      <xsl:apply-templates select="code/node()"/>
    </program>
  </xsl:template>

  <!--Put ul and ol's in a p if they are not already -->
  <xsl:template match="*[not(self::p)]/ul | *[not(self::p)]/ol">
    <p>
      <xsl:copy>
        <xsl:apply-templates select="@* | node()"/>
      </xsl:copy>
    </p>
  </xsl:template>

  <!-- Strip visual attribute from url if it is the same as the href attribute -->
  <xsl:template match="url/@visual[. = ../@href]" />

  <!-- Convert alt attribute of image elements to a shortdescription element -->
  <xsl:template match="image[@alt]">
    <xsl:copy>
      <xsl:apply-templates select="@*[name() != 'alt']" />
      <shortdescription>
        <xsl:value-of select="@alt" />
      </shortdescription>
      <xsl:apply-templates select="node()" />
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>
