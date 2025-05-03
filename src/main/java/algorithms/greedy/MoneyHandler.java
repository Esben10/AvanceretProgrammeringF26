package algorithms.greedy;

public class MoneyHandler {

    public static void main(String[] args) {
        // standard bills
        System.out.println("Udbetaling med 50, 100, 500, 1000 og 5000 kr-bills:");
        int[] bills = {5000, 2000, 1000, 500, 100, 50};
        greedyChange(bills, 1200);
        greedyChange(bills, 1300);
        greedyChange(bills, 1800);

        // 600 kr introduceres
        System.out.println("600 kr-seddel introduceres:");
        int[] moreBills = {5000, 2000, 1000, 600, 500, 100, 50};
        greedyChange(moreBills, 1200);
        greedyChange(moreBills, 1300);
        greedyChange(moreBills, 1800);

    }

    public static void greedyChange(int[] bills, int amount) {
        System.out.println("Beløb: " + amount);
        for (int bill : bills) {
            int noOfBills = amount / bill;
            if (noOfBills > 0) {
                System.out.println(noOfBills + " x " + bill + " kr");
                amount -= noOfBills * bill;
            }
        }
        if (amount > 0) {
            System.out.println("Rest tilbage: " + amount + " kr");
        }
    }


}
