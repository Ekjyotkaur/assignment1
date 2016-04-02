package prolist.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by yli on 23/02/2016.
 */

public class Proposal extends SeriablizableEntity {
    public enum Cohort {
        HONOURS, MINOR_THESIS, BOTH
    }

    public enum ThesisType {
        MARKS_24, MARKS_18, BOTH
    }

    private String title;

    private String supervisors;

    private Cohort cohort;

    private ThesisType thesisType;

    private boolean previouslyOffered;

    private String background;

    private String aimsOutline;

    private Set<URL> urls;

    private String references;

    private String prerequisite;

    private User modifier;

    private ArrayList<User> examiners;

    public Proposal() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (null == title) {
            throw new IllegalArgumentException("Title cannot be null.");
        } else if (title.trim().equals("")) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    public String getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(String supervisors) {

        if (null == supervisors) {
            throw new IllegalArgumentException("This field should have atleast one supervisor.");
        } else if (supervisors.trim().equals("")) {
            throw new IllegalArgumentException("This field should have atleast one supervisor.");
        }
        this.supervisors = supervisors;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {

        if(!cohort.equals("HONOURS") || !cohort.equals("MINOR_THESIS") || !cohort.equals("BOTH"))
            throw new IllegalArgumentException("Invalid Cohort");
        this.cohort = cohort;
    }

    public ThesisType getThesisType() {
        return thesisType;
    }

    public void setThesisType(ThesisType thesisType) {

        if(!thesisType.equals("MARKS_24")|| !thesisType.equals("MARKS_18")|| !thesisType.equals("BOTH"))
            throw new IllegalArgumentException("Invalid Thesis Type!!");

        this.thesisType = thesisType;
    }

    public boolean isPreviouslyOffered() {
        return previouslyOffered;
    }

    public void setPreviouslyOffered(boolean previouslyOffered) {
        this.previouslyOffered = previouslyOffered;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAimsOutline() {
        return aimsOutline;
    }

    public void setAimsOutline(String aimsOutline) {
        this.aimsOutline = aimsOutline;
    }

    public Set<URL> getUrls() {
        return urls;
    }

    public void setUrls(Set<URL> urls) {
        this.urls = urls;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    public ArrayList<User> getExaminers()
    {
        return examiners;
    }

    public void setExaminers(User examiner)
    {
//        if(examiners.size() == 4)
//            throw new IllegalArgumentException("There has to be maximum of 4 examiners");

        if(examiner == null)
            throw new IllegalArgumentException("There has to be atleast one examiner for the project.");
        else
            examiners.add(examiner);
    }
}
