package effectivejava;

import java.util.*;

/**
 * Created by Bill on 2016/6/14.
 */
public class CollectionClassifier {

    public static String classify(Collection<?> c){
        return c instanceof Set<?>? "Set":c instanceof List<?>? "List":"Unknown Collection";
    }
    public static void main(String[] args){
        Collection<?>[] collections={new HashSet<String>(),new ArrayList<String>(),new HashMap<String,String>().values()};
        for (Collection<?> collection:collections){
            System.out.println(classify(collection));
        }
    }
}
