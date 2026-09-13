package org.apache.poi.xssf;

import org.apache.poi.UnsupportedFileFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XLSBUnsupportedException extends UnsupportedFileFormatException {
    public static final String MESSAGE = ".XLSB Binary Workbooks are not supported";
    private static final long serialVersionUID = 7849681804154571175L;

    public XLSBUnsupportedException() {
        super(MESSAGE);
    }
}
