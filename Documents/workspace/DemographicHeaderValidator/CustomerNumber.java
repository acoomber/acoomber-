import java.util.ArrayList;
import java.util.List;

/**
 * Represents the customer number field
 */
public class CustomerNumber extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return CUSTOMER_NUMBER;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        
        if(value.length()>30){
            errors.add(getFieldName() + " is more than 30 characters");
        }

        autoCorrect(errors);
        return errors;
    }
}