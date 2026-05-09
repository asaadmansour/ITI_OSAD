public class ReportAdapter implements JSONReportProvider {
    private final ReportService reportService;

    public ReportAdapter(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String getReportJSON() {
        String csv = reportService.getReport();
        return  convertCSVtoJSON(csv);
    }
    private String convertCSVtoJSON(String csv) {
        return "{\"users\": [{\"name\":\"John\",\"age\":30}]}";
    }
}
