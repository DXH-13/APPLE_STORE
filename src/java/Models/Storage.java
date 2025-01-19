package Models;

public class Storage {
    private int storageID;
    private String storage;

    public Storage() {
    }

    public Storage(int storageID, String storage) {
        this.storageID = storageID;
        this.storage = storage;
    }

    public int getStorageID() {
        return storageID;
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Storage{" + "storageID=" + storageID + ", storage=" + storage + '}';
    }

   
}
