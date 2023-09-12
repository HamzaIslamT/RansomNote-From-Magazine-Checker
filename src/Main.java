import java.util.*;

class Main {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[52];

        for (char c : magazine.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    charCount[c - 'a']++;
                } else if (Character.isUpperCase(c)) {
                    charCount[c - 'A' + 26]++;
                }
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    if (charCount[c - 'a'] > 0) {
                        charCount[c - 'a']--;
                    } else {
                        return false;
                    }
                } else if (Character.isUpperCase(c)) {
                    if (charCount[c - 'A' + 26] > 0) {
                        charCount[c - 'A' + 26]--;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("bba", "ababab"));
        System.out.println(canConstruct("istherea gap", "heretis gaap"));
        System.out.println(canConstruct("aAaj", "aabAb"));

    }
}

