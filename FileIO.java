import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/*********
 * @author Jamie Konigsberg
 * Dalton School
 * Goal: Complete File IO Spec
 * Date: 5/02/15
 * 
 * Some information gathered from: 
 * http://docs.oracle.com/javase/6/docs/api/java/util/Iterator.html 
 * 
 * 
 */

public class FileIO {

	public static void main(String[] args)
	{
		Path source = Paths.get("/Users/student/Downloads/all_students_jan.csv");
		try{
			BufferedReader bf = Files.newBufferedReader(source, StandardCharsets.UTF_8);
			Scanner file = new Scanner(bf);
			ArrayList<Student> people = new ArrayList<Student>();
			file.nextLine();
			while(file.hasNext())
			{
				String line = file.nextLine();
				people.add(new Student(line));
			}

			for(int i = 0; i<10000000; i++) {
				System.out.println();
				System.out.println("Hello! Welcome to BIG DALTON STUDENTS 2011!");
				System.out.println("If you would like:");
				System.out.println("To List a student by only last name with associated data: Type 1"); 
				System.out.println("All student with the same last name with same birthday (aka twins): Type 2");
				System.out.println("All students with same birth month: Type 3");
				System.out.println("All students in a specific House: Type 4"); 
				System.out.println("A sorted list of students by last name: Type 5");
				System.out.println("A report by gender (totals only): Type 6");
				System.out.println("The total number of students in Grade1 vs Grade2: Type 7"); 
				System.out.println("All students born in a specific year: Type 8"); 
				System.out.println("First name frequency (top 10) : Type 9");
				System.out.println("Students by grade: Type 10"); 
				System.out.println("A sorted list of students by first name: Type 11");
				System.out.println("All students that entered Dalton in a specific year: Type 12");
				System.out.println("Last name frequency (top 10) : Type 13");
				System.out.println("To Exit: Type 14");
				System.out.println();


				Scanner s = new Scanner(System.in);
				String request = s.nextLine();
				if(request.equals("1")) {
					request1(people);
				}
				else if(request.equals("2")) {
					request2(people);
				}
				else if(request.equals("3")) {
					request3(people);
				}
				else if(request.equals("4")) {
					request4(people);
				}
				else if(request.equals("5")) {
					request5(people);
				}
				else if(request.equals("6")) {
					request6(people);
				}
				else if(request.equals("7")) {
					request7(people);
				}	
				else if(request.equals("8")) {
					request8(people);
				}
				else if(request.equals("9")) {
					request9(people);
				}
				else if(request.equals("10")) {
					request10(people);
				}
				else if(request.equals("11")) {
					request11(people);
				}
				else if(request.equals("12")) {
					request12(people);
				}
				else if(request.equals("13")) {
					request13(people);
				}
				else if(request.equals("14")) {
					break; 
				}
				else System.out.println("Your input was invalid!");

			}
		}
		catch(FileNotFoundException f)
		{
			System.out.println("There was an error!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request1(ArrayList<Student> input)
	{
		System.out.println("Enter the last name of the person:");
		Scanner scan = new Scanner(System.in);
		String lastname = scan.nextLine();
		boolean check = false; 
		for(int i = 0; i< input.size(); i++)
		{
			if(lastname.equalsIgnoreCase(input.get(i).getln()))
			{
				check = true; 
				String person = 
						input.get(i).getfn() + ", " + 
								input.get(i).getmn() + ", " +
								input.get(i).getln() + ", " +
								input.get(i).getmf() + ", " + 
								input.get(i).getge() + ", " + 
								input.get(i).getcg() + ", " +
								input.get(i).getcy() + ", " +  
								input.get(i).getbday() + ", " + 
								input.get(i).getbmonth() + ", " +
								input.get(i).getbyr() + ", "  +
								input.get(i).getadvisor();

				try {
					File file = new File("//Users/student/Desktop/specificlastname.html");

					if (!file.exists()) 
					{
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file,true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(person + "<br>");
					bw.close();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if(check == false) 
		{
			System.out.println("That is not a last name in our database.");
		}
		else System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}

	public static void request2(ArrayList<Student> input)
	{
		boolean check = false;
		for(int i = 0; i<input.size(); i++)
		{
			for(int j = 0; j<input.size(); j++)
			{
				if((input.get(i).getln().equals(input.get(j).getln())) && (input.get(i).getbmonth().equals(input.get(j).getbmonth())) 
						&& (input.get(i).getbday() == input.get(j).getbday()) && (input.get(i).getbyr() == input.get(j).getbyr()) && (i!=j) && (i<j)) 
				{
					check = true;  
					String twin1 = 
							input.get(i).getfn() + ", " + 
									input.get(i).getmn() + ", " +
									input.get(i).getln() + ", " +
									input.get(i).getmf() + ", " + 
									input.get(i).getge() + ", " + 
									input.get(i).getcg() + ", " +
									input.get(i).getcy() + ", " +  
									input.get(i).getbday() + ", " + 
									input.get(i).getbmonth() + ", " +
									input.get(i).getbyr() + ", "  +
									input.get(i).getadvisor();
					try {
						File file = new File("//Users/student/Desktop/whoaredemtwins.html");
						
						if (!file.exists()) 
						{
							file.createNewFile();
						}

						FileWriter fw = new FileWriter(file,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(twin1 + "<br>");
						bw.close();
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					String twin2 =
							input.get(j).getfn() + ", " + 
									input.get(j).getmn() + ", " +
									input.get(j).getln() + ", " +
									input.get(j).getmf() + ", " + 
									input.get(j).getge() + ", " + 
									input.get(j).getcg() + ", " +
									input.get(j).getcy() + ", " +  
									input.get(j).getbday() + ", " + 
									input.get(j).getbmonth() + ", " +
									input.get(j).getbyr() + ", "  +
									input.get(j).getadvisor();

					try {
						File file = new File("//Users/student/Desktop/whoaredemtwins.html");

			
						if (!file.exists()) 
						{
							file.createNewFile();
						}

						FileWriter fw = new FileWriter(file,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(twin2 + "<br>");
						bw.close();
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		if(check == false) System.out.println("There are no twins in our database.");
		else System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}

	public static void request3(ArrayList<Student> input)
	{
		System.out.println("Enter a birthmonth (ex. 12 for December):");
		Scanner scan = new Scanner(System.in);
		String birthmonth = scan.nextLine();

		boolean check = false;
		for(int i = 0; i< input.size(); i++)
		{
			if(birthmonth.equals(input.get(i).getbmonth()))
			{
				check = true;
				String result = 
						input.get(i).getfn() + ", " + 
								input.get(i).getmn() + ", " +
								input.get(i).getln() + ", " +
								input.get(i).getmf() + ", " + 
								input.get(i).getge() + ", " + 
								input.get(i).getcg() + ", " +
								input.get(i).getcy() + ", " +  
								input.get(i).getbday() + ", " + 
								input.get(i).getbmonth() + ", " +
								input.get(i).getbyr() + ", "  +
								input.get(i).getadvisor();

				try {
					File file = new File("//Users/student/Desktop/birthdays.html");

					if (!file.exists()) 
					{
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file,true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(result + "<br>");
					bw.close();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if(check == false) System.out.println("No one has that birth month.");
		else System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}

	public static void request4(ArrayList<Student> input)
	{
		System.out.println("Enter a House Advisor (ex. Pamela Brighton or Steinlight/Nebres):");
		Scanner scan = new Scanner(System.in);
		String advisor = scan.nextLine();
		boolean check = false;
		for(int i = 0; i<input.size(); i++)
		{
			if(advisor.equalsIgnoreCase(input.get(i).getadvisor()))
			{
				check = true;
				String house = 
						input.get(i).getfn() + ", " + 
								input.get(i).getmn() + ", " +
								input.get(i).getln() + ", " +
								input.get(i).getmf() + ", " + 
								input.get(i).getge() + ", " + 
								input.get(i).getcg() + ", " +
								input.get(i).getcy() + ", " +  
								input.get(i).getbday() + ", " + 
								input.get(i).getbmonth() + ", " +
								input.get(i).getbyr() + ", "  +
								input.get(i).getadvisor();
				try {
					File file = new File("//Users/student/Desktop/certainhouse.html");

				
					if (!file.exists()) 
					{
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file,true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(house + "<br>");
					bw.close();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if(check == false) System.out.println("That is not a valid house.");
		else System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}

	public static void request5(ArrayList<Student> input) 
	{
		String[]lastnames = new String[931];	
		for(int i = 0; i<input.size();i++)
		{

			String dog = input.get(i).getln().substring(0, 1);
			dog = dog.toUpperCase();
			String cat = input.get(i).getln().substring(1, input.get(i).getln().length());

			lastnames[i] = dog + cat + ", " + input.get(i).getmn() + ", " + input.get(i).getfn() + ", " 
					+ input.get(i).getmf() + ", " + 
					input.get(i).getge() + ", " + 
					input.get(i).getcg() + ", " +
					input.get(i).getcy() + ", " +  
					input.get(i).getbday() + ", " + 
					input.get(i).getbmonth() + ", " +
					input.get(i).getbyr() + ", "  +
					input.get(i).getadvisor() ;

		}
		Arrays.sort(lastnames);
		try {
			File file = new File("//Users/student/Desktop/lastnamesoutput.html");

			if (!file.exists()) 
			{
				file.createNewFile();
			}

			for(int i = 0; i< lastnames.length; i++)
			{
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(lastnames[i] + "<br>");
				bw.close();
			}

			System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void request6(ArrayList<Student> input)
	{
		System.out.println("Enter either M for males or F for females:");
		Scanner scan = new Scanner(System.in);
		String sex = scan.nextLine();
		boolean check = false;
		int tally = 0; 
		for(int i = 0; i < input.size(); i++)
		{
			if(sex.equalsIgnoreCase(input.get(i).getmf()))
			{
				check = true;
				tally++; 
			}
		}
		if(check == false) System.out.println("That is not a valid sex code.");
		else if(sex.equals("M")) {

			try {
				File file = new File("//Users/student/Desktop/sexcode.html");

				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("There are " + tally + " males in the school." + "<br>");
				bw.close();

				System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if(sex.equals("F")) 
		{
			try {
				File file = new File("//Users/student/Desktop/sexcode.html");

				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("There are " + tally + " females in the school." + "<br>");
				bw.close();

				System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void request7(ArrayList<Student> input)
	{
		System.out.println("Enter the first grade you want (4th-12th Grade: Ex. for 4th grade type 4):");
		Scanner scan = new Scanner(System.in);
		String grade1 = scan.nextLine();
		System.out.println("Enter the second grade you want (4th-12th Grade: Ex. for 4th grade type 4):");
		String grade2 = scan.nextLine();	
		int grade1tally = 0;
		int grade2tally = 0;
		boolean check1 = false;
		boolean check2 = false;

		for(int i = 0; i < input.size(); i++)
		{

			if(grade1.equalsIgnoreCase(input.get(i).getcg()))
			{
				check1 = true;
				grade1tally++;
			}
			else if(grade2.equalsIgnoreCase(input.get(i).getcg()))
			{
				check2 = true;
				grade2tally++;
			}
		}

		if(check1 == false || check2 == false)
		{
			System.out.println("One or both of those grades was not a valid input.");
		}
		else {

			try {
				File file = new File("//Users/student/Desktop/gradetallys.html");
				
				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Grade " + grade1 + " has " + grade1tally + " students. Grade " + grade2 + " has " + grade2tally + " students." + "<br>");
				bw.close();

				System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	public static void request8(ArrayList<Student> input)
	{
		System.out.println("Which birthyear do you want?");
		Scanner scan = new Scanner(System.in);
		int birthyear = scan.nextInt();
		boolean check = false; 
		for(int i = 0; i < input.size(); i++)
		{
			if(birthyear == (input.get(i).getbyr()))
			{
				check = true; 
				String birthyeardata = 
						input.get(i).getbyr() + ", "  +
								input.get(i).getfn() + ", " + 
								input.get(i).getmn() + ", " +
								input.get(i).getln() + ", " +
								input.get(i).getmf() + ", " + 
								input.get(i).getge() + ", " + 
								input.get(i).getcg() + ", " +
								input.get(i).getcy() + ", " +  
								input.get(i).getbday() + ", " + 
								input.get(i).getbmonth() + ", " +
								input.get(i).getadvisor();

				try {
					File file = new File("//Users/student/Desktop/birthyear.html");

					if (!file.exists()) 
					{
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file,true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(birthyeardata + "<br>");
					bw.close();

				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(check == false) System.out.println("No one was born in that year.");
		else System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");

	}

	public static void request9(ArrayList<Student> input) 
	{

		ArrayList<String> first_name = new ArrayList<String>();
		ArrayList<Integer> freq = new ArrayList<Integer>();
		boolean checker = false; 
		Iterator<Student> iterator = input.iterator(); 
		Student student;
		while(iterator.hasNext())
		{
			student = iterator.next(); 
			for(int i= 0; i< first_name.size(); i++){
				if(student.fn.equals(first_name.get(i))){
					freq.set(i, freq.get(i) +1);
					checker = true;
				}
			}

			if(checker == false){
				first_name.add(student.fn);
				freq.add(1); 
			}
			checker = false; 
		}
		String tempfirstname; 
		int tempfreq; 
		for(int q = 0; q<first_name.size()-1; q++){
			for(int r = 0; r<first_name.size()-1; r++){
				if(freq.get(r) < freq.get(r+1)){
					tempfirstname = first_name.get(r);
					tempfreq = freq.get(r);

					first_name.set(r, first_name.get(r+1));
					freq.set(r, freq.get(r+1));

					first_name.set(r+1, tempfirstname);
					freq.set(r+1, tempfreq);
				}
			}
		}
		for(int i = 0; i<10;i++){
			try {
				File file = new File("//Users/student/Desktop/top10firstnames.html");

				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("There are " + freq.get(i) + " students named " + first_name.get(i) + "." + "<br>");
				bw.close();

			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}

	public static void request10(ArrayList<Student> input) 
	{
		for(int grade = 4; grade <13; grade++)
		{
			String current_grade = "" + grade;
			for(int i = 0; i<input.size(); i++)
			{
				if(input.get(i).getcg().equals(current_grade))
				{
					String currentgradio =
							input.get(i).getcg() + ", " +
									input.get(i).getfn() + ", " + 
									input.get(i).getmn() + ", " +
									input.get(i).getln() + ", " +
									input.get(i).getmf() + ", " + 
									input.get(i).getge() + ", " + 
									input.get(i).getcy() + ", " +  
									input.get(i).getbday() + ", " + 
									input.get(i).getbmonth() + ", " +
									input.get(i).getbyr() + ", "  +
									input.get(i).getadvisor();	

					try {
						File file = new File("//Users/student/Desktop/currentgrade.html");
						
						if (!file.exists()) 
						{
							file.createNewFile();
						}

						FileWriter fw = new FileWriter(file,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(currentgradio + "<br>");
						bw.close();

					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
		}
		System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}	

	public static void request11(ArrayList<Student> input)
	{
		String[]firstnames = new String[931];
		for(int i = 0; i<input.size();i++)
		{
			firstnames[i] = input.get(i).getfn() + ", " + input.get(i).getmn() + ", " + input.get(i).getln() + ", " + input.get(i).getmf() + ", " + 
					input.get(i).getge() + ", " + 
					input.get(i).getcg() + ", " +
					input.get(i).getcy() + ", " +  
					input.get(i).getbday() + ", " + 
					input.get(i).getbmonth() + ", " +
					input.get(i).getbyr() + ", "  +
					input.get(i).getadvisor();

		}
		Arrays.sort(firstnames);

		try {
			File file = new File("//Users/student/Desktop/firstnamesoutput.html");

			if (!file.exists()) 
			{
				file.createNewFile();
			}
			for(int i = 0; i< firstnames.length; i++)
			{
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(firstnames[i] + "<br>");
				bw.close();
			}


			System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
		}


		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void request12(ArrayList<Student> input)
	{
		System.out.println("Which grade do you want to know about? (ex. type K for Kindergarten or 4 for 4th Grade)");
		boolean check = false;
		Scanner scan = new Scanner(System.in);
		String grade_entered = scan.nextLine();
		for(int i = 0; i < input.size(); i++)
		{
			if(grade_entered.equals(input.get(i).getge()))
			{
				check = true;
				String answer = 
						input.get(i).getge() + ", " +
								input.get(i).getfn() + ", " + 
								input.get(i).getmn() + ", " +
								input.get(i).getln() + ", " +
								input.get(i).getmf() + ", " + 
								input.get(i).getcg() + ", " + 
								input.get(i).getcy() + ", " +  
								input.get(i).getbday() + ", " + 
								input.get(i).getbmonth() + ", " +
								input.get(i).getbyr() + ", "  +
								input.get(i).getadvisor();		
				try {

					File file = new File("//Users/student/Desktop/whoentereddalton.html");
					
					if (!file.exists()) 
					{
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file,true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(answer + "<br>");
					bw.close();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
		if(check == false) System.out.println("No one entered Dalton in that grade.");	
		else System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}

	public static void request13(ArrayList<Student> input)
	{
		ArrayList<String> last_name = new ArrayList<String>();
		ArrayList<Integer> freq = new ArrayList<Integer>();
		boolean checker = false; 
		Iterator<Student> iterator = input.iterator(); 
		Student student;
		while(iterator.hasNext())
		{
			student = iterator.next(); 
			for(int i= 0; i< last_name.size(); i++){
				if(student.ln.equals(last_name.get(i))){
					freq.set(i, freq.get(i) +1);
					checker = true;
				}
			}

			if(checker == false){
				last_name.add(student.ln);
				freq.add(1); 
			}
			checker = false; 
		}
		String templastname; 
		int tempfreq; 
		for(int q = 0; q<last_name.size()-1; q++){
			for(int r = 0; r<last_name.size()-1; r++){
				if(freq.get(r) < freq.get(r+1)){
					templastname = last_name.get(r);
					tempfreq = freq.get(r);

					last_name.set(r, last_name.get(r+1));
					freq.set(r, freq.get(r+1));

					last_name.set(r+1, templastname);
					freq.set(r+1, tempfreq);
				}
			}
		}
		for(int i = 0; i<10;i++){

			try {
				File file = new File("//Users/student/Desktop/top10lastnames.html");
				
				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("There are " + freq.get(i) + " students named " + last_name.get(i) + "." + "<br>");
				bw.close();

			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println("Done. The file is on the desktop. When you finish viewing the data, please drag it to the trash before inputing your next function.");
	}
}


