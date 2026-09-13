package org.apache.poi.extractor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EmptyFileException;
import org.apache.poi.ddf.l;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExtractorFactory {
    public static final String OOXML_PACKAGE = "Package";
    private static Boolean allPreferEventExtractors;
    private final List<ExtractorProvider> provider;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) ExtractorFactory.class);
    private static final ThreadLocal<Boolean> threadPreferEventExtractors = ThreadLocal.withInitial(new androidx.emoji2.text.flatbuffer.a(21));

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ProviderMethod {
        POITextExtractor create(ExtractorProvider extractorProvider);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Singleton {
        private static final ExtractorFactory INSTANCE = new ExtractorFactory();

        private Singleton() {
        }
    }

    public static void addProvider(ExtractorProvider extractorProvider) {
        Singleton.INSTANCE.provider.add(extractorProvider);
    }

    public static POITextExtractor createExtractor(POIFSFileSystem pOIFSFileSystem) {
        return createExtractor(pOIFSFileSystem, Biff8EncryptionKey.getCurrentUserPassword());
    }

    public static Boolean getAllThreadsPreferEventExtractors() {
        return allPreferEventExtractors;
    }

    public static POITextExtractor[] getEmbeddedDocsTextExtractors(POIOLE2TextExtractor pOIOLE2TextExtractor) {
        if (pOIOLE2TextExtractor == null) {
            throw new IllegalStateException("extractor must be given");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        DirectoryEntry root = pOIOLE2TextExtractor.getRoot();
        if (root == null) {
            throw new IllegalStateException("The extractor didn't know which POIFS it came from!");
        }
        if (!(pOIOLE2TextExtractor instanceof ExcelExtractor)) {
            for (ExtractorProvider extractorProvider : Singleton.INSTANCE.provider) {
                if (extractorProvider.accepts(FileMagic.OLE2)) {
                    extractorProvider.identifyEmbeddedResources(pOIOLE2TextExtractor, arrayList, arrayList2);
                    break;
                }
            }
        } else {
            int i5 = 2;
            StreamSupport.stream(root.spliterator(), false).filter(new org.apache.commons.compress.archivers.tar.a(i5)).forEach(new l(arrayList, i5));
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            return new POITextExtractor[0];
        }
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            arrayList3.add(createExtractor((DirectoryNode) ((Entry) obj)));
        }
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj2 = arrayList2.get(i7);
            i7++;
            try {
                arrayList3.add(createExtractor((InputStream) obj2));
            } catch (IOException e) {
                LOGGER.atInfo().log("Format not supported yet ({})", e.getLocalizedMessage());
            }
        }
        return (POITextExtractor[]) arrayList3.toArray(new POITextExtractor[0]);
    }

    public static boolean getPreferEventExtractor() {
        Boolean bool = allPreferEventExtractors;
        return bool != null ? bool.booleanValue() : threadPreferEventExtractors.get().booleanValue();
    }

    public static boolean getThreadPrefersEventExtractors() {
        return threadPreferEventExtractors.get().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ POITextExtractor lambda$createExtractor$1(InputStream inputStream, String str, ExtractorProvider extractorProvider) {
        return extractorProvider.create(inputStream, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ POITextExtractor lambda$createExtractor$2(DirectoryNode directoryNode, String str, ExtractorProvider extractorProvider) {
        return extractorProvider.create(directoryNode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ POITextExtractor lambda$createExtractor$3(File file, String str, ExtractorProvider extractorProvider) {
        return extractorProvider.create(file, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ POITextExtractor lambda$createExtractor$4(DirectoryNode directoryNode, String str, ExtractorProvider extractorProvider) {
        return extractorProvider.create(directoryNode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ POITextExtractor lambda$createExtractor$5(DirectoryNode directoryNode, String str, ExtractorProvider extractorProvider) {
        return extractorProvider.create(directoryNode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ POITextExtractor lambda$createExtractor$6(DirectoryNode directoryNode, String str, ExtractorProvider extractorProvider) {
        return extractorProvider.create(directoryNode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getEmbeddedDocsTextExtractors$7(Entry entry) {
        return entry.getName().startsWith("MBD");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeProvider$8(Class cls, ExtractorProvider extractorProvider) {
        return extractorProvider.getClass().isAssignableFrom(cls);
    }

    public static void removeProvider(Class<? extends ExtractorProvider> cls) {
        Singleton.INSTANCE.provider.removeIf(new E4.a(cls, 4));
    }

    public static void setAllThreadsPreferEventExtractors(Boolean bool) {
        allPreferEventExtractors = bool;
    }

    public static void setThreadPrefersEventExtractors(boolean z6) {
        threadPreferEventExtractors.set(Boolean.valueOf(z6));
    }

    private static POITextExtractor wp(FileMagic fileMagic, ProviderMethod providerMethod) throws IOException {
        POITextExtractor pOITextExtractorCreate;
        for (ExtractorProvider extractorProvider : Singleton.INSTANCE.provider) {
            if (extractorProvider.accepts(fileMagic) && (pOITextExtractorCreate = providerMethod.create(extractorProvider)) != null) {
                return pOITextExtractorCreate;
            }
        }
        throw new IOException("Your InputStream was neither an OLE2 stream, nor an OOXML stream or you haven't provide the poi-ooxml*.jar and/or poi-scratchpad*.jar in the classpath/modulepath - FileMagic: " + fileMagic + ", providers: " + Singleton.INSTANCE.provider);
    }

    private ExtractorFactory() {
        ArrayList arrayList = new ArrayList();
        this.provider = arrayList;
        ServiceLoader.load(ExtractorProvider.class, ExtractorFactory.class.getClassLoader()).forEach(new l(arrayList, 3));
    }

    public static POITextExtractor createExtractor(POIFSFileSystem pOIFSFileSystem, String str) {
        return createExtractor(pOIFSFileSystem.getRoot(), str);
    }

    public static POITextExtractor createExtractor(InputStream inputStream) {
        return createExtractor(inputStream, Biff8EncryptionKey.getCurrentUserPassword());
    }

    public static POITextExtractor createExtractor(InputStream inputStream, String str) throws IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        inputStreamPrepareToCheckMagic.mark(1);
        if (inputStreamPrepareToCheckMagic.read(new byte[1]) >= 1) {
            inputStreamPrepareToCheckMagic.reset();
            FileMagic fileMagicValueOf = FileMagic.valueOf(inputStreamPrepareToCheckMagic);
            FileMagic fileMagic = FileMagic.OOXML;
            if (fileMagic == fileMagicValueOf) {
                return wp(fileMagicValueOf, new a(0, str, inputStreamPrepareToCheckMagic));
            }
            if (FileMagic.OLE2 == fileMagicValueOf) {
                DirectoryNode root = new POIFSFileSystem(inputStreamPrepareToCheckMagic).getRoot();
                if (root.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY) || root.hasEntry(OOXML_PACKAGE)) {
                    fileMagicValueOf = fileMagic;
                }
                return wp(fileMagicValueOf, new b(root, str, 0));
            }
            throw new IOException("Can't create extractor - unsupported file type: " + fileMagicValueOf);
        }
        throw new EmptyFileException();
    }

    public static POITextExtractor createExtractor(File file) {
        return createExtractor(file, Biff8EncryptionKey.getCurrentUserPassword());
    }

    public static POITextExtractor createExtractor(File file, String str) throws Throwable {
        if (file.length() != 0) {
            FileMagic fileMagicValueOf = FileMagic.valueOf(file);
            FileMagic fileMagic = FileMagic.OOXML;
            if (fileMagic == fileMagicValueOf) {
                return wp(fileMagicValueOf, new a(1, str, file));
            }
            if (FileMagic.OLE2 == fileMagicValueOf) {
                POIFSFileSystem pOIFSFileSystem = null;
                try {
                    POIFSFileSystem pOIFSFileSystem2 = new POIFSFileSystem(file, true);
                    try {
                        DirectoryNode root = pOIFSFileSystem2.getRoot();
                        if (root.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY) || root.hasEntry(OOXML_PACKAGE)) {
                            fileMagicValueOf = fileMagic;
                        }
                        return wp(fileMagicValueOf, new b(root, str, 3));
                    } catch (IOException e) {
                        e = e;
                        pOIFSFileSystem = pOIFSFileSystem2;
                        IOUtils.closeQuietly(pOIFSFileSystem);
                        throw e;
                    } catch (RuntimeException e6) {
                        e = e6;
                        pOIFSFileSystem = pOIFSFileSystem2;
                        IOUtils.closeQuietly(pOIFSFileSystem);
                        throw e;
                    }
                } catch (IOException e7) {
                    e = e7;
                } catch (RuntimeException e8) {
                    e = e8;
                }
            } else {
                throw new IOException("Can't create extractor - unsupported file type: " + fileMagicValueOf);
            }
        } else {
            throw new EmptyFileException(file);
        }
    }

    public static POITextExtractor createExtractor(DirectoryNode directoryNode) {
        return createExtractor(directoryNode, Biff8EncryptionKey.getCurrentUserPassword());
    }

    public static POITextExtractor createExtractor(DirectoryNode directoryNode, String str) {
        if (!directoryNode.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY) && !directoryNode.hasEntry(OOXML_PACKAGE)) {
            return wp(FileMagic.OLE2, new b(directoryNode, str, 2));
        }
        return wp(FileMagic.OOXML, new b(directoryNode, str, 1));
    }
}
