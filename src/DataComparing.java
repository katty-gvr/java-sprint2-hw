import java.util.ArrayList;

public class DataComparing {

    public void compareMonthlyAndYearReports(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
        checkReports(yearlyReport, monthlyReports);
        checkIncome(yearlyReport, monthlyReports);
        checkExpenses(yearlyReport, monthlyReports);
    }

    // проверка отчетов на факт считывания
    public void checkReports(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
        if (monthlyReports == null || yearlyReport == null) {
            System.out.println("Перед сверкой отчета сначала нужно их считать!");
        }
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






