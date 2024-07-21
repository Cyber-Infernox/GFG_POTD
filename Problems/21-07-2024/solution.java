// Time Limit Exceeded
// class Solution {
//     private long func(int index, List<Integer> arr, long product, HashMap<String, Long> memo) {
//         if (index < 0) {
//             return product;
//         }

//         String key = index + ":" + product;
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         long take = func(index - 1, arr, product * arr.get(index), memo);
//         long notTake = func(index - 1, arr, product, memo);

//         long result = Math.max(take, notTake);
//         memo.put(key, result);
//         return result;
//     }

//     public long findMaxProduct(List<Integer> arr) {
//         int len = arr.size();

//         if (len == 1) return arr.get(0);
//         if (len == 2) {
//             if (arr.get(0) == 0 || arr.get(1) == 0) return 0;
//         }

//         boolean allZeros = true;
//         for (int num : arr) {
//             if (num != 0) {
//                 allZeros = false;
//                 break;
//             }
//         }
//         if (allZeros) return 0;

//         HashMap<String, Long> memo = new HashMap<>();
//         return func(len - 1, arr, 1, memo);
//     }
// }

// Optimised
class Solution {
    public long findMaxProduct(List<Integer> arr) {
        long mod = 1000000007;
        long product = 1;
        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int countNeg = 0;
        int countZero = 0;
        int countPos = 0;

        for (int num : arr) {
            if (num == 0) {
                countZero++;
                continue;
            }
            if (num < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, num);
            } else {
                countPos++;
                minPos = Math.min(minPos, num);
            }

            product = (product * num) % mod;
            if (product < 0)
                product += mod;
        }

        if (arr.size() == 1) {
            return arr.get(0);
        }

        if (countZero == arr.size()) {
            return 0;
        }

        if (countNeg % 2 != 0) {
            if (countNeg == 1 && countZero > 0 && countPos == 0) {
                return 0;
            }
            product = (product * modInverse(maxNeg, mod)) % mod;
            if (product < 0)
                product += mod;
        }

        return product;
    }

    private long modInverse(int a, long mod) {
        return power(a, mod - 2, mod);
    }

    private long power(int x, long y, long mod) {
        if (y == 0)
            return 1;
        long p = power(x, y / 2, mod) % mod;
        p = (p * p) % mod;

        if (y % 2 == 0)
            return p;
        else
            return (x * p) % mod;
    }
}