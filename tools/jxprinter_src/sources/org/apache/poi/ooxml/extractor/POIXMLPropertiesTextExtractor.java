package org.apache.poi.ooxml.extractor;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.util.LocaleUtil;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIXMLPropertiesTextExtractor implements POIXMLTextExtractor {
    private final DateFormat dateFormat;
    private boolean doCloseFilesystem;
    private final POIXMLDocument doc;

    public POIXMLPropertiesTextExtractor(POIXMLDocument pOIXMLDocument) {
        this.doCloseFilesystem = true;
        this.doc = pOIXMLDocument;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", DateFormatSymbols.getInstance(Locale.ROOT));
        this.dateFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
    }

    private void appendDateIfPresent(StringBuilder sb, String str, Optional<Date> optional) {
        if (optional.isPresent()) {
            appendIfPresent(sb, str, this.dateFormat.format(optional.get()));
        }
    }

    private void appendIfPresent(StringBuilder sb, String str, boolean z6) {
        appendIfPresent(sb, str, Boolean.toString(z6));
    }

    public String getCorePropertiesText() {
        POIXMLDocument document = getDocument();
        if (document == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        PackagePropertiesPart underlyingProperties = document.getProperties().getCoreProperties().getUnderlyingProperties();
        appendIfPresent(sb, "Category", underlyingProperties.getCategoryProperty());
        appendIfPresent(sb, "ContentStatus", underlyingProperties.getContentStatusProperty());
        appendIfPresent(sb, "ContentType", underlyingProperties.getContentTypeProperty());
        appendDateIfPresent(sb, "Created", underlyingProperties.getCreatedProperty());
        appendIfPresent(sb, "CreatedString", underlyingProperties.getCreatedPropertyString());
        appendIfPresent(sb, "Creator", underlyingProperties.getCreatorProperty());
        appendIfPresent(sb, "Description", underlyingProperties.getDescriptionProperty());
        appendIfPresent(sb, "Identifier", underlyingProperties.getIdentifierProperty());
        appendIfPresent(sb, "Keywords", underlyingProperties.getKeywordsProperty());
        appendIfPresent(sb, "Language", underlyingProperties.getLanguageProperty());
        appendIfPresent(sb, "LastModifiedBy", underlyingProperties.getLastModifiedByProperty());
        appendDateIfPresent(sb, "LastPrinted", underlyingProperties.getLastPrintedProperty());
        appendIfPresent(sb, "LastPrintedString", underlyingProperties.getLastPrintedPropertyString());
        appendDateIfPresent(sb, "Modified", underlyingProperties.getModifiedProperty());
        appendIfPresent(sb, "ModifiedString", underlyingProperties.getModifiedPropertyString());
        appendIfPresent(sb, "Revision", underlyingProperties.getRevisionProperty());
        appendIfPresent(sb, "Subject", underlyingProperties.getSubjectProperty());
        appendIfPresent(sb, "Title", underlyingProperties.getTitleProperty());
        appendIfPresent(sb, "Version", underlyingProperties.getVersionProperty());
        return sb.toString();
    }

    public String getCustomPropertiesText() {
        String plainString;
        POIXMLDocument document = getDocument();
        if (document == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (CTProperty cTProperty : document.getProperties().getCustomProperties().getUnderlyingProperties().getPropertyList()) {
            if (cTProperty.isSetLpwstr()) {
                plainString = cTProperty.getLpwstr();
            } else if (cTProperty.isSetLpstr()) {
                plainString = cTProperty.getLpstr();
            } else if (cTProperty.isSetDate()) {
                plainString = cTProperty.getDate().toString();
            } else if (cTProperty.isSetFiletime()) {
                plainString = cTProperty.getFiletime().toString();
            } else if (cTProperty.isSetBool()) {
                plainString = Boolean.toString(cTProperty.getBool());
            } else if (cTProperty.isSetI1()) {
                plainString = Integer.toString(cTProperty.getI1());
            } else if (cTProperty.isSetI2()) {
                plainString = Integer.toString(cTProperty.getI2());
            } else if (cTProperty.isSetI4()) {
                plainString = Integer.toString(cTProperty.getI4());
            } else if (cTProperty.isSetI8()) {
                plainString = Long.toString(cTProperty.getI8());
            } else if (cTProperty.isSetInt()) {
                plainString = Integer.toString(cTProperty.getInt());
            } else if (cTProperty.isSetUi1()) {
                plainString = Integer.toString(cTProperty.getUi1());
            } else if (cTProperty.isSetUi2()) {
                plainString = Integer.toString(cTProperty.getUi2());
            } else if (cTProperty.isSetUi4()) {
                plainString = Long.toString(cTProperty.getUi4());
            } else if (cTProperty.isSetUi8()) {
                plainString = cTProperty.getUi8().toString();
            } else if (cTProperty.isSetUint()) {
                plainString = Long.toString(cTProperty.getUint());
            } else if (cTProperty.isSetR4()) {
                plainString = Float.toString(cTProperty.getR4());
            } else if (cTProperty.isSetR8()) {
                plainString = Double.toString(cTProperty.getR8());
            } else if (cTProperty.isSetDecimal()) {
                BigDecimal decimal = cTProperty.getDecimal();
                plainString = decimal == null ? null : decimal.toPlainString();
            } else {
                plainString = "(not implemented!)";
            }
            sb.append(cTProperty.getName());
            sb.append(" = ");
            sb.append(plainString);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getExtendedPropertiesText() {
        POIXMLDocument document = getDocument();
        if (document == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        CTProperties underlyingProperties = document.getProperties().getExtendedProperties().getUnderlyingProperties();
        appendIfPresent(sb, "Application", underlyingProperties.getApplication());
        appendIfPresent(sb, "AppVersion", underlyingProperties.getAppVersion());
        appendIfPresent(sb, "Characters", underlyingProperties.getCharacters());
        appendIfPresent(sb, "CharactersWithSpaces", underlyingProperties.getCharactersWithSpaces());
        appendIfPresent(sb, "Company", underlyingProperties.getCompany());
        appendIfPresent(sb, "HyperlinkBase", underlyingProperties.getHyperlinkBase());
        appendIfPresent(sb, "HyperlinksChanged", underlyingProperties.getHyperlinksChanged());
        appendIfPresent(sb, "Lines", underlyingProperties.getLines());
        appendIfPresent(sb, "LinksUpToDate", underlyingProperties.getLinksUpToDate());
        appendIfPresent(sb, "Manager", underlyingProperties.getManager());
        appendIfPresent(sb, "Pages", underlyingProperties.getPages());
        appendIfPresent(sb, "Paragraphs", underlyingProperties.getParagraphs());
        appendIfPresent(sb, "PresentationFormat", underlyingProperties.getPresentationFormat());
        appendIfPresent(sb, "Template", underlyingProperties.getTemplate());
        appendIfPresent(sb, "TotalTime", underlyingProperties.getTotalTime());
        return sb.toString();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public POIXMLDocument getFilesystem() {
        return null;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        try {
            return getCorePropertiesText() + getExtendedPropertiesText() + getCustomPropertiesText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
        this.doCloseFilesystem = z6;
    }

    private void appendIfPresent(StringBuilder sb, String str, int i5) {
        appendIfPresent(sb, str, Integer.toString(i5));
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor, org.apache.poi.extractor.POITextExtractor
    public POIXMLDocument getDocument() {
        return this.doc;
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor, org.apache.poi.extractor.POITextExtractor
    public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
        throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
    }

    private void appendIfPresent(StringBuilder sb, String str, Optional<String> optional) {
        if (optional.isPresent()) {
            appendIfPresent(sb, str, optional.get());
        }
    }

    private void appendIfPresent(StringBuilder sb, String str, String str2) {
        if (str2 == null) {
            return;
        }
        sb.append(str);
        sb.append(" = ");
        sb.append(str2);
        sb.append('\n');
    }

    public POIXMLPropertiesTextExtractor(POIXMLTextExtractor pOIXMLTextExtractor) {
        this(pOIXMLTextExtractor.getDocument());
    }
}
