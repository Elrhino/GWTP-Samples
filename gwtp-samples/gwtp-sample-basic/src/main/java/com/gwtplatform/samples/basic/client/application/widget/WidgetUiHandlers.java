package com.gwtplatform.samples.basic.client.application.widget;

import com.gwtplatform.mvp.client.UiHandlers;

public interface WidgetUiHandlers extends UiHandlers {
    void onClick();

    void setUsername(String username);
}
