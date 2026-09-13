package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.bitmap.C0506a;
import com.bumptech.glide.load.resource.bitmap.C0507b;
import com.bumptech.glide.load.resource.bitmap.C0508c;
import com.bumptech.glide.load.resource.bitmap.C0512g;
import com.bumptech.glide.load.resource.bitmap.C0513h;
import com.bumptech.glide.load.resource.bitmap.C0521p;
import com.bumptech.glide.load.resource.bitmap.C0524t;
import com.bumptech.glide.load.resource.bitmap.C0528x;
import com.bumptech.glide.load.resource.bitmap.G;
import com.bumptech.glide.load.resource.bitmap.I;
import com.bumptech.glide.load.resource.bitmap.L;
import com.bumptech.glide.load.resource.bitmap.O;
import com.bumptech.glide.load.resource.bitmap.V;
import com.bumptech.glide.load.resource.bitmap.Y;
import com.bumptech.glide.load.resource.bitmap.d0;
import com.bumptech.glide.load.resource.bitmap.f0;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p144z0.C;
import p144z0.C1897b;
import p144z0.C1898c;
import p144z0.C1900e;
import p144z0.C1902g;
import p144z0.C1904i;
import p144z0.C1906k;
import p144z0.C1911p;
import p144z0.C1913s;
import p144z0.C1914t;
import p144z0.C1919y;
import p144z0.C1920z;
import p144z0.E;
import p144z0.c0;
import p144z0.e0;
import p144z0.g0;
import p144z0.h0;
import p144z0.j0;
import p144z0.k0;
import p144z0.l0;
import p144z0.m0;
import p144z0.o0;
import p144z0.q0;
import p144z0.s0;
import p144z0.u0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x {
    public static v createAndInitRegistry(c cVar, List<Object> list, @Nullable G0.a aVar) {
        p126w0.x c0512g;
        p126w0.x o6;
        v vVar;
        com.bumptech.glide.load.engine.bitmap_recycle.c bitmapPool = cVar.getBitmapPool();
        com.bumptech.glide.load.engine.bitmap_recycle.a arrayPool = cVar.getArrayPool();
        Context applicationContext = cVar.getGlideContext().getApplicationContext();
        l lVar = cVar.getGlideContext().f2911h;
        v vVar2 = new v();
        vVar2.register(new C0521p());
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 27) {
            vVar2.register(new C0528x());
        }
        Resources resources = applicationContext.getResources();
        List<p126w0.g> imageHeaderParsers = vVar2.getImageHeaderParsers();
        com.bumptech.glide.load.resource.gif.c cVar2 = new com.bumptech.glide.load.resource.gif.c(applicationContext, imageHeaderParsers, bitmapPool, arrayPool, com.bumptech.glide.load.resource.gif.c.f3134g, com.bumptech.glide.load.resource.gif.c.f3133f);
        f0 f0Var = new f0(bitmapPool, new d0());
        C0524t c0524t = new C0524t(vVar2.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (i5 < 28 || !lVar.f2913a.containsKey(f.class)) {
            c0512g = new C0512g(c0524t);
            o6 = new O(c0524t, arrayPool);
        } else {
            o6 = new G();
            c0512g = new C0513h();
        }
        if (i5 >= 28) {
            vVar2.append(v.BUCKET_GIF, InputStream.class, Drawable.class, new D0.c(new D0.d(imageHeaderParsers, arrayPool)));
            vVar2.append(v.BUCKET_GIF, ByteBuffer.class, Drawable.class, new D0.b(new D0.d(imageHeaderParsers, arrayPool)));
        }
        D0.h hVar = new D0.h(applicationContext);
        C0508c c0508c = new C0508c(arrayPool);
        F0.a aVar2 = new F0.a(Bitmap.CompressFormat.JPEG, 100);
        F0.d dVar = new F0.d();
        ContentResolver contentResolver = applicationContext.getContentResolver();
        vVar2.append(ByteBuffer.class, new C1904i()).append(InputStream.class, new j0(arrayPool)).append("Bitmap", ByteBuffer.class, Bitmap.class, c0512g).append("Bitmap", InputStream.class, Bitmap.class, o6);
        String str = Build.FINGERPRINT;
        if (!"robolectric".equals(str)) {
            vVar2.append("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new I(c0524t));
        }
        v vVarAppend = vVar2.append("Bitmap", ParcelFileDescriptor.class, Bitmap.class, f0Var).append("Bitmap", AssetFileDescriptor.class, Bitmap.class, new f0(bitmapPool, new Y()));
        o0.a aVar3 = o0.a.f9090a;
        vVarAppend.append(Bitmap.class, Bitmap.class, aVar3).append("Bitmap", Bitmap.class, Bitmap.class, new V()).append(Bitmap.class, (p126w0.y) c0508c).append("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C0506a(resources, c0512g)).append("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C0506a(resources, o6)).append("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C0506a(resources, f0Var)).append(BitmapDrawable.class, (p126w0.y) new C0507b(bitmapPool, c0508c)).append(v.BUCKET_GIF, InputStream.class, com.bumptech.glide.load.resource.gif.f.class, new com.bumptech.glide.load.resource.gif.q(imageHeaderParsers, cVar2, arrayPool)).append(v.BUCKET_GIF, ByteBuffer.class, com.bumptech.glide.load.resource.gif.f.class, cVar2).append(com.bumptech.glide.load.resource.gif.f.class, (p126w0.y) new com.bumptech.glide.load.resource.gif.g()).append(com.bumptech.glide.gifdecoder.b.class, com.bumptech.glide.gifdecoder.b.class, aVar3).append("Bitmap", com.bumptech.glide.gifdecoder.b.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.o(bitmapPool)).append(Uri.class, Drawable.class, hVar).append(Uri.class, Bitmap.class, new L(hVar, bitmapPool)).register(new C0.a()).append(File.class, ByteBuffer.class, new C1906k()).append(File.class, InputStream.class, new C1920z(new C())).append(File.class, File.class, new E0.a()).append(File.class, ParcelFileDescriptor.class, new C1920z(new C1919y())).append(File.class, File.class, aVar3).register(new com.bumptech.glide.load.data.q(arrayPool));
        if ("robolectric".equals(str)) {
            vVar = vVar2;
        } else {
            vVar = vVar2;
            vVar.register(new com.bumptech.glide.load.data.t());
        }
        C1914t c1914t = new C1914t(applicationContext);
        p144z0.r rVar = new p144z0.r(applicationContext);
        C1913s c1913s = new C1913s(applicationContext);
        Class cls = Integer.TYPE;
        vVar.append(cls, InputStream.class, c1914t).append(Integer.class, InputStream.class, c1914t).append(cls, AssetFileDescriptor.class, rVar).append(Integer.class, AssetFileDescriptor.class, rVar).append(cls, Drawable.class, c1913s).append(Integer.class, Drawable.class, c1913s).append(Uri.class, InputStream.class, new h0(applicationContext)).append(Uri.class, AssetFileDescriptor.class, new g0(applicationContext));
        e0 e0Var = new e0(resources);
        c0 c0Var = new c0(resources, 0);
        p144z0.d0 d0Var = new p144z0.d0(resources);
        vVar.append(Integer.class, Uri.class, e0Var).append(cls, Uri.class, e0Var).append(Integer.class, AssetFileDescriptor.class, c0Var).append(cls, AssetFileDescriptor.class, c0Var).append(Integer.class, InputStream.class, d0Var).append(cls, InputStream.class, d0Var);
        vVar.append(String.class, InputStream.class, new C1911p()).append(Uri.class, InputStream.class, new C1911p()).append(String.class, InputStream.class, new m0()).append(String.class, ParcelFileDescriptor.class, new l0()).append(String.class, AssetFileDescriptor.class, new k0()).append(Uri.class, InputStream.class, new C1898c(applicationContext.getAssets())).append(Uri.class, AssetFileDescriptor.class, new C1897b(applicationContext.getAssets())).append(Uri.class, InputStream.class, new A0.c(applicationContext)).append(Uri.class, InputStream.class, new A0.e(applicationContext));
        if (i5 >= 29) {
            vVar.append(Uri.class, InputStream.class, new A0.h(applicationContext, InputStream.class));
            vVar.append(Uri.class, ParcelFileDescriptor.class, new A0.h(applicationContext, ParcelFileDescriptor.class));
        }
        vVar.append(Uri.class, InputStream.class, new s0(contentResolver)).append(Uri.class, ParcelFileDescriptor.class, new q0(contentResolver)).append(Uri.class, AssetFileDescriptor.class, new c0(contentResolver, 1)).append(Uri.class, InputStream.class, new u0()).append(URL.class, InputStream.class, new A0.l()).append(Uri.class, File.class, new p144z0.L(applicationContext)).append(E.class, InputStream.class, new A0.a()).append(byte[].class, ByteBuffer.class, new C1900e()).append(byte[].class, InputStream.class, new C1902g()).append(Uri.class, Uri.class, aVar3).append(Drawable.class, Drawable.class, aVar3).append(Drawable.class, Drawable.class, new D0.i()).register(Bitmap.class, BitmapDrawable.class, new F0.b(resources)).register(Bitmap.class, byte[].class, aVar2).register(Drawable.class, byte[].class, new F0.c(bitmapPool, aVar2, dVar)).register(com.bumptech.glide.load.resource.gif.f.class, byte[].class, dVar);
        p126w0.x xVarByteBuffer = f0.byteBuffer(bitmapPool);
        vVar.append(ByteBuffer.class, Bitmap.class, xVarByteBuffer);
        vVar.append(ByteBuffer.class, BitmapDrawable.class, new C0506a(resources, xVarByteBuffer));
        initializeModules(applicationContext, cVar, vVar, list, aVar);
        return vVar;
    }

    private static void initializeModules(Context context, c cVar, v vVar, List<Object> list, @Nullable G0.a aVar) {
        Iterator<Object> it = list.iterator();
        if (it.hasNext()) {
            throw AbstractC1125a.g(it);
        }
        if (aVar != null) {
            aVar.registerComponents(context, cVar, vVar);
        }
    }

    public static L0.k lazilyCreateAndInitializeRegistry(c cVar, List<Object> list, @Nullable G0.a aVar) {
        return new w(cVar, list, aVar);
    }
}
