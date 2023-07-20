package work6.work2;

public class DocumentReportGenerator implements implReportGeneratorXML, implReportGeneratorJSON {

    @Override
    public String generateXml() {
        String report = "Отчет в XML";
        // todo Logic
        return report;
    }

    @Override
    public String generateJson() {
        String report = "Отчет в JSON";
        // todo Logic
        return report;
    }
}