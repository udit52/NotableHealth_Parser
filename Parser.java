import java.util.Scanner;

public class Parser {
    public static void main(String args[]){
        String text = "";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Text: ");
        text=sc.nextLine();
        String final_text = parse(text);

        System.out.println(final_text);
    }

    public static String parse(String s){
        String[] str=s.split(" ");
        String res="";
        boolean flag=false;
        boolean caps=false;
        int ctr=0;
        for(int i=0;i<str.length;++i) {
            if (flag == false) {
                if (str[i].equals("Number") && i+1<str.length && getNumber(str[i+1])!=0){
                    ctr = getNumber(str[i+1]);
                    flag=true;
                    res+= "\n";
                    res += ctr+". ";
                    i++;
                    caps=true;
                }else{
                    if(caps==true){
                        res+= firstLetterCaps(str[i])+" ";
                        caps=false;
                    }
                    else
                        res += str[i]+" ";
                }
            }
            else{
                if (str[i].equals("Number") && i+1<str.length && str[i+1].equalsIgnoreCase("next")){
                    ctr++;
                    res+= "\n";
                    res += ctr+". ";
                    i++;
                    caps=true;
                }
                else{
                    if(caps==true){
                        res+= firstLetterCaps(str[i])+" ";
                        caps=false;
                    }
                    else
                        res += str[i]+" ";
                }
            }
        }
        return res;
    }

    public static int getNumber(String num){
        int n=0;
        if(num.equalsIgnoreCase("one"))
            n=1;
        else if(num.equalsIgnoreCase("two"))
            n=2;
        else if(num.equalsIgnoreCase("three"))
            n=3;
        else if(num.equalsIgnoreCase("four"))
            n=4;
        else if(num.equalsIgnoreCase("five"))
            n=5;
        else if(num.equalsIgnoreCase("six"))
            n=6;
        else if(num.equalsIgnoreCase("seven"))
            n=7;
        else if(num.equalsIgnoreCase("eight"))
            n=8;
        else if(num.equalsIgnoreCase("nine"))
            n=9;
        return n;
    }

    public static String firstLetterCaps(String s){
        String r="";
        if(s.length()>0)
            r += Character.toUpperCase(s.charAt(0))+s.substring(1,s.length());
        return r;
    }
}
