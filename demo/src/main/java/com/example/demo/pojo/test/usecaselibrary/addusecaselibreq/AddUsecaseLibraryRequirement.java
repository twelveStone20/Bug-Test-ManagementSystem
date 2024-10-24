package com.example.demo.pojo.test.usecaselibrary.addusecaselibreq;

public class AddUsecaseLibraryRequirement {
    private int usecaseLibraryId;
    private String usecaseLibraryName;
    private int usecaseNumber;
    private int libRelatedTeamId;
    private int libCreatorId;
    private String libCreatorName;
    public AddUsecaseLibraryRequirement() {
        this.usecaseNumber=0;
    }
    public AddUsecaseLibraryRequirement(int usecaseLibraryId, String usecaseLibraryName, int usecaseNumber,
            int libRelatedTeamId, int libCreatorId, String libCreatorName) {
        this.usecaseLibraryId = usecaseLibraryId;
        this.usecaseLibraryName = usecaseLibraryName;
        this.usecaseNumber = usecaseNumber;
        this.libRelatedTeamId = libRelatedTeamId;
        this.libCreatorId = libCreatorId;
        this.libCreatorName = libCreatorName;
    }
    public int getUsecaseLibraryId() {
        return usecaseLibraryId;
    }
    public void setUsecaseLibraryId(int usecaseLibraryId) {
        this.usecaseLibraryId = usecaseLibraryId;
    }
    public String getUsecaseLibraryName() {
        return usecaseLibraryName;
    }
    public void setUsecaseLibraryName(String usecaseLibraryName) {
        this.usecaseLibraryName = usecaseLibraryName;
    }
    public int getUsecaseNumber() {
        return usecaseNumber;
    }
    public void setUsecaseNumber(int usecaseNumber) {
        this.usecaseNumber = usecaseNumber;
    }
    public int getLibRelatedTeamId() {
        return libRelatedTeamId;
    }
    public void setLibRelatedTeamId(int libRelatedTeamId) {
        this.libRelatedTeamId = libRelatedTeamId;
    }
    public int getLibCreatorId() {
        return libCreatorId;
    }
    public void setLibCreatorId(int libCreatorId) {
        this.libCreatorId = libCreatorId;
    }
    public String getLibCreatorName() {
        return libCreatorName;
    }
    public void setLibCreatorName(String libCreatorName) {
        this.libCreatorName = libCreatorName;
    }
    @Override
    public String toString() {
        return "AddUsecaseLibraryRequirement [usecaseLibraryId=" + usecaseLibraryId + ", usecaseLibraryName="
                + usecaseLibraryName + ", usecaseNumber=" + usecaseNumber + ", libRelatedTeamId=" + libRelatedTeamId
                + ", libCreatorId=" + libCreatorId + ", libCreatorName=" + libCreatorName + "]";
    }
    
}
