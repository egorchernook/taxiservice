package people.users.operator;

import сollectionsInterfaces.Addable;
import сollectionsInterfaces.Deletable;
import сollectionsInterfaces.Findable;
import сollectionsInterfaces.Iterable;

import java.util.*;

public class OperatorCollection
        implements Addable<Operator>,
        Deletable<Operator>,
        Findable<Operator>,
        Iterable<Operator>
{

    private Map<Long, Operator> operatorMap = new HashMap<>();

    public OperatorCollection() {}

    public OperatorCollection(Map<Long, Operator> operatorMap) {
        this.operatorMap = operatorMap;
    }

    @Override
    public Iterator<Operator> getCollectionIterator () {
        return operatorMap.values().iterator();
    }

    @Override
    public void add(Operator element) {
        operatorMap.put(element.getId(), element);
    }

    @Override
    public void delete(Operator element) {
        operatorMap.remove(element.getId());
    }

    @Override
    public Operator find(String pattern) {
        for (Operator a : operatorMap.values()) {
            if ((a.getTabNumber() != null) && a.getTabNumber().equals(pattern) ||
                    (a.getPassport() != null) && a.getPassport().equals(pattern) )  {
                return a;
            }
        }
        return null;
    }

    @Override
    public Set<Operator> findAll(String pattern) {
        Set<Operator> operatorsSet = new HashSet<>();
        for (Operator a : operatorMap.values()) {
            if ((a.getTabNumber() != null) && a.getTabNumber().equals(pattern) ||
                    (a.getPassport() != null) && a.getPassport().equals(pattern) ) {
                operatorsSet.add(a);
            }
        }
        return operatorsSet;
    }

    @Override
    public String toString() {
        return "OperatorCollection{" +
                "operatorMap=" + operatorMap +
                '}';
    }
}
