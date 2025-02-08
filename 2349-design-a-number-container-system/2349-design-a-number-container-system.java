class NumberContainers {
    Map<Integer, Integer> map1;
    Map<Integer, SortedSet<Integer>> map2;
    public NumberContainers() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        SortedSet<Integer> ss = map2.getOrDefault(number, new TreeSet<Integer>());

        int exists = map1.getOrDefault(index, -1);
        
        if(exists == -1) {
            ss.add(index);
            map2.put(number, ss);
        } else {
            // System.out.println(exists);
            SortedSet<Integer> ss2 = map2.get(exists);
            ss2.remove(index);
            map2.put(exists, ss2);
            ss.add(index);
            map2.put(number, ss);
        }
        map1.put(index, number);

    }
    
    public int find(int number) {
        if(!map2.containsKey(number)) return -1;
        SortedSet<Integer> ss = map2.get(number);
        if (ss.isEmpty()) return -1;
        // System.out.println(ss);
        return ss.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */