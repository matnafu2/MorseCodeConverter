/**
 * A utility class that converts a morsecode to English.
 * It accepts either a string or a file and converts it into English 
 * @author Mikias Atanfu
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
    
	private static MoresCodeTree tree;
	
	public MorseCodeConverter() {
	   tree = new MoresCodeTree();
	}
	/**
	 * print the data in the tree in a LNR order
	 * @return a string in the tree
	 */
	public static String printTree() {
	   new MorseCodeConverter();
	   ArrayList<String> str = tree.toArrayList();
	   StringBuilder code = new StringBuilder();
	   for(String itr : str)
		   code.append(itr + " ");
	   return code.toString();
	}
	
	/**
	 * 
	 * @param code a 
	 * @return
	 */
	public static String convertToEnglish(String code) {
		new MorseCodeConverter();
		code = code.trim();
		StringBuilder buildString = new StringBuilder();
		String[] slashDelimited = code.split("/");
		for(int i = 0; i < slashDelimited.length; i++) {
			String[] spaceDelimited = slashDelimited[i].trim().split(" ");
			for(int j = 0; j<spaceDelimited.length; j++) {
				buildString.append(tree.fetch(spaceDelimited[j]));
			}
		   buildString.append(" ");
		}
		return buildString.toString().trim();
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		new MorseCodeConverter();
		Scanner scan = new Scanner(codeFile);
		String str = "";
		while(scan.hasNext())
			str = scan.nextLine();
		scan.close();
		String s = convertToEnglish(str);
		return s;
	}
}

