package сollectionsInterfaces;

import java.util.Set;

public interface Findable<Type> {

    Type find(String pattern);

    Set<Type> findAll(String pattern);
}
