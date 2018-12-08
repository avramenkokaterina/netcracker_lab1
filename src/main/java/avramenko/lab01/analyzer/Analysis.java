package avramenko.lab01.analyzer;

import avramenko.lab01.fillers.*;
import avramenko.lab01.sorters.*;
import org.reflections.Reflections;

import java.lang.reflect.*;
import java.util.*;

public class Analysis {

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

    private Set<Method> getFillers(){
        Set<Method> fillersList = new HashSet<>();

        Method[] methods = GenerateArrays.class.getMethods();

        for (Method method: methods){
            if (method.isAnnotationPresent(Fillers.class)){
                fillersList.add(method);
            }
        }
        return fillersList;
    }

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
