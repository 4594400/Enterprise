package ua.gojava.module_01;


import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class ComparingList extends CommonCollection{


    @Override
    public long add(Collection collection, int size) {
        populateCollection(collection, size);

        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            ((List<Integer>) collection).add(randInt(0, size), randInt(0, size));
        }
        return (System.currentTimeMillis()-startTime)/count;
    }
// additional
    public long get(List list, int size) {
        populateCollection(list, size);

        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            list.get(randInt(0, size - 1));
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

    // additional
    public long listIteratorAdd(List list, int size) {
        populateCollection(list, size);

        int i = 0;
        ListIterator<Integer> iterator = list.listIterator();
        final long startTime = System.currentTimeMillis();

        while (i < count) {
            iterator.add(randInt(0, size));
            i++;
        }
        return (System.currentTimeMillis()-startTime)/count;
    }

    // additional
    public long listIteratorRemove(List list, int size) {
        populateCollection(list, size);

        ListIterator<Integer> iterator = list.listIterator();
        final long startTime = System.currentTimeMillis();

        int i = 0;
        while (i < count) {
            iterator.next();
            iterator.remove();
            i++;
        }
        //System.out.println("Size " + list.size());
        return (System.currentTimeMillis() - startTime)/count;
    }

    public Map<String, Long> resultMap(List list, int size) {
        Map<String, Long> result = new HashMap<>();
        result.put("add", add(list, size));
        result.put("get", get(list, size));
        result.put("remove", remove(list, size));
        result.put("contains", contains(list, size));
        result.put("populate", populate(list, size));
        result.put("listIteratorAdd", listIteratorAdd(list,size));
        result.put("listIteratorRemove", listIteratorRemove(list,size));

        Iterator iterator = result.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = result.get(key).toString();

            System.out.println(key + " " + value);
        }
        return result;
    }


    public void printBodyList(List list, int size) {
        System.out.printf("%-10s%10d%10d%15d%15d%15d%23d%23d%n", list.getClass().getSimpleName(), add(list, size), get(list, size), remove(list, size),
                contains(list, size), populate(list, size), listIteratorAdd(list, size), listIteratorRemove(list, size));
    }




















   /* public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }*/


}
