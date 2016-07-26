import java.util.List;

/**
 * Represents the fax number field
 */
public class Fax extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return FAX;
    }
    
    @Override
    public List<String> verify() {
        return testPhoneNumber();
    }
}