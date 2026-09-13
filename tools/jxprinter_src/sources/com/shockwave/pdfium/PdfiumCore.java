package com.shockwave.pdfium;

import P2.a;
import P2.b;
import P2.c;
import P2.d;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PdfiumCore {
    public static final Object b;
    public static Field c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3765a;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e) {
            Log.e("com.shockwave.pdfium.PdfiumCore", "Native libraries failed to load - " + e);
        }
        b = new Object();
        c = null;
    }

    private native void nativeCloseDocument(long j6);

    private native void nativeClosePage(long j6);

    private native long nativeGetBookmarkDestIndex(long j6, long j7);

    private native String nativeGetBookmarkTitle(long j6);

    private native Integer nativeGetDestPageIndex(long j6, long j7);

    private native String nativeGetDocumentMetaText(long j6, String str);

    private native Long nativeGetFirstChildBookmark(long j6, Long l6);

    private native RectF nativeGetLinkRect(long j6);

    private native String nativeGetLinkURI(long j6, long j7);

    private native int nativeGetPageCount(long j6);

    private native long[] nativeGetPageLinks(long j6);

    private native Size nativeGetPageSizeByIndex(long j6, int i5, int i6);

    private native Long nativeGetSiblingBookmark(long j6, long j7);

    private native long nativeLoadPage(long j6, int i5);

    private native long nativeOpenDocument(int i5, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j6, int i5, int i6, int i7, int i8, int i9, double d, double d6);

    private native void nativeRenderPageBitmap(long j6, Bitmap bitmap, int i5, int i6, int i7, int i8, int i9, boolean z6);

    public final void a(d dVar) {
        synchronized (b) {
            try {
                Iterator it = dVar.c.keySet().iterator();
                while (it.hasNext()) {
                    nativeClosePage(((Long) dVar.c.get((Integer) it.next())).longValue());
                }
                dVar.c.clear();
                nativeCloseDocument(dVar.f565a);
                ParcelFileDescriptor parcelFileDescriptor = dVar.b;
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException unused) {
                    }
                    dVar.b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final c b(d dVar) {
        c cVar;
        synchronized (b) {
            cVar = new c();
            nativeGetDocumentMetaText(dVar.f565a, "Title");
            nativeGetDocumentMetaText(dVar.f565a, "Author");
            nativeGetDocumentMetaText(dVar.f565a, "Subject");
            nativeGetDocumentMetaText(dVar.f565a, "Keywords");
            nativeGetDocumentMetaText(dVar.f565a, "Creator");
            nativeGetDocumentMetaText(dVar.f565a, "Producer");
            nativeGetDocumentMetaText(dVar.f565a, "CreationDate");
            nativeGetDocumentMetaText(dVar.f565a, "ModDate");
        }
        return cVar;
    }

    public final int c(d dVar) {
        int iNativeGetPageCount;
        synchronized (b) {
            iNativeGetPageCount = nativeGetPageCount(dVar.f565a);
        }
        return iNativeGetPageCount;
    }

    public final ArrayList d(d dVar, int i5) {
        synchronized (b) {
            try {
                ArrayList arrayList = new ArrayList();
                Long l6 = (Long) dVar.c.get(Integer.valueOf(i5));
                if (l6 == null) {
                    return arrayList;
                }
                for (long j6 : nativeGetPageLinks(l6.longValue())) {
                    Integer numNativeGetDestPageIndex = nativeGetDestPageIndex(dVar.f565a, j6);
                    String strNativeGetLinkURI = nativeGetLinkURI(dVar.f565a, j6);
                    RectF rectFNativeGetLinkRect = nativeGetLinkRect(j6);
                    if (rectFNativeGetLinkRect != null && (numNativeGetDestPageIndex != null || strNativeGetLinkURI != null)) {
                        b bVar = new b();
                        bVar.f564a = rectFNativeGetLinkRect;
                        bVar.b = numNativeGetDestPageIndex;
                        bVar.c = strNativeGetLinkURI;
                        arrayList.add(bVar);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Size e(d dVar, int i5) {
        Size sizeNativeGetPageSizeByIndex;
        synchronized (b) {
            sizeNativeGetPageSizeByIndex = nativeGetPageSizeByIndex(dVar.f565a, i5, this.f3765a);
        }
        return sizeNativeGetPageSizeByIndex;
    }

    public final ArrayList f(d dVar) {
        ArrayList arrayList;
        synchronized (b) {
            try {
                arrayList = new ArrayList();
                Long lNativeGetFirstChildBookmark = nativeGetFirstChildBookmark(dVar.f565a, null);
                if (lNativeGetFirstChildBookmark != null) {
                    i(arrayList, dVar, lNativeGetFirstChildBookmark.longValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final Point g(d dVar, int i5, int i6, int i7, int i8, int i9, double d, double d6) {
        return nativePageCoordsToDevice(((Long) dVar.c.get(Integer.valueOf(i5))).longValue(), i6, i7, i8, i9, 0, d, d6);
    }

    public final void h(d dVar, int i5) {
        synchronized (b) {
            dVar.c.put(Integer.valueOf(i5), Long.valueOf(nativeLoadPage(dVar.f565a, i5)));
        }
    }

    public final void i(ArrayList arrayList, d dVar, long j6) {
        a aVar = new a(0);
        ArrayList arrayList2 = new ArrayList();
        nativeGetBookmarkTitle(j6);
        nativeGetBookmarkDestIndex(dVar.f565a, j6);
        arrayList.add(aVar);
        Long lNativeGetFirstChildBookmark = nativeGetFirstChildBookmark(dVar.f565a, Long.valueOf(j6));
        if (lNativeGetFirstChildBookmark != null) {
            i(arrayList2, dVar, lNativeGetFirstChildBookmark.longValue());
        }
        Long lNativeGetSiblingBookmark = nativeGetSiblingBookmark(dVar.f565a, j6);
        if (lNativeGetSiblingBookmark != null) {
            i(arrayList, dVar, lNativeGetSiblingBookmark.longValue());
        }
    }

    public final void j(d dVar, Bitmap bitmap, int i5, int i6, int i7, int i8, int i9, boolean z6) {
        synchronized (b) {
            try {
                nativeRenderPageBitmap(((Long) dVar.c.get(Integer.valueOf(i5))).longValue(), bitmap, this.f3765a, i6, i7, i8, i9, z6);
            } catch (NullPointerException e) {
                Log.e("com.shockwave.pdfium.PdfiumCore", "mContext may be null");
                e.printStackTrace();
            } catch (Exception e6) {
                Log.e("com.shockwave.pdfium.PdfiumCore", "Exception throw from native");
                e6.printStackTrace();
            }
        }
    }

    public d newDocument(ParcelFileDescriptor parcelFileDescriptor) {
        return newDocument(parcelFileDescriptor, (String) null);
    }

    public d newDocument(ParcelFileDescriptor parcelFileDescriptor, String str) {
        d dVar = new d();
        dVar.b = parcelFileDescriptor;
        synchronized (b) {
            int i5 = -1;
            try {
                if (c == null) {
                    Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                    c = declaredField;
                    declaredField.setAccessible(true);
                }
                i5 = c.getInt(parcelFileDescriptor.getFileDescriptor());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e6) {
                e6.printStackTrace();
            }
            dVar.f565a = nativeOpenDocument(i5, str);
        }
        return dVar;
    }

    public d newDocument(byte[] bArr) {
        return newDocument(bArr, (String) null);
    }

    public d newDocument(byte[] bArr, String str) {
        d dVar = new d();
        synchronized (b) {
            dVar.f565a = nativeOpenMemDocument(bArr, str);
        }
        return dVar;
    }
}
