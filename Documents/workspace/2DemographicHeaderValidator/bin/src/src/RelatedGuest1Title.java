import java.util.List;

/**
 * Represents the related guest 1 title field
 */
public class RelatedGuest1Title extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG1_TITLE;
    }
    
    @Override
    public List<String> verify() {
        return testTitle();
    }
}