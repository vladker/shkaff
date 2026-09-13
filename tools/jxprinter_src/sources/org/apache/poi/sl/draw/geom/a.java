package org.apache.poi.sl.draw.geom;

import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7178a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f7178a = i5;
        this.b = obj;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7178a) {
            case 0:
                PresetParser.lambda$updateGuideList$0((Guide) this.b, (String) obj, (String) obj2);
                break;
            case 1:
                PresetParser.lambda$arcTo$5((ArcToCommand) this.b, (String) obj, (String) obj2);
                break;
            case 2:
                PresetParser.lambda$addPolar$2((PolarAdjustHandle) this.b, (String) obj, (String) obj2);
                break;
            case 3:
                PresetParser.lambda$parseAdjPoint$7((AdjustPoint) this.b, (String) obj, (String) obj2);
                break;
            case 4:
                PresetParser.lambda$addRectangle$6((String[]) this.b, (String) obj, (String) obj2);
                break;
            case 5:
                PresetParser.lambda$updateCxnList$3((ConnectionSite) this.b, (String) obj, (String) obj2);
                break;
            case 6:
                PresetParser.lambda$addXY$1((XYAdjustHandle) this.b, (String) obj, (String) obj2);
                break;
            default:
                ((PresetParser) this.b).lambda$updatePathLst$4((String) obj, (String) obj2);
                break;
        }
    }
}
