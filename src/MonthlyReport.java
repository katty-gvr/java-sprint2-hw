import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<Data> dataFromFile;
    int month;
    public int getIncomeOfMonth() { // общие доходы по месяцу

        int income = 0;
        for (int i = 0; i < dataFromFile.size(); i++) {
            Data currentData = dataFromFile.get(i);
            if (!currentData.isExpense) {
                income += currentData.quantity * currentData.sumOfOne;
            }
        }
        return income;
    }
    public int getExpensesOfMonth() { // общие расходы по месяцу
        int expense = 0;
        for (int i = 0; i < dataFromFile.size(); i++) {
            Data currentData = dataFromFile.get(i);
            if (currentData.isExpense) {
                expense += currentData.quantity * currentData.sumOfOne;
            }
        }
        return expense;
    }

    public void findTheBestItem() { // поиск самого прибыльного товара
        int sum = 0;
        String name = "";
        for (int i = 0; i < dataFromFile.size(); i++) {
            Data currentData = dataFromFile.get(i);
            String currentName = currentData.itemName;
            int incomeOfItem = currentData.quantity * currentData.sumOfOne;
            if(!currentData.isExpense && incomeOfItem > sum) {
                sum = incomeOfItem;
                name = currentName;
            }
        }
        System.out.println("Самый прибыльный товар - " + name + ". Сумма " + sum + " руб.");
    }
    public void findTheBiggestExpense () { // поиск самой большой траты
        int expense = 0;
        String name = "";
        for (int i = 0; i < dataFromFile.size(); i++) {
            Data currentData = dataFromFile.get(i);
            String currentName = currentData.itemName;
            int expenseOfItem = currentData.quantity * currentData.sumOfOne;
            if(currentData.isExpense && expenseOfItem > expense) {
                expense = expenseOfItem;
                name = currentName;
            }
        }
        System.out.println("Самая большая трата - " + name + ". Сумма " + expense + " руб.");
    }
}




