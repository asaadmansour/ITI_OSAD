public class Main {
    public static void main(String[] args) {
        ReportService reportService = new ReportService();
        ReportAdapter reportAdapter = new ReportAdapter(reportService);
        Dashboard dashboard = new Dashboard();
        dashboard.displayReport(reportAdapter);
    }
}
