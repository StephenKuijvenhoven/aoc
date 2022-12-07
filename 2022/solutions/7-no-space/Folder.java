// We have nodes at home:
public class Folder{
    public String name;
    public Folder[] folders;
    public int size;
    public Folder parent;

    public Folder(String name){
        this.name = name;
        this.folders = new Folder[0];
        this.size = 0;
    }

    public void addFolder(Folder newFolder){
        Folder[] temp = folders;
        folders = new Folder[folders.length+1];
        for (int i = 0; i < temp.length; i++) {
            folders[i] = temp[i];
        }
        folders[folders.length-1] = newFolder;
    }

    public void addSize(int fileSize){
        this.size += fileSize;
    }

    public void setParent(Folder parentFolder){
        this.parent = parentFolder;
    }

    public int getFullSize(){
        int fullSize = size;
        for (Folder folder : folders) {
            fullSize+= folder.getFullSize();
        }
        return fullSize;
    }
}