package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.launchcode.techjobs_oo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(1, Math.abs(job1.getId() - job2.getId())); //Subtracts one id from the other and takes the absolute value of the difference
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testJobToStringAllFieldsEmpty() {
        Job job = new Job();
        assertEquals(job.toString(), "OOPS! This job does not seem to exist.");
    }

    @Test
    public void testJobToStringContainsAllFieldsAndValues() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String buildingString = "\n";
        buildingString += "ID: " + job.getId() + "\n";
        buildingString += "Name: Product tester\n";
        buildingString += "Employer: ACME\n";
        buildingString += "Location: Desert\n";
        buildingString += "Position Type: Quality control\n";
        buildingString += "Core Competency: Persistence\n";
        assertEquals(job.toString(), buildingString);
    }

    @Test
    public void testJobToStringDisplaysDataNotAvailable() {
        Job job = new Job();
        job.setEmployer(new Employer("ACME"));
        String buildingString = "\n";
        buildingString += "ID: " + job.getId() + "\n";
        buildingString += "Name: Data not available\n";
        buildingString += "Employer: ACME\n";
        buildingString += "Location: Data not available\n";
        buildingString += "Position Type: Data not available\n";
        buildingString += "Core Competency: Data not available\n";
        assertEquals(job.toString(), buildingString);
    }
}
