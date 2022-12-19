class Compute  
{ 

/*
Given an array of integers, 
sort the array (in descending order) 
according to count of set bits 
in binary representation of array elements. 

Note: For integers having same number of set bits in their binary representation,
sort according to their position in the original array i.e., a stable sort.
*/
  
    private static ArrayList<Integer> mem;
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        mem = new ArrayList<>();
        mem.add(0, 0);
        mem.add(1, 1);
        Num[] numArr = new Num[n];
        int pos = 0;
        for (Integer i : arr) {
            numArr[pos] = new Num(countSetBit(i), i);
            pos ++;
        }
        Arrays.sort(numArr);
        pos = 0; 
        for (Num i : numArr) {
            arr[pos] = i.num;
            pos ++;
        }
    } 
    
    static int countSetBit(int n) {
        if (n < mem.size()) return mem.get(n);
        for (int i = mem.size(); i <= n; i ++) {
            int sb = mem.get(i / 2);
            // even is same as even / 2
            if (i % 2 == 0) mem.add(i, sb);
            else mem.add(i, sb + 1);
        }
        return mem.get(n);
    }
    
    static class Num implements Comparable<Num>{
        int setBit = 0;
        int num = 0;
        boolean isPresent = false;
        
        Num(int s, int n) {
            this.setBit = s;
            this.num = n;
            this.isPresent = true;
        }
        
        @Override
        public int compareTo(Num a) {
            if (this.setBit > a.setBit) return -1; // descending order
            if (this.setBit < a.setBit) return 1;
            return 0; // in-place sorting
        }
    }
}
