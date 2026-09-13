package org.apache.poi.poifs.dev;

import androidx.collection.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIFSLister {
    public static void displayDirectory(DirectoryNode directoryNode, String str, boolean z6) {
        String str2;
        PrintStream printStream = System.out;
        StringBuilder sbR = a.r(str);
        sbR.append(directoryNode.getName());
        sbR.append(" -");
        printStream.println(sbR.toString());
        String str3 = str + "  ";
        Iterator<Entry> entries = directoryNode.getEntries();
        boolean z7 = false;
        while (entries.hasNext()) {
            Entry next = entries.next();
            if (next instanceof DirectoryNode) {
                displayDirectory((DirectoryNode) next, str3, z6);
            } else {
                DocumentNode documentNode = (DocumentNode) next;
                String name = documentNode.getName();
                if (name.charAt(0) < '\n') {
                    name = name.substring(1) + " <" + ("(0x0" + ((int) name.charAt(0)) + ")" + name.substring(1)) + ">";
                }
                if (z6) {
                    str2 = " [" + documentNode.getSize() + " / 0x" + Integer.toHexString(documentNode.getSize()) + "]";
                } else {
                    str2 = "";
                }
                System.out.println(str3 + name + str2);
            }
            z7 = true;
        }
        if (z7) {
            return;
        }
        System.out.println(str3 + "(no children)");
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to view");
            System.exit(1);
        }
        boolean z6 = true;
        boolean z7 = false;
        for (String str : strArr) {
            if (str.equalsIgnoreCase("-size") || str.equalsIgnoreCase("-sizes")) {
                z7 = true;
            } else if (str.equalsIgnoreCase("-old") || str.equalsIgnoreCase("-old-poifs")) {
                z6 = false;
            } else if (z6) {
                viewFile(str, z7);
            } else {
                viewFileOld(str, z7);
            }
        }
    }

    public static void viewFile(String str, boolean z6) {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(new File(str));
        try {
            displayDirectory(pOIFSFileSystem.getRoot(), "", z6);
            pOIFSFileSystem.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    pOIFSFileSystem.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void viewFileOld(String str, boolean z6) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(fileInputStream);
            try {
                displayDirectory(pOIFSFileSystem.getRoot(), "", z6);
                pOIFSFileSystem.close();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        pOIFSFileSystem.close();
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
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }
}
