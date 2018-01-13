package pojos;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IntRange {

    private final int from;
    private final int to;
    private static final Map<Integer,Map<Integer,IntRange>> cache = new HashMap<>();

    public static final IntRange UNLIMITED = new IntRange(Integer.MIN_VALUE,Integer.MAX_VALUE);

    private IntRange(int from,int to){
        this.from = from;
        this.to = to;
    }

    /**
     * This is the static factory method returns an IntRange with the given from and to values.
     * @param from the beginning interval
     * @param to the end interval
     * @return new IntRange with from and to as correct order.
     */
    public static IntRange of(int from,int to) {
        if(from > to){
            return of(to,from);
        }
        if(cacheable(from,to)){
            Optional<IntRange> cachedInstance = getFromCache(from,to);
            if(cachedInstance.isPresent()){
                return cachedInstance.get();
            }else{
                return putIntoCache(from,to);
            }
        }
        return new IntRange(from,to);
    }

    private static IntRange putIntoCache(int from, int to) {
        IntRange newInstance = new IntRange(from,to);
        if(cache.containsKey(from)){
           Map<Integer,IntRange> subMap = cache.get(from);
           subMap.put(to,newInstance);
        }else{
            Map<Integer,IntRange> subMap = new HashMap<>();
            subMap.put(to,newInstance);
            cache.put(from,subMap);
        }
        return newInstance;
    }

    private static Optional<IntRange> getFromCache(int from, int to) {
        if(cache.containsKey(from)){
            Map<Integer,IntRange> subMap = cache.get(from);
            if(subMap.containsKey(to)){
                return Optional.of(subMap.get(to));
            }
        }
        return Optional.empty();
    }

    private static boolean cacheable(int from, int to) {
        return from >=0 && from <=10 && to>=0 && to<=10;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public boolean isWithInRange(int number) {
        return number >= from && number <= to;
    }
}
