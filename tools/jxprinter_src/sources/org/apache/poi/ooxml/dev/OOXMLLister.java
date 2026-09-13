package org.apache.poi.ooxml.dev;

import A3.AbstractC0157z;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OOXMLLister implements Closeable {
    private final OPCPackage container;
    private final PrintStream disp;

    public OOXMLLister(OPCPackage oPCPackage) {
        this(oPCPackage, System.out);
    }

    private void displayRelation(PackageRelationship packageRelationship, String str) {
        this.disp.println(str + "Relationship:");
        PrintStream printStream = this.disp;
        StringBuilder sbX = AbstractC0157z.x(str, "\tFrom: ");
        sbX.append(packageRelationship.getSourceURI());
        printStream.println(sbX.toString());
        PrintStream printStream2 = this.disp;
        StringBuilder sbX2 = AbstractC0157z.x(str, "\tTo:   ");
        sbX2.append(packageRelationship.getTargetURI());
        printStream2.println(sbX2.toString());
        PrintStream printStream3 = this.disp;
        StringBuilder sbX3 = AbstractC0157z.x(str, "\tID:   ");
        sbX3.append(packageRelationship.getId());
        printStream3.println(sbX3.toString());
        PrintStream printStream4 = this.disp;
        StringBuilder sbX4 = AbstractC0157z.x(str, "\tMode: ");
        sbX4.append(packageRelationship.getTargetMode());
        printStream4.println(sbX4.toString());
        PrintStream printStream5 = this.disp;
        StringBuilder sbX5 = AbstractC0157z.x(str, "\tType: ");
        sbX5.append(packageRelationship.getRelationshipType());
        printStream5.println(sbX5.toString());
    }

    public static long getSize(PackagePart packagePart) throws IOException {
        InputStream inputStream = packagePart.getInputStream();
        try {
            byte[] bArr = new byte[8192];
            long j6 = 0;
            int i5 = 0;
            while (i5 > -1) {
                i5 = inputStream.read(bArr);
                if (i5 > 0) {
                    j6 += (long) i5;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return j6;
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

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("Use:");
            System.err.println("\tjava OOXMLLister <filename>");
            System.exit(1);
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            System.err.println("Error, file not found!");
            System.err.println("\t" + file);
            System.exit(2);
        }
        OOXMLLister oOXMLLister = new OOXMLLister(OPCPackage.open(file.toString(), PackageAccess.READ));
        try {
            oOXMLLister.disp.println(file + "\n");
            oOXMLLister.displayParts();
            oOXMLLister.disp.println();
            oOXMLLister.displayRelations();
            oOXMLLister.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    oOXMLLister.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.container.close();
    }

    public void displayParts() throws InvalidFormatException {
        ArrayList<PackagePart> parts = this.container.getParts();
        int size = parts.size();
        int i5 = 0;
        while (i5 < size) {
            PackagePart packagePart = parts.get(i5);
            i5++;
            PackagePart packagePart2 = packagePart;
            this.disp.println(packagePart2.getPartName());
            this.disp.println("\t" + packagePart2.getContentType());
            if (!packagePart2.getPartName().toString().equals("/docProps/core.xml")) {
                this.disp.println("\t" + getSize(packagePart2) + " bytes");
            }
            if (!packagePart2.isRelationshipPart()) {
                this.disp.println("\t" + packagePart2.getRelationships().size() + " relations");
                Iterator<PackageRelationship> it = packagePart2.getRelationships().iterator();
                while (it.hasNext()) {
                    displayRelation(it.next(), "\t  ");
                }
            }
        }
    }

    public void displayRelations() {
        Iterator<PackageRelationship> it = this.container.getRelationships().iterator();
        while (it.hasNext()) {
            displayRelation(it.next(), "");
        }
    }

    public OOXMLLister(OPCPackage oPCPackage, PrintStream printStream) {
        this.container = oPCPackage;
        this.disp = printStream;
    }
}
