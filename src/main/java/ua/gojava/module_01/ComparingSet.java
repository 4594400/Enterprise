package ua.gojava.module_01;


import java.util.Collection;
import java.util.Set;

public class ComparingSet extends CommonCollection {

    @Override
    public long add(Collection collection, int size) {
        populateCollection(collection, size);

        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            collection.add(randInt(0, size));
        }
        return (System.currentTimeMillis() - startTime)/count;
    }
    @Override
    public long remove(Collection collection, int size) {
        populateCollection(collection, size);

        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            collection.remove(randInt(0, size - i - 1));
        }
        return (System.currentTimeMillis() - startTime)/count;
    }

    public void printBodySet(Set set, int size) {
        System.out.printf("%-10s%10d%10d%15d%15d%15d%23d%23d%n", set.getClass().getSimpleName(), add(set, size), null, remove(set, size),
                contains(set, size), populate(set, size), null, null);
    }

}



