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

import java.io.*;
import java.util.*;

public interface QuoteProvider {
    public String getQuote() throws IOException;

    public List<String> getHistory() throws IOException;

    public void clearHistory() throws IOException;
}