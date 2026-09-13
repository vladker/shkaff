package A1;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface g extends i {
    @Override // A1.i
    /* synthetic */ Point convertMapToOffset(Map map);

    @Override // A1.i
    /* synthetic */ int getColor(String str);

    @Override // A1.i
    /* synthetic */ Map getMap();

    @Override // A1.i
    /* synthetic */ Point getOffset(String str);

    Paint getPaint();

    @Override // A1.i
    /* synthetic */ Rect getRect(String str);
}
