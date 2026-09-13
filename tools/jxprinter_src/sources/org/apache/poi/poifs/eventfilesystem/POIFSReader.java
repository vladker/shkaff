package org.apache.poi.poifs.eventfilesystem;

import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSDocument;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIFSReader {
    private boolean notifyEmptyDirectories;
    private final POIFSReaderRegistry registry = new POIFSReaderRegistry();
    private boolean registryClosed = false;

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            System.err.println("at least one argument required: input filename(s)");
            System.exit(1);
        }
        for (String str : strArr) {
            POIFSReader pOIFSReader = new POIFSReader();
            pOIFSReader.registerListener(new a());
            System.out.println("reading " + str);
            pOIFSReader.read(new File(str));
        }
    }

    private void processProperties(POIFSFileSystem pOIFSFileSystem, DirectoryProperty directoryProperty, POIFSDocumentPath pOIFSDocumentPath) {
        Iterator<Property> it = directoryProperty.iterator();
        boolean z6 = false;
        while (true) {
            POIFSDocument pOIFSDocument = null;
            if (!it.hasNext()) {
                break;
            }
            Property next = it.next();
            String name = next.getName();
            if (next.isDirectory()) {
                processProperties(pOIFSFileSystem, (DirectoryProperty) next, new POIFSDocumentPath(pOIFSDocumentPath, new String[]{name}));
            } else {
                for (POIFSReaderListener pOIFSReaderListener : this.registry.getListeners(pOIFSDocumentPath, name)) {
                    if (pOIFSDocument == null) {
                        pOIFSDocument = new POIFSDocument((DocumentProperty) next, pOIFSFileSystem);
                    }
                    DocumentInputStream documentInputStream = new DocumentInputStream(pOIFSDocument);
                    try {
                        pOIFSReaderListener.processPOIFSReaderEvent(new POIFSReaderEvent(documentInputStream, pOIFSDocumentPath, name, directoryProperty.getStorageClsid()));
                        documentInputStream.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                documentInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                }
            }
            z6 = true;
        }
        if (z6 || !this.notifyEmptyDirectories) {
            return;
        }
        Iterator<POIFSReaderListener> it2 = this.registry.getListeners(pOIFSDocumentPath, Consts.DOT).iterator();
        while (it2.hasNext()) {
            it2.next().processPOIFSReaderEvent(new POIFSReaderEvent(null, pOIFSDocumentPath, null, directoryProperty.getStorageClsid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEntry(POIFSReaderEvent pOIFSReaderEvent) {
        POIFSDocumentPath path = pOIFSReaderEvent.getPath();
        StringBuilder sb = new StringBuilder();
        try {
            DocumentInputStream stream = pOIFSReaderEvent.getStream();
            try {
                sb.setLength(0);
                int length = path.length();
                for (int i5 = 0; i5 < length; i5++) {
                    sb.append('/');
                    sb.append(path.getComponent(i5));
                }
                byte[] byteArray = IOUtils.toByteArray(stream);
                sb.append('/');
                sb.append(pOIFSReaderEvent.getName());
                sb.append(": ");
                sb.append(byteArray.length);
                sb.append(" bytes read");
                System.out.println(sb);
                if (stream != null) {
                    stream.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
        }
    }

    public void read(InputStream inputStream) {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(inputStream);
        try {
            read(pOIFSFileSystem);
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

    public void registerListener(POIFSReaderListener pOIFSReaderListener) {
        pOIFSReaderListener.getClass();
        if (this.registryClosed) {
            throw new IllegalStateException();
        }
        this.registry.registerListener(pOIFSReaderListener);
    }

    public void setNotifyEmptyDirectories(boolean z6) {
        this.notifyEmptyDirectories = z6;
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, String str) {
        registerListener(pOIFSReaderListener, null, str);
    }

    public void read(File file) {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(file, true);
        try {
            read(pOIFSFileSystem);
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

    public void registerListener(POIFSReaderListener pOIFSReaderListener, POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (pOIFSReaderListener != null && str != null && str.length() != 0) {
            if (!this.registryClosed) {
                POIFSReaderRegistry pOIFSReaderRegistry = this.registry;
                if (pOIFSDocumentPath == null) {
                    pOIFSDocumentPath = new POIFSDocumentPath();
                }
                pOIFSReaderRegistry.registerListener(pOIFSReaderListener, pOIFSDocumentPath, str);
                return;
            }
            throw new IllegalStateException();
        }
        throw null;
    }

    public void read(POIFSFileSystem pOIFSFileSystem) {
        this.registryClosed = true;
        processProperties(pOIFSFileSystem, pOIFSFileSystem.getPropertyTable().getRoot(), new POIFSDocumentPath());
    }
}
