package org.zky.genshinwidgets.widgets;

import androidx.glance.GlanceId;
import androidx.glance.appwidget.AppWidgetId;

public class GlanceFxxker {

    public static int getAppWidgetId(GlanceId glanceId){
        if (glanceId instanceof AppWidgetId) {
            return ((AppWidgetId)glanceId).getAppWidgetId();
        }
        return -1;
    }
}
