import java.util.ArrayList;

public class ReportBase {

    ArrayList<Data> report = new ArrayList<>();
    ArrayList<MonthlyReport> reports = new ArrayList<>();
    YearlyReport yearlyReport = new YearlyReport();


    public ArrayList<MonthlyReport> getReportsForAllMonths() { // считывание всех месячных отчетов
        int monthNumber = 1;
        for (int i = 1; i <= 3; i++) {
            MonthlyReport monthlyReport = new MonthlyReport();
            monthlyReport.dataFromFile = getMonthlyReport("resources/m.20210" + i + ".csv");
            monthlyReport.month = monthNumber++;
            reports.add(monthlyReport);
        }
        return reports;
    }
    public ArrayList<Data> getMonthlyReport(String path) { // считывание одного месячного отчета

        String fileContents = ReadingFiles.readFileContentsOrNull(path); // прочитали файл

        String[] lines = fileContents.split("\\n"); // разделили построчно
        ArrayList<Data> dataArray = new ArrayList<>(); // создали лист для возврата с объектами файла

        for (int i = 1; i < lines.length; i++) {

            String[] lineContents = lines[i].split(","); // c помощью цикла разделили строчки по запятым и записали в массив

            String itemName = lineContents[0];
            int quantity = Integer.parseInt(lineContents[2]);
            int sumOfOne = Integer.parseInt(lineContents[3]);
            boolean isExpense = Boolean.parseBoolean(lineContents[1]);

            Data data = new Data(); // создали экземляр класса дата
            data.itemName = itemName;
            data.isExpense = isExpense;
            data.quantity = quantity;
            data.sumOfOne = sumOfOne;

            dataArray.add(data);
        }
        return dataArray;
    }
    public ArrayList<YearData> readYearlyReport(String path) { // считывание годового отчета

        String fileContents = ReadingFiles.readFileContentsOrNull(path);
        String[] lines = fileContents.split("\\n"); // разделили построчно
        ArrayList<YearData> yearDataArray = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {

            String[] lineContents = lines[i].split(",");
            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);

            YearData yearData = new YearData();
            yearData.month = month;
            yearData.amount = amount;
            yearData.isExpense = isExpense;

            yearDataArray.add(yearData);

        }
        return yearDataArray;
    }
    public YearlyReport getYearlyReport() { // получение годового отчета

        YearlyReport yearlyReport = new YearlyReport();
        yearlyReport.yearData = readYearlyReport("resources/y.2021.csv");

        return yearlyReport;
    }
}








