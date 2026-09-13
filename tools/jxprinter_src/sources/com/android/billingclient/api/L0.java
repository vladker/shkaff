package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzjs;
import io.flutter.plugin.common.MethodCall;
import io.reactivex.internal.schedulers.RunnableC0971j;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class L0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2440a;
    public final Object b;
    public final Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ L0(h1 h1Var, J j6, K k6) {
        this.f2440a = 2;
        this.b = h1Var;
        this.d = j6;
        this.c = k6;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IOException, InvocationTargetException {
        File cacheDir;
        int i5 = this.f2440a;
        Object obj = this.d;
        Object obj2 = this.b;
        Object obj3 = this.c;
        switch (i5) {
            case 0:
                zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
                H h6 = k1.f2517k;
                ((C0421m) obj2).N(4, h6, zzjsVar);
                ((p062l0.a) ((K) obj3)).onConsumeResponse(h6, ((J) obj).getPurchaseToken());
                return;
            case 1:
                super/*com.android.billingclient.api.m*/.queryProductDetailsAsync((C0443x0) obj3, (InterfaceC0426o0) obj);
                return;
            case 2:
                super/*com.android.billingclient.api.m*/.consumeAsync((J) obj, (K) obj3);
                return;
            case 3:
                p033f3.h hVar = (p033f3.h) obj2;
                p011b3.c cVarSchedule = ((RunnableC0971j) obj).schedule((Runnable) obj3);
                hVar.getClass();
                p033f3.d.c(hVar, cVarSchedule);
                return;
            default:
                p121v1.b bVar = (p121v1.b) obj3;
                MethodCall methodCall = (MethodCall) obj2;
                p133x1.g gVar = (p133x1.g) obj;
                try {
                    String str = methodCall.method;
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -2032648323:
                                if (str.equals("memoryToMemory")) {
                                    p121v1.b.c(bVar, methodCall, gVar, true);
                                    return;
                                }
                                break;
                            case -1708153454:
                                if (str.equals("registerFont")) {
                                    Object objArgument = methodCall.argument("path");
                                    kotlin.jvm.internal.E.c(objArgument);
                                    gVar.reply(p127w1.a.registerFont((String) objArgument));
                                    return;
                                }
                                break;
                            case -563320815:
                                if (str.equals("getCachePath")) {
                                    Context context = bVar.applicationContext;
                                    gVar.reply((context == null || (cacheDir = context.getCacheDir()) == null) ? null : cacheDir.getAbsolutePath());
                                    return;
                                }
                                break;
                            case 215369967:
                                if (str.equals("mergeToFile")) {
                                    p121v1.b.d(bVar, methodCall, gVar, false);
                                    return;
                                }
                                break;
                            case 712763128:
                                if (str.equals("memoryToFile")) {
                                    p121v1.b.c(bVar, methodCall, gVar, false);
                                    return;
                                }
                                break;
                            case 1008861108:
                                if (str.equals("mergeToMemory")) {
                                    p121v1.b.d(bVar, methodCall, gVar, true);
                                    return;
                                }
                                break;
                            case 1064226040:
                                if (str.equals("fileToMemory")) {
                                    p121v1.b.c(bVar, methodCall, gVar, true);
                                    return;
                                }
                                break;
                            case 1824364339:
                                if (str.equals("fileToFile")) {
                                    p121v1.b.c(bVar, methodCall, gVar, false);
                                    return;
                                }
                                break;
                        }
                    }
                    gVar.b();
                    return;
                } catch (p139y1.a unused) {
                    p133x1.f fVar = p133x1.g.Companion;
                    gVar.replyError("Decode bitmap error.", null, null);
                    return;
                } catch (Exception e) {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    try {
                        e.printStackTrace(printWriter);
                        String string = stringWriter.getBuffer().toString();
                        kotlin.jvm.internal.E.e(string, "toString(...)");
                        gVar.replyError(string, "", null);
                        L3.d.closeFinally(printWriter, null);
                        return;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            L3.d.closeFinally(printWriter, th);
                            throw th2;
                        }
                    }
                }
        }
    }

    public /* synthetic */ L0(Object obj, int i5, Object obj2, Object obj3) {
        this.f2440a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public L0(RunnableC0971j runnableC0971j, p033f3.h hVar, Runnable runnable) {
        this.f2440a = 3;
        this.d = runnableC0971j;
        this.b = hVar;
        this.c = runnable;
    }
}
