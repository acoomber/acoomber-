import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Abstract class that represents a single field from the registration upload file.
 */
public abstract class CustomerInformationField
{
    protected String value;
    protected boolean autoCorrect;
    
    public CustomerInformationField(){
        this.value = new String();
        this.autoCorrect = false;
    }
    
    public void setValue(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
    
    public void setAutoCorrect(boolean autoCorrect){
        this.autoCorrect = autoCorrect;
    }
    
    public boolean getAutoCorrect(){
        return this.autoCorrect;
    }
    
    /** Identifies what field from the file this is */
    public abstract String getFieldName();
    
    /** Verifys this field. Returns a list of strings identifying what the errors were. */
    public abstract List<String> verify();
    
    public static final String CARD_NUMBER       = "Card Number";
    public static final String EMAIL             = "Email";
    public static final String EMAIL_FAILED      = "Email Failed";
    public static final String DATE_OF_BIRTH     = "Date of Birth";
    public static final String ANNIVERSARY_DATE  = "Anniversary Date";
    public static final String OPT_IN            = "Opt-In";
    public static final String FIRST_NAME        = "First Name";
    public static final String MIDDLE_INITIAL    = "Middle Initial";
    public static final String LAST_NAME         = "Last Name";
    public static final String COMPANY_NAME      = "Company Name";
    public static final String TITLE             = "Title";
    public static final String ADDRESS           = "Address";
    public static final String ADDRESS_2         = "Address 2";
    public static final String CITY              = "City";
    public static final String COUNTRY           = "Country";
    public static final String STATE             = "State";
    public static final String ZIP_CODE          = "Zip Code";
    public static final String PHONE_NUMBER      = "Phone Number";
    public static final String FAX               = "Fax";
    public static final String CUSTOM_FIELD_1    = "Custom Field 1";
    public static final String CUSTOM_FIELD_2    = "Custom Field 2";
    public static final String CUSTOM_FIELD_3    = "Custom Field 3";
    public static final String CUSTOM_FIELD_4    = "Custom Field 4";
    public static final String CUSTOM_FIELD_5    = "Custom Field 5";
    public static final String CUSTOM_FIELD_6    = "Custom Field 6";
    public static final String TIER              = "Tier";
    public static final String CUSTOMER_NUMBER   = "Customer Number";
    public static final String RG1_EMAIL         = "RG1 Email";
    public static final String RG2_EMAIL         = "RG2 Email";
    public static final String RG3_EMAIL         = "RG3 Email";
    public static final String RG1_EMAIL_FAILED  = "RG1 Email Failed";
    public static final String RG2_EMAIL_FAILED  = "RG2 Email Failed";
    public static final String RG3_EMAIL_FAILED  = "RG3 Email Failed";
    public static final String RG1_DATE_OF_BIRTH = "RG1 Date of Birth";
    public static final String RG2_DATE_OF_BIRTH = "RG2 Date of Birth";
    public static final String RG3_DATE_OF_BIRTH = "RG3 Date of Birth";
    public static final String RG1_FIRST_NAME    = "RG1 First Name";
    public static final String RG2_FIRST_NAME    = "RG2 First Name";
    public static final String RG3_FIRST_NAME    = "RG3 First Name";
    public static final String RG1_LAST_NAME     = "RG1 Last Name";
    public static final String RG2_LAST_NAME     = "RG2 Last Name";
    public static final String RG3_LAST_NAME     = "RG3 Last Name";
    public static final String RG1_TITLE         = "RG1 Title";
    public static final String RG2_TITLE         = "RG2 Title";
    public static final String RG3_TITLE         = "RG3 Title";
    public static final String MOBILE_PHONE      = "Mobile Phone";
    public static final String FAVORITE_STORE    = "Favorite Store";
    
    /**
     * Tests to make sure an email address is formatted correctly
     * @return List of errors
     */
    protected List<String> testEmail(){
        List<String> errors = new ArrayList<String>();
        if(value == null || value.length()==0){
            return errors;
        }
            
        //Strip leading and trailing whitespace
        if(autoCorrect){
            value=value.trim();
        }

        if(!value.matches("[A-Za-z0-9\\._%+-]+@[A-Za-z0-9\\.-]+\\.[A-Za-z]{2,4}")){
            errors.add(getFieldName() + " is of an unknown format");
        }

        //search for a period directly before or after the @ symbol.
        if(value.contains(".@") || value.contains("@.")){
            errors.add(getFieldName() + " contains a period before or after the @ symbol");
        }

        //search for ".."
        if(value.contains("..")){
            errors.add(getFieldName() + " contains '..'");
        }
        
        autoCorrect(errors);
        return errors;
    }
    /**
     * Test to make sure a date formatted correctly and is not in the future.
     * @param testForJuvenille If true will return an error if date represents a juvenille user
     * @return A list of errors
     */
    protected List<String> testDate(boolean testForJuvenille){
        List<String> errors = new ArrayList<String>();
        if(value == null || value.length()==0){
            return errors;
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today = new Date();
        String sDate = dateFormat.format(today); 
        Integer now= new Integer(sDate.substring(0, 4)).intValue();
        Integer then;
        
        // Special case to verify the date is not all zeros
        if(value.matches("[0-9]{1,4}[- /.][0-9]{1,4}[- /.][0-9]{1,4}")){
            Boolean allZeros = true;
            String f[]=value.split("[^0-9]",3);
            //System.out.print(value+"\n");
            for(int i=0; i<3; i++){
                for(int k=0; k<f[i].length(); k++){
                    if(f[i].charAt(k) != '0'){
                        allZeros=false;
                    }
                }
                
                if(allZeros && autoCorrect){
                    value = new String();;
                    return new ArrayList<String>();
                } else if(allZeros){
                    errors.add(getFieldName() + " is invalid.");
                    return errors;
                }
            }
        }

        if(value.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}")){
            then = new Integer(value.substring(value.length()-4, value.length())).intValue();
        } else if(value.matches("[0-9]{1,2}.[0-9]{1,2}.[0-9]{2}")){
            then = new Integer(value.substring(value.length()-2, value.length())).intValue();
            then+=1900;
        } else if(value.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") || value.matches("[0-9]{4}.[0-9]{2}.[0-9]{2} 00:00:00")){
            then = new Integer(value.substring(0, 4)).intValue();
        } else {
            errors.add(getFieldName() + " is of an unknown format");
            return errors;
        }
        
        if(now<then){
            errors.add(getFieldName() + " is in future");
        } else if(testForJuvenille && now-then<14){
            errors.add(getFieldName() + " is a juvenille");
        }
        
        autoCorrect(errors);
        return errors;
    }
    
    /**
     * Tests a name to ensure it is the correct length.
     * @return A list of errors
     */
    protected List<String> testName(){
        List<String> errors = new ArrayList<String>();
        if(value == null || value.length()==0){
            return errors;
        }
        
        //Strip leading and trailing whitespace
        if(autoCorrect){
            value=value.trim();
        }
        if(value.length()>30){
            errors.add(getFieldName() + " is greater than 30 characters");
        }
        
        autoCorrect(errors);
        return errors;
    }
    
    /**
     * Tests a title to make sure it is one of the accepted values.
     * @return A list of errors
     */
    protected List<String> testTitle(){
        List<String> errors = new ArrayList<String>();
        if(value.equals("") || value.equals("Mr.") || value.equals("Ms.") || value.equals("Mrs.") || value.equals("Dr.") || value.equals("Rev.")){
            return errors;
        } else if(autoCorrect){
            value = new String();
        } else {
            errors.add(getFieldName() + " is invalid");
        }
        return errors;
    }
    
    /**
     * Tests the value to make sure it is either Yes, No, or blank
     * @return A list of errors
     */
    protected List<String> testBoolean(){
        List<String> errors = new ArrayList<String>();
        if(!value.equals("Yes") && !value.equals("No") && !value.equals("")){
            errors.add(getFieldName() + " is not boolean");
        }
        
        autoCorrect(errors);
        return errors;
    }
    
    protected List<String> testPhoneNumber(){
        List<String> errors = new ArrayList<String>();
        if(value.length()==0){
            return errors;
        }
        
        if(!value.matches("^\\(?[0-9]{3}\\)?.[0-9]{3}.[0-9]{4}$")){
            errors.add(getFieldName() + " is of an unknown format");
        }
        
        autoCorrect(errors);
        return errors;
    }
    
    protected List<String> testCustomField(){
        List<String> errors = new ArrayList<String>();
        if(value.length() > 50){
            errors.add(getFieldName() + " is more than 50 characters");
        }
        
        autoCorrect(errors);
        return errors;
    }
    
    protected void autoCorrect(List<String> errors){
        if(!errors.isEmpty() && autoCorrect){
            value = new String();
            errors = new ArrayList<String>();
        }
    }
    
}
