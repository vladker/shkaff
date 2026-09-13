package com.idlefish.flutterboost.containers;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.tool.CodeGenUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3555a;
    public final /* synthetic */ StringBuilder b;

    public /* synthetic */ a(StringBuilder sb, int i5) {
        this.f3555a = i5;
        this.b = sb;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f3555a) {
            case 0:
                FlutterContainerManager.lambda$toString$0(this.b, (FlutterViewContainer) obj);
                break;
            case 1:
                this.b.append((String) obj);
                break;
            default:
                CodeGenUtil.lambda$null$1(this.b, (String) obj);
                break;
        }
    }
}
