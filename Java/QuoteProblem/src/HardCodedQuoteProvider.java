/*Assignment 4:
Create a class diagram and Java code for the following system and scenario, taking into account the possibility of
future extensions. "The system is a command line utility that prints a short 'quote of the day' on the user's terminal
when run. To begin with the quote is selected randomly from a set of hard-coded strings within the program itself,
but that might change later on -- the quotes might be based on the user's history, the time of day, the date, etc..
Scenario
1. User types "java QuoteOfTheDay" on the command line.
2. System prints out a quote of the day, with an attribution.
Examples:
> javac QuoteOfTheDay
God helps them that help themselves. -- Benjamin Franklin
> javac QuoteOfTheDay
Happiness is not a reward - it is consequence. Suffering is not a punishment - it is a result. -- Robert Green
Ingersoll
> javac QuoteOfTheDay
Future. That period of time in which our affairs prosper, our friends are true and our happiness is assured. --
Ambrose Bierce
> javac QuoteOfTheDay
Honesty is the first chapter of the book of wisdom. --Thomas Jefferson
Note:
● user's history: within a fixed time duration it will not print any similar type of quote (considering different
execution)
● the time of day: morning, noon evening , night
● the date: on 15th August -- Independence day, 5th September -- Teachers’ day*/

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HardCodedQuoteProvider implements QuoteProvider {

    // quotes to be used if the time is A.M.
    private final String[] AM_QUOTES = { "Be yourself; everyone else is already taken.― Oscar Wilde",
            "A room without books is like a body without a soul. ― Marcus Tullius Cicero",
            "Be the change that you wish to see in the world. ― Mahatma Gandhi",
            "If you tell the truth, you don't have to remember anything. ― Mark Twain",
            "If you want to know what a man's like, take a good look at how he treats his inferiors, not his equals.― J.K. Rowling",
            "To live is the rarest thing in the world. Most people exist, that is all.― Oscar Wilde" };

    // quotes to be used if the time is P.M.
    private final String[] PM_QUOTES = { "Without music, life would be a mistake. ― Friedrich Nietzsche",
            "Always forgive your enemies, nothing annoys them so much. ― Oscar Wilde",
            "Life isn't about getting and having, it's about giving and being. –Kevin Kruse",
            "Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill",
            "Strive not to be a success, but rather to be of value. –Albert Einstein" };

    // the time when a quote was last used is stored in the file
    // the value is 0 if the quote was previously not used
    private Path historyPath = Paths.get("history.txt");
    private long[] lastUsedAM = new long[AM_QUOTES.length];
    private long[] lastUsedPM = new long[PM_QUOTES.length];

    public HardCodedQuoteProvider() throws IOException {
        // history has to be read from the history file to intialize the lastUsed arrays
        readHistory();
    }

    public String getQuote() throws IOException {
        String[] QUOTES;
        long[] lastUsed;
        if (!isPM()) {
            QUOTES = AM_QUOTES;
            lastUsed = lastUsedAM;
        } else {
            QUOTES = PM_QUOTES;
            lastUsed = lastUsedPM;
        }
        String quote;
        while (true) {
            int index = ThreadLocalRandom.current().nextInt(0, QUOTES.length - 1);
            if (lastUsed[index] == 0) {
                lastUsed[index] = System.currentTimeMillis();
                quote = QUOTES[index];
                break;
            }
        }
        writeHistory();
        return new String(quote);
    }

    private void readHistory() throws IOException {
        if (Files.exists(historyPath)) {
            List<String> lines = Files.readAllLines(historyPath, Charset.defaultCharset());
            int i = 0;
            for (String line : lines) {
                Long time = Long.parseLong(line);
                if (i < lastUsedAM.length) {
                    lastUsedAM[i] = time;
                } else {
                    lastUsedPM[i - lastUsedAM.length] = time;
                }
                i++;
            }
        }
    }

    private void writeHistory() throws IOException {
        try {
            Files.createFile(historyPath);
        } catch (FileAlreadyExistsException e) {
        }
        List<String> lines = new ArrayList<>();
        for (long time : lastUsedAM) {
            lines.add(Long.toString(time));
        }
        for (long time : lastUsedPM) {
            lines.add(Long.toString(time));
        }
        Files.write(historyPath, lines, Charset.defaultCharset());
    }

    public void clearHistory() throws IOException {
        Arrays.fill(lastUsedAM, 0);
        Arrays.fill(lastUsedPM, 0);
        writeHistory();
    }

    public List<String> getHistory() {
        List<String> history = new ArrayList<>();
        history.addAll(getHistoryFromArrays(AM_QUOTES, lastUsedAM));
        history.addAll(getHistoryFromArrays(PM_QUOTES, lastUsedPM));
        return history;
    }

    private List<String> getHistoryFromArrays(String[] QUOTES, long[] lastUsed) {
        List<String> history = new ArrayList<>();
        for (int i = 0; i < QUOTES.length; i++) {
            if (lastUsed[i] != 0) {
                String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(lastUsed[i]));
                history.add(QUOTES[i] + " " + timestamp);
            }
        }
        return history;
    }

    private boolean isPM() {
        String currentTimeStamp = getCurrentTimeStamp();
        return currentTimeStamp.substring(currentTimeStamp.length() - 2).equals("PM");
    }

    private String getCurrentTimeStamp() {
        return new SimpleDateFormat("h:mm a").format(new Date());
    }
}