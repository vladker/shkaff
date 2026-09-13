package org.apache.commons.compress.harmony.pack200;

import I4.a;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PackingUtils {
    private static PackingLogger packingLogger = new PackingLogger("org.harmony.apache.pack200", null);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PackingLogger extends Logger {
        private boolean verbose;

        public PackingLogger(String str, String str2) {
            super(str, str2);
            this.verbose = false;
        }

        @Override // java.util.logging.Logger
        public void log(LogRecord logRecord) {
            if (this.verbose) {
                super.log(logRecord);
            }
        }

        public void setVerbose(boolean z6) {
            this.verbose = z6;
        }
    }

    static {
        LogManager.getLogManager().addLogger(packingLogger);
    }

    public static void config(PackingOptions packingOptions) {
        String logFile = packingOptions.getLogFile();
        if (logFile != null) {
            FileHandler fileHandler = new FileHandler(logFile, false);
            fileHandler.setFormatter(new SimpleFormatter());
            packingLogger.addHandler(fileHandler);
            packingLogger.setUseParentHandlers(false);
        }
        packingLogger.setVerbose(packingOptions.isVerbose());
    }

    public static void copyThroughJar(JarInputStream jarInputStream, OutputStream outputStream) throws IOException {
        JarOutputStream jarOutputStream = new JarOutputStream(outputStream, jarInputStream.getManifest());
        jarOutputStream.setComment("PACK200");
        log("Packed META-INF/MANIFEST.MF");
        byte[] bArr = new byte[16384];
        while (true) {
            JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
            if (nextJarEntry == null) {
                jarInputStream.close();
                jarOutputStream.close();
                return;
            }
            jarOutputStream.putNextEntry(nextJarEntry);
            while (true) {
                int i5 = jarInputStream.read(bArr);
                if (i5 != -1) {
                    jarOutputStream.write(bArr, 0, i5);
                }
            }
            log("Packed " + nextJarEntry.getName());
        }
    }

    public static List getPackingFileListFromJar(JarInputStream jarInputStream, boolean z6) throws IOException {
        ArrayList arrayList = new ArrayList();
        Manifest manifest = jarInputStream.getManifest();
        if (manifest != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            manifest.write(byteArrayOutputStream);
            arrayList.add(new Archive.PackingFile("META-INF/MANIFEST.MF", byteArrayOutputStream.toByteArray(), 0L));
        }
        while (true) {
            JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
            if (nextJarEntry == null) {
                break;
            }
            arrayList.add(new Archive.PackingFile(readJarEntry(nextJarEntry, new BufferedInputStream(jarInputStream)), nextJarEntry));
        }
        if (!z6) {
            reorderPackingFiles(arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$reorderPackingFiles$0(Object obj, Object obj2) {
        if (!(obj instanceof Archive.PackingFile) || !(obj2 instanceof Archive.PackingFile)) {
            throw new IllegalArgumentException();
        }
        String name = ((Archive.PackingFile) obj).getName();
        String name2 = ((Archive.PackingFile) obj2).getName();
        if (name.equals(name2)) {
            return 0;
        }
        if ("META-INF/MANIFEST.MF".equals(name)) {
            return -1;
        }
        if ("META-INF/MANIFEST.MF".equals(name2)) {
            return 1;
        }
        return name.compareTo(name2);
    }

    public static void log(String str) {
        packingLogger.log(Level.INFO, str);
    }

    private static byte[] readJarEntry(JarEntry jarEntry, InputStream inputStream) {
        long size = jarEntry.getSize();
        if (size > 2147483647L) {
            throw new RuntimeException("Large Class!");
        }
        if (size < 0) {
            size = 0;
        }
        byte[] bArr = new byte[(int) size];
        if (inputStream.read(bArr) == size) {
            return bArr;
        }
        throw new RuntimeException("Error reading from stream");
    }

    private static void reorderPackingFiles(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Archive.PackingFile) it.next()).isDirectory()) {
                it.remove();
            }
        }
        Collections.sort(list, new a(18));
    }

    public static List getPackingFileListFromJar(JarFile jarFile, boolean z6) {
        ArrayList arrayList = new ArrayList();
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
            arrayList.add(new Archive.PackingFile(readJarEntry(jarEntryNextElement, new BufferedInputStream(jarFile.getInputStream(jarEntryNextElement))), jarEntryNextElement));
        }
        if (!z6) {
            reorderPackingFiles(arrayList);
        }
        return arrayList;
    }

    public static void copyThroughJar(JarFile jarFile, OutputStream outputStream) throws IOException {
        JarOutputStream jarOutputStream = new JarOutputStream(outputStream);
        jarOutputStream.setComment("PACK200");
        byte[] bArr = new byte[16384];
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
            jarOutputStream.putNextEntry(jarEntryNextElement);
            InputStream inputStream = jarFile.getInputStream(jarEntryNextElement);
            while (true) {
                int i5 = inputStream.read(bArr);
                if (i5 != -1) {
                    jarOutputStream.write(bArr, 0, i5);
                }
            }
            jarOutputStream.closeEntry();
            log("Packed " + jarEntryNextElement.getName());
        }
        jarFile.close();
        jarOutputStream.close();
    }
}
