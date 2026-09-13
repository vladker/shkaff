package org.apache.poi.xdgf.util;

import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.xdgf.usermodel.XDGFPage;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HierarchyPrinter {
    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 2) {
            System.err.println("Usage: in.vsdx outdir");
            System.exit(1);
        }
        String str = strArr[0];
        String str2 = strArr[1];
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            printHierarchy(new XmlVisioDocument(fileInputStream), str2);
            fileInputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void printHierarchy(XDGFPage xDGFPage, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "page" + xDGFPage.getPageNumber() + ProcessIdUtil.DEFAULT_PROCESSID + Util.sanitizeFilename(xDGFPage.getName()) + ".txt"));
        try {
            PrintStream printStream = new PrintStream((OutputStream) fileOutputStream, false, StandardCharsets.UTF_8.name());
            try {
                printHierarchy(xDGFPage, printStream);
                printStream.close();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        printStream.close();
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
                    fileOutputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public static void printHierarchy(XDGFPage xDGFPage, final PrintStream printStream) {
        xDGFPage.getContent().visitShapes(new ShapeVisitor() { // from class: org.apache.poi.xdgf.util.HierarchyPrinter.1
            @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
            public void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i5) {
                for (int i6 = 0; i6 < i5; i6++) {
                    printStream.append((CharSequence) "  ");
                }
                printStream.println(xDGFShape + " [" + xDGFShape.getShapeType() + ", " + xDGFShape.getSymbolName() + "] " + xDGFShape.getMasterShape() + " " + xDGFShape.getTextAsString().trim());
            }
        });
    }

    public static void printHierarchy(XmlVisioDocument xmlVisioDocument, String str) throws IOException {
        File file = new File(str);
        Iterator<XDGFPage> it = xmlVisioDocument.getPages().iterator();
        while (it.hasNext()) {
            printHierarchy(it.next(), file);
        }
    }
}
