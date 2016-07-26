import java.util.ArrayList;
import java.util.List;

/**
 * Represents the address2 field
 */
public class Address2 extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return ADDRESS_2;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        
        //Strip leading and trailing whitespace
        if(autoCorrect){
            value = value.trim();
        }
        
        if(value.length()>100){
            errors.add(getFieldName() + " is greater than 100 characters");
        }
        
        autoCorrect(errors);
        return errors;
    }
}