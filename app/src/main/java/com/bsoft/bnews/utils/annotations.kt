package com.bsoft.bnews.utils

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview


@Preview(name = "light", showBackground = true,
    device = "id:Nexus S",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(name = "dark", showBackground = true,
    device = "id:Nexus S",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightDarkPreview