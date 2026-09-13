package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class Q implements p126w0.q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final L0.n f2971j = new L0.n(50);
    public final com.bumptech.glide.load.engine.bitmap_recycle.a b;
    public final p126w0.q c;
    public final p126w0.q d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f2973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p126w0.v f2974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p126w0.z f2975i;

    public Q(com.bumptech.glide.load.engine.bitmap_recycle.a aVar, p126w0.q qVar, p126w0.q qVar2, int i5, int i6, p126w0.z zVar, Class cls, p126w0.v vVar) {
        this.b = aVar;
        this.c = qVar;
        this.d = qVar2;
        this.e = i5;
        this.f2972f = i6;
        this.f2975i = zVar;
        this.f2973g = cls;
        this.f2974h = vVar;
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof Q) {
            Q q6 = (Q) obj;
            if (this.f2972f == q6.f2972f && this.e == q6.e && L0.s.bothNullOrEqual(this.f2975i, q6.f2975i) && this.f2973g.equals(q6.f2973g) && this.c.equals(q6.c) && this.d.equals(q6.d) && this.f2974h.equals(q6.f2974h)) {
                return true;
            }
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        int iHashCode = ((((this.d.hashCode() + (this.c.hashCode() * 31)) * 31) + this.e) * 31) + this.f2972f;
        p126w0.z zVar = this.f2975i;
        if (zVar != null) {
            iHashCode = (iHashCode * 31) + zVar.hashCode();
        }
        return this.f2974h.b.hashCode() + ((this.f2973g.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f2972f + ", decodedResourceClass=" + this.f2973g + ", transformation='" + this.f2975i + "', options=" + this.f2974h + '}';
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Object objE;
        com.bumptech.glide.load.engine.bitmap_recycle.j jVar = (com.bumptech.glide.load.engine.bitmap_recycle.j) this.b;
        synchronized (jVar) {
            com.bumptech.glide.load.engine.bitmap_recycle.i iVar = jVar.b;
            com.bumptech.glide.load.engine.bitmap_recycle.m mVarB = (com.bumptech.glide.load.engine.bitmap_recycle.m) iVar.f2982a.poll();
            if (mVarB == null) {
                mVarB = iVar.b();
            }
            com.bumptech.glide.load.engine.bitmap_recycle.h hVar = (com.bumptech.glide.load.engine.bitmap_recycle.h) mVarB;
            hVar.b = 8;
            hVar.c = byte[].class;
            objE = jVar.e(hVar, byte[].class);
        }
        byte[] bArr = (byte[]) objE;
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f2972f).array();
        this.d.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        p126w0.z zVar = this.f2975i;
        if (zVar != null) {
            zVar.updateDiskCacheKey(messageDigest);
        }
        this.f2974h.updateDiskCacheKey(messageDigest);
        L0.n nVar = f2971j;
        Class cls = this.f2973g;
        byte[] bytes = (byte[]) nVar.get(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(p126w0.q.f8812a);
            nVar.put(cls, bytes);
        }
        messageDigest.update(bytes);
        ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.b).g(bArr);
    }
}
