
/*
* GameCatalogue.java
* @author Daniel Morales
* @author Jason Hammar
* @author Zyad Khater
* @author Zeko Khater
* @author Donggyu(Alex) Yu
* @author Aurielle Jocom
* CIS 22C, Course Project
*/
import java.io.*;
import java.util.*;

public class GameCatalogue {
	private final int numvideogames = 25;
	// private String userName;
	Hash<VideoGames> hash = new Hash<>(numvideogames * 2);
	BST<VideoGames> bst = new BST<>();
	BST<VideoGames2> bst2 = new BST<>();

	public static void main(String[] args) throws IOException {
		String serialCode;
		String title;
		int year;
		String publisher;
		String rating;

		GameCatalogue gameCatalogue = new GameCatalogue();
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to your video game library!");

		// try catch block for valid file from user
		boolean isTrue = true;
		String fileName;
		while (isTrue) {
			try {
				System.out.print("Enter text file name: ");
				fileName = input.nextLine();
				gameCatalogue.readFile(fileName);
				isTrue = false;
			} catch (IOException e) {
				System.out.println("Not a valid file name");
			}
		}

		int choice = 0;
		String in;
		VideoGames vg;
		VideoGames2 vg2;

		System.out.println();

		while (choice != 6) {
			System.out.println("Please select one of the following:");
			System.out.println("1. Print your catalogue");
			System.out.println("2. Search for video game");
			System.out.println("3. Add video game");
			System.out.println("4. Remove video game");
			System.out.println("5. Save to file");
			System.out.println("6. Quit");
			System.out.print("Enter your choice: ");

			if (!input.hasNextInt()) {
				in = input.next();
				choice = 0;
			}

			else {
				choice = input.nextInt();
			}

			while (choice < 1 || choice > 6) {
				System.out.println("\nInvalid choice!");
				System.out.print("Enter your choice: ");

				if (!input.hasNextInt()) {
					in = input.next();
					choice = 0;
				}

				else {
					choice = input.nextInt();
				}
			}

			if (choice == 1) {
				System.out.println("\nPlease select one of the following:");
				System.out.println("1. Print unsorted");
				System.out.println("2. Print sorted by serial code");
				System.out.println("3. Print sorted by title");
				System.out.print("Enter your choice: ");

				if (!input.hasNextInt()) {
					in = input.next();
					choice = 0;
				}

				else {
					choice = input.nextInt();
				}

				while (choice < 1 || choice > 3) {
					System.out.println("\nInvalid choice!");
					System.out.print("Enter your choice: ");

					if (!input.hasNextInt()) {
						in = input.next();
						choice = 0;
					}

					else {
						choice = input.nextInt();
					}
				}

				if (choice == 1) {
					System.out.println();
					System.out.print(gameCatalogue.hash);
				}

				else if (choice == 2) {
					System.out.println();
					gameCatalogue.bst.inOrderPrint();
				}

				else {
					System.out.println();
					gameCatalogue.bst2.inOrderPrint();
				}
			}

			else if (choice == 2) {
				System.out.println("\nPlease select one of the following:");
				System.out.println("1. Search by serial code");
				System.out.println("2. Search by title");
				System.out.print("Enter your choice: ");

				if (!input.hasNextInt()) {
					in = input.next();
					choice = 0;
				}

				else {
					choice = input.nextInt();
				}

				while (choice < 1 || choice > 2) {
					System.out.println("\nInvalid choice!");
					System.out.print("Enter your choice: ");

					if (!input.hasNextInt()) {
						in = input.next();
						choice = 0;
					}

					else {
						choice = input.nextInt();
					}
				}

				if (choice == 1) {
					System.out.print("\nEnter the serial code: ");
					serialCode = input.next();
					vg = new VideoGames(serialCode, "", 0, "", "");

					if (gameCatalogue.bst.search(vg) == false) {
						System.out
								.println("\nVideo game with serial code: " + serialCode + " is not in the database\n");
					}

					else {
						System.out.println("\nVideo game with serial code: " + serialCode + " is in the database\n");
						System.out.println("Displaying search result:\n");
						gameCatalogue.bst.printElement(vg);
					}
				}

				else {
					System.out.print("\nEnter the title: ");
					title = input.next() + input.nextLine();
					vg2 = new VideoGames2("", title, 0, "", "");

					if (gameCatalogue.bst2.search(vg2) == false) {
						System.out.println("\nVideo game with title: " + title + " is not in the database\n");
					}

					else {
						System.out.println("\nVideo game with title: " + title + " is in the database\n");
						System.out.println("Displaying search results:\n");
						gameCatalogue.bst2.printAllMatches(vg2);
					}
				}
			}

			else if (choice == 3) {
				System.out.print("\nEnter the serial code: ");
				serialCode = input.next();
				System.out.print("Enter the title: ");
				title = input.next() + input.nextLine();
				System.out.print("Enter the year: ");
				year = input.nextInt();
				System.out.print("Enter the publisher: ");
				publisher = input.next();
				System.out.print("Enter the rating: ");
				rating = input.next();

				vg = new VideoGames(serialCode, title, year, publisher, rating);
				vg2 = new VideoGames2(serialCode, title, year, publisher, rating);

				gameCatalogue.hash.insert(vg);
				gameCatalogue.bst.insert(vg);
				gameCatalogue.bst2.insert(vg2);

				System.out.println("\n" + title + " was added!\n");
			}

			else if (choice == 4) {
				System.out.print("\nEnter the serial code: ");
				serialCode = input.next();
				System.out.print("Enter the title: ");
				title = input.next() + input.nextLine();

				vg = new VideoGames(serialCode, title, 0, "", "");
				vg2 = new VideoGames2(serialCode, title, 0, "", "");

				if (gameCatalogue.hash.search(vg) == -1) {
					System.out.println(
							"\nI cannot find " + title + " with serial code: " + serialCode + " in the database.\n");
				}

				else {
					System.out.print("\nAre you sure you want to delete the following?\n");
					gameCatalogue.bst.printAllMatches(vg);
					System.out.print("\n1. Yes\n2. No\n");
					System.out.print("Enter your choice: ");
					
					if (!input.hasNextInt()) {
						in = input.next();
						choice = 0;
					}
					
					else {
						choice = input.nextInt();
					}
					
					while (choice < 1 || choice > 2) {
						System.out.print("\nInvalid Entry.");
						System.out.print("\nEnter your choice: ");
						
						if (!input.hasNextInt()) {
							in = input.next();
							choice = 0;
						}
						
						else {
							choice = input.nextInt();
						}
					}
					
					if (choice == 1) {
						gameCatalogue.hash.remove(vg);
						gameCatalogue.bst.remove(vg);
						gameCatalogue.bst2.remove(vg2);

						System.out.println("\n" + title + " was removed!\n");
					}
				}
			}

			else {
				gameCatalogue.writeFile();

				if (choice == 6) {
					System.out.print("\nGoodbye!");
					break;
				}

				System.out.println("\nCatalogue is saved in out.txt!");
				System.out.println("Your current catalogue:\n");
				System.out.print(gameCatalogue.hash);
			}
		}
		input.close();
	}

	/**
	 * reads file content
	 * 
	 * @throws IOException
	 */
	public void readFile(String fileName) throws IOException {
		File inFile = new File(fileName);
		Scanner in = new Scanner(inFile);

		while (in.hasNext()) {
			String serialNum = in.nextLine();
			String title = in.nextLine();
			String publisher = in.nextLine();
			int year = in.nextInt();
			in.nextLine();
			String rating = in.nextLine();

			if (in.hasNextLine()) {
				in.nextLine();
			}

			VideoGames v = new VideoGames(serialNum, title, year, publisher, rating);
			VideoGames2 v2 = new VideoGames2(serialNum, title, year, publisher, rating);

			hash.insert(v);
			bst.insert(v);
			bst2.insert(v2);
		}
		in.close();
	}

	/**
	 * outputs the hash contents onto file by calling on hash.printOut
	 */
	public void writeFile() throws IOException {
		File outFile = new File("out.txt");
		PrintWriter output = new PrintWriter(outFile);
		hash.printOut(output);
		output.close();
	}
}