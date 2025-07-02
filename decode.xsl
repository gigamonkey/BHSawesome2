<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- Identity transform -->
  <xsl:template match="@* | node()">
    <xsl:copy>
      <xsl:apply-templates select="@* | node()" />
    </xsl:copy>
  </xsl:template>

  <!-- Match <code> inside <p> and convert to <c> with trimmed content -->
  <xsl:template match="p/code">
    <c>
      <xsl:call-template name="trim">
        <xsl:with-param name="text" select="normalize-space()" />
      </xsl:call-template>
    </c>
  </xsl:template>

  <!-- Trimming template (uses normalize-space) -->
  <xsl:template name="trim">
    <xsl:param name="text" />
    <xsl:value-of select="$text" />
  </xsl:template>

</xsl:stylesheet>
