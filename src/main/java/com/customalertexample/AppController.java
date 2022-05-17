
package com.customalertexample;

import java.util.Arrays;
import javax.swing.JOptionPane;


/**
 * @author Nate - https://github.com/AussieDev81
 */

public class AppController {
    
    private final int MIN_LENGTH = 3;

    public void processData(Form form, String name, char[] password, char[] confirmPassword){
        try{
            //Situations that could cause an exception
            if(name.isBlank())
                throw new InputDataException("Name cannot be empty");
            else if(name.length() < MIN_LENGTH)
                throw new InputDataException("Name is only " + name.length() + " characters long, the minimum length is " + MIN_LENGTH);
            else if(!Arrays.equals(password, confirmPassword))
                throw new InputDataException("Passwords must match");
            
            //If no exception, display the success dialog and reset the form
            showSuccessDialog(String.format("Hi %s, your password has been saved! (not really 😜)", name));
            form.clearAllFields();
            
        } catch(InputDataException e){
            showErrorDialog(e);
        }
    }
    
    //Shows an info dialog with the given message
    public void showSuccessDialog(String successMessage){
        JOptionPane.showMessageDialog(
            null, 
            successMessage, 
            "Success!", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Displays an error message with the exception text
    public void showErrorDialog(Exception ex){
        JOptionPane.showMessageDialog(
            null, 
            ex.getMessage(), 
            "Error!", 
            JOptionPane.ERROR_MESSAGE);
    }
}
