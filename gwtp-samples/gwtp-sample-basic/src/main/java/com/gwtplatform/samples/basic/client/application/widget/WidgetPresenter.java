package com.gwtplatform.samples.basic.client.application.widget;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class WidgetPresenter extends PresenterWidget<WidgetPresenter.MyView> implements
        WidgetUiHandlers {
    public interface MyView extends View, HasUiHandlers<WidgetUiHandlers> {
        void setUsername(String username);
    }

    @Inject
    public WidgetPresenter(EventBus eventBus,
                           MyView view) {
        super(eventBus, view);

        getView().setUiHandlers(this);
    }

    @Override
    public void onClick() {
        Window.alert("Click from presenter widget !");
    }

    @Override
    public void setUsername(String username) {
        getView().setUsername(username);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }
}
