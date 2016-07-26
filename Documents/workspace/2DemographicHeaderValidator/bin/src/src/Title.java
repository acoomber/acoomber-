import java.util.List;

/**
 * Represents the title field
 */
public class Title extends CustomerInformationField
{
    @Override
    public String getFieldName() {
        return TITLE;
    }
    
    @Override
    public List<String> verify() {
        return testTitle();
    }
}