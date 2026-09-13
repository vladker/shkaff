package cn.fly.tools.b;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ReflectHelper;
import cn.fly.tools.utils.ResHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class i {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f1710a;

        public a(Object obj) {
            this.f1710a = obj;
        }

        private long m() {
            if (DH.SyncMtd.getOSVersionIntForFly() >= 17) {
                try {
                    long jLongValue = ((Long) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, "getElapsedRealtimeNanos", -1L, new Object[0])).longValue();
                    long millis = TimeUnit.NANOSECONDS.toMillis(SystemClock.elapsedRealtimeNanos() - jLongValue);
                    if (millis >= 0) {
                        return millis;
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
            return -1L;
        }

        public float a() {
            return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("011Zdi)eh%ec_bb1cfci]cb(db"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public double b() {
            return ((Double) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("011[diSeh(ed ch$ch?h;cfcb6e"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public double c() {
            return ((Double) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("012Kdi3eh@edcj!d9dichLh9cfcbMe"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public long d() {
            return ((Long) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("007Kdi_eh?ebchceUe"), 0L, new Object[0])).longValue();
        }

        public String e() {
            return (String) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("011Ddi0ehKfkcicjccchcbAeIci"), null, new Object[0]);
        }

        public double f() {
            return ((Double) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("011+diOeh'ec[fh;chThLcfcbXe"), Double.valueOf(0.0d), new Object[0])).doubleValue();
        }

        public float g() {
            return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("010NdiTehLei5ec^cichPd^di"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public float h() {
            return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("0084di5ehQdkBiee<cb"), Float.valueOf(0.0f), new Object[0])).floatValue();
        }

        public boolean i() {
            if (DH.SyncMtd.getOSVersionIntForFly() >= 26) {
                return ((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("019gc>ehfj[e-ciBh$ch9bcf'ec(bb%cfci,cbHdb"), Boolean.FALSE, new Object[0])).booleanValue();
            }
            return false;
        }

        public float j() {
            if (DH.SyncMtd.getOSVersionIntForFly() >= 26) {
                return ((Float) ReflectHelper.invokeInstanceMethodNoThrow(this.f1710a, x.b("025[diYeh3fj0eCci-h%chMbcf.ec-bbRcfci8cb-dbgb2eheVcieh"), Float.valueOf(0.0f), new Object[0])).floatValue();
            }
            return 0.0f;
        }

        public long k() {
            long jD = d();
            try {
                long jM = m();
                if (jM != -1) {
                    long caliSysTime = ResHelper.getCaliSysTime() - jM;
                    if (Math.abs(caliSysTime - jD) > 600000) {
                        return caliSysTime;
                    }
                }
                return jD;
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
                return jD;
            }
        }

        public HashMap<String, Object> l() {
            Throwable th;
            HashMap<String, Object> map;
            if (this.f1710a == null) {
                return null;
            }
            try {
                map = new HashMap<>();
                try {
                    map.put("accmt", Float.valueOf(a()));
                    if (i()) {
                        map.put("vacmt", Float.valueOf(j()));
                    }
                    map.put("ltdmt", Double.valueOf(b()));
                    map.put("lndmt", Double.valueOf(c()));
                    map.put(cn.fly.commons.g.f1427a, Long.valueOf(k()));
                    map.put("prvmt", e());
                    map.put("atdmt", Double.valueOf(f()));
                    map.put("brmt", Float.valueOf(g()));
                    map.put("spmt", Float.valueOf(h()));
                    return map;
                } catch (Throwable th2) {
                    th = th2;
                    FlyLog.getInstance().d(androidx.exifinterface.media.a.n("[cl] glfe ", th), new Object[0]);
                    return map;
                }
            } catch (Throwable th3) {
                th = th3;
                map = null;
            }
        }

        public float a(Object obj) {
            if (obj == null) {
                return 0.0f;
            }
            try {
                return ((Float) ReflectHelper.invokeInstanceMethod(this.f1710a, x.b("0100cbcheh[hcdbe>ebcj"), new Object[]{obj}, new Class[]{Class.forName(x.b("025cd%cbcicjchcbck>fEcjYbch)chcj:dNckedcjVbch8chcj7d"))})).floatValue();
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
                return 0.0f;
            }
        }
    }

    public static Object a(Context context, String str) throws Throwable {
        String str2;
        Object objA;
        Parcel parcel;
        if (cn.fly.commons.e.f() && cn.fly.tools.utils.e.a().a(str) && DH.SyncMtd.getOSVersionIntForFly() >= 23) {
            cn.fly.tools.a.f fVarA = cn.fly.tools.a.f.a(context);
            if (DH.SyncMtd.getOSVersionIntForFly() >= 31) {
                Object objA2 = fVarA.a(x.b("036cdUcbcicjchcbck*f7cj(bchGchcjUdWckedWc<eh^h,edcj,bch6chcj(dZfi=eCcdcf-eKeh(h") + "$" + x.b("007;eicfch+f$cb6e+ci"));
                if (objA2 != null) {
                    str2 = "$";
                    objA = fVarA.a(x.b("036cdFcbcicjchcbck6f@cjGbch]chcj,d_cked7c*ehThOedcj2bchGchcj dAfi@eVcdcf+e?ehQh") + "$" + x.b("007Qeicfch0f>cb(eHci"), objA2, x.b("005SeecfchTf>cb"), (Class[]) null, (Object[]) null, (Class<?>) fVarA.b(x.b("036cdEcbcicjchcbckOfIcjKbchXchcjRd)cked<cRehDhOedcj^bch;chcjJdCfiQe@cdcf[eMeh7h")), (Object) null);
                } else {
                    str2 = "$";
                    objA = null;
                }
            } else {
                str2 = "$";
                objA = fVarA.a(x.b("032cdScbcicjchcbck0fJcjMbchPchcjYd4ckedcj[bchBchcj+d,fi*eHcdcf;eAehIh"), (Object) null, x.b("028b?ci?eche.fbcicjceekDei9ciFebcheHcbfkcicjccchcb-e;ci"), new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE}, new Object[]{str, 0, 0, Boolean.TRUE}, (Class<?>) fVarA.b(x.b("036cdMcbcicjchcbck.f=cjHbch,chcj6d0ckedScZehHh[edcj,bch%chcj@dRfiZe9cdcfPe5ehGh")), (Object) null);
            }
            Object obj = objA;
            String str3 = x.b("033cd?cbcicjchcbckWf.cjNbch2chcjWd]ckddedcj8bchNchcj>dKgb8cdcDdiJe'ci") + str2 + x.b("004@dk)hGcfee");
            String strB = x.b("0270ebfiecdfdkecdcebddfgdfcgdi:eh_edUcGeh'hCedcj+bch:chcjId");
            Class<?> cls = Integer.TYPE;
            int iIntValue = ((Integer) fVarA.a(str3, strB, null, cls, -1)).intValue();
            IBinder iBinder = (IBinder) fVarA.a(x.b("025cd_cbcicjchcbckcjehckdk:e)ciccch0beZgb^cdc6diNeOci"), (Object) null, x.b("010Edi$eh>dkEe6ciccchDbe"), new Class[]{String.class}, new Object[]{x.b("008fKcjNbchJchcjQd")}, IBinder.class, (Object) null);
            if (obj != null && iBinder != null) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(x.b("033cd4cbcicjchcbckBf-cj+bch=chcjNd8ckddedcj1bchPchcj%d3gbNcdc_di*eJci"));
                    if (DH.SyncMtd.getOSVersionIntForFly() >= 31) {
                        parcelObtain.writeString(str);
                        parcelObtain.writeTypedObject((Parcelable) obj, 0);
                        parcel = parcelObtain2;
                    } else {
                        parcelObtain.writeInt(1);
                        parcel = parcelObtain2;
                        try {
                            fVarA.a(obj.getClass(), obj, x.b("013?efcichOheYebcjfkUc2ci<bef"), new Class[]{Parcel.class, cls}, new Object[]{parcelObtain, 0}, (Class<?>) null, (Object) null);
                        } catch (Throwable th) {
                            th = th;
                            cn.fly.tools.a.f.a(context).b(context);
                            parcel.recycle();
                            parcelObtain.recycle();
                            throw th;
                        }
                    }
                    parcelObtain.writeString(context.getPackageName());
                    if (DH.SyncMtd.getOSVersionIntForFly() >= 30) {
                        parcelObtain.writeString(context.getAttributionTag());
                    }
                    iBinder.transact(iIntValue, parcelObtain, parcel, 0);
                    parcel.readException();
                    Object typedObject = parcel.readTypedObject(a());
                    cn.fly.tools.a.f.a(context).b(context);
                    parcel.recycle();
                    parcelObtain.recycle();
                    return typedObject;
                } catch (Throwable th2) {
                    th = th2;
                    parcel = parcelObtain2;
                }
            }
        }
        return null;
    }

    private static Parcelable.Creator<?> a() {
        return (Parcelable.Creator) ReflectHelper.getStaticField(ReflectHelper.importClass(x.b("025cd5cbcicjchcbck+fCcj9bch.chcj3dMckedcj5bchOchcj'd")), x.b("0074dcfifhecebfgfi"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [cn.fly.tools.a.f] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [android.os.Parcel] */
    /* JADX WARN: Type inference failed for: r12v28, types: [android.os.Parcel] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v42 */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.os.Parcel] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static Object a(Context context, String str, long j6) throws Throwable {
        Class cls;
        int i5;
        String str2;
        Object objA;
        ?? r12;
        Object[] objArr;
        Parcel parcel;
        char c;
        ?? r9;
        Object objCreateProxy;
        Object objA2;
        Parcel parcel2 = null;
        if (!cn.fly.commons.e.e() || !cn.fly.tools.utils.e.a().a(str) || DH.SyncMtd.getOSVersionIntForFly() < 23) {
            return null;
        }
        cn.fly.tools.a.f fVarA = cn.fly.tools.a.f.a(context);
        final ?? countDownLatch = new CountDownLatch(1);
        final Object[] objArr2 = new Object[1];
        Class<?> clsB = cn.fly.tools.a.f.a(FlySDK.getContext()).b(x.b("032cdFcbcicjchcbckFf-cj'bchGchcjNd-ckedcj*bch6chcj_d=fi!e4cdcf2eQehRh"));
        int oSVersionIntForFly = DH.SyncMtd.getOSVersionIntForFly();
        Class cls2 = Long.TYPE;
        if (oSVersionIntForFly >= 31) {
            Object objA3 = fVarA.a(x.b("032cd6cbcicjchcbckEfNcjVbch^chcj'd>ckedcj,bch2chcjNd(fi;eHcdcf.eGehYh") + "$" + x.b("007:eicfchAfHcbGeQci"), new Class[]{cls2}, new Object[]{0L});
            if (objA3 != null) {
                str2 = "$";
                cls = String.class;
                i5 = 31;
                objA = fVarA.a(x.b("032cd<cbcicjchcbck^fWcjJbchKchcj(dVckedcj[bchZchcjOdEfiDeHcdcf>e_eh6h") + "$" + x.b("007SeicfchPfLcb;eGci"), objA3, x.b("005Weecfch2fXcb"), (Class[]) null, (Object[]) null, clsB, (Object) null);
            } else {
                cls = String.class;
                str2 = "$";
                i5 = 31;
                objA = null;
            }
        } else {
            cls = String.class;
            i5 = 31;
            str2 = "$";
            objA = fVarA.a(x.b("032cd9cbcicjchcbck1f0cjDbch]chcj_d7ckedcjRbch5chcjHdIfi?e@cdcf.e@ehBh"), (Object) null, x.b("028b'ci-eche+fbcicjceekFeiTciEebche]cbfkcicjccchcb5e:ci"), new Class[]{cls, cls2, Float.TYPE, Boolean.TYPE}, new Object[]{str, 0, 0, Boolean.TRUE}, clsB, (Object) null);
        }
        Object obj = objA;
        ?? r6 = (IBinder) fVarA.a(x.b("025cdScbcicjchcbckcjehckdkPeKciccch'be gb$cdc7di3e=ci"), (Object) null, x.b("010=diCehJdkWeDciccch<be"), new Class[]{cls}, new Object[]{x.b("008fUcj0bch2chcj$d")}, IBinder.class, (Object) null);
        if (obj == null || r6 == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(x.b("033cd:cbcicjchcbck[fRcjCbchKchcjWdTckddedcj7bch)chcjDdFgbQcdc3diBeHci"));
            try {
                if (DH.SyncMtd.getOSVersionIntForFly() >= i5) {
                    try {
                        parcelObtain.writeString(str);
                        parcelObtain.writeTypedObject((Parcelable) obj, 0);
                        Consumer consumer = new Consumer() { // from class: cn.fly.tools.b.i.1
                            @Override // java.util.function.Consumer
                            public void accept(Object obj2) {
                                try {
                                    objArr2[0] = obj2;
                                } catch (Throwable th) {
                                    try {
                                        FlyLog.getInstance().d(th);
                                    } finally {
                                        countDownLatch.countDown();
                                    }
                                }
                            }
                        };
                        StringBuilder sb = new StringBuilder(x.b("032cd[cbcicjchcbck f3cj]bchUchcjUdBckedcj!bchRchcj>d!gb'cdcXdiUe_ci"));
                        String str3 = str2;
                        sb.append(str3);
                        sb.append(x.b("027Phc]eh?dccfciciLedh<edcjNbchEchcj*dMebciQcd3eh*iXcjci@h"));
                        Object objA4 = fVarA.a(sb.toString(), new Class[]{Executor.class, Consumer.class, CancellationSignal.class}, new Object[]{Executors.newSingleThreadExecutor(), consumer, null});
                        try {
                            parcel2 = parcelObtain;
                            try {
                                String str4 = (String) fVarA.a(AppOpsManager.class, (Object) null, x.b("012hBcjfi5ebeKchccDeFciddcb"), new Class[]{Object.class}, new Object[]{consumer}, String.class, (Object) null);
                                if (TextUtils.isEmpty(str4)) {
                                    objArr = objArr2;
                                    parcel = parcelObtain2;
                                } else {
                                    parcel2.writeStrongInterface((IInterface) objA4);
                                    parcel2.writeString(context.getPackageName());
                                    parcel2.writeString(context.getAttributionTag());
                                    parcel2.writeString(str4);
                                    objArr = objArr2;
                                    parcel = parcelObtain2;
                                    r6.transact(((Integer) fVarA.a(x.b("033cdMcbcicjchcbckCfHcj+bch1chcj'd*ckddedcjGbch?chcjWdYgb5cdc2di)e6ci") + str3 + x.b("004Tdk,h cfee"), x.b("030Hebfiecdfdkecdcebddfgdfcgdi1ehGdccfciciUedhOedcjGbch,chcjNd"), null, Integer.TYPE, -1)).intValue(), parcel2, parcel, 0);
                                }
                                r12 = parcel;
                                c = 0;
                                r9 = countDownLatch;
                            } catch (Throwable th) {
                                th = th;
                                countDownLatch = parcelObtain2;
                                r12 = countDownLatch;
                                r12.recycle();
                                parcel2.recycle();
                                cn.fly.tools.a.f.a(context).b(context);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            countDownLatch = parcelObtain2;
                            parcel2 = parcelObtain;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        parcel2 = parcelObtain;
                        countDownLatch = parcelObtain2;
                    }
                } else {
                    countDownLatch = parcelObtain2;
                    parcel2 = parcelObtain;
                    String str5 = str2;
                    parcel2.writeInt(1);
                    fVarA.a(obj.getClass(), obj, x.b("013ZefcichJhe%ebcjfk'c4ci]bef"), new Class[]{Parcel.class, Integer.TYPE}, new Object[]{parcel2, 0}, (Class<?>) null, (Object) null);
                    HashMap map = new HashMap();
                    final int iIdentityHashCode = System.identityHashCode(map);
                    try {
                        map.put(x.b("017'cj7d^edcjGbchPchcj2dVdc3gcdXdiTe^cb"), new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.b.i.2
                            @Override // cn.fly.tools.utils.ReflectHelper.a
                            public Object a(Object[] objArr3) {
                                if (objArr3 != null) {
                                    try {
                                        if (objArr3.length > 0) {
                                            FlyLog.getInstance().d("[212] oncge" + objArr3[0], new Object[0]);
                                            Object obj2 = objArr3[0];
                                            if (!(obj2 instanceof List) || ((List) obj2).size() <= 0) {
                                                objArr2[0] = objArr3[0];
                                            } else {
                                                List list = (List) objArr3[0];
                                                objArr2[0] = list.get(list.size() - 1);
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        try {
                                            FlyLog.getInstance().d(th4);
                                        } finally {
                                            countDownLatch.countDown();
                                        }
                                    }
                                }
                                return null;
                            }
                        });
                        map.put("equals", new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.b.i.3
                            @Override // cn.fly.tools.utils.ReflectHelper.a
                            public Object a(Object[] objArr3) {
                                if (objArr3 != null) {
                                    Object obj2 = objArr3[0];
                                    if (obj2 != null) {
                                        return Boolean.valueOf(obj2.hashCode() == iIdentityHashCode);
                                    }
                                }
                                return Boolean.FALSE;
                            }
                        });
                        map.put(x.b("008gc!eh3gLdccjcb[e"), new ReflectHelper.a<Object[], Object>() { // from class: cn.fly.tools.b.i.4
                            @Override // cn.fly.tools.utils.ReflectHelper.a
                            public Object a(Object[] objArr3) {
                                return Integer.valueOf(iIdentityHashCode);
                            }
                        });
                        objCreateProxy = ReflectHelper.createProxy((Map<String, ReflectHelper.a<Object[], Object>>) map, (Class<?>[]) new Class[]{Class.forName(x.b("033cd1cbcicjchcbck:f!cjWbch2chcjWdVckedcj5bch4chcj$dQedchehShede ci"))});
                    } catch (Throwable th4) {
                        FlyLog.getInstance().d(th4);
                        objCreateProxy = null;
                    }
                    if (DH.SyncMtd.getOSVersionIntForFly() >= 30) {
                        objA2 = fVarA.a(x.b("032cdJcbcicjchcbck-fEcj bchVchcjYd<ckedcj]bch%chcj'd)gbKcdcUdiJe:ci") + str5 + x.b("0258edcjDbch[chcj<dEedchehLhedeRciebci;cd=eh)i*cjci:h"), new Class[]{Class.forName(x.b("032cd[cbcicjchcbckOfXcj7bch0chcj(dPckedcjEbch]chcj!d*gbScdc1di6eFci")), Class.forName(x.b("033cd2cbcicjchcbckJf!cjWbchXchcjDdYckedcj:bchZchcjJd)edchehPhede[ci"))}, new Object[]{DH.SyncMtd.getSystemServiceSafe(x.b("008f>cj)bch7chcj0d")), objCreateProxy});
                        fVarA.a(objA2.getClass(), objA2, x.b("008+ciMePdicheh)he_ci"), new Class[]{Executor.class}, new Object[]{Executors.newSingleThreadExecutor()}, (Class<?>) null, (Object) null);
                    } else {
                        objA2 = fVarA.a(x.b("032cd_cbcicjchcbckUfScjPbch:chcj;d!ckedcjZbch*chcjIdNgbZcdc<diUe>ci") + str5 + x.b("017'edchehLhede8ciebci-cdQeh3iYcjci-h"), new Class[]{Class.forName(x.b("032cdIcbcicjchcbckDf$cj bch^chcjOd1ckedcjRbchJchcj1d;gbVcdc8di-e;ci")), Class.forName(x.b("033cdNcbcicjchcbck,f cj_bchMchcjHd0ckedcj%bchKchcj,dNedchehIhede_ci")), Looper.class}, new Object[]{DH.SyncMtd.getSystemServiceSafe(x.b("008f:cj>bch.chcj d")), objCreateProxy, cn.fly.commons.a.l.a().c()});
                    }
                    parcel2.writeStrongBinder((IBinder) objA2);
                    parcel2.writeInt(0);
                    parcel2.writeString(context.getPackageName());
                    r9 = countDownLatch;
                    objArr = objArr2;
                    r12 = countDownLatch;
                    try {
                        c = 0;
                        r6.transact(((Integer) fVarA.a(x.b("033cd=cbcicjchcbckOfEcjJbch chcjHd.ckddedcjUbchFchcj?dCgbIcdcYdiSe<ci") + str5 + x.b("004+dk4h8cfee"), x.b("0340ebfiecdfdkecdcebddfgdfcgciYeTcdcf7e0ehUh^edcjKbch7chcjZdBdj:i(cb@cheTeh"), null, Integer.TYPE, -1)).intValue(), parcel2, r12, 0);
                        r12 = r12;
                    } catch (Throwable th5) {
                        th = th5;
                        r12.recycle();
                        parcel2.recycle();
                        cn.fly.tools.a.f.a(context).b(context);
                        throw th;
                    }
                }
                r12.readException();
                r9.await(j6, TimeUnit.MILLISECONDS);
                Object obj2 = objArr[c];
                r12.recycle();
                parcel2.recycle();
                cn.fly.tools.a.f.a(context).b(context);
                return obj2;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            parcel2 = parcelObtain;
            r12 = parcelObtain2;
        }
    }
}
