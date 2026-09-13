package E4;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.nio.file.Path;
import java.util.function.Function;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
import org.apache.poi.hssf.record.cf.Threshold;
import org.apache.poi.hssf.record.common.ExtendedColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f233a;

    public /* synthetic */ b(int i5) {
        this.f233a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f233a) {
            case 0:
                return RegexFileFilter.lambda$new$0((Path) obj);
            case 1:
                return HSSFRequest.lambda$addListener$0((Short) obj);
            case 2:
                return ((ColorGradientThreshold) obj).copy();
            case 3:
                return ((ExtendedColor) obj).copy();
            case 4:
                return ((Threshold) obj).copy();
            case 5:
                return ((DynamicScheme) obj).neutralPalette;
            case 6:
                return ((DynamicScheme) obj).secondaryPalette;
            case 7:
                return MaterialDynamicColors.lambda$onSecondary$71((DynamicScheme) obj);
            case 8:
                return ((DynamicScheme) obj).secondaryPalette;
            case 9:
                return MaterialDynamicColors.lambda$secondary$68((DynamicScheme) obj);
            case 10:
                return ((DynamicScheme) obj).neutralPalette;
            case 11:
                return MaterialDynamicColors.lambda$surfaceContainerLowest$22((DynamicScheme) obj);
            case 12:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 13:
                return MaterialDynamicColors.lambda$outline$43((DynamicScheme) obj);
            case 14:
                return ((DynamicScheme) obj).neutralPalette;
            case 15:
                return ((DynamicScheme) obj).primaryPalette;
            case 16:
                return MaterialDynamicColors.lambda$surfaceTint$51((DynamicScheme) obj);
            case 17:
                return ((DynamicScheme) obj).secondaryPalette;
            case 18:
                return MaterialDynamicColors.lambda$onSecondaryFixed$124((DynamicScheme) obj);
            case 19:
                return ((DynamicScheme) obj).neutralPalette;
            case 20:
                return MaterialDynamicColors.lambda$inverseOnSurface$40((DynamicScheme) obj);
            case 21:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 22:
                return MaterialDynamicColors.lambda$neutralPaletteKeyColor$7((DynamicScheme) obj);
            case 23:
                return ((DynamicScheme) obj).secondaryPalette;
            case 24:
                return ((DynamicScheme) obj).primaryPalette;
            case 25:
                return MaterialDynamicColors.lambda$onPrimaryFixed$110((DynamicScheme) obj);
            case 26:
                return ((DynamicScheme) obj).errorPalette;
            case 27:
                return ((DynamicScheme) obj).neutralPalette;
            case 28:
                return MaterialDynamicColors.lambda$error$92((DynamicScheme) obj);
            default:
                return ((DynamicScheme) obj).neutralPalette;
        }
    }
}
