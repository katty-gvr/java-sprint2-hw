import java.util.ArrayList;

public class DataComparing {

    public void compareMonthlyAndYearReports(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
        checkIncome(yearlyReport, monthlyReports);
        checkExpenses(yearlyReport, monthlyReports);
    }

    // сверка доходов
   public void checkIncome(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
       for (int i = 0; i < monthlyReports.size(); i++) {
           MonthlyReport currentMonthReport = monthlyReports.get(i);
            int monthIncome = currentMonthReport.getIncomeOfMonth();
            int yearIncome = yearlyReport.getIncomeOfMonthInYearReport(currentMonthReport.month);
            if(monthIncome != yearIncome) {
                System.out.println("Обнаружена ошибка при сверке доходов в месяце " + currentMonthReport.month);
            }
        }
    }
    // сверка расходов
    public void checkExpenses(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
        for (int i = 0; i < monthlyReports.size(); i++) {
            MonthlyReport currentMonthReport = monthlyReports.get(i);
            int monthExpense = currentMonthReport.getExpensesOfMonth();
            int yearExpense = yearlyReport.getExpensesOfMonthInYearReport(currentMonthReport.month);
            if(monthExpense != yearExpense) {
                System.out.println("Обнаружена ошибка при сверке расходов в месяце " + currentMonthReport.month);
            }
        }
    }

}






