import java.util.*;


public class StringTest {
	String st;
	
	public StringTest(String a) {
		st=a;
	}
	
	void reverse()
	{	
		String temp="";
		{
			int i=st.length()-1;
			while(i>=0){
				temp=temp + st.charAt(i);
				i--;
			}
		}
		st=temp;
	}
	
	void removeLast()
	{
		if( st.length()>0 ){
			st=st.substring(0, st.length()-1);
		}else{
			System.out.println("Empty string found");
		}
	}
	

	void removeFirst()
	{
		if( st.length()>0 ){
			st=st.substring(1, st.length());
		}else{
			System.out.println("Empty string found");
		}
	}
	
	void addLast(char ch)
	{
		st=st+ch;
	}
	
	void moveLastToFirst(){
		char temp=st.charAt(st.length()-1);
		this.removeLast();
		st=temp+st;
	}
	
	void toogle(){
		String temp="";
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)>=97 && st.charAt(i)<=122){ // small case
				temp =temp + (char)(st.charAt(i)  - 32);	
			}else if(st.charAt(i)>=65 && st.charAt(i)<=90){
				temp =temp +(char)(st.charAt(i)  + 32);
			}else{
				temp+=(char)(st.charAt(i));
			}
		}
		st=temp;
	}
	
	void increment(){
		String temp="";
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)=='z'){
				temp+=(char)('a');
			}else if(st.charAt(i)=='Z'){
				temp+=(char)('A');
			}
			else if((st.charAt(i)>=97 && st.charAt(i)<122) || (st.charAt(i)>=65 && st.charAt(i)<90)){
				temp =temp + (char)(st.charAt(i)  +1);	
			}else{
				temp+=(char)(st.charAt(i));
			}
		}
		st=temp;
	}
	
	void doubleString(){
		String temp="";
		for(int i=0;i<st.length();i++){
			temp=temp+st.charAt(i)+st.charAt(i);
		}
		st=temp;
	}
	
	void addHash(){
		st=st+'#'+st;
	}
	
	void interchange(){
		String temp="";
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)>=97 && st.charAt(i)<=122){
				temp+=(char)('z'-st.charAt(i)+'a');
			}else if(st.charAt(i)>=65 && st.charAt(i)<=90){
				temp+=(char)('Z'-st.charAt(i)+'A');
			}else{
				temp+=(char)(st.charAt(i));
			}
		}
		st=temp;
	}
	
	boolean checkPalindrome(){
		String cpy="";
		for(int i=st.length()-1;i>=0;i--){
			cpy+=st.charAt(i);
		}
		return cpy.contentEquals(st);
	}
	
	boolean empty(){
		return st.length()==0;
	}
	
	void toUpperCase(){
		String temp="";
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)>=97 && st.charAt(i)<=122){ // small case
				temp +=(char)(st.charAt(i)  - 32);
			}else{
				temp+=(char)(st.charAt(i));
			}
		}
		st=temp;
	}
	
	void toLowerCase(){
		String temp="";
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)>=65 && st.charAt(i)<=90){ // large case
				temp +=(char)(st.charAt(i)  + 32);
			}else{
				temp+=(char)(st.charAt(i));
			}
		}
		st=temp;
	}
	
	void addToFront(char ch){
		st=ch+st;
	}
	
	void clear(){
		st="";
	}
	
	void addSpace(){
		String temp="";
		String temp2="_";
		for(int i=0;i<st.length();i++){
			temp+=(st.charAt(i)+temp2);
		}
		st=temp;
	}
	
	boolean isInt(){
		boolean a=false;
		if( st==""){
			return false;
		}else if(st.charAt(0)=='-'){
			for (int i = 1; i < st.length(); i++) {
				if ((st.charAt(i)>=48) && (st.charAt(i)<=57)){
					a=true;
				}else{
					return false;
				}
			}
		}else{
			for (int i = 0; i < st.length(); i++) {
				if ((st.charAt(i)>=48) && (st.charAt(i)<=57)){
					a=true;
				}else{
					return false;
				}
			}
		}
		return a;
	}
	
	boolean isProperNoun(){
		boolean a=false;
		if( st==""){
			return false;
		}else if(st.charAt(0)>='A' && st.charAt(0)<='Z'  ){
			a=true;
		}
		return a;
	}
	
	boolean positive_float(String s,int begin){
		if(s==""){
			return false;
		}
		int start=findStart(s,begin);
		int end=findEnd(s);
		
		int dot=0,digit=0;
		for(int i=start;i<=end;i++){
			if(s.charAt(i)=='.'){
				dot++;
			}
			else if((s.charAt(i)>='0') && (s.charAt(i)<='9')){
				digit++;
			}
		}
		return dot<=1 && digit>0 && (dot+digit==end-start+1);
	}
	
	boolean isFloat(){
		if(st==""){
			return false;
		}
		int start=findStart(st,0);
		if(start==st.length()){
			return false;
		}
		if(st.charAt(start)=='-'){
			if(st.length()==start+1){
				
				return false;
			}
			else{
				return positive_float(st,start+1);
			}	
		}
		else{
			return positive_float(st,start);
		}
	}
	
	int findStart(String sa,int i){
		int start=i;
		while(start<sa.length() && sa.charAt(start)==' '){
			start++;
		};
		return start;
	}
	
	int findEnd(String sa){
		int end=sa.length()-1;
		while(end>=0 && sa.charAt(end)==' '){
			end--;
		};
		return end;
	}
	
	int getHashCode(){
		int prime=31;
		int h=0;
		int z=1;
		for(int i=st.length()-1;i>=0;i--){
			h+=st.charAt(i) * z;
			z=z*prime;
		}
		return h;
	}
	
	void sort(){
		char temp;
		String temp1="";
		char cpy[]=new char[st.length()];
		for(int i=0;i<st.length();i++){
			cpy[i]=st.charAt(i);
		}
		for(int i=0;i<st.length()-1;i++)
	    {
	    	for(int j=0;j<(st.length()-i-1);j++)
	        {
	        	if (cpy[j]> cpy[j+1])
	      		{
	         		temp=cpy[j];
	        		cpy[j]=cpy[j+1];
	        		cpy[j+1]=temp;
	      		}
	    	}
	  	}
		for(int i=0;i<st.length();i++){
			temp1+=cpy[i];
		}
		st=temp1;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringTest obj=new StringTest(new String("asdwezajkl"));
		System.out.println("COMMANDS:");
		System.out.println("\t 1.Reverse the string");
		System.out.println("\t 2.Remove last char");
		System.out.println("\t 3.Remove first char");
		System.out.println("\t 4.Add last char at first ");
		System.out.println("\t 5.Tongle String");
		System.out.println("\t 6.Char move by 1");
		System.out.println("\t 7.Double String");
		System.out.println("\t 8.Add String # string");
		System.out.println("\t 9.Interchange string");
		System.out.println("\t 10.Check Palindrome");
		System.out.println("\t 11.Empty");
		System.out.println("\t 12.To Uppercase");
		System.out.println("\t 13.To Lowercase ");
		System.out.println("\t 14.Add to Front");
		System.out.println("\t 15.Get hashcode");
		System.out.println("\t 16.Clear the String");
		System.out.println("\t 17.Add Space");
		System.out.println("\t 18.IS Int");
		System.out.println("\t 19.IS Proper Noun");
		System.out.println("\t 20.IS Float");
		System.out.println("\t 21.sort string");
		Scanner reader=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("\nenter option");
			String s=reader.nextLine();
//			System.err.println(s);
			if(s.equals("quit") || s.equals("")){
				System.exit(0);
			}else if(s.equals("1")){
				obj.reverse();
			}else if(s.equals("2")){
				obj.removeLast();
			}else if(s.equals("3")){
				obj.removeFirst();
			}else if( (s.charAt(0)>='a' && s.charAt(0)<='z') || (s.charAt(0)>='A' && s.charAt(0)<='Z')){
				obj.addLast(s.charAt(0));
			}else if(s.charAt(0)=='4'){
				obj.moveLastToFirst();
			}else if(s.charAt(0)=='5'){
				obj.toogle();
			}else if(s.charAt(0)=='6'){
				obj.increment();
			}else if(s.charAt(0)=='7'){
				obj.doubleString();
			}else if(s.charAt(0)=='8'){
				obj.addHash();
			}else if(s.charAt(0)=='9'){
				obj.interchange();
			}else if(s.equals("10")){
				boolean val=obj.checkPalindrome();
				if(val){
					System.out.println("this is palindrome");
				}else{
					System.out.println("this is not palindrome");					
				}
				
			}else if(s.equals("11")){
				if(obj.empty()){
					System.out.println("String is empty");
				}else{
					System.out.println("String is not empty");
				}
				
			}else if(s.equals("12")){
				obj.toUpperCase();
			}else if(s.equals("13")){
				obj.toLowerCase();
			}else if(s.equals("14")){
				System.out.println("Enter char");
				Scanner reader1=new Scanner(System.in);
				String a=reader1.next();
//				if( (a.charAt(0)>='a' && a.charAt(0)<='z') || (a.charAt(0)>='A' && a.charAt(0)<='Z'))
				obj.addToFront(a.charAt(0));
			}else if(s.equals("15")){
				System.out.println(obj.getHashCode());
			}else if(s.equals("16")){
				obj.clear();
			}else if(s.equals("17")){
				obj.addSpace();
			}else if(s.equals("18")){
				if(obj.isInt()){
					System.out.println("String is Int Type");
				}else{
					System.out.println("String is not Int Type");
				}
			}else if(s.equals("19")){
				if(obj.isProperNoun()){
					System.out.println("String is Proper Noun Type");
				}else{
					System.out.println("String is not Proper Noun Type");
				}
			}else if(s.equals("20")){
				if(obj.isFloat()){
					System.out.println("String is Float Type");
				}else{
					System.out.println("String is not Float Type");
				}
			}else if(s.equals("21")){
				obj.sort();
			}else{
				System.out.println("invalid input");
			}
			System.out.println("Final string : "+obj.st);
		}
	}

}
