package interfaces;

import java.util.List;

public interface HistActions {
    List<String> getHistory();
    void showHistory();
    void clearHistory();
}
