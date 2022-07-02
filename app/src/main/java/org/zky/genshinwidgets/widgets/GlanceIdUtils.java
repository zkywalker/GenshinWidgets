package org.zky.genshinwidgets.widgets;

import androidx.glance.GlanceId;
import androidx.glance.appwidget.AppWidgetId;

public class GlanceIdUtils {

    static int getId(GlanceId glanceId) {
        if (glanceId instanceof AppWidgetId) {
            return ((AppWidgetId) glanceId).getAppWidgetId();
        }
        return -1;
    }

    static GlanceId getGlanceId(int id) {
        return new AppWidgetId(id);
    }
}
