package ua.gojava.module_01;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ComparingList cl = new ComparingList();
        ComparingSet cs = new ComparingSet();

        cl.printHead("SIZE = 10K");
        cl.printBodyList(new ArrayList<>(), 10_000);
        cl.printBodyList(new LinkedList<>(), 10_000);
        cs.printBodySet(new HashSet<>(), 10_000);
        cs.printBodySet(new TreeSet<>(), 10_000);
        cl.printFooter();


        cl.printHead("SIZE = 100K");
        cl.printBodyList(new ArrayList<>(), 100_000);
        cl.printBodyList(new LinkedList<>(), 100_000);
        cs.printBodySet(new HashSet<>(), 100_000);
        cs.printBodySet(new TreeSet<>(), 100_000);
        cl.printFooter();


        cl.printHead("SIZE = 1000K");
        cl.printBodyList(new ArrayList<>(), 1_000_000);
        cl.printBodyList(new LinkedList<>(), 1_000_000);
        cs.printBodySet(new HashSet<>(), 1_000_000);
        cs.printBodySet(new TreeSet<>(), 1_000_000);
        cl.printFooter();


    }
}
