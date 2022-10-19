/*
* VideoGamesTest.java
* @author Daniel Morales
* @author Jason Hammar
* @author Zyad Khater
* @author Zeko Khater
* @author Donggyu(Alex) Yu
* @author Aurielle Jocom
* CIS 22C, Course Project
*/
public class VideoGameTest {

	public static void main(String[] args) {
		VideoGames game1 = new VideoGames("12sder45-789", "Halo: Combat Evolved", 2002, "Microsoft", "Mature");
		VideoGames game2 = new VideoGames("we-4876-uiru", "Star Wars: Republic Commando", 2004, "LucasArts", "Teen");
		VideoGames game3 = new VideoGames(null, null, 0, null, null);
		VideoGames game4 = new VideoGames("12sder45-789", "Halo: Combat Evolved", 2002, "Microsoft", "Mature");
		VideoGames game5 = new VideoGames(null, null, 0, null, null);
		
		System.out.print("**Testing VideoGames Constructor** \n\nShould print out: 12sder45-789, Halo: Combat Evolved, 2002, Microsoft, Mature\n");
		System.out.print(game1);
		System.out.print("Should print an empty video game, with null and 0 as the values.\n");
		System.out.print(game3);
		
		System.out.print("**Testing getTitle()**\n\nShould Print: Halo: Combat Evolved.\n");
		System.out.print(game1.getTitle());
		System.out.println("\nShould print: Star Wars: Republic Commando.");
		System.out.print(game2.getTitle());
		
		System.out.print("**Testing getSerialNumber()**\n\nShould Print: 12sder45-789.\n");
		System.out.print(game1.getSerialNumber());
		System.out.println("\nShould print: we-4876-uiru.");
		System.out.print(game2.getSerialNumber());
		
		System.out.print("**Testing getYear()**\n\nShould Print: 2002.\n");
		System.out.print(game1.getYear());
		System.out.println("\nShould print: 2004.");
		System.out.print(game2.getYear());
		
		System.out.print("**Testing getPublisher()**\n\nShould Print: Microsoft.\n");
		System.out.print(game1.getPublisher());
		System.out.println("\nShould print: LucasArts.");
		System.out.print(game2.getPublisher());
		
		System.out.print("**Testing getRating()**\n\nShould Print: Mature.\n");
		System.out.print(game1.getRating());
		System.out.println("\nShould print: Teen.");
		System.out.print(game2.getRating());
		
		System.out.print("**Testing setTitle()**\n\nShould Print: Uncharted: Drakes Fortune.\n");
		game3.setTitle("Uncharted: Drakes Fortune");
		System.out.print(game3.getTitle());
		System.out.println("\nShould print: Wii Sports.");
		game5.setTitle("Wii Sports");
		System.out.print(game5.getTitle());
		
		System.out.print("**Testing setisbn()**\n\nShould Print: wuthj-687-fjyt7.\n");
		game3.setSerialNumber("wuthj-687-fjyt7");
		System.out.print(game3.getSerialNumber());
		System.out.println("\nShould print: 687yu-r76eu-tu.");
		game5.setSerialNumber("687yu-r76eu-tu");
		System.out.print(game5.getSerialNumber());
		
		System.out.print("**Testing setYear()**\n\nShould Print: 2006.\n");
		game3.setYear(2006);
		System.out.print(game3.getYear());
		System.out.println("\nShould print: 2005.");
		game5.setYear(2005);
		System.out.print(game5.getYear());
		
		System.out.print("**Testing setStudioOrPublisher()**\n\nShould Print: Naughty Dog.\n");
		game3.setStudioOrPublisher("Naughty Dog");
		System.out.print(game3.getPublisher());
		System.out.println("\nShould print: Nintendo.");
		game5.setStudioOrPublisher("Nintendo");
		System.out.print(game5.getPublisher());
		
		System.out.print("**Testing setRating()**\n\nShould Print: Teen.\n");
		game3.setRating("Teen");
		System.out.print(game3.getRating());
		System.out.println("\nShould print: Everyone.");
		game5.setRating("Everyone");
		System.out.print(game5.getRating());
		
		System.out.print("\n\n**Testing toString()**\n\nShould print out data for Halo: Combat Evolved. \n");
		System.out.print(game1.toString());
		System.out.print("Should print out data for Star Wars Republic Commando.\n");
		System.out.print(game2.toString());
		
		System.out.print("**Testing Equals**\n\nShould Print false.\n");
		System.out.print(game1.equals(game2));
		System.out.println("\nShould print: true.");
		System.out.print(game1.equals(game4));
		
		System.out.print("\n\n**Testing compareTo()**\n\nShould Print 0.\n");
		System.out.print(game1.compareTo(game4));
		System.out.print("\nShould Print -1.\n");
		System.out.print(-1);
		
		System.out.print("\n\n**Testing hashCode()**\n\nShould print: 2680\n");
		System.out.print(game1.hashCode());
		System.out.print("\nShould print: 3593\n");
		System.out.print(game2.hashCode());
	}

}