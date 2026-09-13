package org.apache.xmlbeans.impl.common;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlEncodingSniffer {
    private String _javaencoding;
    private Reader _reader;
    private InputStream _stream;
    private String _xmlencoding;

    public XmlEncodingSniffer(Reader reader, String str) {
        str = str == null ? "UTF-8" : str;
        SniffedXmlReader sniffedXmlReader = new SniffedXmlReader(reader);
        this._reader = sniffedXmlReader;
        String xmlEncoding = sniffedXmlReader.getXmlEncoding();
        this._xmlencoding = xmlEncoding;
        if (xmlEncoding == null) {
            String java2IANAMapping = EncodingMap.getJava2IANAMapping(str);
            this._xmlencoding = java2IANAMapping;
            if (java2IANAMapping != null) {
                this._javaencoding = str;
            } else {
                this._xmlencoding = str;
            }
        }
        if (this._xmlencoding == null) {
            this._xmlencoding = "UTF-8";
        }
        String iANA2JavaMapping = EncodingMap.getIANA2JavaMapping(this._xmlencoding);
        this._javaencoding = iANA2JavaMapping;
        if (iANA2JavaMapping == null) {
            this._javaencoding = this._xmlencoding;
        }
    }

    public String getJavaEncoding() {
        return this._javaencoding;
    }

    public Reader getReader() {
        Reader reader = this._reader;
        if (reader != null) {
            this._reader = null;
            return reader;
        }
        if (this._stream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(this._stream, this._javaencoding);
        this._stream = null;
        return inputStreamReader;
    }

    public InputStream getStream() {
        InputStream inputStream = this._stream;
        if (inputStream != null) {
            this._stream = null;
            return inputStream;
        }
        if (this._reader == null) {
            return null;
        }
        ReaderInputStream readerInputStream = new ReaderInputStream(this._reader, this._javaencoding);
        this._reader = null;
        return readerInputStream;
    }

    public String getXmlEncoding() {
        return this._xmlencoding;
    }
}
