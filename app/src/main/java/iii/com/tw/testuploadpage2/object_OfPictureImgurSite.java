package iii.com.tw.testuploadpage2;

/**
 * Created by poloi on 2017/2/1.
 */

public class object_OfPictureImgurSite {
    private String animalPicID;
    private String animalPic_animalID;
    private String animalPicAddress;

    public object_OfPictureImgurSite(String imgSite){
        animalPicID = "0";
        animalPic_animalID = "0";
        this.animalPicAddress = imgSite;
    }

    public String getAnimalPic_animalID() {
        return animalPic_animalID;
    }

    public void setAnimalPic_animalID(String animalPic_animalID) {
        this.animalPic_animalID = animalPic_animalID;
    }

    public String getAnimalPicAddress() {
        return animalPicAddress;
    }

    public void setAnimalPicAddress(String animalPicAddress) {
        this.animalPicAddress = animalPicAddress;
    }

    public String getAnimalPicID() {
        return animalPicID;
    }

    public void setAnimalPicID(String animalPicID) {
        this.animalPicID = animalPicID;
    }
}
