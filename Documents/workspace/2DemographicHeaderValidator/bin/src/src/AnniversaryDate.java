import java.util.List;

/**
 * Represents the anniversary date field
 */
public class AnniversaryDate extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return ANNIVERSARY_DATE;
    }
    
    @Override
    public List<String> verify() {
        return testDate(false);
    }
}