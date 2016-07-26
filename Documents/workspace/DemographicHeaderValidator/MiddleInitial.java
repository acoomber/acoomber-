import java.util.ArrayList;
import java.util.List;

/**
 * Represents the middle initial field
 */
public class MiddleInitial extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return MIDDLE_INITIAL;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        if(value.length()==0){
            return errors;
        }
        if(value.length() != 1){
            errors.add(getFieldName() + " is more than 1 character");
        }

        if(!value.matches("[A-Za-z]")){
            errors.add(getFieldName() + " is not alphabetic");
        }
        
        autoCorrect(errors);
        return errors; 
    }
}