import java.util.ArrayList;
import java.util.List;

/**
 * Represents the favorite store field
 */
public class FavoriteStore extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return FAVORITE_STORE;
    }
    
    @Override
    public List<String> verify() {
        List<String> errors = new ArrayList<String>();
        
        //Strip leading and trailing whitespace
        if(autoCorrect){
            value = value.trim();
        }
        
        if(value.length()>8){
            errors.add(getFieldName() + " is greater than 8 characters");
        }

        autoCorrect(errors);
        return errors;
    }
}