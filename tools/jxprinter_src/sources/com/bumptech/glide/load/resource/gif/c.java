package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;
import java.util.List;
import p126w0.v;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class c implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3133f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f3134g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3135a;
    public final List b;
    public final b c;
    public final a d;
    public final d e;

    @VisibleForTesting
    public c(Context context, List<p126w0.g> list, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, com.bumptech.glide.load.engine.bitmap_recycle.a aVar, b bVar, a aVar2) {
        this.f3135a = context.getApplicationContext();
        this.b = list;
        this.d = aVar2;
        this.e = new d(cVar, aVar);
        this.c = bVar;
    }

    public static int a(com.bumptech.glide.gifdecoder.d dVar, int i5, int i6) {
        int iMin = Math.min(dVar.f2879f / i6, dVar.e / i5);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            StringBuilder sbS = androidx.collection.a.s("Downsampling GIF, sampleSize: ", iMax, i5, ", target dimens: [", "x");
            sbS.append(i6);
            sbS.append("], actual dimens: [");
            sbS.append(dVar.e);
            sbS.append("x");
            sbS.append(dVar.f2879f);
            sbS.append("]");
            Log.v("BufferGifDecoder", sbS.toString());
        }
        return iMax;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:38:0x0051
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // p126w0.x
    public com.bumptech.glide.load.resource.gif.h decode(@androidx.annotation.NonNull java.nio.ByteBuffer r9, int r10, int r11, @androidx.annotation.NonNull p126w0.v r12) {
        /*
            r8 = this;
            com.bumptech.glide.load.resource.gif.b r1 = r8.c
            monitor-enter(r1)
            java.util.Queue r0 = r1.f3132a     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L4c
            com.bumptech.glide.gifdecoder.e r0 = (com.bumptech.glide.gifdecoder.e) r0     // Catch: java.lang.Throwable -> L4c
            if (r0 != 0) goto L17
            com.bumptech.glide.gifdecoder.e r0 = new com.bumptech.glide.gifdecoder.e     // Catch: java.lang.Throwable -> L13
            r0.<init>()     // Catch: java.lang.Throwable -> L13
            goto L17
        L13:
            r0 = move-exception
            r9 = r0
            r2 = r8
            goto L4f
        L17:
            com.bumptech.glide.gifdecoder.e r6 = r0.setData(r9)     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r1)
            r1 = 0
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            com.bumptech.glide.load.resource.gif.h r9 = r2.decode(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L38
            com.bumptech.glide.load.resource.gif.b r10 = r2.c
            monitor-enter(r10)
            r6.b = r1     // Catch: java.lang.Throwable -> L34
            r6.c = r1     // Catch: java.lang.Throwable -> L34
            java.util.Queue r11 = r10.f3132a     // Catch: java.lang.Throwable -> L34
            r11.offer(r6)     // Catch: java.lang.Throwable -> L34
            monitor-exit(r10)
            return r9
        L34:
            r0 = move-exception
            r9 = r0
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L34
            throw r9
        L38:
            r0 = move-exception
            r9 = r0
            com.bumptech.glide.load.resource.gif.b r10 = r2.c
            monitor-enter(r10)
            r6.b = r1     // Catch: java.lang.Throwable -> L48
            r6.c = r1     // Catch: java.lang.Throwable -> L48
            java.util.Queue r11 = r10.f3132a     // Catch: java.lang.Throwable -> L48
            r11.offer(r6)     // Catch: java.lang.Throwable -> L48
            monitor-exit(r10)
            throw r9
        L48:
            r0 = move-exception
            r9 = r0
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L48
            throw r9
        L4c:
            r0 = move-exception
            r2 = r8
        L4e:
            r9 = r0
        L4f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L51
            throw r9
        L51:
            r0 = move-exception
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.c.decode(java.nio.ByteBuffer, int, int, w0.v):com.bumptech.glide.load.resource.gif.h");
    }

    @Override // p126w0.x
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull v vVar) {
        return !((Boolean) vVar.get(p.b)).booleanValue() && p126w0.p.getType(this.b, byteBuffer) == ImageHeaderParser$ImageType.GIF;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:576)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:602)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    @Nullable
    private h decode(ByteBuffer byteBuffer, int i5, int i6, com.bumptech.glide.gifdecoder.e eVar, v vVar) {
        StringBuilder sb;
        Bitmap.Config config;
        long logTime = L0.l.getLogTime();
        try {
            com.bumptech.glide.gifdecoder.d header = eVar.parseHeader();
            if (header.b > 0 && header.f2878a == 0) {
                if (vVar.get(p.f3159a) == p126w0.b.b) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                int iA = a(header, i5, i6);
                a aVar = this.d;
                d dVar = this.e;
                aVar.getClass();
                com.bumptech.glide.gifdecoder.f fVar = new com.bumptech.glide.gifdecoder.f(dVar, header, byteBuffer, iA);
                fVar.setDefaultBitmapConfig(config);
                fVar.f2889i = (fVar.f2889i + 1) % fVar.f2890j.b;
                Bitmap nextFrame = fVar.getNextFrame();
                if (nextFrame == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                        sb.append(L0.l.a(logTime));
                        Log.v("BufferGifDecoder", sb.toString());
                        return null;
                    }
                    return null;
                }
                h hVar = new h(new f(this.f3135a, fVar, B0.e.get(), i5, i6, nextFrame));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + L0.l.a(logTime));
                }
                return hVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb = new StringBuilder("Decoded GIF from stream in ");
                sb.append(L0.l.a(logTime));
                Log.v("BufferGifDecoder", sb.toString());
                return null;
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + L0.l.a(logTime));
            }
            throw th;
        }
    }
}
