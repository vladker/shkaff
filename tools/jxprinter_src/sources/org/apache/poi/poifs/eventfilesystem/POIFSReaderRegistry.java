package org.apache.poi.poifs.eventfilesystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.apache.poi.poifs.filesystem.DocumentDescriptor;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class POIFSReaderRegistry {
    private Set<POIFSReaderListener> omnivorousListeners = new HashSet();
    private Map<POIFSReaderListener, Set<DocumentDescriptor>> selectiveListeners = new HashMap();
    private Map<DocumentDescriptor, Set<POIFSReaderListener>> chosenDocumentDescriptors = new HashMap();

    private void dropDocument(POIFSReaderListener pOIFSReaderListener, DocumentDescriptor documentDescriptor) {
        Set<POIFSReaderListener> set = this.chosenDocumentDescriptors.get(documentDescriptor);
        set.remove(pOIFSReaderListener);
        if (set.isEmpty()) {
            this.chosenDocumentDescriptors.remove(documentDescriptor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Set lambda$registerListener$0(POIFSReaderListener pOIFSReaderListener) {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Set lambda$registerListener$1(DocumentDescriptor documentDescriptor) {
        return new HashSet();
    }

    private void removeSelectiveListener(POIFSReaderListener pOIFSReaderListener) {
        Set<DocumentDescriptor> setRemove = this.selectiveListeners.remove(pOIFSReaderListener);
        if (setRemove != null) {
            Iterator<DocumentDescriptor> it = setRemove.iterator();
            while (it.hasNext()) {
                dropDocument(pOIFSReaderListener, it.next());
            }
        }
    }

    public Iterable<POIFSReaderListener> getListeners(POIFSDocumentPath pOIFSDocumentPath, String str) {
        HashSet hashSet = new HashSet(this.omnivorousListeners);
        Set<POIFSReaderListener> set = this.chosenDocumentDescriptors.get(new DocumentDescriptor(pOIFSDocumentPath, str));
        if (set != null) {
            hashSet.addAll(set);
        }
        return hashSet;
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (this.omnivorousListeners.contains(pOIFSReaderListener)) {
            return;
        }
        final int i5 = 0;
        Set<DocumentDescriptor> setComputeIfAbsent = this.selectiveListeners.computeIfAbsent(pOIFSReaderListener, new Function() { // from class: org.apache.poi.poifs.eventfilesystem.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                switch (i5) {
                    case 0:
                        return POIFSReaderRegistry.lambda$registerListener$0((POIFSReaderListener) obj);
                    default:
                        return POIFSReaderRegistry.lambda$registerListener$1((DocumentDescriptor) obj);
                }
            }
        });
        DocumentDescriptor documentDescriptor = new DocumentDescriptor(pOIFSDocumentPath, str);
        if (setComputeIfAbsent.add(documentDescriptor)) {
            final int i6 = 1;
            this.chosenDocumentDescriptors.computeIfAbsent(documentDescriptor, new Function() { // from class: org.apache.poi.poifs.eventfilesystem.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i6) {
                        case 0:
                            return POIFSReaderRegistry.lambda$registerListener$0((POIFSReaderListener) obj);
                        default:
                            return POIFSReaderRegistry.lambda$registerListener$1((DocumentDescriptor) obj);
                    }
                }
            }).add(pOIFSReaderListener);
        }
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener) {
        if (this.omnivorousListeners.contains(pOIFSReaderListener)) {
            return;
        }
        removeSelectiveListener(pOIFSReaderListener);
        this.omnivorousListeners.add(pOIFSReaderListener);
    }
}
