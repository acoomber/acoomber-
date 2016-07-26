import java.util.ArrayList;
import java.util.List;

/**
 * Represents the tier field
 */
public class Tier extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return TIER;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();

        if(value.length()>50){
            errors.add(getFieldName() + " is more than 50 characters");
        }

        autoCorrect(errors);
        return errors;
    }
}