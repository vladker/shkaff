package org.apache.poi.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DrawingDump {
    private DrawingDump() {
    }

    public static void main(String[] strArr) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out, Charset.defaultCharset());
        try {
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            try {
                POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(new File(strArr[0]));
                try {
                    HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(pOIFSFileSystem);
                    try {
                        printWriter.println("Drawing group:");
                        hSSFWorkbook.dumpDrawingGroupRecords(true);
                        for (Sheet sheet : hSSFWorkbook) {
                            printWriter.println("Sheet 1(" + sheet.getSheetName() + "):");
                            ((HSSFSheet) sheet).dumpDrawingRecords(true, printWriter);
                        }
                        hSSFWorkbook.close();
                        pOIFSFileSystem.close();
                        printWriter.close();
                        outputStreamWriter.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                hSSFWorkbook.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            pOIFSFileSystem.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    try {
                        printWriter.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                try {
                    outputStreamWriter.close();
                } catch (Throwable th12) {
                    th10.addSuppressed(th12);
                }
                throw th11;
            }
        }
    }
}
