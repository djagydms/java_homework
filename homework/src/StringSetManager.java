import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum StringCommand { ADD, REMOVE, CLEAN, QUIT, INVALID};

public class StringSetManager {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		String[] stringSet = new String[100];
		
		while ( true ) {
			
			final StringCommand command = getCommand(scanner);
			
			if ( command == StringCommand.QUIT ) {
				System.out.println("BYE!"); break;
			}
			
			switch ( command ) {
			case ADD: {
				final String str = getString(scanner);
				executeAdd(stringSet, str);
				break;
			}
			case REMOVE: {
				final String str = getString(scanner);
				executeRemove(stringSet, str);
				break;
			}
			case CLEAN: {
				executeClear(stringSet);
				break;
			}
			default:
				System.out.println("Unknown Command!");
				break;
			}
			executePrint(stringSet);
		}
	}
	// Your code here

	private static void executePrint(String[] stringSet) {
		int cnt = 0;
		List<String>printStr = new ArrayList<>();
		for(String i : stringSet) {
			if(i != null) {
				cnt++;
				printStr.add(i);
			}
		}
		System.out.printf("Element Size: %d, Values = ", cnt );
		int i = 0;
		if(printStr.size()>0) {
			for(i = 0 ; i< printStr.size()-1; i++) {
				System.out.printf("%s, ",printStr.get(i));
			}
			System.out.println(printStr.get(i));
		}
		else {
			System.out.println();
		}
		
	}

	private static void executeClear(String[] stringSet) {
		for(int i=0 ; i< stringSet.length; i++) {
			if(stringSet[i] !=null) {
				stringSet[i]=null;
			}
		}
	}

	private static void executeRemove(String[] stringSet, String str) {
		for(int i=0 ; i< stringSet.length; i++) {
			if(stringSet[i] !=null && stringSet[i].equals(str)) {
				stringSet[i] = null;
				break;
			}	
		}
		
	}

	private static void executeAdd(String[] stringSet, String str) {
		
		for(int i=0 ; i< stringSet.length; i++) {
			if(stringSet[i] !=null && stringSet[i].equals(str)) {
				return;
			}	
		}
		
		for(int i=0 ; i< stringSet.length; i++) {
			if(stringSet[i] == null) {
				stringSet[i] = str;
				break;
			}
			
		}
		
	}

	private static String getString(final Scanner scanner) {
		final String input = scanner.next().trim();
	
		return input;
	}

	private static StringCommand getCommand(final Scanner scanner) {
		final String input = scanner.next().trim();
		
		StringCommand command;
		try {
			command = StringCommand.valueOf(input.toUpperCase());
		}
		catch(Exception e)
		{
			command = StringCommand.INVALID;
		}
		return command;
	}
}
