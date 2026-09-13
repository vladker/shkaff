package com.google.android.gms.auth.api.accounttransfer;

import O3.l;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzlm;
import com.google.android.gms.internal.mlkit_common.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfa;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn;
import com.google.android.gms.internal.mlkit_vision_common.zzae;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzct;
import com.google.android.gms.internal.play_billing.zzfx;
import com.google.android.gms.measurement.internal.zzic;
import com.google.firebase.encoders.FieldDescriptor;
import io.flutter.plugins.webviewflutter.AndroidWebKitError;
import java.util.List;
import p023d4.AbstractC0618q;
import p100r3.c;
import p100r3.g;
import p147z3.C1929i;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static int A(int i5, int i6, int i7) {
        return zbtk.zbD(i5) + i6 + i7;
    }

    public static FieldDescriptor B(int i5, FieldDescriptor.Builder builder) {
        zzct zzctVar = new zzct();
        zzctVar.zza(i5);
        return builder.withProperty(zzctVar.zzb()).build();
    }

    public static int C(int i5, int i6, int i7) {
        return zzfx.zzy(i5) + i6 + i7;
    }

    public static double a(double d, double d6, double d7, double d8) {
        return (d7 - (d * d6)) / d8;
    }

    public static int b(int i5, int i6, int i7) {
        return zzlm.zzz(i5) + i6 + i7;
    }

    public static int c(int i5, int i6, int i7, int i8) {
        return zzfx.zzy(i5) + i6 + i7 + i8;
    }

    public static FieldDescriptor.Builder d(int i5, FieldDescriptor.Builder builder, String str) {
        zzay zzayVar = new zzay();
        zzayVar.zza(i5);
        builder.withProperty(zzayVar.zzb()).build();
        return FieldDescriptor.builder(str);
    }

    public static FieldDescriptor e(int i5, FieldDescriptor.Builder builder) {
        zzay zzayVar = new zzay();
        zzayVar.zza(i5);
        return builder.withProperty(zzayVar.zzb()).build();
    }

    public static Object f(zzbk zzbkVar, int i5, List list, int i6) {
        com.google.android.gms.internal.measurement.zzh.zza(zzbkVar.name(), i5, list);
        return list.get(i6);
    }

    public static Object g(String str) {
        return u.m1361constructorimpl(v.createFailure(new Exception(str)));
    }

    public static String h(int i5, int i6, String str) {
        StringBuilder sb = new StringBuilder(i5);
        sb.append(str);
        sb.append(i6);
        return sb.toString();
    }

    public static String i(int i5, String str, String str2) {
        StringBuilder sb = new StringBuilder(i5);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String j(int i5, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i5);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String k(String str, StringBuilder sb) {
        return str + ((Object) sb);
    }

    public static C1929i l() {
        AbstractC0618q.noImpl();
        return new C1929i();
    }

    public static void m(int i5, FieldDescriptor.Builder builder) {
        zzay zzayVar = new zzay();
        zzayVar.zza(i5);
        builder.withProperty(zzayVar.zzb()).build();
    }

    public static void n(zzic zzicVar, String str) {
        zzicVar.zzaV().zzb().zza(str);
    }

    public static void o(AndroidWebKitError androidWebKitError, l lVar) {
        lVar.invoke(u.a(u.m1361constructorimpl(v.createFailure(androidWebKitError))));
    }

    public static void p(String str, String str2, String str3, l lVar) {
        lVar.invoke(u.a(u.m1361constructorimpl(v.createFailure(new AndroidWebKitError(str, str2, str3)))));
    }

    public static void q(c cVar, c cVar2, t5.c cVar3) {
        cVar.getClass();
        cVar3.onError(g.b(cVar2));
    }

    public static int r(int i5, int i6, int i7) {
        int i8 = i5 / i6;
        return i8 + i8 + i7;
    }

    public static FieldDescriptor.Builder s(int i5, FieldDescriptor.Builder builder, String str) {
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(i5);
        builder.withProperty(zzfaVar.zzb()).build();
        return FieldDescriptor.builder(str);
    }

    public static FieldDescriptor t(int i5, FieldDescriptor.Builder builder) {
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(i5);
        return builder.withProperty(zzfaVar.zzb()).build();
    }

    public static void u(int i5, FieldDescriptor.Builder builder) {
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(i5);
        builder.withProperty(zzfaVar.zzb()).build();
    }

    public static void v(zzic zzicVar, String str) {
        zzicVar.zzaV().zze().zza(str);
    }

    public static int w(int i5, int i6, int i7) {
        return zzdn.zzA(i5) + i6 + i7;
    }

    public static FieldDescriptor.Builder x(int i5, FieldDescriptor.Builder builder, String str) {
        zzct zzctVar = new zzct();
        zzctVar.zza(i5);
        builder.withProperty(zzctVar.zzb()).build();
        return FieldDescriptor.builder(str);
    }

    public static FieldDescriptor y(int i5, FieldDescriptor.Builder builder) {
        zzae zzaeVar = new zzae();
        zzaeVar.zza(i5);
        return builder.withProperty(zzaeVar.zzb()).build();
    }

    public static void z(int i5, FieldDescriptor.Builder builder) {
        zzct zzctVar = new zzct();
        zzctVar.zza(i5);
        builder.withProperty(zzctVar.zzb()).build();
    }
}
