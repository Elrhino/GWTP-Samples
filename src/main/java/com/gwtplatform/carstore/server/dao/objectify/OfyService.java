/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.carstore.server.dao.objectify;

import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.gwtplatform.carstore.server.dao.domain.Car;
import com.gwtplatform.carstore.server.dao.domain.CarProperties;
import com.gwtplatform.carstore.server.dao.domain.Manufacturer;
import com.gwtplatform.carstore.server.dao.domain.Rating;
import com.gwtplatform.carstore.server.dao.domain.User;
import com.gwtplatform.carstore.server.dao.domain.UserSession;

public class OfyService {
    static {
        ObjectifyService.setFactory(new OfyFactory());
        factory().register(Car.class);
        factory().register(CarProperties.class);
        factory().register(Manufacturer.class);
        factory().register(Rating.class);
        factory().register(User.class);
        factory().register(UserSession.class);
    }

    public static Ofy ofy() {
        return (Ofy) ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
