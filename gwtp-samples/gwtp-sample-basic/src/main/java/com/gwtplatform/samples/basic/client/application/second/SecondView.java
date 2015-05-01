package com.gwtplatform.samples.basic.client.application.second;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class SecondView extends ViewWithUiHandlers<SecondUiHandlers> implements SecondPresenter.MyView {
    interface Binder extends UiBinder<Widget, SecondView> {
    }

    @UiField
    SimplePanel ourWidget;

    @Inject
    public SecondView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == SecondPresenter.LOGIN_SLOT) {
            ourWidget.setWidget(content);
        }
    }
}
