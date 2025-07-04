class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> li = new ArrayList<>();
        
        for(int i = 0; i<capital.length; i++){
            li.add(new Project(capital[i], profits[i]));
        }

        li.sort((a,b) -> a.capital-b.capital);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int n = profits.length;

        while(k>0){
            while(i<n && li.get(i).capital<=w){
                pq.offer(li.get(i).profit);
                i++;
            }
            if(pq.isEmpty()) break;

            w += pq.poll();
            k--;
        }

        return w;
    }
}

class Project{
    int capital;
    int profit;
    Project(int capital, int profit){
        this.capital = capital;
        this.profit = profit;
    }
}