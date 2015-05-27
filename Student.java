	public class Student{
		String fn;
		String mn;
		String ln; 
		String mf;
		String ge;
		String cg;
		int cy; 
		int bday;
		String bmonth;
		int byr;
		String advisor; 


		public Student (String input) {
			String [] data = input.split(","); 
			fn = data[0];
			mn = data[1];
			ln = data[2];
			mf = data[3];
			ge = data[4];
			cg = data[5];
			cy = Integer.parseInt(data[6]);
			bday = Integer.parseInt(data[7]);
			bmonth = data[8];
			byr = Integer.parseInt(data[9]);
			advisor = data[10];
		}

		public String getfn() {
			return fn;
		}
		
		public void setfn(String fn)
		{
			this.fn = fn; 
		}
		
		public String getmn() {
			return mn;
		}
		
		public void setmn(String mn)
		{
			this.mn = mn; 
		}

		public String getln() {
			return ln;
		}

		public void setln(String ln)
		{
			this.ln = ln; 
		}
		
		public String getmf() {
			return mf;
		}
		
		public void setmf(String mf)
		{
			this.mf = mf; 
		}

		public String getge() {
			return ge;
		}

		public void setge(String ge)
		{
			this.ge = ge; 
		}

		public String getcg() {
			return cg;
		}
		
		public void setcg(String cg)
		{
			this.cg = cg;
		}

		public int getcy() {
			return cy;
		}
		
		public void setcy(int cy)
		{
			this.cy = cy;
		}
		
		public int getbday() {
			return bday;
		}
		
		public void setbday(int bday)
		{
			this.bday = bday;
		}
		
		public String getbmonth() {
			return bmonth;
		}
	
		public void setbmonth(String bmonth)
		{
			this.bmonth = bmonth;
		}
		
		public int getbyr() {
			return byr;
		}

		public void setbyr(int byr)
		{
			this.byr = byr;
		}
		
		public String getadvisor() {
			return advisor;
		}
		
		public void setadvisor(String advisor)
		{
			this.advisor = advisor;
		}
	}

