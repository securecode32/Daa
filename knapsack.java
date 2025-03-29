//knapsack
import java.util.*;

 class FractionalKnapsackDemo {
    public static void main(String args[]) {
        Item items[] = {new Item(10, 60), new Item(20, 100), new Item(30, 120)};
        double tp = fractionalKnapsack(items, 50);
        System.out.println("Total Profit: " + tp);
    }

    public static double fractionalKnapsack(Item items[], int w) {
        double tprofit = 0.0;
        sortByProfitRatio(items);
        for (int i = 0; i < items.length; i++) {
            Item x = items[i];
            if (w == 0)
                return tprofit;
            else {
                if (x.weight <= w) {
                    tprofit += x.profit;
                    w -= x.weight;
                } else {
                    tprofit += (x.profit / (double) x.weight) * w;
                    w = 0;
                }
            }
        }
        return tprofit;
    }

    public static void sortByProfitRatio(Item items[]) {
        int i, j;
        Item temp;
        for (i = 0; i < items.length - 1; i++) {
            for (j = i + 1; j < items.length; j++) {
                double r1 = items[i].profit / (double) items[i].weight;
                double r2 = items[j].profit / (double) items[j].weight;
                if (r1 < r2) {
                    temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
    }
}
class Item {
    int weight;
    int profit;
    public Item(int w, int p) {
        weight = w;
        profit = p;
    }
}
knapsack