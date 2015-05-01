package com.gwtplatform.samples.basic.client.application.widget;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WidgetModule extends AbstractPresenterModule {
    // TODO: Document this !
    @Override
    protected void configure() {
        bindSingletonPresenterWidget(WidgetPresenter.class, WidgetPresenter.MyView.class,
                WidgetView.class);

        bind(WidgetUiHandlers.class).to(WidgetPresenter.class);
    }
}
