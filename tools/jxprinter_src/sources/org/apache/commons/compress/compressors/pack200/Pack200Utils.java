package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import org.apache.commons.compress.java.util.jar.Pack200;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Pack200Utils {
    private Pack200Utils() {
    }

    public static void normalize(File file) throws IOException {
        normalize(file, file, null);
    }

    public static void normalize(File file, Map<String, String> map) throws IOException {
        normalize(file, file, map);
    }

    public static void normalize(File file, File file2) throws IOException {
        normalize(file, file2, null);
    }

    public static void normalize(File file, File file2, Map<String, String> map) throws IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(Pack200.Packer.SEGMENT_LIMIT, StructuredDataId.RESERVED);
        File fileCreateTempFile = File.createTempFile("commons-compress", "pack200normalize");
        try {
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(fileCreateTempFile.toPath(), new OpenOption[0]);
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    Pack200.Packer packerNewPacker = Pack200.newPacker();
                    packerNewPacker.properties().putAll(map);
                    packerNewPacker.pack(jarFile, outputStreamNewOutputStream);
                    jarFile.close();
                    if (outputStreamNewOutputStream != null) {
                        outputStreamNewOutputStream.close();
                    }
                    Pack200.Unpacker unpackerNewUnpacker = Pack200.newUnpacker();
                    JarOutputStream jarOutputStream = new JarOutputStream(Files.newOutputStream(file2.toPath(), new OpenOption[0]));
                    try {
                        unpackerNewUnpacker.unpack(fileCreateTempFile, jarOutputStream);
                        jarOutputStream.close();
                        if (fileCreateTempFile.delete()) {
                            return;
                        }
                        fileCreateTempFile.deleteOnExit();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                jarOutputStream.close();
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
                            jarFile.close();
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
                    if (outputStreamNewOutputStream != null) {
                        try {
                            outputStreamNewOutputStream.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            if (!fileCreateTempFile.delete()) {
                fileCreateTempFile.deleteOnExit();
            }
            throw th10;
        }
    }
}
