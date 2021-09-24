package people;

import java.util.*;

public class UserCollection
        implements Addable<User>,
            Deletable<User>,
            Findable<User> {
    private Map<Long, User> userMap = new HashMap<>();

    public UserCollection() {}
    public UserCollection(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    public Iterator<User> getUserCollectionIterator(){
        return userMap.values().iterator();
    }

    @Override
    public String toString() {
        return userMap.toString();
    }

    @Override
    public void add(User element) {
        userMap.put( element.getId(), element );
    }

    @Override
    public void delete(User element) {
        userMap.remove( element.getId() );
    }

    @Override
    public User find(String pattern) {
        for ( User u : userMap.values() ){
            if ( ( (u.getName() != null ) && u.getName().equals(pattern)) ||
                 ( (u.getLogin() != null ) && u.getLogin().equals(pattern))){
                return u;
            }
        }
        return null;
    }

    @Override
    public Set<User> findAll(String pattern) {
        Set<User> userSet = new HashSet<>();
        for ( User u : userMap.values() ){
            if ( ( (u.getName() != null ) && u.getName().equals(pattern)) ||
                    ( (u.getLogin() != null ) && u.getLogin().equals(pattern))){
                userSet.add(u);
            }
        }
        return userSet;
    }
}
