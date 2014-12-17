package org.mele.api.component;

import org.mele.api.RequestController;
import org.mele.api.querying.ResponseStatus;
import org.mele.api.querying.TextQueryResult;
import org.mele.api.querying.UserQuery;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MeleApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(RequestController.class);

        return classes;
    }

}