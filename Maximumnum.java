class Maximumnum{
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String i : sentences) {
            int words = 1; 
            for (char c : i.toCharArray()) {
                if (c == ' ') {
                    words++;
                }
            }
            max = Math.max(max, words);
        }

        return max;
    }
}