import java.util.List;

/**
 * Represents the date of birth field
 */
public class DateOfBirth extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return DATE_OF_BIRTH;
    }
    
    @Override
    public List<String> verify() {
        return testDate(true);
    }
}