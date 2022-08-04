package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;

	public Physician(Integer id) {
		super(id);
		
	}
	
	
	public boolean assignPin(int pin) {
		int lengthOfInt = String.valueOf(pin).length();
		if(lengthOfInt != 4) {
			return false;
		}
		return true;
	}

	
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(super.getId() != confirmedAuthID) {
			return false;
		}
		return true;
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

}
