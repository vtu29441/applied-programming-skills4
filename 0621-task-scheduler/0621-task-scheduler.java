class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        
        // Count frequencies of each task
        for (char t : tasks) {
            freq[t - 'A']++;
            maxFreq = Math.max(maxFreq, freq[t - 'A']);
        }
        
        // Count tasks that share the maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }
        
        // Calculate minimum intervals needed
        int intervals = (maxFreq - 1) * (n + 1) + maxCount;
        
        // Result cannot be less than the total number of tasks
        return Math.max(tasks.length, intervals);
    }
}