package tn.esprit.propnetapp.features.inputvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static InputValidator inputValidator;
    private String getRegexByValidatorType(ValidatorType validatorType) {
        String regex;
        switch (validatorType) {
            case EMAIL:
                regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                break;
            case MAX256CHAR:
                regex = "^.{0,256}$";
                break;
            case MIN10CHAR:
                regex = "^.{10,}$";
                break;
            default:
                // Regular expression pattern to reject any input string
                regex = "^(?!.*).*$";
        }
        return regex;
    }

    public boolean validateInput(String input, ValidatorType validatorType) {
        String regex = getRegexByValidatorType(validatorType);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static  InputValidator getInstance() {
        if(inputValidator == null)
            inputValidator = new InputValidator();
        return inputValidator;
    }
}
