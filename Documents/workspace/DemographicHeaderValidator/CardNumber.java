import java.util.ArrayList;
import java.util.List;

/**
 * Represents the card number field
 */
public class CardNumber extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CARD_NUMBER;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        
        if(value.length() <= 5){
            errors.add(getFieldName() + " is less than 6 digits");
        }

        if(value.length() > 0 && !value.matches("[0-9]+")){
            errors.add(getFieldName() + " contains non-numerical characters");
        }

        return errors;
    }
}