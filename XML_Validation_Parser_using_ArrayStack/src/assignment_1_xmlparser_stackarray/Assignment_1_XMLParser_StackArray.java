/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_xmlparser_stackarray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rajat
 */
public class Assignment_1_XMLParser_StackArray {

    /**
     * @param args the command line arguments
     */
    public static String stripEnds(String t) {
        if (t.length() <= 2) {
            return null;	// this is a degenerate tag
        }
        return t.substring(1, t.length() - 1);
    }

    public static boolean isOpeningTag(String tag) {
        return (tag.charAt(0) != '/');
    }

    public static boolean areMatchingTags(String tag1, String tag2) {
        return tag1.equals(tag2.substring(1));
    }

    public static String isXMLTagMatched(arrayStack S, String tag) {
        if (isOpeningTag(tag)) {
            S.push(tag);
        } else {
            if (S.isEmpty()) {
                return "Un-Blanced XML Tags"; // we have nothing to match
            }
            if (!areMatchingTags((String) S.pop(), tag)) {
                return "Un-Balanced XML Tags"; // we have some tags that never were matched
            }
        }

        if (S.isEmpty()) {
            return "Balanced XML Tags"; // we matched everything
        }
        return "Un-Balanced XML Tags"; // we have some tags that never were matched
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER FILE PATH/NAME");
        String input = scan.nextLine();
        File file = new File(input);
        long startTime = System.currentTimeMillis();
        arrayStack S = new arrayStack();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = null;
        String output = "";
        boolean comment = false;
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            if (line.trim().startsWith("<!--") && line.trim().endsWith("-->")) {
                continue;
            }
            if (line.contains("<!--")) {
                comment = true;
                continue;
            }
            if (line.contains("-->")) {
                comment = false;
                continue;
            }
            if (!comment) {
                Pattern regex = Pattern.compile("<.[^>]*>");
                Matcher matcher = regex.matcher(line);
                while (matcher.find()) {
                    sb.append(matcher.group());
                    sb.append("\n");
                }
            }
        }

    StringTokenizer tok = new StringTokenizer(sb.toString(), "\n"); 
        System.out.println("Total Number of Tokens : " + tok.countTokens());        
        while (tok.hasMoreTokens()) {
            String token = tok.nextToken();
            System.out.println("Tokens : " +token);  
            if (token.trim().startsWith("<") && (!token.trim().endsWith("/>")) && (!token.contains("</"))) {
                String tag = stripEnds(token);
                if (tag.contains(" ")) {
                    String[] a = tag.split(" ");
                    if (a[0] != null) {
                        output = isXMLTagMatched(S, a[0]);
                    }
                } else {
                    output = isXMLTagMatched(S, tag);
                }
            } else if (token.trim().startsWith("</")) {
                String tag = stripEnds(token);
                output = isXMLTagMatched(S, tag);
            } else if (token.trim().startsWith("<") && token.trim().endsWith("/>")) {
                continue;
            }

        }
        System.out.println("Output : " + output);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Running Time: " + totalTime);
        
    }

}
