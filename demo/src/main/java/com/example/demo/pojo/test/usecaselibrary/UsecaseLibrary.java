package com.example.demo.pojo.test.usecaselibrary;

public class UsecaseLibrary {
    private int usecaseLibraryId;
    private String usecaseLibraryName;
    private int usecaseNumber;
    private int libRelateTeamId;
    private int libCreatorId;
    private String libCreatorName;

    public UsecaseLibrary() {
        this.usecaseNumber=0;
    }
    public UsecaseLibrary(int usecaseLibraryId, String usecaseLibraryName, int usecaseNumber, int libRelateTeamId,
            int libCreatorId, String libCreatorName) {
        this.usecaseLibraryId = usecaseLibraryId;
        this.usecaseLibraryName = usecaseLibraryName;
        this.usecaseNumber = usecaseNumber;
        this.libRelateTeamId = libRelateTeamId;
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
    public int getLibRelateTeamId() {
        return libRelateTeamId;
    }
    public void setLibRelateTeamId(int libRelateTeamId) {
        this.libRelateTeamId = libRelateTeamId;
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
        return "UsecaseLibrary [usecaseLibraryId=" + usecaseLibraryId + ", usecaseLibraryName=" + usecaseLibraryName
                + ", usecaseNumber=" + usecaseNumber + ", libRelateTeamId=" + libRelateTeamId + ", libCreatorId="
                + libCreatorId + ", libCreatorName=" + libCreatorName + "]";
    }
    
}
