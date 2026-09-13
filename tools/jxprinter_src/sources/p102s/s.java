package p102s;

import O3.l;
import android.graphics.Rect;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.google.mlkit.vision.text.Text;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f8180a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public /* synthetic */ s(l lVar, int i5, int i6, long j6, long j7) {
        this.f8180a = lVar;
        this.b = i5;
        this.c = i6;
        this.d = j6;
        this.e = j7;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        Text visionText = (Text) obj;
        E.f(visionText, "visionText");
        ArrayList arrayList = new ArrayList();
        Iterator<Text.TextBlock> it = visionText.getTextBlocks().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            l lVar = this.f8180a;
            if (!zHasNext) {
                lVar.invoke(u.a(u.m1361constructorimpl(arrayList)));
                return Q.INSTANCE;
            }
            Text.TextBlock next = it.next();
            ElementAttributeTextBean elementAttributeTextBean = new ElementAttributeTextBean();
            Rect boundingBox = next.getBoundingBox();
            int size = next.getLines().size();
            if (boundingBox == null) {
                lVar.invoke(u.a(u.m1361constructorimpl(v.createFailure(new Exception("rect is null")))));
            } else {
                elementAttributeTextBean.setElementType(5);
                float f6 = this.b;
                float f7 = this.c;
                float f8 = f6 / f7;
                float f9 = this.d;
                float f10 = this.e;
                if (f8 > f9 / f10) {
                    elementAttributeTextBean.setX((boundingBox.left / f6) * f9);
                    elementAttributeTextBean.setY((((boundingBox.top / f7) * f9) * f7) / f6);
                    elementAttributeTextBean.setWidth((boundingBox.width() / f6) * f9);
                    elementAttributeTextBean.setHeight((((boundingBox.height() / f7) * f9) * f7) / f6);
                } else {
                    elementAttributeTextBean.setX((((boundingBox.left / f6) * f10) * f6) / f7);
                    elementAttributeTextBean.setY((boundingBox.top / f7) * f10);
                    elementAttributeTextBean.setWidth((((boundingBox.width() / f6) * f10) * f6) / f7);
                    elementAttributeTextBean.setHeight((boundingBox.height() / f7) * f10);
                }
                elementAttributeTextBean.setInputDataType(0);
                elementAttributeTextBean.setContent(next.getText());
                elementAttributeTextBean.setTextSize((elementAttributeTextBean.getHeight() / size) * 9);
                String json = elementAttributeTextBean.toJson();
                E.e(json, "toJson(...)");
                arrayList.add(json);
            }
        }
    }
}
