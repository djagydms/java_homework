import java.util.Scanner;

enum Command {
	ADD,LIST,SUM,INVALID,QUIT;

};


public class ArrayEnum {

	public static void main(String[] args) {
		final int[] values = new int[100];
		int index = 0;
		
		System.out.println("명령을 입력하세요.");
		
		final Scanner scanner = new Scanner(System.in);
		
		while(true) {
			final Command command = getCommand(scanner);
			if(command == Command.QUIT) {
				System.out.println("Bye!");
				break;
			}
			switch(command) {
			case ADD:
				final int newValue = getValue(scanner);
				values[index] = newValue;
				index++;
				break;
			case LIST:
				printList(values,index);
				break;
			case SUM:
				System.out.println(getSum(values,index));
				break;
			case INVALID:
				System.out.println("Invaild Command");
				default: break;
			}
		}

		scanner.close();
	}
	
	private static void printList(int[] values, int index) {
		// TODO Auto-generated method stub
		for(int i = 0; i<index ; i++) {
			System.out.printf("%d ",values[i]);
		}
		System.out.println();
		
	}

	private static int getSum(final int[] values,final int index) {
		int sum=0;
		for(int i = 0; i<index ; i++) {
			sum += values[i];
		}
		return sum;
	}

	private static int getValue(final Scanner scanner) {
		int input = Integer.parseInt(scanner.next());
				
		return input;
	}

	private static  Command getCommand(final Scanner scanner) {
		// TODO Auto-generated method stub
		final String input = scanner.next().trim();
		
		Command command;
		try {
			command = Command.valueOf(input.toUpperCase());
		}
		catch(Exception e)
		{
			command = Command.INVALID;
		}
		return command;
	}

}
