import java.util.ArrayList;
import java.util.List;

/**
 * Represents the country field
 */
public class Country extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return COUNTRY;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        
        //Strip leading and trailing whitespace
        if(autoCorrect){
            value = value.trim();
        }
        
        if(value.length() != 0 && !value.equals("United States") && !value.equals("Canada")){
            errors.add(getFieldName() + " invalid value.");
        }

        autoCorrect(errors);
        return errors;
    }
}