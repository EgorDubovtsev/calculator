package service;

import exceptions.IllegalOperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    private ParsingService parsingService = new ParsingService();
    private String unparsedLine;

    public ValidationService(String unparsedLine) {
        this.unparsedLine = unparsedLine;
    }

    public void validate() throws IllegalOperation {
        Pattern patternSpace = Pattern.compile("\\s+");
        Matcher matcherSpace = patternSpace.matcher(unparsedLine);
        if (matcherSpace.find()) {
            unparsedLine = matcherSpace.replaceAll(" ");
        }
        parsingService.parse(unparsedLine);
    }
}