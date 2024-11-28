class Solution {
    static int min = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        dfs(picks[0], picks[1], picks[2], minerals, 0, 0);

        return min;
    }

    private static void dfs(int dia, int iron, int stone, String[] minerals, int idx, int sum) {
        if (idx >= minerals.length) {
            min = Math.min(min, sum);
            return;
        }

        if (dia == 0 && iron == 0 && stone == 0) {
            min = Math.min(min, sum);
            return;
        }

        int cnt = Math.min(minerals.length, idx + 5);

        if (dia > 0) {
            int tired = cnt - idx;
            dfs(dia - 1, iron, stone, minerals, cnt, sum + tired);
        }

        if (iron > 0) {
            int tired = 0;
            for (int i = idx; i < cnt; i++) {
                if (minerals[i].equals("diamond")) {
                    tired += 5;
                    continue;
                }
                tired += 1;
            }
            dfs(dia, iron - 1, stone, minerals, cnt, sum + tired);
        }

        if (stone > 0) {
            int tired = 0;
            for (int i = idx; i < cnt; i++) {
                if (minerals[i].equals("diamond")) {
                    tired += 25;
                } else if (minerals[i].equals("iron")) {
                    tired += 5;
                } else {
                    tired += 1;
                }
            }
            dfs(dia, iron, stone - 1, minerals, cnt, sum + tired);
        }
    }
}