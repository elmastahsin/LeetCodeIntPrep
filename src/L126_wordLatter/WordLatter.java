package L126_wordLatter;

import java.util.*;

public class WordLatter {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"))); // 5
        System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"))); // 0
        System.out.println(ladderLength("hot", "dog", List.of("hot","dog","dot"))); // 3
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return level;
                }
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordChars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if (wordSet.contains(newWord) && !newWord.equals(currentWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
