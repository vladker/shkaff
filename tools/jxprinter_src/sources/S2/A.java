package S2;

import android.content.ContentResolver;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.H0;
import p007a4.K0;
import p007a4.M;
import p023d4.AbstractC0618q;
import p023d4.V1;
import p023d4.p2;
import p023d4.q2;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A implements FlutterPlugin, MethodChannel.MethodCallHandler, h, M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MethodChannel f634a;
    private ContentResolver contentResolver;
    private final E3.q coroutineContext = K0.m927Job((H0) null).plus(C0276f0.getMain());
    private final U2.e activeRequests = new U2.e();
    private final V1 concurrentReadOperationCounterFlow = q2.MutableStateFlow(0);

    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b7 A[Catch: all -> 0x006e, Exception -> 0x0073, TRY_LEAVE, TryCatch #5 {Exception -> 0x0073, blocks: (B:21:0x0069, B:70:0x01af, B:72:0x01b7, B:80:0x01f9, B:84:0x022a, B:86:0x022e, B:91:0x025c, B:93:0x0263, B:96:0x0286, B:39:0x00e7), top: B:124:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f9 A[Catch: all -> 0x006e, Exception -> 0x0073, TRY_ENTER, TryCatch #5 {Exception -> 0x0073, blocks: (B:21:0x0069, B:70:0x01af, B:72:0x01b7, B:80:0x01f9, B:84:0x022a, B:86:0x022e, B:91:0x025c, B:93:0x0263, B:96:0x0286, B:39:0x00e7), top: B:124:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0220  */
    /* JADX WARN: Code duplicated, block: B:83:0x0222  */
    /* JADX WARN: Code duplicated, block: B:86:0x022e A[Catch: all -> 0x006e, Exception -> 0x0073, TryCatch #5 {Exception -> 0x0073, blocks: (B:21:0x0069, B:70:0x01af, B:72:0x01b7, B:80:0x01f9, B:84:0x022a, B:86:0x022e, B:91:0x025c, B:93:0x0263, B:96:0x0286, B:39:0x00e7), top: B:124:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x024f  */
    /* JADX WARN: Code duplicated, block: B:91:0x025c A[Catch: all -> 0x006e, Exception -> 0x0073, TryCatch #5 {Exception -> 0x0073, blocks: (B:21:0x0069, B:70:0x01af, B:72:0x01b7, B:80:0x01f9, B:84:0x022a, B:86:0x022e, B:91:0x025c, B:93:0x0263, B:96:0x0286, B:39:0x00e7), top: B:124:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0263 A[Catch: all -> 0x006e, Exception -> 0x0073, TryCatch #5 {Exception -> 0x0073, blocks: (B:21:0x0069, B:70:0x01af, B:72:0x01b7, B:80:0x01f9, B:84:0x022a, B:86:0x022e, B:91:0x025c, B:93:0x0263, B:96:0x0286, B:39:0x00e7), top: B:124:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0284  */
    /* JADX WARN: Code duplicated, block: B:96:0x0286 A[Catch: all -> 0x006e, Exception -> 0x0073, TRY_LEAVE, TryCatch #5 {Exception -> 0x0073, blocks: (B:21:0x0069, B:70:0x01af, B:72:0x01b7, B:80:0x01f9, B:84:0x022a, B:86:0x022e, B:91:0x025c, B:93:0x0263, B:96:0x0286, B:39:0x00e7), top: B:124:0x0028 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [U2.e] */
    /* JADX WARN: Type inference failed for: r0v33, types: [U2.e] */
    /* JADX WARN: Type inference failed for: r0v35, types: [U2.e] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2, types: [S2.A, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v24, types: [S2.A, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v25, types: [S2.A, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v3, types: [S2.A] */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r1v0, types: [S2.A] */
    /* JADX WARN: Type inference failed for: r1v18, types: [long] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v22, types: [long] */
    /* JADX WARN: Type inference failed for: r1v23, types: [long] */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [long] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v14, types: [long] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r3v0, types: [U2.e] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v18, types: [U2.e] */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v6, types: [S2.A] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0251 -> B:90:0x0254). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object c(S2.A r17, java.lang.String r18, long r19, long r21, G3.d r23) {
        /*
            Method dump skipped, instruction units count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.A.c(S2.A, java.lang.String, long, long, G3.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(A a6, long j6, G3.d dVar) throws Throwable {
        z zVar;
        if (dVar instanceof z) {
            zVar = (z) dVar;
            int i5 = zVar.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                zVar.e = i5 - Integer.MIN_VALUE;
            } else {
                zVar = new z(a6, dVar);
            }
        } else {
            zVar = new z(a6, dVar);
        }
        Object obj = zVar.c;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = zVar.e;
        if (i6 == 0) {
            p147z3.v.throwOnFailure(obj);
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j7 = zVar.b;
            A a7 = zVar.f666a;
            p147z3.v.throwOnFailure(obj);
            a6 = a7;
            j6 = j7;
        }
        while (((Number) ((p2) a6.concurrentReadOperationCounterFlow).getValue()).intValue() > 1 && Runtime.getRuntime().freeMemory() < ((long) 4) * j6) {
            y yVar = new y(a6.concurrentReadOperationCounterFlow, ((Number) ((p2) a6.concurrentReadOperationCounterFlow).getValue()).intValue());
            zVar.f666a = a6;
            zVar.b = j6;
            zVar.e = 1;
            if (AbstractC0618q.first(yVar, zVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Q.INSTANCE;
    }

    @Override // S2.h
    public void exists(String url, O3.l callback) {
        E.f(url, "url");
        E.f(callback, "callback");
        AbstractC0272e.b(this, null, 3, new p(this, url, callback, (E3.g) null, 0));
    }

    @Override // S2.h
    public void getContentLength(String url, O3.l callback) {
        E.f(url, "url");
        E.f(callback, "callback");
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver == null) {
            callback.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("ContentResolver is null")))));
        } else {
            AbstractC0272e.b(this, null, 3, new r(url, contentResolver, callback, null, 0));
        }
    }

    @Override // p007a4.M
    public E3.q getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        E.f(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "uri_content");
        this.f634a = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.contentResolver = flutterPluginBinding.getApplicationContext().getContentResolver();
        g gVar = h.Companion;
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        E.e(binaryMessenger, "getBinaryMessenger(...)");
        gVar.setUp(binaryMessenger, this, "");
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        E.f(binding, "binding");
        MethodChannel methodChannel = this.f634a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        } else {
            E.m("channel");
            throw null;
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        E.f(call, "call");
        E.f(result, "result");
    }

    @Override // S2.h
    public void registerRequest(String url, long j6, long j7, O3.l callback) {
        E.f(url, "url");
        E.f(callback, "callback");
        AbstractC0272e.b(this, null, 3, new u(this, j6, j7, callback, url, null));
    }

    @Override // S2.h
    public void requestNextChunk(long j6, O3.l callback) {
        E.f(callback, "callback");
        AbstractC0272e.b(this, null, 3, new v(this, j6, callback, null));
    }
}
