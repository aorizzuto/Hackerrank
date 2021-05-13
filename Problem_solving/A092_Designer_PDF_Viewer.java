package Problem_solving;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result92 {

    public static int designerPdfViewer(List<Integer> h, String word) {
        int max = 0;
        for (int i = 0; i < word.length(); i++) {
            int ch = (int) word.charAt(i) - 97; // 97: ascii for first letter lowercase
            max = h.get(ch) > max? h.get(ch):max;
        }

        return max*word.length();
    }

}

public class A092_Designer_PDF_Viewer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result92.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
