// LeetCode 1472 - Design Browser History
// Java focus: constructor, this keyword, ArrayList, method arguments and returns
import java.util.ArrayList;
import java.util.List;

class LC1472_DesignBrowserHistory {
    private final List<String> history;
    private int current;

    public LC1472_DesignBrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.current = 0;
    }

    public void visit(String url) {
        // Remove forward history before adding a new page.
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        current++;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }

    public static void main(String[] args) {
        LC1472_DesignBrowserHistory browser =
                new LC1472_DesignBrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        System.out.println(browser.back(1));    // facebook.com
        System.out.println(browser.back(1));    // google.com
        System.out.println(browser.forward(1)); // facebook.com
    }
}
