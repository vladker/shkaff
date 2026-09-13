package org.apache.poi.xssf.model;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SharedStringsTable extends POIXMLDocumentPart implements SharedStrings, Closeable {
    private static final XmlOptions options;
    private SstDocument _sstDoc;
    protected int count;
    private final Map<String, Integer> stmap;
    private final List<CTRst> strings;
    protected int uniqueCount;

    static {
        XmlOptions xmlOptions = new XmlOptions();
        options = xmlOptions;
        xmlOptions.setSaveInner();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setUseDefaultNamespace(true);
        xmlOptions.setSaveImplicitNamespaces(Collections.singletonMap("", XSSFRelation.NS_SPREADSHEETML));
    }

    public SharedStringsTable() {
        this.strings = new ArrayList();
        this.stmap = new HashMap();
        SstDocument sstDocumentNewInstance = SstDocument.Factory.newInstance();
        this._sstDoc = sstDocumentNewInstance;
        sstDocumentNewInstance.addNewSst();
    }

    @Internal
    public int addEntry(CTRst cTRst) {
        String strXmlText = xmlText(cTRst);
        this.count++;
        if (this.stmap.containsKey(strXmlText)) {
            return this.stmap.get(strXmlText).intValue();
        }
        this.uniqueCount++;
        CTRst cTRstAddNewSi = this._sstDoc.getSst().addNewSi();
        cTRstAddNewSi.set(cTRst);
        int size = this.strings.size();
        this.stmap.put(strXmlText, Integer.valueOf(size));
        this.strings.add(cTRstAddNewSi);
        return size;
    }

    public int addSharedStringItem(RichTextString richTextString) {
        if (richTextString instanceof XSSFRichTextString) {
            return addEntry(((XSSFRichTextString) richTextString).getCTRst());
        }
        throw new IllegalArgumentException("Only XSSFRichTextString argument is supported");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            writeTo(outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
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

    public List<RichTextString> getSharedStringItems() {
        ArrayList arrayList = new ArrayList();
        Iterator<CTRst> it = this.strings.iterator();
        while (it.hasNext()) {
            arrayList.add(new XSSFRichTextString(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // org.apache.poi.xssf.model.SharedStrings
    public int getUniqueCount() {
        return this.uniqueCount;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            SstDocument sstDocument = SstDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            this._sstDoc = sstDocument;
            CTSst sst = sstDocument.getSst();
            this.count = (int) sst.getCount();
            this.uniqueCount = (int) sst.getUniqueCount();
            int i5 = 0;
            for (CTRst cTRst : sst.getSiArray()) {
                this.stmap.put(xmlText(cTRst), Integer.valueOf(i5));
                this.strings.add(cTRst);
                i5++;
            }
        } catch (XmlException e) {
            throw new IOException("unable to parse shared strings table", e);
        }
    }

    public void writeTo(OutputStream outputStream) {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveCDataLengthThreshold(SchemaType.SIZE_BIG_INTEGER);
        xmlOptions.setSaveCDataEntityCountThreshold(-1);
        CTSst sst = this._sstDoc.getSst();
        sst.setCount(this.count);
        sst.setUniqueCount(this.uniqueCount);
        this._sstDoc.save(outputStream, xmlOptions);
    }

    public String xmlText(CTRst cTRst) {
        return cTRst.xmlText(options);
    }

    public SharedStringsTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        this.strings = new ArrayList();
        this.stmap = new HashMap();
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
