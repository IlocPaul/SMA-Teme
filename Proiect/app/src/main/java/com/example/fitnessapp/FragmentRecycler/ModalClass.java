package com.example.fitnessapp.FragmentRecycler;

public class ModalClass {

    int image;
    String text;

    //class stores information about items that will be stored in recycler view
    //in this case 1 image of the exercise and it's description / name
    public ModalClass(int image, String text)
    {
        this.image=image;
        this.text=text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
