import java.util.Scanner;


public class SUBMISSION {
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in); 
		String[] input = s.nextLine().split(", ");	
		int i = 0;
		for(int j = 0; j<5; j++)
		{
			if(i ==0) {
				System.out.println("Hello");
				i++;
			}
			if(i==1) {
				System.out.println("William");
				i++;
			}
			if(i==2) {
				System.out.println("I think");
				i++;
			}
			if(i==3) {
				System.out.println("I need my");
				i++;
			}
			if(i == 4) {
				System.out.println("22nd Lab!");
				i++;
			}
		}
	}

	public static String combine(String [] binaryinputarray)
	{
		String[] simplified = new String[binaryinputarray.length*binaryinputarray.length-1]; 
		for(int i =0; i <binaryinputarray.length; i++)
		{
			for(int j =0; j<binaryinputarray.length; j++)
			{
				if(j>i)
				{
					boolean check = true;
					int whereami=0; 
					int numberofones1 = 0;
					int numberofones2 = 0;
					int placeswrong = 0;	
					for(int k = 0; k<binaryinputarray[i].length(); k++)
					{
						if(binaryinputarray[i].charAt(k) == '1')
						{
							numberofones1++;
						}
						if(binaryinputarray[j].charAt(k) == '1')
						{
							numberofones2++;
						}
						if(binaryinputarray[i].charAt(k) != binaryinputarray[j].charAt(k)) placeswrong++;
						if((binaryinputarray[i].charAt(k) == 'x' && binaryinputarray[j].charAt(k) != 'x') || 
								(binaryinputarray[j].charAt(k) == 'x' && binaryinputarray[i].charAt(k) != 'x'))
							check = false;
					}
					if((numberofones1-numberofones2)<(-2)&&(numberofones1-numberofones2)>2) check = false; 
					if(placeswrong>1) check = false; 
					if(check = true)
					{
						for(int k = 0; k<binaryinputarray[i].length(); k++)
						{
							if(binaryinputarray[i].charAt(k) == 120 && binaryinputarray[j].charAt(k) == 120 
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								
							}
							else if(binaryinputarray[i].charAt(k) == 48 && binaryinputarray[j].charAt(k) == 48
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								
							}
							else if(binaryinputarray[i].charAt(k) == 49 && binaryinputarray[j].charAt(k) == 49
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								
							}
							else if((binaryinputarray[i].charAt(k) == 49 && binaryinputarray[j].charAt(k) == 48)
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								
							}
							else if((binaryinputarray[i].charAt(k) == 48 && binaryinputarray[j].charAt(k) == 49)
									&& binaryinputarray[j].charAt(k) != 0 && binaryinputarray[i].charAt(k) != 0)
							{
								
							}
						}
					}
				}
			}	
		}
		return null;
	}
}




