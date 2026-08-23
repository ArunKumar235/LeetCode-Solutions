class Solution {
    public int longestSubarray(int[] nums, int k) {
        buildSPF((int) 1e5);

        int[] freq = new int[(int) 1e5 + 1];

        int l = 0;
        int unique = 0;
        int ans = 0;

        for(int r = 0; r<nums.length; r++){
            List<Integer> rFactors = getFactorization(nums[r]);

            for(int factor: rFactors){
                if(freq[factor] == 0){
                    unique++;
                }
                freq[factor]++;
            }

            while(unique > k){
                List<Integer> lFactors = getFactorization(nums[l]);

                for(int factor: lFactors){
                    freq[factor]--;
                    if(freq[factor] == 0){
                        unique--;
                    }
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }

    // https://codeforces.com/blog/entry/140773

    // Sieve of Eratosthenes -> O(n log log n) 
    // It is used to find prime number upto N effeciently, it stores boolean value of wheter a number is prime or composite

    // SPF Sieve - Smallest Prime Factor Sieve ->  O(n log log n)
    // Smallest Prime Factor (SPF): The SPF of a number n is the smallest prime number that divides n. If n is a prime number, its smallest prime factor is the number itself.
    // Example: For n = 35, the prime factorization is 35 = 5 * 7. Hence, the smallest prime factor (SPF) of 35 is 5, which is the smallest prime factor in the factorization.

    int[] spf;

    private void buildSPF(int n){
        spf = new int[n+1];

        for(int i = 1; i<=n; i++) spf[i] = i;

        for(int i = 2; i*i <= n; i++){
            // if spf[i] == i, then i is prime
            if(spf[i] == i){
                for(int j = i*i; j<=n; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
    }

    // Retrieves the prime factorization of a number using the SPF array
    // Time Complexity per query: O(log x)
    private List<Integer> getFactorization(int x){
        List<Integer> factors = new ArrayList<>();
        while(x > 1){
            factors.add(spf[x]);
            x /= spf[x];
        }
        return factors;
    }
}