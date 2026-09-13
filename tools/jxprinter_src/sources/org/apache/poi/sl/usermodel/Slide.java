package org.apache.poi.sl.usermodel;

import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Slide<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Sheet<S, P> {
    List<? extends Comment> getComments();

    @Removal(version = "6.0.0")
    @Deprecated
    default boolean getDisplayPlaceholder(Placeholder placeholder) {
        return false;
    }

    boolean getFollowMasterBackground();

    boolean getFollowMasterColourScheme();

    boolean getFollowMasterObjects();

    Notes<S, P> getNotes();

    MasterSheet<S, P> getSlideLayout();

    String getSlideName();

    int getSlideNumber();

    String getTitle();

    boolean isHidden();

    void setFollowMasterBackground(boolean z6);

    void setFollowMasterColourScheme(boolean z6);

    void setFollowMasterObjects(boolean z6);

    void setHidden(boolean z6);

    void setNotes(Notes<S, P> notes);

    default boolean getDisplayPlaceholder(SimpleShape<?, ?> simpleShape) {
        return false;
    }
}
