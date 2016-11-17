package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bill on 2016/10/19.
 * 类型安全的异构容器
 */
public class Favorites {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private Map<Class<?>,Object> favorites=new HashMap<>();
    public <T> void putFavorite(Class<T> type,T instance){
        if (type==null)
            throw new NullPointerException("Type is null");
        favorites.put(type,instance);
    }
    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }
}
