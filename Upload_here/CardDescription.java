//importing nessesary modules
import java.util.Scanner;
    public class CardDescription {
// Driver code
    public static void main(String[] args) {
// Creating scanner for taking user input
        Scanner sc=new Scanner(System.in);
// prints greeting
    System.out.println("Welcome!");
    System.out.print("Enter the Card Notation: ");
// taking user input
        String card=sc.next();
// iterating loop with string length
        for(int i=0;i<card.length();i++){
// Apply condition
        if(card.charAt(i)=='A'){
System.out.print("Ace");
// condition used to print " of " 
        if(i==0){
        System.out.print(" of ");
    }
    }
    else if(card.charAt(i)=='2'){
        System.out.print("2");
    if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='3'){
System.out.print("3");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='4'){
System.out.print("4");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='5'){
System.out.print("5");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='6'){
System.out.print("6");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='7'){
System.out.print("7");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='8'){
System.out.print("8");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='9'){
System.out.print("9");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='1'&& card.charAt(i+1)=='0'){
System.out.print("10");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='J'){
System.out.print("Jack");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='Q'){
System.out.print("Queen");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='K'){
System.out.print("King");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='D'){
System.out.print("Diamonds");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='H'){
System.out.print("Hearts");
        if(i==0){
System.out.print(" of ");
}
}
        else if(card.charAt(i)=='S'){
    System.out.print("Spades");
        if(i==0){
    System.out.print(" of ");
}
}
    else if(card.charAt(i)=='C'){
    System.out.print("Clubs");
if(i==0){
    System.out.print(" of ");
}
}
// if characters don't match
else {
    System.out.print(" Invalid! ");
}

}
}
}