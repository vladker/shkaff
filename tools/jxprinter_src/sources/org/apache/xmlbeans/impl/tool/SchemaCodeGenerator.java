package org.apache.xmlbeans.impl.tool;

import A3.AbstractC0157z;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.repackage.Repackager;
import org.apache.xmlbeans.impl.util.FilerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaCodeGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Set<File> deleteFileQueue = new HashSet();
    private static int triesRemaining = 0;

    public static File createTempDir() throws IOException {
        String string;
        try {
            IOUtil.getTempDir().toFile().mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i5 = 0;
        File file = Files.createTempFile(IOUtil.getTempDir(), "xbean", ".tmp", new FileAttribute[0]).toFile();
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith(".tmp")) {
            throw new IOException("Error: createTempFile did not create a file ending with .tmp");
        }
        String strG = androidx.collection.a.g(4, 0, absolutePath);
        File file2 = null;
        while (i5 < 100) {
            StringBuilder sbX = AbstractC0157z.x(strG, ".d");
            if (i5 == 0) {
                string = "";
            } else {
                string = Integer.toString(i5);
                i5++;
            }
            sbX.append(string);
            File file3 = new File(sbX.toString());
            if (!file3.exists()) {
                file3.mkdirs();
                file2 = file3;
                break;
            }
            i5++;
            file2 = file3;
        }
        file.deleteOnExit();
        return file2;
    }

    private static void deleteDirRecursively(File file, File file2) {
        String[] list = file2.list();
        while (list != null && list.length == 0 && !file2.equals(file)) {
            file2.delete();
            file2 = file2.getParentFile();
            list = file2.list();
        }
    }

    public static void deleteObsoleteFiles(File file, File file2, Set set) {
        if (!file.isDirectory() || !file2.isDirectory()) {
            throw new IllegalArgumentException();
        }
        String absolutePath = file2.getAbsolutePath();
        if (absolutePath.length() <= 5) {
            return;
        }
        if (!absolutePath.startsWith("/home/") || (absolutePath.indexOf(PackagingURIHelper.FORWARD_SLASH_STRING, 6) < absolutePath.length() - 1 && absolutePath.indexOf(PackagingURIHelper.FORWARD_SLASH_STRING, 6) >= 0)) {
            File[] fileArrListFiles = file2.listFiles();
            for (int i5 = 0; i5 < fileArrListFiles.length; i5++) {
                if (fileArrListFiles[i5].isDirectory()) {
                    deleteObsoleteFiles(file, fileArrListFiles[i5], set);
                } else if (!set.contains(fileArrListFiles[i5])) {
                    deleteXmlBeansFile(fileArrListFiles[i5]);
                    deleteDirRecursively(file, fileArrListFiles[i5].getParentFile());
                }
            }
        }
    }

    private static void deleteXmlBeansFile(File file) {
        if (file.getName().endsWith(".java")) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void giveUp() {
        synchronized (deleteFileQueue) {
            deleteFileQueue.clear();
            triesRemaining = 0;
        }
    }

    public static void saveTypeSystem(SchemaTypeSystem schemaTypeSystem, File file, File file2, Repackager repackager, XmlOptions xmlOptions) {
        schemaTypeSystem.save(new FilerImpl(file, null, repackager, false, false));
    }

    public static void tryHardToDelete(File file) {
        tryToDelete(file);
        if (file.exists()) {
            tryToDeleteLater(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tryNowThatItsLater() {
        ArrayList arrayList;
        boolean z6;
        synchronized (deleteFileQueue) {
            arrayList = new ArrayList(deleteFileQueue);
            deleteFileQueue.clear();
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            File file = (File) obj;
            tryToDelete(file);
            if (file.exists()) {
                arrayList2.add(file);
            }
        }
        synchronized (deleteFileQueue) {
            try {
                int i6 = triesRemaining;
                if (i6 > 0) {
                    triesRemaining = i6 - 1;
                }
                if (triesRemaining <= 0 || arrayList2.size() == 0) {
                    triesRemaining = 0;
                } else {
                    deleteFileQueue.addAll(arrayList2);
                }
                z6 = triesRemaining <= 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    private static void tryToDelete(File file) {
        String[] list;
        if (file.exists()) {
            if (file.isDirectory() && (list = file.list()) != null) {
                for (String str : list) {
                    tryToDelete(new File(file, str));
                }
            }
            file.delete();
        }
    }

    private static void tryToDeleteLater(File file) {
        synchronized (deleteFileQueue) {
            try {
                deleteFileQueue.add(file);
                if (triesRemaining == 0) {
                    new Thread() { // from class: org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            while (!SchemaCodeGenerator.tryNowThatItsLater()) {
                                try {
                                    Thread.sleep(3000L);
                                } catch (InterruptedException unused) {
                                    SchemaCodeGenerator.giveUp();
                                    return;
                                }
                            }
                        }
                    };
                }
                if (triesRemaining < 10) {
                    triesRemaining = 10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
