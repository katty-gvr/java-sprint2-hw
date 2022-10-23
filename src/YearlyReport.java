import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearData> yearData;
    public int getIncomeOfMonthInYearReport(int monthNumber) { // общие доходы по каждому месяцу из годового отчета

        int income = 0;
        for (int i = 0; i < yearData.size(); i++) {
            YearData currentData = yearData.get(i);
            if (currentData.month == monthNumber && !currentData.isExpense) {
                income += currentData.amount;
            }
        }
        return income;
    }
    public int getExpensesOfMonthInYearReport(int monthNumber) { // общие расходы по каждому месяцу из годового отчета

        int expense = 0;
        for (int i = 0; i < yearData.size(); i++) {
            YearData currentData = yearData.get(i);
            if (currentData.month == monthNumber && currentData.isExpense) {
                expense += currentData.amount;
            }
        }
        return expense;
    }

    public int getProfitOfMonthInYearReport(int monthNumber) { // прибыль по каждому месяцу
        return getIncomeOfMonthInYearReport(monthNumber) - getExpensesOfMonthInYearReport(monthNumber);
    }
   public int getAverageYearExpense() { // средний расход за год
        int sumOfExpenses = 0;
        int quantityOfExpenses = 0;
        for (int i = 0; i < yearData.size(); i++) {
            YearData currentData = yearData.get(i);
            if (currentData.isExpense) {
                quantityOfExpenses++;
                sumOfExpenses += currentData.amount;
            }
        }
        return sumOfExpenses / quantityOfExpenses;
    }
    public int getAverageYearIncome() { // средний доход за год
        int sumOfIncome = 0;
        int quantityOfIncome = 0;
        for (int i = 0; i < yearData.size(); i++) {
            YearData currentData = yearData.get(i);
            if (!currentData.isExpense) {
                quantityOfIncome++;
                sumOfIncome += currentData.amount;
            }
        }
        return sumOfIncome / quantityOfIncome;
    }

}


