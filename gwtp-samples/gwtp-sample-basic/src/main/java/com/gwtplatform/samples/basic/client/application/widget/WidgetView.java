package com.gwtplatform.samples.basic.client.application.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class WidgetView extends ViewWithUiHandlers<WidgetUiHandlers> implements WidgetPresenter.MyView {
    interface Binder extends UiBinder<HTMLPanel, WidgetView> {

    }
    @UiField
    TextBox username;

    @Inject
    public WidgetView(Binder binder) {
        // TODO: Document this !
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("btnLogin")
    public void onLogin(ClickEvent event) {
        getUiHandlers().onClick();
    }

    @Override
    public void setUsername(String username) {
        this.username.setText(username);
    }
}
