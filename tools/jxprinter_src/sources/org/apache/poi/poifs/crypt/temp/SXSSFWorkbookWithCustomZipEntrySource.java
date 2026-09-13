package org.apache.poi.poifs.crypt.temp;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.streaming.SheetDataWriter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SXSSFWorkbookWithCustomZipEntrySource extends SXSSFWorkbook {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SXSSFWorkbookWithCustomZipEntrySource.class);

    public SXSSFWorkbookWithCustomZipEntrySource() {
        super(20);
        setCompressTempFiles(true);
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook
    public SheetDataWriter createSheetDataWriter() {
        Logger logger = LOG;
        logger.atInfo().log("isCompressTempFiles: {}", Unbox.box(isCompressTempFiles()));
        logger.atInfo().log("SharedStringSource: {}", getSharedStringSource());
        return new SheetDataWriterWithDecorator();
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook, org.apache.poi.ss.usermodel.Workbook
    public void write(OutputStream outputStream) {
        flushSheets();
        EncryptedTempData encryptedTempData = new EncryptedTempData();
        AesZipFileZipEntrySource aesZipFileZipEntrySourceCreateZipEntrySource = null;
        try {
            OutputStream outputStream2 = encryptedTempData.getOutputStream();
            try {
                getXSSFWorkbook().write(outputStream2);
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                InputStream inputStream = encryptedTempData.getInputStream();
                try {
                    aesZipFileZipEntrySourceCreateZipEntrySource = AesZipFileZipEntrySource.createZipEntrySource(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    injectData(aesZipFileZipEntrySourceCreateZipEntrySource, outputStream);
                    encryptedTempData.dispose();
                    IOUtils.closeQuietly(aesZipFileZipEntrySourceCreateZipEntrySource);
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
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (Throwable th7) {
            encryptedTempData.dispose();
            IOUtils.closeQuietly(aesZipFileZipEntrySourceCreateZipEntrySource);
            throw th7;
        }
    }
}
