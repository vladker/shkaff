package kotlinx.serialization.json.internal;

import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;
import p084o4.AbstractC1299b;
import p089p4.AbstractC1519d;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class d0 extends p078n4.a implements p089p4.k, p078n4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5735a;
    private final p089p4.j configuration;
    private a discriminatorHolder;
    private final B elementMarker;
    private final AbstractC1519d json;
    public final AbstractC1126b lexer;
    private final m0 mode;
    private final p095q4.g serializersModule;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a {
        public String discriminatorToSkip;

        public a(String str) {
            this.discriminatorToSkip = str;
        }
    }

    public d0(AbstractC1519d json, m0 mode, AbstractC1126b lexer, p072m4.r descriptor, a aVar) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(mode, "mode");
        kotlin.jvm.internal.E.f(lexer, "lexer");
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        this.json = json;
        this.mode = mode;
        this.lexer = lexer;
        this.serializersModule = json.getSerializersModule();
        this.f5735a = -1;
        this.discriminatorHolder = aVar;
        p089p4.j configuration = json.getConfiguration();
        this.configuration = configuration;
        this.elementMarker = configuration.f7759f ? null : new B(descriptor);
    }

    @Override // p078n4.a, p078n4.j
    public final double a() {
        AbstractC1126b abstractC1126b = this.lexer;
        String strConsumeStringLenient = abstractC1126b.consumeStringLenient();
        try {
            double d = Double.parseDouble(strConsumeStringLenient);
            if (this.json.getConfiguration().f7762i || !(Double.isInfinite(d) || Double.isNaN(d))) {
                return d;
            }
            E.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(d));
            throw new C1929i();
        } catch (IllegalArgumentException unused) {
            throw AbstractC1125a.k(abstractC1126b, "Failed to parse type 'double' for input '" + strConsumeStringLenient + Chars.QUOTE, 0, null, 6);
        }
    }

    @Override // p078n4.a, p078n4.j
    public final byte b() {
        long jI = this.lexer.i();
        byte b = (byte) jI;
        if (jI == b) {
            return b;
        }
        throw AbstractC1125a.k(this.lexer, "Failed to parse byte for input '" + jI + Chars.QUOTE, 0, null, 6);
    }

    @Override // p078n4.a, p078n4.j, p089p4.k
    public p078n4.f beginStructure(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        m0 m0VarSwitchMode = n0.switchMode(this.json, descriptor);
        this.lexer.path.pushDescriptor(descriptor);
        this.lexer.h(m0VarSwitchMode.begin);
        if (this.lexer.q() == 4) {
            throw AbstractC1125a.k(this.lexer, "Unexpected leading comma", 0, null, 6);
        }
        int iOrdinal = m0VarSwitchMode.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
            return new d0(this.json, m0VarSwitchMode, this.lexer, descriptor, this.discriminatorHolder);
        }
        return (this.mode == m0VarSwitchMode && this.json.getConfiguration().f7759f) ? this : new d0(this.json, m0VarSwitchMode, this.lexer, descriptor, this.discriminatorHolder);
    }

    @Override // p078n4.a, p078n4.j
    public final long c() {
        return this.lexer.i();
    }

    @Override // p078n4.a, p078n4.j
    public final short d() {
        long jI = this.lexer.i();
        short s6 = (short) jI;
        if (jI == s6) {
            return s6;
        }
        throw AbstractC1125a.k(this.lexer, "Failed to parse short for input '" + jI + Chars.QUOTE, 0, null, 6);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x01b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x0221  */
    /* JADX WARN: Code duplicated, block: B:169:0x01b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x01af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x01ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0231 A[EDGE_INSN: B:172:0x0231->B:139:0x0231 BREAK  A[LOOP:1: B:109:0x01a3->B:174:0x01a3], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:? A[SYNTHETIC] */
    @Override // p078n4.a, p078n4.f, p089p4.k
    public int decodeElementIndex(p072m4.r descriptor) {
        boolean zT;
        boolean z6;
        AbstractC1126b abstractC1126b;
        boolean z7;
        ArrayList arrayList;
        byte bQ;
        byte bQ2;
        String strPeekString;
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        int iOrdinal = this.mode.ordinal();
        boolean zT2 = false;
        int iB = -1;
        if (iOrdinal == 0) {
            boolean zT3 = this.lexer.t();
            while (true) {
                if (this.lexer.d()) {
                    String strConsumeStringLenientNotNull = this.configuration.c ? this.lexer.consumeStringLenientNotNull() : this.lexer.consumeKeyString();
                    this.lexer.h(NameUtil.COLON);
                    int jsonNameIndex = I.getJsonNameIndex(descriptor, this.json, strConsumeStringLenientNotNull);
                    if (jsonNameIndex != -3) {
                        if (this.configuration.f7760g) {
                            AbstractC1519d abstractC1519d = this.json;
                            boolean zIsElementOptional = descriptor.isElementOptional(jsonNameIndex);
                            p072m4.r elementDescriptor = descriptor.getElementDescriptor(jsonNameIndex);
                            if (!zIsElementOptional || elementDescriptor.a() || !this.lexer.u(true)) {
                                if (kotlin.jvm.internal.E.a(elementDescriptor.getKind(), p072m4.y.INSTANCE) && ((!elementDescriptor.a() || !this.lexer.u(false)) && (strPeekString = this.lexer.peekString(this.configuration.c)) != null)) {
                                    int jsonNameIndex2 = I.getJsonNameIndex(elementDescriptor, abstractC1519d, strPeekString);
                                    boolean z8 = !abstractC1519d.getConfiguration().f7759f && elementDescriptor.a();
                                    if (jsonNameIndex2 == -3 && (zIsElementOptional || z8)) {
                                        this.lexer.consumeString();
                                    }
                                }
                            }
                            zT = this.lexer.t();
                            z6 = false;
                        }
                        B b = this.elementMarker;
                        if (b != null) {
                            b.a(jsonNameIndex);
                        }
                        iB = jsonNameIndex;
                    } else {
                        zT = false;
                        z6 = true;
                    }
                    if (z6) {
                        if (this.configuration.b) {
                            abstractC1126b = this.lexer;
                            z7 = this.configuration.c;
                            abstractC1126b.getClass();
                            arrayList = new ArrayList();
                            bQ = abstractC1126b.q();
                            if (bQ != 8 || bQ == 6) {
                                while (true) {
                                    bQ2 = abstractC1126b.q();
                                    if (bQ2 != 1) {
                                        if (bQ2 != 8 || bQ2 == 6) {
                                            arrayList.add(Byte.valueOf(bQ2));
                                        } else if (bQ2 == 9) {
                                            if (((Number) A3.T.last((List) arrayList)).byteValue() != 8) {
                                                throw E.JsonDecodingException(abstractC1126b.currentPosition, "found ] instead of } at path: " + abstractC1126b.path, abstractC1126b.getSource());
                                            }
                                            A3.O.removeLast(arrayList);
                                        } else if (bQ2 == 7) {
                                            if (((Number) A3.T.last((List) arrayList)).byteValue() != 6) {
                                                throw E.JsonDecodingException(abstractC1126b.currentPosition, "found } instead of ] at path: " + abstractC1126b.path, abstractC1126b.getSource());
                                            }
                                            A3.O.removeLast(arrayList);
                                        } else if (bQ2 == 10) {
                                            throw AbstractC1125a.k(abstractC1126b, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
                                        }
                                        abstractC1126b.f();
                                        if (arrayList.size() == 0) {
                                            break;
                                        }
                                    } else if (z7) {
                                        abstractC1126b.consumeStringLenient();
                                    } else {
                                        abstractC1126b.consumeKeyString();
                                    }
                                }
                            } else {
                                abstractC1126b.consumeStringLenient();
                            }
                        } else {
                            a aVar = this.discriminatorHolder;
                            if (aVar != null && kotlin.jvm.internal.E.a(aVar.discriminatorToSkip, strConsumeStringLenientNotNull)) {
                                aVar.discriminatorToSkip = null;
                                abstractC1126b = this.lexer;
                                z7 = this.configuration.c;
                                abstractC1126b.getClass();
                                arrayList = new ArrayList();
                                bQ = abstractC1126b.q();
                                if (bQ != 8) {
                                    while (true) {
                                        bQ2 = abstractC1126b.q();
                                        if (bQ2 != 1) {
                                            if (bQ2 != 8) {
                                                arrayList.add(Byte.valueOf(bQ2));
                                            } else {
                                                arrayList.add(Byte.valueOf(bQ2));
                                            }
                                            abstractC1126b.f();
                                            if (arrayList.size() == 0) {
                                                break;
                                                break;
                                            }
                                        } else if (z7) {
                                            abstractC1126b.consumeStringLenient();
                                        } else {
                                            abstractC1126b.consumeKeyString();
                                        }
                                    }
                                } else {
                                    while (true) {
                                        bQ2 = abstractC1126b.q();
                                        if (bQ2 != 1) {
                                            if (bQ2 != 8) {
                                                arrayList.add(Byte.valueOf(bQ2));
                                            } else {
                                                arrayList.add(Byte.valueOf(bQ2));
                                            }
                                            abstractC1126b.f();
                                            if (arrayList.size() == 0) {
                                                break;
                                                break;
                                            }
                                        } else if (z7) {
                                            abstractC1126b.consumeStringLenient();
                                        } else {
                                            abstractC1126b.consumeKeyString();
                                        }
                                    }
                                }
                            } else {
                                this.lexer.failOnUnknownKey(strConsumeStringLenientNotNull);
                            }
                        }
                        zT3 = this.lexer.t();
                    } else {
                        zT3 = zT;
                    }
                } else {
                    if (zT3 && !this.json.getConfiguration().f7765l) {
                        E.invalidTrailingComma(this.lexer, "object");
                        throw new C1929i();
                    }
                    B b6 = this.elementMarker;
                    if (b6 != null) {
                        iB = b6.b();
                    }
                }
            }
        } else if (iOrdinal != 2) {
            boolean zT4 = this.lexer.t();
            if (this.lexer.d()) {
                int i5 = this.f5735a;
                if (i5 != -1 && !zT4) {
                    throw AbstractC1125a.k(this.lexer, "Expected end of the array or comma", 0, null, 6);
                }
                iB = i5 + 1;
                this.f5735a = iB;
            } else if (zT4 && !this.json.getConfiguration().f7765l) {
                E.invalidTrailingComma(this.lexer, "array");
                throw new C1929i();
            }
        } else {
            int i6 = this.f5735a;
            boolean z9 = i6 % 2 != 0;
            if (!z9) {
                this.lexer.h(NameUtil.COLON);
            } else if (i6 != -1) {
                zT2 = this.lexer.t();
            }
            if (this.lexer.d()) {
                if (z9) {
                    if (this.f5735a == -1) {
                        AbstractC1126b abstractC1126b2 = this.lexer;
                        int i7 = abstractC1126b2.currentPosition;
                        if (zT2) {
                            throw AbstractC1125a.k(abstractC1126b2, "Unexpected leading comma", i7, null, 4);
                        }
                    } else {
                        AbstractC1126b abstractC1126b3 = this.lexer;
                        int i8 = abstractC1126b3.currentPosition;
                        if (!zT2) {
                            throw AbstractC1125a.k(abstractC1126b3, "Expected comma after the key-value pair", i8, null, 4);
                        }
                    }
                }
                iB = this.f5735a + 1;
                this.f5735a = iB;
            } else if (zT2 && !this.json.getConfiguration().f7765l) {
                E.invalidTrailingComma(this.lexer, "object");
                throw new C1929i();
            }
        }
        if (this.mode != m0.MAP) {
            this.lexer.path.c(iB);
        }
        return iB;
    }

    @Override // p078n4.a, p078n4.j, p089p4.k
    public int decodeEnum(p072m4.r enumDescriptor) {
        kotlin.jvm.internal.E.f(enumDescriptor, "enumDescriptor");
        return I.getJsonNameIndexOrThrow(enumDescriptor, this.json, decodeString(), " at path " + this.lexer.path.getPath());
    }

    @Override // p078n4.a, p078n4.j, p089p4.k
    public p078n4.j decodeInline(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return f0.isUnsignedNumber(descriptor) ? new C1148y(this.lexer, this.json) : super.decodeInline(descriptor);
    }

    @Override // p089p4.k
    public p089p4.m decodeJsonElement() {
        return new Y(this.json.getConfiguration(), this.lexer).read();
    }

    @Override // p078n4.a, p078n4.j, p089p4.k
    public final boolean decodeNotNullMark() {
        B b = this.elementMarker;
        return ((b != null ? b.f5725a : false) || this.lexer.u(true)) ? false : true;
    }

    @Override // p078n4.a, p078n4.j, p089p4.k
    public Void decodeNull() {
        return null;
    }

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
    @Override // p078n4.a, p078n4.f, p089p4.k
    public <T> T decodeSerializableElement(p072m4.r descriptor, int i5, p060k4.a deserializer, T t6) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        boolean z6 = this.mode == m0.MAP && (i5 & 1) == 0;
        if (z6) {
            this.lexer.path.b();
        }
        T t7 = (T) super.decodeSerializableElement(descriptor, i5, deserializer, t6);
        if (z6) {
            this.lexer.path.updateCurrentMapKey(t7);
        }
        return t7;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x014c  */
    /* JADX WARN: Code duplicated, block: B:47:0x014d  */
    /* JADX WARN: Instruction removed from duplicated block: B:47:0x014d, please report this as an issue */
    @Override // p078n4.a, p078n4.j, p089p4.k
    public <T> T decodeSerializableValue(p060k4.a deserializer) {
        String message;
        p089p4.E jsonPrimitive;
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        try {
            if ((deserializer instanceof AbstractC1299b) && !this.json.getConfiguration().f7761h) {
                String strClassDiscriminator = Z.classDiscriminator(((AbstractC1299b) deserializer).getDescriptor(), this.json);
                String strPeekLeadingMatchingValue = this.lexer.peekLeadingMatchingValue(strClassDiscriminator, this.configuration.c);
                if (strPeekLeadingMatchingValue != null) {
                    try {
                        p060k4.a aVarFindPolymorphicSerializer = p060k4.f.findPolymorphicSerializer((AbstractC1299b) deserializer, this, strPeekLeadingMatchingValue);
                        kotlin.jvm.internal.E.d(aVarFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
                        this.discriminatorHolder = new a(strClassDiscriminator);
                        return (T) aVarFindPolymorphicSerializer.deserialize(this);
                    } catch (p060k4.l e) {
                        String message2 = e.getMessage();
                        kotlin.jvm.internal.E.c(message2);
                        String strRemoveSuffix = X3.b0.removeSuffix(X3.b0.substringBefore(message2, '\n', message2), (CharSequence) Consts.DOT);
                        String message3 = e.getMessage();
                        kotlin.jvm.internal.E.c(message3);
                        AbstractC1126b.n(this.lexer, strRemoveSuffix, 0, X3.b0.substringAfter(message3, '\n', ""), 2);
                        throw new C1929i();
                    }
                }
                if ((deserializer instanceof AbstractC1299b) && !getJson().getConfiguration().f7761h) {
                    String strClassDiscriminator2 = Z.classDiscriminator(((AbstractC1299b) deserializer).getDescriptor(), getJson());
                    p089p4.m mVarDecodeJsonElement = decodeJsonElement();
                    String serialName = ((AbstractC1299b) deserializer).getDescriptor().getSerialName();
                    if (mVarDecodeJsonElement instanceof p089p4.A) {
                        p089p4.A a6 = (p089p4.A) mVarDecodeJsonElement;
                        p089p4.m mVar = (p089p4.m) a6.get((Object) strClassDiscriminator2);
                        try {
                            p060k4.a aVarFindPolymorphicSerializer2 = p060k4.f.findPolymorphicSerializer((AbstractC1299b) deserializer, this, (mVar == null || (jsonPrimitive = p089p4.n.getJsonPrimitive(mVar)) == null) ? null : p089p4.n.getContentOrNull(jsonPrimitive));
                            kotlin.jvm.internal.E.d(aVarFindPolymorphicSerializer2, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                            return (T) k0.readPolymorphicJson(getJson(), strClassDiscriminator2, a6, aVarFindPolymorphicSerializer2);
                        } catch (p060k4.l e6) {
                            String message4 = e6.getMessage();
                            kotlin.jvm.internal.E.c(message4);
                            throw E.JsonDecodingException(-1, message4, a6.toString());
                        }
                    }
                    throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.A.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + this.lexer.path.getPath(), mVarDecodeJsonElement.toString());
                }
                return (T) deserializer.deserialize(this);
                message = e.getMessage();
                kotlin.jvm.internal.E.c(message);
                if (X3.b0.contains((CharSequence) message, (CharSequence) "at path", false)) {
                    throw e;
                }
                throw new p060k4.c(e.getMissingFields(), e.getMessage() + " at path: " + this.lexer.path.getPath(), e);
            }
            return (T) deserializer.deserialize(this);
        } catch (p060k4.c e7) {
            message = e7.getMessage();
            kotlin.jvm.internal.E.c(message);
            if (X3.b0.contains((CharSequence) message, (CharSequence) "at path", false)) {
                throw e7;
            }
            throw new p060k4.c(e7.getMissingFields(), e7.getMessage() + " at path: " + this.lexer.path.getPath(), e7);
        }
    }

    @Override // p078n4.a, p078n4.j, p089p4.k
    public String decodeString() {
        return this.configuration.c ? this.lexer.consumeStringLenientNotNull() : this.lexer.consumeString();
    }

    @Override // p078n4.c
    public void decodeStringChunked(O3.l consumeChunk) {
        kotlin.jvm.internal.E.f(consumeChunk, "consumeChunk");
        this.lexer.consumeStringChunked(this.configuration.c, consumeChunk);
    }

    @Override // p078n4.a, p078n4.j
    public final char e() {
        String strConsumeStringLenient = this.lexer.consumeStringLenient();
        if (strConsumeStringLenient.length() == 1) {
            return strConsumeStringLenient.charAt(0);
        }
        throw AbstractC1125a.k(this.lexer, "Expected single char, but got '" + strConsumeStringLenient + Chars.QUOTE, 0, null, 6);
    }

    @Override // p078n4.a, p078n4.f, p089p4.k
    public void endStructure(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        if (this.json.getConfiguration().b && descriptor.b() == 0) {
            while (decodeElementIndex(descriptor) != -1) {
            }
        }
        if (this.lexer.t() && !this.json.getConfiguration().f7765l) {
            E.invalidTrailingComma(this.lexer, "");
            throw new C1929i();
        }
        this.lexer.h(this.mode.end);
        this.lexer.path.a();
    }

    @Override // p078n4.a, p078n4.j
    public final int f() {
        long jI = this.lexer.i();
        int i5 = (int) jI;
        if (jI == i5) {
            return i5;
        }
        throw AbstractC1125a.k(this.lexer, "Failed to parse int for input '" + jI + Chars.QUOTE, 0, null, 6);
    }

    @Override // p078n4.a, p078n4.j
    public final float g() {
        AbstractC1126b abstractC1126b = this.lexer;
        String strConsumeStringLenient = abstractC1126b.consumeStringLenient();
        try {
            float f6 = Float.parseFloat(strConsumeStringLenient);
            if (this.json.getConfiguration().f7762i || !(Float.isInfinite(f6) || Float.isNaN(f6))) {
                return f6;
            }
            E.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(f6));
            throw new C1929i();
        } catch (IllegalArgumentException unused) {
            throw AbstractC1125a.k(abstractC1126b, "Failed to parse type 'float' for input '" + strConsumeStringLenient + Chars.QUOTE, 0, null, 6);
        }
    }

    @Override // p089p4.k
    public final AbstractC1519d getJson() {
        return this.json;
    }

    @Override // p078n4.a, p078n4.j, p078n4.f, p089p4.k
    public p095q4.g getSerializersModule() {
        return this.serializersModule;
    }

    @Override // p078n4.a, p078n4.j
    public final boolean h() {
        boolean z6;
        boolean z7;
        AbstractC1126b abstractC1126b = this.lexer;
        int iS = abstractC1126b.s();
        if (iS == abstractC1126b.getSource().length()) {
            throw AbstractC1125a.k(abstractC1126b, "EOF", 0, null, 6);
        }
        if (abstractC1126b.getSource().charAt(iS) == '\"') {
            iS++;
            z6 = true;
        } else {
            z6 = false;
        }
        int iR = abstractC1126b.r(iS);
        if (iR >= abstractC1126b.getSource().length() || iR == -1) {
            throw AbstractC1125a.k(abstractC1126b, "EOF", 0, null, 6);
        }
        int i5 = iR + 1;
        int iCharAt = abstractC1126b.getSource().charAt(iR) | Chars.SPACE;
        if (iCharAt == 102) {
            abstractC1126b.e(i5, "alse");
            z7 = false;
        } else {
            if (iCharAt != 116) {
                throw AbstractC1125a.k(abstractC1126b, "Expected valid boolean literal prefix, but had '" + abstractC1126b.consumeStringLenient() + Chars.QUOTE, 0, null, 6);
            }
            abstractC1126b.e(i5, "rue");
            z7 = true;
        }
        if (!z6) {
            return z7;
        }
        if (abstractC1126b.currentPosition == abstractC1126b.getSource().length()) {
            throw AbstractC1125a.k(abstractC1126b, "EOF", 0, null, 6);
        }
        if (abstractC1126b.getSource().charAt(abstractC1126b.currentPosition) != '\"') {
            throw AbstractC1125a.k(abstractC1126b, "Expected closing quotation mark", 0, null, 6);
        }
        abstractC1126b.currentPosition++;
        return z7;
    }
}
