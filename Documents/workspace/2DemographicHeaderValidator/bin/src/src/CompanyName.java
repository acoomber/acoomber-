import java.util.ArrayList;
import java.util.List;

/**
 * Represents the company name field
 */
public class CompanyName extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return COMPANY_NAME;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        
        //Strip leading and trailing whitespace
        if(autoCorrect){
            value = value.trim();
        }
        
        if(value.length()>50){
            errors.add(getFieldName() + " is greater than 50 characters");
        }

        autoCorrect(errors);
        return errors;
    }
}