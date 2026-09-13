package org.apache.poi.xssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ReadOnlySharedStringsTable extends DefaultHandler implements SharedStrings {
    private StringBuilder characters;
    protected int count;
    private boolean inRPh;
    protected final boolean includePhoneticRuns;
    private List<String> strings;
    private boolean tIsOpen;
    protected int uniqueCount;

    public ReadOnlySharedStringsTable(OPCPackage oPCPackage) {
        this(oPCPackage, true);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i5, int i6) {
        if (this.tIsOpen) {
            boolean z6 = this.inRPh;
            if (z6 && this.includePhoneticRuns) {
                this.characters.append(cArr, i5, i6);
            } else {
                if (z6) {
                    return;
                }
                this.characters.append(cArr, i5, i6);
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str == null || str.equals(XSSFRelation.NS_SPREADSHEETML)) {
            if ("si".equals(str2)) {
                this.strings.add(this.characters.toString());
            } else if ("t".equals(str2)) {
                this.tIsOpen = false;
            } else if ("rPh".equals(str2)) {
                this.inRPh = false;
            }
        }
    }

    @Override // org.apache.poi.xssf.model.SharedStrings
    public int getCount() {
        return this.count;
    }

    @Override // org.apache.poi.xssf.model.SharedStrings
    public RichTextString getItemAt(int i5) {
        return new XSSFRichTextString(this.strings.get(i5));
    }

    @Override // org.apache.poi.xssf.model.SharedStrings
    public int getUniqueCount() {
        return this.uniqueCount;
    }

    public void readFrom(InputStream inputStream) throws SAXException, IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 1);
        int i5 = pushbackInputStream.read();
        if (i5 > -1) {
            pushbackInputStream.unread(i5);
            InputSource inputSource = new InputSource(pushbackInputStream);
            try {
                XMLReader xMLReaderNewXMLReader = XMLHelper.newXMLReader();
                xMLReaderNewXMLReader.setContentHandler(this);
                xMLReaderNewXMLReader.parse(inputSource);
            } catch (ParserConfigurationException e) {
                throw new SAXException("SAX parser appears to be broken - " + e.getMessage());
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (str == null || str.equals(XSSFRelation.NS_SPREADSHEETML)) {
            if ("sst".equals(str2)) {
                String value = attributes.getValue("count");
                if (value != null) {
                    this.count = Integer.parseInt(value);
                }
                String value2 = attributes.getValue("uniqueCount");
                if (value2 != null) {
                    this.uniqueCount = Integer.parseInt(value2);
                }
                this.strings = new ArrayList(this.uniqueCount);
                this.characters = new StringBuilder(64);
                return;
            }
            if ("si".equals(str2)) {
                this.characters.setLength(0);
                return;
            }
            if ("t".equals(str2)) {
                this.tIsOpen = true;
                return;
            }
            if ("rPh".equals(str2)) {
                this.inRPh = true;
                if (!this.includePhoneticRuns || this.characters.length() <= 0) {
                    return;
                }
                this.characters.append(" ");
            }
        }
    }

    public ReadOnlySharedStringsTable(OPCPackage oPCPackage, boolean z6) throws IOException {
        this.includePhoneticRuns = z6;
        ArrayList<PackagePart> partsByContentType = oPCPackage.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
        if (partsByContentType.isEmpty()) {
            return;
        }
        InputStream inputStream = partsByContentType.get(0).getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public ReadOnlySharedStringsTable(PackagePart packagePart) {
        this(packagePart, true);
    }

    public ReadOnlySharedStringsTable(PackagePart packagePart, boolean z6) throws IOException {
        this.includePhoneticRuns = z6;
        InputStream inputStream = packagePart.getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public ReadOnlySharedStringsTable(InputStream inputStream) {
        this(inputStream, true);
    }

    public ReadOnlySharedStringsTable(InputStream inputStream, boolean z6) throws SAXException, IOException {
        this.includePhoneticRuns = z6;
        readFrom(inputStream);
    }
}
