class Leaderboard {
  PriorityQueue<List<Integer>> pq;
  Map<Integer, List<Integer>> map;

  public Leaderboard() {
    pq = new PriorityQueue<>((a,b) -> b.get(1) - a.get(1));
    map = new HashMap<>();
  }

  public void addScore(int playerId, int score) {
    if (map.containsKey(playerId)) {
      List<Integer> pair = map.get(playerId);
      pq.remove(pair);
      pair.set(1, pair.get(1) + score);
      pq.add(pair);      
    } else {
      List<Integer> pair = new ArrayList<>();
      pair.add(playerId);
      pair.add(score);
      pq.add(pair);
      map.put(playerId, pair);
    }
  }

  public int top(int K) {
    List<List<Integer>> removed = new ArrayList<>();
    int sum = 0;
    // pop off top K
    for (int i = 0; i < K && !pq.isEmpty(); i++) {
      sum += pq.peek().get(1);
      removed.add(pq.poll());
    }
    // add back in
    for (List<Integer> p : removed) {
      pq.add(p);
    }
    return sum;
  }

  public void reset(int playerId) {
    List<Integer> pair = map.get(playerId);
    pq.remove(pair);
    pair.set(1, 0);
    pq.add(pair);
  }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
