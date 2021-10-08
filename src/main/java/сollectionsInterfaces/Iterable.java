package сollectionsInterfaces;

import java.util.Iterator;

public interface Iterable<Type> {
    Iterator<Type> getCollectionIterator();
}
