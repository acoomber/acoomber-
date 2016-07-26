import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a single line for a Registration Upload file. Contains all the information
 * for a single user.
 * @author jwatts
 *
 */
public class CustomerInformation {
    private Map<String, CustomerInformationField> dataFields;
    private List<String> ordering;

    public CustomerInformation(){
        initialize(false);
    }
    
    public CustomerInformation(boolean autoCorrect){
        initialize(autoCorrect);
    }
    
    private void initialize(boolean autoCorrect){
        dataFields = new HashMap<String, CustomerInformationField>();
        dataFields.put(CustomerInformationField.ADDRESS,           new Address());
        dataFields.put(CustomerInformationField.ADDRESS_2,         new Address2());
        dataFields.put(CustomerInformationField.ANNIVERSARY_DATE,  new AnniversaryDate());
        dataFields.put(CustomerInformationField.CARD_NUMBER,       new CardNumber());
        dataFields.put(CustomerInformationField.CITY,              new City());
        dataFields.put(CustomerInformationField.COMPANY_NAME,      new CompanyName());
        dataFields.put(CustomerInformationField.COUNTRY,           new Country());
        dataFields.put(CustomerInformationField.CUSTOM_FIELD_1,    new CustomField1());
        dataFields.put(CustomerInformationField.CUSTOM_FIELD_2,    new CustomField2());
        dataFields.put(CustomerInformationField.CUSTOM_FIELD_3,    new CustomField3());
        dataFields.put(CustomerInformationField.CUSTOM_FIELD_4,    new CustomField4());
        dataFields.put(CustomerInformationField.CUSTOM_FIELD_5,    new CustomField5());
        dataFields.put(CustomerInformationField.CUSTOM_FIELD_6,    new CustomField6());
        dataFields.put(CustomerInformationField.CUSTOMER_NUMBER,   new CustomerNumber());
        dataFields.put(CustomerInformationField.DATE_OF_BIRTH,     new DateOfBirth());
        dataFields.put(CustomerInformationField.EMAIL,             new Email());
        dataFields.put(CustomerInformationField.EMAIL_FAILED,      new EmailFailed());
        dataFields.put(CustomerInformationField.FAX,               new Fax());
        dataFields.put(CustomerInformationField.FAVORITE_STORE,    new FavoriteStore());
        dataFields.put(CustomerInformationField.FIRST_NAME,        new FirstName());
        dataFields.put(CustomerInformationField.LAST_NAME,         new LastName());
        dataFields.put(CustomerInformationField.MIDDLE_INITIAL,    new MiddleInitial());
        dataFields.put(CustomerInformationField.MOBILE_PHONE,      new MobilePhone());
        dataFields.put(CustomerInformationField.OPT_IN,            new OptIn());
        dataFields.put(CustomerInformationField.PHONE_NUMBER,      new PhoneNumber());
        dataFields.put(CustomerInformationField.RG1_DATE_OF_BIRTH, new RelatedGuest1DateOfBirth());
        dataFields.put(CustomerInformationField.RG1_EMAIL,         new RelatedGuest1Email());
        dataFields.put(CustomerInformationField.RG1_EMAIL_FAILED,  new RelatedGuest1EmailFailed());
        dataFields.put(CustomerInformationField.RG1_FIRST_NAME,    new RelatedGuest1FirstName());
        dataFields.put(CustomerInformationField.RG1_LAST_NAME,     new RelatedGuest1LastName());
        dataFields.put(CustomerInformationField.RG1_TITLE,         new RelatedGuest1Title());
        dataFields.put(CustomerInformationField.RG2_DATE_OF_BIRTH, new RelatedGuest2DateOfBirth());
        dataFields.put(CustomerInformationField.RG2_EMAIL,         new RelatedGuest2Email());
        dataFields.put(CustomerInformationField.RG2_EMAIL_FAILED,  new RelatedGuest2EmailFailed());
        dataFields.put(CustomerInformationField.RG2_FIRST_NAME,    new RelatedGuest2FirstName());
        dataFields.put(CustomerInformationField.RG2_LAST_NAME,     new RelatedGuest2LastName());
        dataFields.put(CustomerInformationField.RG2_TITLE,         new RelatedGuest2Title());
        dataFields.put(CustomerInformationField.RG3_DATE_OF_BIRTH, new RelatedGuest3DateOfBirth());
        dataFields.put(CustomerInformationField.RG3_EMAIL,         new RelatedGuest3Email());
        dataFields.put(CustomerInformationField.RG3_EMAIL_FAILED,  new RelatedGuest3EmailFailed());
        dataFields.put(CustomerInformationField.RG3_FIRST_NAME,    new RelatedGuest3FirstName());
        dataFields.put(CustomerInformationField.RG3_LAST_NAME,     new RelatedGuest3LastName());
        dataFields.put(CustomerInformationField.RG3_TITLE,         new RelatedGuest3Title());
        dataFields.put(CustomerInformationField.STATE,             new State());
        dataFields.put(CustomerInformationField.TIER,              new Tier());
        dataFields.put(CustomerInformationField.TITLE,             new Title());
        dataFields.put(CustomerInformationField.ZIP_CODE,          new ZipCode());
        
        if(autoCorrect){
            for(CustomerInformationField field : dataFields.values()){
                field.setAutoCorrect(autoCorrect);
            }
        }
    }
    
    public void setOrdering(List<String> ordering){
        this.ordering = ordering;
    }
    
    public String verifyData(){
        String errorLine = new String();
        for(CustomerInformationField field : dataFields.values()){
            for(String error : field.verify()){
                errorLine = errorLine.concat("\t").concat(error);
            }
        }
        return errorLine;
    }
    
    public String getData() {
        String result = new String();
        for(String headerField : ordering){
            result = result.concat(dataFields.get(headerField).getValue()).concat("\t");
        }
        return result.substring(0,result.length()-1); // hack off the tab at the end
    }
    
    public void loadDataRow(List<String> dataRow){
        for(int i=0; i<ordering.size(); i++){
            String headerField = ordering.get(i);
            String value = dataRow.get(i);
            dataFields.get(headerField).setValue(value);
        }
    }
    
    public boolean isHeaderFieldValid(String field){
        return (dataFields.get(field) != null);
    }
}
