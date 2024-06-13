<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" indent="yes"/>

  <xsl:template match="node()|@*">
    <xsl:copy>
      <xsl:apply-templates select="node()|@*"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="introduction">
    <xsl:apply-templates select="title"/>
    <xsl:copy>
      <xsl:apply-templates select="@*|node()[not(self::title)]"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="introduction/title">
    <xsl:copy-of select="."/>
  </xsl:template>

</xsl:stylesheet>
