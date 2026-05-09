public class Dashboard {
    public void displayReport(JSONReportProvider provider) {
        String json = provider.getReportJSON();
        System.out.println(json);
    }
}
