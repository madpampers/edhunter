package ru.edhunter.independent_seatwork.gof_patterns.chain.chain;

public class ReportNotifier extends Notifier {
    public ReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("simple report" + message);
    }
}
