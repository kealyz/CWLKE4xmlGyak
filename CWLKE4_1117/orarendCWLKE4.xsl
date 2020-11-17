<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<html>
		<body>
			<h2>Orarend</h2>
			<table border="1">
				<tr style="background-color:#2F2">
					<th>Tárgy</th>
					<th>Időpont</th>
					<th>Helyszín</th>
					<th>Oktató</th>
					<th>Szak</th>
				</tr>
				<xsl:for-each select="orarend/ora">
					<tr>
						<td><xsl:value-of select="targy"/></td>
						<td><xsl:value-of select="idopont/nap"/>: <xsl:value-of select="idopont/tol"/>-<xsl:value-of select="idopont/ig"/></td>
						<td><xsl:value-of select="helyszin"/></td>
						<td><xsl:value-of select="oktato"/></td>
						<td><xsl:value-of select="szak"/></td>
					</tr>
				</xsl:for-each>
			</table>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>