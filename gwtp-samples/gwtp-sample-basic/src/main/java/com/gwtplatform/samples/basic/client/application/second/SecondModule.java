package com.gwtplatform.samples.basic.client.application.second;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.samples.basic.client.application.widget.WidgetModule;

public class SecondModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new WidgetModule());

        bindPresenter(SecondPresenter.class, SecondPresenter.MyView.class, SecondView.class,
                SecondPresenter.MyProxy.class);
    }
}
