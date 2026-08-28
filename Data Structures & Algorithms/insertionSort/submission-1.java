// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        if (pairs.size() == 0) {
            return new ArrayList<>();
        }
        List<List<Pair>> sorted = new ArrayList<>();
        sorted.add(new ArrayList<>(pairs));
        for (int i=1; i<pairs.size(); i++) {
            int j = i;
            while (j > 0 && pairs.get(j-1).key > pairs.get(j).key) {
                Pair temp = pairs.get(j-1);
                pairs.set(j-1, pairs.get(j));
                pairs.set(j, temp);
                j--;
            }
            sorted.add(new ArrayList<>(pairs));
        }
        return sorted;
    }
}
