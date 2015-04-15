// Two notes here:
//   1. You must rename this and put in your username
//   2. You must comment out this line to compile with "javac"
package edu.saintjoe.cs.brianc.appskeleton;

/* App Skeleton
 * Written by Yemi Ogunbameru 17 March 2015
 * This is my demonstration copy for in class
 *    we are going to add a getter and a setter to our app class
 *    13 April 2015
 */

//Import directives tell Eclipse which components you intend to use
import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Form;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;

import com.google.devtools.simple.runtime.events.EventDispatcher;

//This is the only class file for our app
public class SkeletonActivity extends Form implements HandlesEventDispatching {

	
	// We begin with constants, and "global settings" variables
	// -- This app has none for now
	
	// Next are the UI widget references
	
	// These objects are equivalent to "components" of App Inventor
	// The containers which organize the app screen
	private HorizontalArrangement line1;
	private HorizontalArrangement line2;

	// Next our three components
	private Button retrieveButton;
	private Button saveButton;
	private TextBox inputBox;
	
	// Variable to hold our saved value for later retrieval
	private int savedValue;
	private String tempString;
	
	private Label resultLabel;

// Java Bridger apps all use $define() in place of main()
void $define() {
	
	// Code in this block is equivalent to the "Designer" part of App Inventor
 
	 // "this" is an Activity object, or the "main screen"
  this.BackgroundColor(COLOR_WHITE);
  
  // Create containers for UI widgets
  line1 = new HorizontalArrangement(this);
  line2 = new HorizontalArrangement(this);
  
  // Now create the user interface
  saveButton = new Button(line1,"Save"); 
  retrieveButton = new Button(line1, "Retrieve");
  inputBox = new TextBox(line2);
  inputBox.NumbersOnly(true);
  resultLabel = new Label(line2,"");
  
  
  // Let the runtime system know which events to report to the dispatcher
  EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
 
} // end $define()

// This method, known as a "callback" is invoked by the runtime system
// It will only be called when a delegated event occurs
@Override
public boolean dispatchEvent(Component component, String id, String eventName,
      Object[] args) {
	
	// This code is equivalent to the "Blocks" part of App Inventor
	    if (component.equals(saveButton) && eventName.equals("Click")){
	    	savedValue = Integer.parseInt(inputBox.Text());
	    	// tempString = Integer.toString(savedValue);
	    	resultLabel.Text("Input value has been saved");
	    	inputBox.Text("");
	        return true;
	     } // 
	    
	    if (component.equals(retrieveButton) && eventName.equals("Click")){
	    	resultLabel.Text("");
	    	tempString = Integer.toString(savedValue);
	    	resultLabel.Text(tempString);
	        return true;
	     } // 
	// This line is syntactically required
 return true;
	} // end dispatchEvent

} // end activity class