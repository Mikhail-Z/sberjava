package task01_05.my_bean;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyScope implements Scope {

    private Map<String, Object> scopedObjects = Collections.synchronizedMap(new HashMap<String, Object>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<String, Runnable>());

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(s)) {
            scopedObjects.put(s, objectFactory.getObject());
        }

        return scopedObjects.get(s);
    }

    @Override
    public Object remove(String s) {
        destructionCallbacks.remove(s);
        return scopedObjects.remove(s);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {
        destructionCallbacks.put(s, runnable);
    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
