package avramenko.lab01.analyzer;

import avramenko.lab01.fillers.ArraysGenerator;
import avramenko.lab01.fillers.Fillers;
import avramenko.lab01.sorters.AbstractSorter;
import org.reflections.Reflections;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <h1>Analyzer</h1>
 * <p>The Analyzer class work with all sorts and fillers.
 * With help of the reflection analyzer gets in method
 * all children of AbstractSorter {@link AbstractSorter}. With help of the
 * annotations analyzer gets in method {@link Analyzer#getFillers()}  all fillers.
 * Then in foreach it checks sorting time and add this values to TreeMap.</p>
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 * @see TreeMap
 * @see Reflections
 * @see java.lang.annotation.Annotation
 * @see Fillers
 */

public class Analyzer {

    /**
     * startAnalysis doing analysis of sorting. It gets length of entry array, and
     * return a TreeMap, which consists of String and Long. String consists
     * name of sorter, name of filler. Long consists sorting time.
     * @param length length of entry array
     * @return TreeMap with sorting name, filler name, array length, sorting time
     */

    public TreeMap<String, Long> startAnalysis(int length) {
        TreeMap<String, Long> treeMap = new TreeMap<>();
        Set<Method> fillers = getFillers();
        List<AbstractSorter> sorters = getSorters();
        Object obj;

        for (Method filler: fillers){
            for (AbstractSorter sorter: sorters){
                try {
                    obj = filler.invoke(Fillers.class, length);

                    int[] array = new int [Array.getLength(obj)];
                    for (int i=0; i< Array.getLength(obj); i++){
                        array[i] = (Integer) Array.get(obj, i);
                    }
                    int[] tempArray = Arrays.copyOf(array, array.length);

                    long before = System.nanoTime();
                    sorter.sort(tempArray);
                    long after = System.nanoTime();
                    treeMap.put(sorter.getClass().getSimpleName() + " " + filler.getAnnotation(Fillers.class).name() + " " + length, after - before);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return treeMap;
    }

    /**
     * getFillers gets all fillers for array with help of the Annotation {@link Fillers}
     * @return set with all fillers
     */
    private Set<Method> getFillers(){
        Set<Method> fillersList = new HashSet<>();

        Method[] methods = ArraysGenerator.class.getMethods();

        for (Method method: methods){
            if (method.isAnnotationPresent(Fillers.class)){
                fillersList.add(method);
            }
        }
        return fillersList;
    }

    /**
     * getSorters gets all sorters for array with help of the Reflection (@see Reflections)
     * @return list with all sorting methods
     */
    private List<AbstractSorter> getSorters(){
        Reflections reflections = new Reflections("avramenko.lab01.sorters");
        Set<Class<? extends AbstractSorter>> classes = reflections.getSubTypesOf(AbstractSorter.class);

        List<AbstractSorter> sorters =  new ArrayList<>();
        for (Class<? extends AbstractSorter> aClass: classes) {
            try {
                AbstractSorter sorter = aClass.newInstance();
                sorters.add(sorter);
            } catch (Exception ex){
            }
        }
        return sorters;
    }


}
