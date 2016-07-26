import java.util.List;

/**
 * Represents the related guest 3 title field
 */
public class RelatedGuest3Title extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return RG3_TITLE;
    }
    
    @Override
    public List<String> verify() {
        return testTitle();
    }
}