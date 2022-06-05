package org.zky.genshinwidgets.widgets

import org.zky.genshinwidgets.cst.SpCst
import org.zky.genshinwidgets.utils.PreferenceDelegate

object Config {

    var showUID: Boolean by PreferenceDelegate(SpCst.KEY_SHOW_UID, true)

    var crashReport: Boolean by PreferenceDelegate(SpCst.KEY_CRASH_REPORT, true)

    var autoRefreshMs: Long by PreferenceDelegate(SpCst.KEY_AUTO_REFRESH_MS, 60 * 60 * 1000L)

    var launchTarget by PreferenceDelegate(SpCst.KEY_LAUNCH_TARGET, "")


}