package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import p147z3.AbstractC1923c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class X extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC1923c f5731a;
    public Y b;
    public LinkedHashMap c;
    public String d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Y f5732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5733g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(Y y6, G3.a aVar) {
        super(aVar);
        this.f5732f = y6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f5733g |= Integer.MIN_VALUE;
        return Y.b(this.f5732f, null, this);
    }
}
