package org.apache.poi.ss.usermodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Predicate;
import org.apache.poi.EmptyFileException;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkbookFactory {
    private final List<WorkbookProvider> provider;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ProviderMethod {
        Workbook create(WorkbookProvider workbookProvider);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Singleton {
        private static final WorkbookFactory INSTANCE = new WorkbookFactory();

        private Singleton() {
        }
    }

    public static void addProvider(WorkbookProvider workbookProvider) {
        Singleton.INSTANCE.provider.add(workbookProvider);
    }

    public static Workbook create(boolean z6) {
        return wp(z6 ? FileMagic.OOXML : FileMagic.OLE2, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Workbook lambda$create$0(DirectoryNode directoryNode, String str, WorkbookProvider workbookProvider) {
        return workbookProvider.create(directoryNode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Workbook lambda$create$1(DirectoryNode directoryNode, String str, WorkbookProvider workbookProvider) {
        return workbookProvider.create(directoryNode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Workbook lambda$create$2(InputStream inputStream, WorkbookProvider workbookProvider) {
        return workbookProvider.create(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Workbook lambda$create$3(DirectoryNode directoryNode, String str, WorkbookProvider workbookProvider) {
        return workbookProvider.create(directoryNode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Workbook lambda$create$4(File file, String str, boolean z6, WorkbookProvider workbookProvider) {
        return workbookProvider.create(file, str, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Workbook lambda$create$5(File file, String str, boolean z6, WorkbookProvider workbookProvider) {
        return workbookProvider.create(file, str, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeProvider$6(Class cls, WorkbookProvider workbookProvider) {
        return workbookProvider.getClass().isAssignableFrom(cls);
    }

    public static void removeProvider(final Class<? extends WorkbookProvider> cls) {
        Singleton.INSTANCE.provider.removeIf(new Predicate() { // from class: org.apache.poi.ss.usermodel.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return WorkbookFactory.lambda$removeProvider$6(cls, (WorkbookProvider) obj);
            }
        });
    }

    private static Workbook wp(FileMagic fileMagic, ProviderMethod providerMethod) throws IOException {
        for (WorkbookProvider workbookProvider : Singleton.INSTANCE.provider) {
            if (workbookProvider.accepts(fileMagic)) {
                return providerMethod.create(workbookProvider);
            }
        }
        throw new IOException("Your InputStream was neither an OLE2 stream, nor an OOXML stream or you haven't provide the poi-ooxml*.jar in the classpath/modulepath - FileMagic: " + fileMagic + ", having providers: " + Singleton.INSTANCE.provider);
    }

    private WorkbookFactory() {
        ArrayList arrayList = new ArrayList();
        this.provider = arrayList;
        ServiceLoader.load(WorkbookProvider.class, WorkbookFactory.class.getClassLoader()).forEach(new b(arrayList, 1));
    }

    public static Workbook create(POIFSFileSystem pOIFSFileSystem) {
        return create(pOIFSFileSystem, (String) null);
    }

    private static Workbook create(POIFSFileSystem pOIFSFileSystem, String str) {
        return create(pOIFSFileSystem.getRoot(), str);
    }

    public static Workbook create(DirectoryNode directoryNode) {
        return create(directoryNode, (String) null);
    }

    public static Workbook create(DirectoryNode directoryNode, String str) {
        if (!directoryNode.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY) && !directoryNode.hasEntry(ExtractorFactory.OOXML_PACKAGE)) {
            return wp(FileMagic.OLE2, new f(directoryNode, str, 1));
        }
        return wp(FileMagic.OOXML, new f(directoryNode, str, 0));
    }

    public static Workbook create(InputStream inputStream) {
        return create(inputStream, (String) null);
    }

    public static Workbook create(InputStream inputStream, String str) throws IOException {
        final InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        inputStreamPrepareToCheckMagic.mark(1);
        if (inputStreamPrepareToCheckMagic.read(new byte[1]) >= 1) {
            inputStreamPrepareToCheckMagic.reset();
            FileMagic fileMagicValueOf = FileMagic.valueOf(inputStreamPrepareToCheckMagic);
            FileMagic fileMagic = FileMagic.OOXML;
            if (fileMagic == fileMagicValueOf) {
                return wp(fileMagicValueOf, new ProviderMethod() { // from class: org.apache.poi.ss.usermodel.g
                    @Override // org.apache.poi.ss.usermodel.WorkbookFactory.ProviderMethod
                    public final Workbook create(WorkbookProvider workbookProvider) {
                        return WorkbookFactory.lambda$create$2(inputStreamPrepareToCheckMagic, workbookProvider);
                    }
                });
            }
            if (FileMagic.OLE2 == fileMagicValueOf) {
                DirectoryNode root = new POIFSFileSystem(inputStreamPrepareToCheckMagic).getRoot();
                if (root.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY) || root.hasEntry(ExtractorFactory.OOXML_PACKAGE)) {
                    fileMagicValueOf = fileMagic;
                }
                return wp(fileMagicValueOf, new f(root, str, 2));
            }
            throw new IOException("Can't open workbook - unsupported file type: " + fileMagicValueOf);
        }
        throw new EmptyFileException();
    }

    public static Workbook create(File file) {
        return create(file, (String) null);
    }

    public static Workbook create(File file, String str) {
        return create(file, str, false);
    }

    public static Workbook create(final File file, final String str, final boolean z6) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        if (file.length() != 0) {
            FileMagic fileMagicValueOf = FileMagic.valueOf(file);
            FileMagic fileMagic = FileMagic.OOXML;
            if (fileMagicValueOf == fileMagic) {
                final int i5 = 0;
                return wp(fileMagicValueOf, new ProviderMethod() { // from class: org.apache.poi.ss.usermodel.c
                    @Override // org.apache.poi.ss.usermodel.WorkbookFactory.ProviderMethod
                    public final Workbook create(WorkbookProvider workbookProvider) {
                        switch (i5) {
                            case 0:
                                return WorkbookFactory.lambda$create$4(file, str, z6, workbookProvider);
                            default:
                                return WorkbookFactory.lambda$create$5(file, str, z6, workbookProvider);
                        }
                    }
                });
            }
            if (fileMagicValueOf == FileMagic.OLE2) {
                boolean z7 = true;
                POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(file, true);
                try {
                    DirectoryNode root = pOIFSFileSystem.getRoot();
                    if (!root.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY) && !root.hasEntry(ExtractorFactory.OOXML_PACKAGE)) {
                        z7 = false;
                    }
                    pOIFSFileSystem.close();
                    if (z7) {
                        fileMagicValueOf = fileMagic;
                    }
                    final int i6 = 1;
                    return wp(fileMagicValueOf, new ProviderMethod() { // from class: org.apache.poi.ss.usermodel.c
                        @Override // org.apache.poi.ss.usermodel.WorkbookFactory.ProviderMethod
                        public final Workbook create(WorkbookProvider workbookProvider) {
                            switch (i6) {
                                case 0:
                                    return WorkbookFactory.lambda$create$4(file, str, z6, workbookProvider);
                                default:
                                    return WorkbookFactory.lambda$create$5(file, str, z6, workbookProvider);
                            }
                        }
                    });
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
            throw new IOException("Can't open workbook - unsupported file type: " + fileMagicValueOf);
        }
        throw new EmptyFileException(file);
    }
}
