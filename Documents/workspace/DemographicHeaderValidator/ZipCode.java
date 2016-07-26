import java.util.ArrayList;
import java.util.List;

/**
 * Represents the zip code field
 */
public class ZipCode extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return ZIP_CODE;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        
        if(value.length()==0){
            return errors;
        }
        
        if(!value.matches("^[0-9]{5}$") && !value.matches("^[0-9]{5}-[0-9]{4}$")){
            errors.add(getFieldName() + " is an unknown format");
        }
        
        autoCorrect(errors);
        return errors;
    }
}