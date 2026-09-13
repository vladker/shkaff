package org.apache.poi.sl.draw;

import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class m implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7183a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m(Object obj, int i5) {
        this.f7183a = i5;
        this.b = obj;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7183a) {
            case 0:
                DrawTextParagraph.lambda$getAttributedString$1((ArrayList) this.b, (AttributedCharacterIterator.Attribute) obj, obj2);
                break;
            default:
                ((AttributedString) this.b).addAttribute((TextAttribute) obj, obj2);
                break;
        }
    }
}
