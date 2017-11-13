package ru.edhunter.independent_seatwork.gof_patterns.chain.chain;

public class BugTrackerRunner {
    public static void main(String[] args) {
        Notifier report = new ReportNotifier(Priority.ROUTINE);
        Notifier mailReport = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsReport = new SmsNotifier(Priority.ASAP);

        report.setNextNotifier(mailReport);
        mailReport.setNextNotifier(smsReport);

        report.notifyManager("Everuthing ok", Priority.ROUTINE);
        report.notifyManager("Something wrong", Priority.IMPORTANT);
        report.notifyManager("Bad news", Priority.ASAP);
    }
}
