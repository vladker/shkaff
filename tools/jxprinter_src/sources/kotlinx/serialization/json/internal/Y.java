package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import p089p4.C1521f;
import p147z3.AbstractC1922b;
import p147z3.C1921a;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5734a;
    public final boolean b;
    public int c;
    private final AbstractC1126b lexer;

    public Y(p089p4.j configuration, AbstractC1126b lexer) {
        kotlin.jvm.internal.E.f(configuration, "configuration");
        kotlin.jvm.internal.E.f(lexer, "lexer");
        this.lexer = lexer;
        this.f5734a = configuration.c;
        this.b = configuration.f7765l;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    /* JADX WARN: Code duplicated, block: B:22:0x006a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0089  */
    /* JADX WARN: Code duplicated, block: B:29:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0089 -> B:27:0x008e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object b(kotlinx.serialization.json.internal.Y r12, p147z3.AbstractC1923c r13, G3.a r14) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.Y.b(kotlinx.serialization.json.internal.Y, z3.c, G3.a):java.lang.Object");
    }

    public final C1521f c() {
        byte bF = this.lexer.f();
        if (this.lexer.q() == 4) {
            throw AbstractC1125a.k(this.lexer, "Unexpected leading comma", 0, null, 6);
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.d()) {
            arrayList.add(read());
            bF = this.lexer.f();
            if (bF != 4) {
                AbstractC1126b abstractC1126b = this.lexer;
                boolean z6 = bF == 9;
                int i5 = abstractC1126b.currentPosition;
                if (!z6) {
                    throw AbstractC1125a.k(abstractC1126b, "Expected end of the array or comma", i5, null, 4);
                }
            }
        }
        if (bF == 8) {
            this.lexer.g((byte) 9);
        } else if (bF == 4) {
            if (!this.b) {
                E.invalidTrailingComma(this.lexer, "array");
                throw new C1929i();
            }
            this.lexer.g((byte) 9);
        }
        return new C1521f(arrayList);
    }

    public final p089p4.E d(boolean z6) {
        String strConsumeStringLenient = (this.f5734a || !z6) ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
        return (z6 || !kotlin.jvm.internal.E.a(strConsumeStringLenient, AbstractC1127c.NULL)) ? new p089p4.s(strConsumeStringLenient, z6, null) : p089p4.x.INSTANCE;
    }

    public final p089p4.m read() {
        p089p4.m a6;
        byte bQ = this.lexer.q();
        if (bQ == 1) {
            return d(true);
        }
        if (bQ == 0) {
            return d(false);
        }
        if (bQ != 6) {
            if (bQ == 8) {
                return c();
            }
            throw AbstractC1125a.k(this.lexer, "Cannot read Json element because of unexpected " + AbstractC1127c.tokenDescription(bQ), 0, null, 6);
        }
        int i5 = this.c + 1;
        this.c = i5;
        if (i5 == 200) {
            a6 = (p089p4.m) AbstractC1922b.invoke(new C1921a(new W(this, null)), p147z3.Q.INSTANCE);
        } else {
            byte bG = this.lexer.g((byte) 6);
            if (this.lexer.q() == 4) {
                throw AbstractC1125a.k(this.lexer, "Unexpected leading comma", 0, null, 6);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (this.lexer.d()) {
                String strConsumeStringLenient = this.f5734a ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
                this.lexer.g((byte) 5);
                linkedHashMap.put(strConsumeStringLenient, read());
                bG = this.lexer.f();
                if (bG != 4) {
                    if (bG == 7) {
                        break;
                    }
                    throw AbstractC1125a.k(this.lexer, "Expected end of the object or comma", 0, null, 6);
                }
            }
            if (bG == 6) {
                this.lexer.g((byte) 7);
            } else if (bG == 4) {
                if (!this.b) {
                    E.invalidTrailingComma(this.lexer, "object");
                    throw new C1929i();
                }
                this.lexer.g((byte) 7);
            }
            a6 = new p089p4.A(linkedHashMap);
        }
        this.c--;
        return a6;
    }
}
