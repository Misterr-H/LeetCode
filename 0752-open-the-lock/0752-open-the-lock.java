class Solution {
    public int openLock(String[] deadends, String target) {
        if (target == "0000") return 0;
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        if (deadendSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String curr = queue.poll();

                if(curr.equals(target)) {
                    return steps;
                }

                for (int j=0; j < 4; j++) {
                    String up = turnUp(curr, j);
                    String down = turnDown(curr, j);

                    if(!deadendSet.contains(up) && !visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    if(!deadendSet.contains(down) && !visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }

                
            }

            steps++;
        }

        return -1;
        
    }

    public String turnUp(String s, int i) {
        char[] chars = s.toCharArray();
        if(chars[i]=='9') {
            chars[i]='0';
        } else {
            chars[i]++;
        }
        return new String(chars);
    }

    public String turnDown(String s, int i) {
        char[] chars = s.toCharArray();
        if(chars[i]=='0') {
            chars[i]='9';
        } else {
            chars[i]--;
        }
        return new String(chars);
    }
}