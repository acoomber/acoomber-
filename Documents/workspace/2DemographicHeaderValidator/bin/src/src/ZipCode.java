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
        
        if(value.equals("United States") && !value.matches("^[0-9]{5}$") && !value.matches("^[0-9]{5}-[0-9]{4}$")) {
			errors.add(getFieldName() + " is an unknown format");
			
		} else if(value.equals("Canada") && !value.matches("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$")) {
		errors.add(getFieldName() + " is an unknown format");
		
		} 
        
		} else if(value.equals("United Kingdom") && !value.matches("^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$")) {
		errors.add(getFieldName() + " is an unknown format");
		
		} 
		
        autoCorrect(errors);
        return errors;
		
	
    }
}